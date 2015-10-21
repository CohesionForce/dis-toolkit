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
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

/**
 * Main generator that reads the contents of the Resource and calls the
 * other code generation classes.
 */
class EcoreGenerator implements IGenerator {

	AvroSchemaGenerator avroGen = new AvroSchemaGenerator
	GenerateUnmarshaller unmarshallGen = new GenerateUnmarshaller
	GenerateLogWriter logWriter = new GenerateLogWriter
	GenerateConverter converter = new GenerateConverter
	GeneratePlugin pluginGen = new GeneratePlugin
	GenerateMarshaller marshallerGen = new GenerateMarshaller
	
	/**
	 * Code generation entry method
	 */
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		pluginGen.generatePlugin(fsa)
		logWriter.generateLogWriter(fsa)
		for (EPackage epackage : resource.contents.filter(typeof(EPackage))) {
			converter.generateConverter(epackage, fsa)
			avroGen.generateAvroSchema(epackage, fsa)
			unmarshallGen.generateUnmarshaller(epackage, fsa)
			marshallerGen.generateMarshaller(epackage, fsa)
		}
	}
}
