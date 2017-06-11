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

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * The GenerateUnmarshaller class generates a method for unmarshalling
 * each Avro class from a byte stream.
 */
class GenerateCaseClasses {
	
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

		fsa.generateFile("src/com/cohesionforce/dis/CaseClasses.scala", '''
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

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
case class «eclass.name»(
	«FOR aFeature : eclass.EAllStructuralFeatures SEPARATOR ","»
		«IF aFeature.upperBound == 1»
			«IF aFeature instanceof EAttribute»
				«IF aFeature.EType.name.equalsIgnoreCase('UShort')»
					var «aFeature.name»: Int = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EFloat')»
					var «aFeature.name»: Float = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EDouble')»
					var «aFeature.name»: Double = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UByte')»
					var «aFeature.name»: Short = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EByte')»
					var «aFeature.name»: Byte = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UShort')»
					var «aFeature.name»: Int = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EShort')»
					var «aFeature.name»: Short = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EInt')»
					var «aFeature.name»: Int = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UInt')»
					var «aFeature.name»: Long = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ELong')»
					var «aFeature.name»: Long = 0
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ULong')»
					var «aFeature.name»: Long = 0
				«ENDIF»
			«ELSE»
				var «aFeature.name»: «aFeature.EType.name» = null
			«ENDIF»
		«ELSE»
			«IF aFeature instanceof EAttribute»
				«IF aFeature.EType.name.equalsIgnoreCase('UShort')»
					var «aFeature.name»: List[Int] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EFloat')»
					var «aFeature.name»: List[Float] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EDouble')»
					var «aFeature.name»: List[Double] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UByte')»
					var «aFeature.name»: List[Short] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EByte')»
					var «aFeature.name»: List[Byte] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UShort')»
					var «aFeature.name»: List[Int] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EShort')»
					var «aFeature.name»: List[Short] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EInt')»
					var «aFeature.name»: List[Int] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UInt')»
					var «aFeature.name»: List[Long] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ELong')»
					var «aFeature.name»: List[Long] = null
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ULong')»
					var «aFeature.name»: List[Long] = null
				«ENDIF»
			«ELSE»
				var «aFeature.name»: List[«aFeature.EType.name»] = null
			«ENDIF»
		«ENDIF»
	«ENDFOR»
)

«ENDFOR»
''')
}
	
}