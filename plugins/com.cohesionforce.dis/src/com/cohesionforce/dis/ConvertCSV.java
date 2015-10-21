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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.cohesionforce.dis.avro.DeadReckoningParameter;
import com.cohesionforce.dis.avro.EntityID;
import com.cohesionforce.dis.avro.EntityStatePdu;
import com.cohesionforce.dis.avro.EntityType;
import com.cohesionforce.dis.avro.Marking;
import com.cohesionforce.dis.avro.Orientation;
import com.cohesionforce.dis.avro.Vector3Double;
import com.cohesionforce.dis.avro.Vector3Float;

public class ConvertCSV implements Runnable {

	private String outputDirectory;
	private String inputFile;
	public static final int MAX_PDU_SIZE = 2048;
	private ThreadGroup threadGroup;
	private String extension = "avro";
	private Random rand = new Random(System.currentTimeMillis());
	private LogWriter<EntityStatePdu> entityStatePduWriter;
	private boolean done = false;
	private List<LogWriter<?>> writers = new ArrayList<LogWriter<?>>();
	String cvsSplitBy = ",";
	private Marshaller marshaller = new Marshaller();
	
	public ConvertCSV() {
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
		BufferedReader br;
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File(outputDirectory+"/EntityStatePdu.log")));
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		
		startWriters();
		Marking marking = new Marking();
		marking.setCharacterSet(0);

		Vector3Float zeroVector = new Vector3Float();

		DeadReckoningParameter dr = new DeadReckoningParameter();

		dr.setDeadReckoningAlgorithm(2);
		dr.setEntityLinearAcceleration(zeroVector);
		dr.setEntityAngularVelocity(zeroVector);

		System.out.println("Starting to convert PDUs");

		while (done == false) {
			String line = null;
			try {
				line = br.readLine(); // throw away header
				while ((line = br.readLine()) != null) {
					String[] pieces = line.split(cvsSplitBy);
					EntityStatePdu output = new EntityStatePdu();

					output.setProtocolVersion(6);
					output.setExerciseID(1);
					output.setPduType(1);
					output.setProtocolFamily(1);
					// Generate TS from time
					long ts = 0;
					output.setTimestamp(ts);
					output.setPduLength(144);
					output.setPadding(0);

					EntityID id = new EntityID();

					id.setSite(0);
					id.setApplication(0);
					id.setEntity(0);

					output.setEntityID(getRandomEntityId());
					output.setForceId(0);
					output.setNumberOfArticulationParameters(0);

					EntityType type = getRandomEntityType();
					output.setEntityType(type);
					output.setAlternativeEntityType(type);

					output.setEntityLinearVelocity(getRandomFloatV());

					// Create EntityLocation from string
					output.setEntityLocation(getRandomDoubleV());

					output.setEntityOrientation(getRandomOrientation());

					output.setEntityAppearance(0);
					output.setDeadReckoningParameters(dr);
					output.setMarking(marking);
					output.setCapabilities(0);
					if (output != null) {
						logPdu(output, 1);
						marshaller.writePdu(output, output.getPduType(), dos);
					}
					if (++count % 100000 == 0) {
						System.out.println("Converted " + count + " PDUs");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			done = true;
		} // end
		try {
			br.close();
			dos.close();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		System.out.print("Waiting on writers to clear their queues");

		boolean emptyQueue = false;
		while (!emptyQueue)

		{
			emptyQueue = true;
			for (LogWriter<?> writer : writers) {
				// If any queue is not empty, sleep and check again
				if (!writer.getQueue().isEmpty()) {
					try {
						emptyQueue = false;
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
		while (threadGroup.activeCount() > 0 && tries < 10)

		{
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
		case 1:
			entityStatePduWriter.getQueue().add((EntityStatePdu) pduObject);
			break;
		}
	}

	private void startWriters() {

		entityStatePduWriter = new LogWriter<EntityStatePdu>(threadGroup,
				outputDirectory + File.separator + "EntityStatePdu." + extension, EntityStatePdu.getClassSchema());
		writers.add(entityStatePduWriter);
		entityStatePduWriter.start();
	}

	public void shutdown() {
		this.done = true;
	}

	private Vector3Float getRandomFloatV() {
		Vector3Float vector = new Vector3Float();
		vector.setX((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		vector.setY((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		vector.setZ((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		return vector;
	}

	private Vector3Double getRandomDoubleV() {
		Vector3Double output = new Vector3Double();
		output.setX(1.0 - (rand.nextFloat() * 2.0) * Double.MAX_VALUE);
		output.setY(1.0 - (rand.nextFloat() * 2.0) * Double.MAX_VALUE);
		output.setZ(1.0 - (rand.nextFloat() * 2.0) * Double.MAX_VALUE);
		return output;

	}

	private Orientation getRandomOrientation() {
		Orientation orientation = new Orientation();
		orientation.setPsi((float) (1.0 - (rand.nextFloat() * 2.0) * Math.PI));
		orientation.setTheta((float) (1.0 - (rand.nextFloat() * 2.0) * Math.PI));
		orientation.setPhi((float) (1.0 - (rand.nextFloat() * 2.0) * Math.PI));
		return orientation;
	}

	private EntityID getRandomEntityId() {
		EntityID output = new EntityID();
		output.setSite(rand.nextInt(1000)+1);
		output.setApplication(rand.nextInt(1000)+1);
		output.setEntity(rand.nextInt(1000)+1);
		return output;
	}
	
	private EntityType getRandomEntityType() {
		EntityType output = new EntityType();
		output.setEntityKind(rand.nextInt(1000)+1);
		output.setDomain(rand.nextInt(1000)+1);
		output.setCountry(rand.nextInt(1000)+1);
		output.setCategory(rand.nextInt(1000)+1);
		output.setSubcategory(rand.nextInt(1000)+1);
		output.setSpec(rand.nextInt(1000)+1);
		output.setExtra(rand.nextInt(1000)+1);
		return output;
	}

	public static void main(String[] args) {

		HelpFormatter formatter = new HelpFormatter();
		// create Options object
		Options options = new Options();

		options.addOption("i", true, "CSV Log file");
		options.addOption("o", true, "Ouput directory for Avro files");
		options.addOption("c", true, "Compression Codec <snappy,deflate,none> Default is snappy");
		options.addOption("p", false, "Write to Parquet format");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		String inputFile = null;
		String outputFile = null;
		try {
			cmd = parser.parse(options, args);
			inputFile = cmd.getOptionValue("i");
			outputFile = cmd.getOptionValue("o");
			if (inputFile == null || outputFile == null) {
				formatter.printHelp("usage: ConvertCSV", options);
				return;
			}
			if (cmd.hasOption("p")) {
				LogWriter.setParquet(true);
			}
			if (cmd.hasOption("c")) {
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
		final ConvertCSV converter = new ConvertCSV();
		if (cmd.hasOption("p")) {
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
