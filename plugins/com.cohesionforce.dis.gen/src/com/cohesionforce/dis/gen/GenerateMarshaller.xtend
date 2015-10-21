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
import org.eclipse.emf.ecore.EAnnotation
import org.eclipse.emf.ecore.EAttribute

/**
 * The GenerateUnmarshaller class generates a method for unmarshalling
 * each Avro class from a byte stream.
 */
class GenerateMarshaller {
	
	/**
	 * Base Package to use for the DIS classes
	 */	
	val basePackage = "com.cohesionforce.dis"
	
	/**
	 * Base Package to use for the Avro classes
	 */
	val avroPrefix = basePackage + ".avro."
	
	/**
	 * Generates the unmarshaller for each class in an EPackage.
	 */
	def generateMarshaller(EPackage anEPackage, IFileSystemAccess fsa) {

		fsa.generateFile("src/com/cohesionforce/dis/Marshaller.java", '''
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
package com.cohesionforce.dis;

import java.util.ArrayList;
import java.util.List;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.File;

import com.cohesionforce.dis.LogWriter;

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
import com.cohesionforce.dis.avro.«eclass.name»;
«ENDFOR»

public class Marshaller {

public void writePdu(Object pdu, int pduType, DataOutputStream dos) throws IOException {

	switch(pduType) {
«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
«IF ! eclass.EAnnotations.isEmpty»
	«var EAnnotation annotation = eclass.EAnnotations.findFirst[annot | annot.source == "pduType"]»
	«IF annotation != null && annotation.details != null»
	case «annotation.details.findFirst[detail | detail.key == "value"].value»:
		marshall«eclass.name»((«avroPrefix.concat(eclass.name)»)pdu, dos);
		break;
	«ENDIF»
«ENDIF»
«ENDFOR»
	}
}

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
public void marshall«eclass.name»(«avroPrefix.concat(eclass.name)» pdu,
	DataOutputStream dos) throws IOException {

	«FOR aFeature : eclass.EAllStructuralFeatures»
		«IF aFeature.upperBound == 1»
			«IF aFeature instanceof EAttribute»
				«IF aFeature.EType.name.equalsIgnoreCase('UShort')»
					dos.writeShort(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EFloat')»
					dos.writeFloat(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EDouble')»
					dos.writeDouble(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UByte')»
					dos.writeByte(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EByte')»
					dos.writeByte(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UShort')»
					dos.writeByte(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EShort')»
					dos.writeShort(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EInt')»
					dos.writeInt(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UInt')»
					dos.writeInt(pdu.get«aFeature.name.toFirstUpper»().intValue());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ELong')»
					dos.writeLong(pdu.get«aFeature.name.toFirstUpper»());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ULong')»
					dos.writeLong(pdu.get«aFeature.name.toFirstUpper»());
				«ENDIF»
			«ELSE»
				marshall«aFeature.EType.name»(pdu.get«aFeature.name.toFirstUpper»(), dos);
			«ENDIF»
		«ELSEIF aFeature.upperBound > 1»
			«IF aFeature instanceof EAttribute»
			«ELSE»
				List<«aFeature.EType.name»> «aFeature.name»List = new ArrayList<«aFeature.EType.name»>();
				for(int i = 0; i < output.getNumberOf«aFeature.name.toFirstUpper»(); i++)
				{
					«aFeature.name»List.add(unMarshall«aFeature.EType.name»(dis));
				}
				output.set«aFeature.name.toFirstUpper»(«aFeature.name»List);
			«ENDIF»
		«ENDIF»
	«ENDFOR»
}

«ENDFOR»
}
''')
}
	
}