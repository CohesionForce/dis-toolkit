/*******************************************************************************
 * Copyright (c) 2015 CohesionForce, Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CohesionForce, Inc - initial API and implementation
 *******************************************************************************/
package com.cohesionforce.dis.gen

import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EClass
import java.util.List
import java.util.ArrayList
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum

/**
 * The AvroSchemaGenerator generates Avro Schemas for classes defined in
 *  an EPackage.  It also adds reception and source timestamp information
 *  for logging.
 */
class AvroSchemaGenerator {

	// List of Classes already visited for a given parent Class.
	var List<EClass> classes = new ArrayList<EClass>();
	
	// List of Enumerations already visited for a given parent Class.
	var List<EEnum> enums = new ArrayList<EEnum>();

	/**
	 * Adds a class to the list of visited classes and returns
	 * true if the class did NOT exist in the list.
	 */
	def boolean addClass(EClass eclass) {
		if (classes.contains(eclass)) {
			return false
		}
		classes.add(eclass)
		return true
	}

	/**
	 * Adds an enumeration to the list of visited enumerations and returns
	 * true if the class did NOT exist in the list.
	 */
	def boolean addEnum(EEnum eenum) {
		if (enums.contains(eenum)) {
			return false
		}
		enums.add(eenum)
		return true
	}

	/**
	 * Generates an Avro Schema file for each class in a package.
	 */
	def CharSequence generateAvroSchema(EPackage anEPackage, IFileSystemAccess fsa) {'''
		«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
			«eclass.generateSchema(anEPackage.name, fsa)»
		«ENDFOR»
		«FOR subPackage : anEPackage.ESubpackages»
			«subPackage.generateAvroSchema(fsa)»
		«ENDFOR»
	'''}

	/**
	 * Generates a string that contains an Avro Schema instead of a file.
	 */
	def generateSchemaString(EClass anEClass) {

		classes.clear;
		enums.clear;
		classes.add(anEClass)

		return '''

		{"type":"record","name":"«anEClass.name»","namespace":"com.cohesionforce.dis.avro","fields":[
			«IF anEClass.name.endsWith("Pdu")»
			{"name":"reception_timestamp","type":["null",
				{"type":"record","name":"Time_t","fields":[
					{"name":"sec","type":"int"},
					{"name":"nanosec","type":"int"}
				]}]},
			{"name":"source_timestamp","type":["null","Time_t"]},
			«ENDIF»
			«FOR aFeature : anEClass.EAllStructuralFeatures SEPARATOR ","»
				«aFeature.generateFeature()»
			«ENDFOR»
		]}
		'''
	}

	/**
	 * Generates an Avro Schema file for an EClass.
	 */
	def generateSchema(EClass anEClass, String basePackage, IFileSystemAccess fsa) {

		classes.clear;
		enums.clear;
		classes.add(anEClass)

		fsa.generateFile("src/com/cohesionforce/dis/schema/"+anEClass.name+".avsc", '''

		{"type":"record","name":"«anEClass.name»","namespace":"com.cohesionforce.dis.avro","fields":[
			«IF anEClass.name.endsWith("Pdu")»
			{"name":"reception_timestamp","type":["null",
				{"type":"record","name":"Time_t","fields":[
					{"name":"sec","type":"int"},
					{"name":"nanosec","type":"int"}
				]}]},
			{"name":"source_timestamp","type":["null","Time_t"]},
			«ENDIF»
			«FOR aFeature : anEClass.EAllStructuralFeatures SEPARATOR ","»
				«aFeature.generateFeature()»
			«ENDFOR»
		]}
		''')
	}

	/**
	 * Generates a property in the schema for a feature.
	 */
	def CharSequence generateFeature(EStructuralFeature aFeature) {'''
		«IF aFeature.upperBound != 1»
			{"name":"«aFeature.name»","type":["null",«aFeature.generateArray()»]}
		«ELSEIF aFeature instanceof EAttribute»
			«(aFeature as EAttribute).generateAttribute()»
		«ELSE»
			«(aFeature as EReference).generateReference()»
		«ENDIF»
	'''}

	/**
	 * Generates an array property in a schema based on a feature with upperBound > 1.
	 */
	def generateArray(EStructuralFeature aFeature) {'''
		{"type":"array","items":
		«IF aFeature instanceof EAttribute»
			"«aFeature.EType.printAvroType()»"
		«ELSE»
			«IF aFeature instanceof EReference && addClass((aFeature as EReference).EReferenceType) »
				«(aFeature as EReference).EReferenceType.generateRecord()»
			«ELSE»
				"«aFeature.EType.name»"
			«ENDIF»
		«ENDIF»
		}
	'''}

	/**
	 * Returns the avro type for a given EClassifier.
	 */
	def printAvroType(EClassifier eClass) {
		switch eClass.name {
			case "EInt": return "int"
			case "EShort": return "int"
			case "ELong": return "long"
			case "EDouble": return "double"
			case "EFloat": return "float"
			case "EString": return "string"
			case "EBoolean": return "boolean"
			case "EDate": return "string"
			case "EChar": return "int"
			case "EByte": return "int"
			case "UShort": return "int"
			case "UByte": return "int"
			case "UInt": return "long"
			case "ULong": return "long"
			default: return eClass.name
		}
	}

	/**
	 * Generates a schema property based on an EAttribute
	 */
	def generateAttribute(EAttribute anAttribute) {'''
		«IF anAttribute.EType instanceof EEnum»
			{"name":"«anAttribute.name»","type":«(anAttribute.EType as EEnum).generateEnum»}
		«ELSE»
			«IF anAttribute.EType.name == "EString" || anAttribute.EType.name == "EDate"»
				{"name":"«anAttribute.name»","type":["null","«anAttribute.EType.printAvroType»"]}
			«ELSE»
				{"name":"«anAttribute.name»","type":"«anAttribute.EType.printAvroType»"}
			«ENDIF»
		«ENDIF»
	'''}

	/**
	 * Generates a schema property based on an EReference.  Either creates a new
	 * record type, or references an existing record type.
	 */
	def generateReference(EReference aReference) {'''
		«IF addClass(aReference.EReferenceType)»
			{"name":"«aReference.name»","type":["null",«aReference.EReferenceType.generateRecord»]}
		«ELSE»
			{"name":"«aReference.name»","type":["null","«aReference.EType.name»"]}
		«ENDIF»
	'''}

	/**
	 * Generates a new record type based on an EClass
	 */
	def generateRecord(EClass anEClass) {'''
		{"type":"record","name":"«anEClass.name»","fields":[
		«IF anEClass.name.endsWith("Topic")»
			{"name":"reception_timestamp","type":["null","Time_t"]},
			{"name":"source_timestamp","type":["null","Time_t"]},
		«ENDIF»
		«FOR aFeature : anEClass.EAllStructuralFeatures SEPARATOR ","»
			«aFeature.generateFeature»
		«ENDFOR»]}
	'''}

	/**
	 * Generates a schema property based on an EEnum.  Either creates a new
	 * enumeration type, or references an existing enumeration type.
	 */
	def generateEnum(EEnum eEnum) {'''
		«IF addEnum(eEnum)»
			{"type":"enum","name":"«eEnum.name»","symbols":[«FOR eLiteral: eEnum.ELiterals SEPARATOR ","»"«eLiteral.name»"«ENDFOR»]}
		«ELSE»
			"«eEnum.name»"
		«ENDIF»
	'''}

}