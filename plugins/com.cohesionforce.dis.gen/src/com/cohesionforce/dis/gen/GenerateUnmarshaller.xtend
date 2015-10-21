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
class GenerateUnmarshaller {
	
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
	def generateUnmarshaller(EPackage anEPackage, IFileSystemAccess fsa) {

		fsa.generateFile("src/com/cohesionforce/dis/Unmarshaller.java", '''
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
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.File;

import com.cohesionforce.dis.LogWriter;

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
import com.cohesionforce.dis.avro.«eclass.name»;
«ENDFOR»

public class Unmarshaller {

public Object getPdu(byte[] data) throws IOException {
    // Promote a signed byte to an int, then do a bitwise AND to wipe out everthing but the 
    // first eight bits. This effectively lets us read this as an unsigned byte
     // The pdu type is a one-byte, unsigned byte in the third byte position.
    int pduType = 0x000000FF & (int) data[2];

    DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));

	switch(pduType) {
«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
«IF ! eclass.EAnnotations.isEmpty»
	«var EAnnotation annotation = eclass.EAnnotations.findFirst[annot | annot.source == "pduType"]»
	«IF annotation != null && annotation.details != null»
	case «annotation.details.findFirst[detail | detail.key == "value"].value»:
		«eclass.name» new«eclass.name» = unMarshall«eclass.name»(dis);
		return new«eclass.name»;
	«ENDIF»
«ENDIF»
«ENDFOR»
	}
	return null;
}

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
public «avroPrefix.concat(eclass.name)» unMarshall«eclass.name»(
	DataInputStream dis) throws IOException {

	«avroPrefix.concat(eclass.name)» output = new «avroPrefix.concat(eclass.name)»();

	«FOR aFeature : eclass.EAllStructuralFeatures»
		«IF aFeature.upperBound == 1»
			«IF aFeature instanceof EAttribute»
				«IF aFeature.EType.name.equalsIgnoreCase('UShort')»
					output.set«aFeature.name.toFirstUpper»((int)dis.readUnsignedShort());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EFloat')»
					output.set«aFeature.name.toFirstUpper»(dis.readFloat());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EDouble')»
					output.set«aFeature.name.toFirstUpper»(dis.readDouble());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UByte')»
					output.set«aFeature.name.toFirstUpper»((int)dis.readUnsignedByte());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EByte')»
					output.set«aFeature.name.toFirstUpper»((int)dis.readByte());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UShort')»
					output.set«aFeature.name.toFirstUpper»((int)dis.readUnsignedShort());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EShort')»
					output.set«aFeature.name.toFirstUpper»((int)dis.readShort());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('EInt')»
					output.set«aFeature.name.toFirstUpper»(dis.readInt());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('UInt')»
					output.set«aFeature.name.toFirstUpper»((long)dis.readInt());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ELong')»
					output.set«aFeature.name.toFirstUpper»((long)dis.readLong());
				«ELSEIF aFeature.EType.name.equalsIgnoreCase('ULong')»
					output.set«aFeature.name.toFirstUpper»((long)dis.readLong());
				«ENDIF»
			«ELSE»
				output.set«aFeature.name.toFirstUpper»(unMarshall«aFeature.EType.name»(dis));
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
	return output;
}

«ENDFOR»
}
''')
}
	
}