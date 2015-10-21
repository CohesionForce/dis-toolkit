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

import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * The GeneratePlugin class generates all of the Eclipse plugin
 * related files.  These files include the MANIFEST.MF, .classpath,
 * build.properties, and .project files.
 */
class GeneratePlugin {
	def generatePlugin(IFileSystemAccess fsa) {

		fsa.generateFile("META-INF/MANIFEST.MF", '''
Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: DIS Utilities
Bundle-SymbolicName: com.cohesionforce.dis
Bundle-Version: 0.0.1.qualifier
Bundle-Vendor: CohesionForce, Inc
Bundle-RequiredExecutionEnvironment: JavaSE-1.8
		''')
		
		fsa.generateFile("build.properties", '''
source.. = src/
output.. = bin/
bin.includes = META-INF/,\
               .
		''')
		
		fsa.generateFile(".classpath", '''
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
	<classpathentry kind="con" path="org.eclipse.pde.core.requiredPlugins"/>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="lib" path="lib/avro-1.7.6.jar"/>
	<classpathentry kind="lib" path="lib/avro-tools-1.7.6.jar"/>
	<classpathentry kind="lib" path="lib/parquet-avro-1.6.0rc3.jar"/>
	<classpathentry kind="lib" path="lib/parquet-hadoop-bundle-1.6.0rc3.jar"/>
	<classpathentry kind="lib" path="lib/commons-cli-1.3.1.jar"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
	''')
	
		fsa.generateFile(".project", '''
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>com.cohesionforce.dis</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.pde.ManifestBuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.pde.SchemaBuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.pde.PluginNature</nature>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>
	''')
	
	}
}
