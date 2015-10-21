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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

/**
 * The ECoreGeneratorModule is used by the Guice injection engine
 * to connect the class of the Resource to the Generator.
 * 
 * @author jlangley
 *
 */
public class EcoreGeneratorModule extends AbstractGenericResourceRuntimeModule {
 
	/**
	 * The use of the language name is not fully understood when using the 
	 * generator outside of the normal XText DSL context.
	 */
    @Override
    protected String getLanguageName() {
        return "does.not.seem.to.matter";
    }
 
    /**
     * This Generator works with *.ecore files.
     */
    @Override
    protected String getFileExtensions() {
        return "ecore";
    }
 
    /**
     * Returns the class that will be instantiated as the Generator.
     * @return EcoreGenerator.class
     */
    public Class<? extends IGenerator> bindIGenerator() {
        return EcoreGenerator.class;
    }
 
    /**
     * Returns the class that will be used to load the resource.
     * @return
     */
    public Class<? extends ResourceSet> bindResourceSet() {
        return ResourceSetImpl.class;
    }
 
}