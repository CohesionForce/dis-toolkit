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
package com.cohesionforce.dis.gen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.avro.tool.SpecificCompilerTool;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * Main method that runs the code generation for DIS
 * 
 * @author jlangley
 *
 */
public class GeneratorMain {

	private static Injector injector = Guice.createInjector(new EcoreGeneratorModule());
	private static String outputDir = null;
	private static String projectDir = null;
	
	public static void main(String[] args) {
		Generator generator = injector.getInstance(Generator.class);
		projectDir = args[0];
		outputDir = args[1];
		generator.runGenerator(projectDir+"/model/DIS1998.ecore");
	}

	static class Generator {
		
		@Inject 
		private Provider<ResourceSet> resourceSetProvider;
		
		@Inject
		private IResourceValidator validator;
		
		@Inject
		private IGenerator generator;
		
		@Inject 
		private JavaIoFileSystemAccess fileAccess;

		protected void runGenerator(String string) {
			// load the resource
			ResourceSet set = resourceSetProvider.get();
			set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new XMIResourceFactoryImpl());
			Resource resource = set.getResource(URI.createURI(string), true);
			
			// validate the resource
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					System.err.println(issue);
				}
			}
			
			// configure and start the generator
			fileAccess.setOutputPath(outputDir);
			
			generator.doGenerate(resource, fileAccess);
			
			SpecificCompilerTool tool = new SpecificCompilerTool();
			File directory = new File(outputDir+"/src/com/cohesionforce/dis/schema");
			File output = new File(outputDir+"/src");
			if(!directory.exists())
				return;
			
			for(File schemaFile: directory.listFiles())
			{
				List<String> args = new ArrayList<String>();
				args.add("schema");
				args.add(schemaFile.getAbsolutePath());
				args.add(output.getAbsolutePath());
				try {
					tool.run(System.in,  System.out,  System.err,  args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// Copy in the Avro jar file
			File outputLib = new File(outputDir+"/lib");
			outputLib.mkdir();
			try {
				FileUtils.copyDirectory(new File(projectDir+"/lib"), outputLib);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Code generation finished.");
		}

	}
}
