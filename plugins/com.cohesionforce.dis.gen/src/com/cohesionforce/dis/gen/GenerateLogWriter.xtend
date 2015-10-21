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
 * The GenerateLogWriter class generates the LogWriter template
 * that handles all of the writing to Avro or Parquet formats.
 */
class GenerateLogWriter {
	
	/**
	 * Generate the LogWriter.java file.
	 */
	def generateLogWriter(IFileSystemAccess fsa) {

		fsa.generateFile("src/com/cohesionforce/dis/LogWriter.java", '''
/*******************************************************************************
 * Copyright (c) 2015 CohesionForce, Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      CohesionForce, Inc - initial API and implementation
 *******************************************************************************/
package com.cohesionforce.dis;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.hadoop.fs.Path;
import parquet.avro.AvroParquetWriter;
import parquet.hadoop.metadata.CompressionCodecName;

public class LogWriter<T> extends Thread {

	String filename;
	BlockingQueue<T> queue = new LinkedBlockingQueue<T>();
	private Schema schema;
	private int totalCount = 0;
	boolean writing = true;

	private static CodecFactory codec = CodecFactory.snappyCodec();
	private static CompressionCodecName compressionCodecName = CompressionCodecName.SNAPPY;
	private static boolean useParquet = false;

	public static void setParquet(boolean parquet) {
		LogWriter.useParquet = parquet;
	}

	public static void setCodec(String string) {
		if (string.equalsIgnoreCase("snappy")) {
			LogWriter.codec = CodecFactory.snappyCodec();
			LogWriter.compressionCodecName = CompressionCodecName.SNAPPY;
		} else if (string.equalsIgnoreCase("deflate")) {
			LogWriter.codec = CodecFactory.deflateCodec(9);
		} else if (string.equalsIgnoreCase("gzip")) {
			LogWriter.compressionCodecName = CompressionCodecName.GZIP;
		} else {
			LogWriter.codec = CodecFactory.nullCodec();
		}
	}

	public LogWriter(String filename, Schema schema) {
		this.schema = schema;
		this.filename = filename;
	}

	public LogWriter(ThreadGroup tg, String filename, Schema schema) {
		super(tg, "LogWriter");
		this.schema = schema;
		this.filename = filename;
	}

	public BlockingQueue<T> getQueue() {
		return queue;
	}

	public void stopWriting() {
		this.writing = false;
	}

	public void run() {
		if (useParquet) {
			runParquet();
		} else {
			runAvro();
		}
	}

	/**
	 * Start writing PDUs. This blocks if it has no PDU lists to write.
	 */
	public void runAvro() {

		DatumWriter<T> writer = new SpecificDatumWriter<T>(schema);
		DataFileWriter<T> out = null;
		try {

			File file = new File(filename);
			// create a file of packets
			out = new DataFileWriter<T>(writer).setCodec(codec).create(schema, file);
			while (writing) {
				// Blocks until there's something in the queue to take
				T object = queue.take();
				out.append(object);
			}
			out.flush();
			out.close();
			out = null;
			writing = false;

		} catch (InterruptedException iexc) {
			// Expected exception to bail out of the thread. Go ahead and close
			// what we have
			if (out != null) {
				try {
					System.out.println("Closing " + filename);
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Could not open file for writing:" + e.getMessage());
		}
	}

	/**
	 * Start writing PDUs. This blocks if it has no PDU lists to write.
	 */
	public void runParquet() {
		// choose compression scheme

		// set Parquet file block size and page size values
		int blockSize = 16 * 1024 * 1024;  // 16 MB
		int pageSize = 1 * 1024  * 1024;	// 1 MB

		DataFileWriter<T> out = null;
		AvroParquetWriter parquetWriter = null;
		int count = 0;
		try {

			// Create a log file name, or the format "exerciseName_nnnnn"
			Path outputPath = new Path(filename);
			
			// If the file already exists, delete it so that the converter does not throw an error
			File file = new File(filename);
			if(file.exists()) {
				file.delete();
			}
			// create a file of packets
			parquetWriter = new AvroParquetWriter(outputPath, schema, LogWriter.compressionCodecName, blockSize,
					pageSize);

			while (writing) {

				// Blocks until there's something in the queue to take
				T object = queue.take();
				parquetWriter.write(object);
			}
			parquetWriter.close();
			parquetWriter = null;
			writing = false;
		} catch (InterruptedException iexc) {
			// Expected exception to bail out of the thread. Go ahead and close
			// what we have
			if (parquetWriter != null) {
				try {
					totalCount += count;
					System.out.println("Wrote total: " + totalCount + ". Closing " + filename);
					// out.close();
					parquetWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
		''')
	}
}
