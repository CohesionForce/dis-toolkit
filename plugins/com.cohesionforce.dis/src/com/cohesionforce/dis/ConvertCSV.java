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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

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

/**
 * The ConvertCSV class is a custom class that is not currently generated. The
 * purpose of the class is to convert NYC taxi data from CSV and transform it
 * to some type of DIS structure.
 * 
 * http://www.andresmh.com/nyctaxitrips/
 * 
 * @author jlangley
 *
 */
public class ConvertCSV implements Runnable {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	final double EARTH_RADIUS = 6378137.0; /* Meters */
	final double EARTH_RADIUS_SQUARED = EARTH_RADIUS * EARTH_RADIUS;
	final double PI_OVER_2 = Math.PI / 2.0;
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
	private TreeMap<String, Integer> idMap = new TreeMap<String, Integer>();
	private TreeMap<String, EntityType> typeMap = new TreeMap<String, EntityType>();
	private int nextInt = 1;
	private Marking marking = new Marking();
	private Vector3Float zeroVector = new Vector3Float();

	DeadReckoningParameter dr = new DeadReckoningParameter();

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
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}

		startWriters();
		marking.setCharacterSet(0);

		dr.setDeadReckoningAlgorithm(2);
		dr.setEntityLinearAcceleration(zeroVector);
		dr.setEntityAngularVelocity(zeroVector);

		System.out.println("Starting to convert PDUs");

		while (done == false) {
			String line = null;
			try {
				line = br.readLine(); // throw away header

				// medallion, hack_license, vendor_id, rate_code,
				// store_and_fwd_flag,pickup_datetime,dropoff_datetime,passenger_count,
				// trip_time_in_secs,trip_distance,pickup_longitude,pickup_latitude,
				// dropoff_longitude,dropoff_latitude
				while ((line = br.readLine()) != null) {
					String[] pieces = line.split(cvsSplitBy);

					String medallion = pieces[0];

					LocalDateTime localTime = LocalDateTime.from(formatter.parse(pieces[5]));
					ZonedDateTime zoneTime = localTime.atZone(ZoneId.of("America/New_York"));
					long ts = zoneTime.toInstant().toEpochMilli();

					EntityStatePdu output = getNewEntityState(medallion);
					output.setTimestamp(ts);

					// Create EntityLocation from string
					double plon = Double.parseDouble(pieces[10]);
					double plat = Double.parseDouble(pieces[11]);
					Vector3Double loc = getLocation(plon, plat);
					output.setEntityLocation(loc);

					logPdu(output, 1);

					if (++count % 100000 == 0) {
						System.out.println("Converted " + count + " PDUs");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			done = true;
		} // end
		try {
			br.close();
		} catch (IOException e1) {
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

	private EntityStatePdu getNewEntityState(String medallion) {
		EntityStatePdu output = new EntityStatePdu();
		output.setProtocolVersion(6);
		output.setExerciseID(1);
		output.setPduType(1);
		output.setProtocolFamily(1);
		output.setPduLength(144);
		output.setPadding(0);

		int entity = 0;
		if (idMap.containsKey(medallion)) {
			entity = idMap.get(medallion);
		} else {
			idMap.put(medallion, nextInt++);
		}
		EntityID id = new EntityID();

		id.setSite(1);
		id.setApplication(2);
		id.setEntity(entity);

		output.setEntityID(id);
		output.setForceId(0);
		output.setNumberOfArticulationParameters(0);

		EntityType type = getRandomEntityType();
		if (typeMap.containsKey(medallion)) {
			type = typeMap.get(medallion);
		} else {
			type = getRandomEntityType();
			typeMap.put(medallion, type);
		}

		output.setEntityType(type);
		output.setAlternativeEntityType(type);
		output.setEntityLinearVelocity(getRandomFloatV());
		output.setEntityOrientation(getRandomOrientation());

		output.setEntityAppearance(0);
		output.setDeadReckoningParameters(dr);
		output.setMarking(marking);
		output.setCapabilities(0);
		return output;

	}
	
	private Vector3Float getRandomFloatV() {
		Vector3Float vector = new Vector3Float();
		vector.setX((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		vector.setY((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		vector.setZ((float) (1.0 - (rand.nextFloat() * 2.0) * Float.MAX_VALUE));
		return vector;
	}

	private Vector3Double getLocation(double lat, double lon) {
		Vector3Double output = new Vector3Double();
		double phi = PI_OVER_2 - lat;
		double theta = lon;
		double rho = EARTH_RADIUS;
		/* Subvalue for optimization */
		double rho_sin_phi = rho * Math.sin(phi);

		output.setX(rho_sin_phi * Math.cos(theta));
		output.setY(rho_sin_phi * Math.sin(theta));
		output.setY(rho * Math.cos(phi));

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
		output.setSite(rand.nextInt(1000) + 1);
		output.setApplication(rand.nextInt(1000) + 1);
		output.setEntity(rand.nextInt(1000) + 1);
		return output;
	}

	private EntityType getRandomEntityType() {
		EntityType output = new EntityType();
		output.setEntityKind(rand.nextInt(1000) + 1);
		output.setDomain(rand.nextInt(1000) + 1);
		output.setCountry(rand.nextInt(1000) + 1);
		output.setCategory(rand.nextInt(1000) + 1);
		output.setSubcategory(rand.nextInt(1000) + 1);
		output.setSpec(rand.nextInt(1000) + 1);
		output.setExtra(rand.nextInt(1000) + 1);
		return output;
	}

	/**
	 * The main method of this converter. It could be more robust, but it is
	 * intended to be a test tool.
	 */
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
