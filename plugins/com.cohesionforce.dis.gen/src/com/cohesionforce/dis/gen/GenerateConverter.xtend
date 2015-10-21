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

/**
 * The GenerateConverter class generates the BinaryConverter class that will
 * read a binary log file and create Avro or Parquet files.
 */
class GenerateConverter {

	/**
	 * Generates a BinaryConverter that handles all EClasses defined in
	 * the EPackage parameter.
	 */
	def generateConverter(EPackage anEPackage, IFileSystemAccess fsa) {

		fsa.generateFile("src/com/cohesionforce/dis/BinaryConverter.java", '''
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

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;
import java.util.List;

«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
	«IF eclass.name.endsWith("Pdu")»
import com.cohesionforce.dis.avro.«eclass.name»;
	«ENDIF»
«ENDFOR»

public class BinaryConverter implements Runnable {

	private String outputDirectory;
	private String inputFile;
	private Unmarshaller unmarshaller;
	public static final int MAX_PDU_SIZE = 2048;
	private ThreadGroup threadGroup;
	private String extension = "avro";

	«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
		«IF eclass.name.endsWith("Pdu")»
			private LogWriter<«eclass.name»> «eclass.name.toFirstLower»Writer;
		«ENDIF»
	«ENDFOR»
	private boolean done = false;
	private List<LogWriter<?>> writers = new ArrayList<LogWriter<?>>();

	public BinaryConverter() {
		unmarshaller = new Unmarshaller();
		threadGroup = new ThreadGroup("LoggerThreads");
	}

	public void setExtension(String ext) {
		this.extension = ext;
	}
	
	public void setOutputDirectory(String filename) {
		this.outputDirectory = filename;
	}

	public void setInputFile(String inFile) {
		this.inputFile = inFile;
	}

	public void run() {
		int count = 0;

		System.out.println("Opening file to convert: " + inputFile);
		FileInputStream fis;
		try {
			fis = new FileInputStream(inputFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}

		DataInputStream dis = new DataInputStream(fis);
		startWriters();

		System.out.println("Starting to convert PDUs");

		while (done == false) {
			byte buffer[] = new byte[MAX_PDU_SIZE];

			byte pduType;
			try {
				pduType = dis.readByte();
				int pduSize = dis.readInt();
				int skip = dis.read(buffer, 0, 19);
				assert (skip == 19);
				int numberRead = dis.read(buffer, 0, pduSize);
				assert (numberRead == pduSize);
				++count;

				// Convert the byte array to an object
				Object object;
				object = unmarshaller.getPdu(buffer);
				if (object != null) {
					logPdu(object, pduType);
				}
			} catch(EOFException e) {
				done = true;
			}catch (IOException e) {
				e.printStackTrace();
			}catch(Exception e)
			{
				done = true;
				e.printStackTrace();
			}
			
			if(count % 100000 == 0) {
				System.out.println("Converted "+count+" PDUs");
			}
		} // end loop
		try {
			dis.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.print("Waiting on writers to clear their queues");
		
		boolean emptyQueue = false;
		while(!emptyQueue)
		{
			emptyQueue = true;
			for(LogWriter<?> writer : writers)
			{
				// If any queue is not empty, sleep and check again
				if(!writer.getQueue().isEmpty()) {
					try {
						emptyQueue=false;
						System.out.print(".");
						Thread.sleep(1000);
						break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		System.out.println("");
		System.out.println("PDUs converted: " + count);
		System.out.println("Shutting down logging threads");
		threadGroup.interrupt();
		int tries = 0;
		while (threadGroup.activeCount() > 0 && tries < 10) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			++tries;
		}
		System.out.println("Completed logging threads shutdown");

	}

	private void logPdu(Object pduObject, int pduType) {
		if (pduObject == null) {
			return;
		}
		switch (pduType) {
		«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
			«IF eclass.name.endsWith("Pdu") && getPduType(eclass)!=null»
				case «getPduType(eclass)»:
					«eclass.name.toFirstLower»Writer.getQueue().add((«eclass.name»)pduObject);
				break;
			«ENDIF»
		«ENDFOR»
		}
	}
	
	private void startWriters() {
		
	«FOR eclass : anEPackage.EClassifiers.filter(typeof(EClass))»
		«IF eclass.name.endsWith("Pdu")»
		«eclass.name.toFirstLower»Writer = new LogWriter<«eclass.name»>(threadGroup, outputDirectory + File.separator + "«eclass.name»."+ extension, «eclass.name».getClassSchema());
		writers.add(«eclass.name.toFirstLower»Writer);
		«eclass.name.toFirstLower»Writer.start();
		«ENDIF»
	«ENDFOR»
	}	

	public void shutdown() {
		this.done = true;
	}
	
	public static void main(String[] args) {

		HelpFormatter formatter = new HelpFormatter();
		// create Options object
		Options options = new Options();

		options.addOption("i", true, "Input DIS Log file");
		options.addOption("o", true, "Ouput directory for Avro files");
		options.addOption("c", true, "Compression Codec <snappy,deflate,none> Default is snappy");
		options.addOption("p", false, "Write to Parquet format" );
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		String inputFile = null;
		String outputFile = null;
		try {
			cmd = parser.parse(options, args);
			inputFile = cmd.getOptionValue("i");
			outputFile = cmd.getOptionValue("o");
			if (inputFile == null || outputFile == null) {
				formatter.printHelp("usage: BinaryConverter", options);
				return;
			}
			if(cmd.hasOption("p")) {
				LogWriter.setParquet(true);
			}
			if(cmd.hasOption("c")) {
				LogWriter.setCodec(cmd.getOptionValue("c"));
			}
		} catch (ParseException exc) {
			System.err.println("Problem with command line parameters: " + exc.getMessage());
			return;
		}

		// Make sure the output directory exists
		File outputDir = new File(outputFile);
		outputDir.mkdirs();
		
		// Start the logger thread listening
		final BinaryConverter converter = new BinaryConverter();
		if(cmd.hasOption("p")) {
			converter.setExtension("parquet");
		}
		converter.setOutputDirectory(outputFile);
		converter.setInputFile(inputFile);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Shutting down DIS Logger");
				synchronized (converter) {
					converter.shutdown();
				}
			}
		});
		converter.run();
		converter.shutdown();
	}
	
}
''')
	}
	
	/**
	 * Returns the PDU Type based on the annotation on the EClass.
	 */
	def CharSequence getPduType(EClass eclass) {
		var CharSequence rvalue = null
		var EAnnotation annotation = eclass.getEAnnotation("pduType")
		if(annotation != null) {
			rvalue = annotation.details.get("value").toString
		}
		return rvalue
	}

}