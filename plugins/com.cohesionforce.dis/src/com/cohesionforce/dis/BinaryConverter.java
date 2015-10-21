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

import com.cohesionforce.dis.avro.Pdu;
import com.cohesionforce.dis.avro.EntityInformationFamilyPdu;
import com.cohesionforce.dis.avro.EntityStatePdu;
import com.cohesionforce.dis.avro.CollisionPdu;
import com.cohesionforce.dis.avro.CollisionElasticPdu;
import com.cohesionforce.dis.avro.EntityStateUpdatePdu;
import com.cohesionforce.dis.avro.WarfareFamilyPdu;
import com.cohesionforce.dis.avro.FirePdu;
import com.cohesionforce.dis.avro.DetonationPdu;
import com.cohesionforce.dis.avro.LogisticsFamilyPdu;
import com.cohesionforce.dis.avro.ServiceRequestPdu;
import com.cohesionforce.dis.avro.ResupplyOfferPdu;
import com.cohesionforce.dis.avro.ResupplyReceivedPdu;
import com.cohesionforce.dis.avro.ResupplyCancelPdu;
import com.cohesionforce.dis.avro.RepairCompletePdu;
import com.cohesionforce.dis.avro.RepairResponsePdu;
import com.cohesionforce.dis.avro.SimulationManagementFamilyPdu;
import com.cohesionforce.dis.avro.CreateEntityPdu;
import com.cohesionforce.dis.avro.RemoveEntityPdu;
import com.cohesionforce.dis.avro.StartResumePdu;
import com.cohesionforce.dis.avro.StopFreezePdu;
import com.cohesionforce.dis.avro.AcknowledgePdu;
import com.cohesionforce.dis.avro.ActionRequestPdu;
import com.cohesionforce.dis.avro.ActionResponsePdu;
import com.cohesionforce.dis.avro.DataQueryPdu;
import com.cohesionforce.dis.avro.SetDataPdu;
import com.cohesionforce.dis.avro.DataPdu;
import com.cohesionforce.dis.avro.EventReportPdu;
import com.cohesionforce.dis.avro.CommentPdu;
import com.cohesionforce.dis.avro.DistributedEmissionsFamilyPdu;
import com.cohesionforce.dis.avro.ElectronicEmissionsPdu;
import com.cohesionforce.dis.avro.DesignatorPdu;
import com.cohesionforce.dis.avro.UaPdu;
import com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu;
import com.cohesionforce.dis.avro.IffAtcNavAidsLayer2Pdu;
import com.cohesionforce.dis.avro.SeesPdu;
import com.cohesionforce.dis.avro.RadioCommunicationsFamilyPdu;
import com.cohesionforce.dis.avro.IntercomSignalPdu;
import com.cohesionforce.dis.avro.TransmitterPdu;
import com.cohesionforce.dis.avro.SignalPdu;
import com.cohesionforce.dis.avro.ReceiverPdu;
import com.cohesionforce.dis.avro.IntercomControlPdu;
import com.cohesionforce.dis.avro.EntityManagementFamilyPdu;
import com.cohesionforce.dis.avro.AggregateStatePdu;
import com.cohesionforce.dis.avro.IsGroupOfPdu;
import com.cohesionforce.dis.avro.TransferControlRequestPdu;
import com.cohesionforce.dis.avro.IsPartOfPdu;
import com.cohesionforce.dis.avro.MinefieldFamilyPdu;
import com.cohesionforce.dis.avro.MinefieldStatePdu;
import com.cohesionforce.dis.avro.MinefieldQueryPdu;
import com.cohesionforce.dis.avro.MinefieldDataPdu;
import com.cohesionforce.dis.avro.MinefieldResponseNackPdu;
import com.cohesionforce.dis.avro.SyntheticEnvironmentFamilyPdu;
import com.cohesionforce.dis.avro.EnvironmentalProcessPdu;
import com.cohesionforce.dis.avro.GriddedDataPdu;
import com.cohesionforce.dis.avro.PointObjectStatePdu;
import com.cohesionforce.dis.avro.LinearObjectStatePdu;
import com.cohesionforce.dis.avro.ArealObjectStatePdu;
import com.cohesionforce.dis.avro.SimulationManagementWithReliabilityFamilyPdu;
import com.cohesionforce.dis.avro.CreateEntityReliablePdu;
import com.cohesionforce.dis.avro.RemoveEntityReliablePdu;
import com.cohesionforce.dis.avro.StartResumeReliablePdu;
import com.cohesionforce.dis.avro.StopFreezeReliablePdu;
import com.cohesionforce.dis.avro.AcknowledgeReliablePdu;
import com.cohesionforce.dis.avro.ActionRequestReliablePdu;
import com.cohesionforce.dis.avro.ActionResponseReliablePdu;
import com.cohesionforce.dis.avro.DataQueryReliablePdu;
import com.cohesionforce.dis.avro.SetDataReliablePdu;
import com.cohesionforce.dis.avro.DataReliablePdu;
import com.cohesionforce.dis.avro.EventReportReliablePdu;
import com.cohesionforce.dis.avro.CommentReliablePdu;
import com.cohesionforce.dis.avro.RecordQueryReliablePdu;
import com.cohesionforce.dis.avro.SetRecordReliablePdu;

public class BinaryConverter implements Runnable {

	private String outputDirectory;
	private String inputFile;
	private Unmarshaller unmarshaller;
	public static final int MAX_PDU_SIZE = 2048;
	private ThreadGroup threadGroup;
	private String extension = "avro";

	private LogWriter<Pdu> pduWriter;
	private LogWriter<EntityInformationFamilyPdu> entityInformationFamilyPduWriter;
	private LogWriter<EntityStatePdu> entityStatePduWriter;
	private LogWriter<CollisionPdu> collisionPduWriter;
	private LogWriter<CollisionElasticPdu> collisionElasticPduWriter;
	private LogWriter<EntityStateUpdatePdu> entityStateUpdatePduWriter;
	private LogWriter<WarfareFamilyPdu> warfareFamilyPduWriter;
	private LogWriter<FirePdu> firePduWriter;
	private LogWriter<DetonationPdu> detonationPduWriter;
	private LogWriter<LogisticsFamilyPdu> logisticsFamilyPduWriter;
	private LogWriter<ServiceRequestPdu> serviceRequestPduWriter;
	private LogWriter<ResupplyOfferPdu> resupplyOfferPduWriter;
	private LogWriter<ResupplyReceivedPdu> resupplyReceivedPduWriter;
	private LogWriter<ResupplyCancelPdu> resupplyCancelPduWriter;
	private LogWriter<RepairCompletePdu> repairCompletePduWriter;
	private LogWriter<RepairResponsePdu> repairResponsePduWriter;
	private LogWriter<SimulationManagementFamilyPdu> simulationManagementFamilyPduWriter;
	private LogWriter<CreateEntityPdu> createEntityPduWriter;
	private LogWriter<RemoveEntityPdu> removeEntityPduWriter;
	private LogWriter<StartResumePdu> startResumePduWriter;
	private LogWriter<StopFreezePdu> stopFreezePduWriter;
	private LogWriter<AcknowledgePdu> acknowledgePduWriter;
	private LogWriter<ActionRequestPdu> actionRequestPduWriter;
	private LogWriter<ActionResponsePdu> actionResponsePduWriter;
	private LogWriter<DataQueryPdu> dataQueryPduWriter;
	private LogWriter<SetDataPdu> setDataPduWriter;
	private LogWriter<DataPdu> dataPduWriter;
	private LogWriter<EventReportPdu> eventReportPduWriter;
	private LogWriter<CommentPdu> commentPduWriter;
	private LogWriter<DistributedEmissionsFamilyPdu> distributedEmissionsFamilyPduWriter;
	private LogWriter<ElectronicEmissionsPdu> electronicEmissionsPduWriter;
	private LogWriter<DesignatorPdu> designatorPduWriter;
	private LogWriter<UaPdu> uaPduWriter;
	private LogWriter<IffAtcNavAidsLayer1Pdu> iffAtcNavAidsLayer1PduWriter;
	private LogWriter<IffAtcNavAidsLayer2Pdu> iffAtcNavAidsLayer2PduWriter;
	private LogWriter<SeesPdu> seesPduWriter;
	private LogWriter<RadioCommunicationsFamilyPdu> radioCommunicationsFamilyPduWriter;
	private LogWriter<IntercomSignalPdu> intercomSignalPduWriter;
	private LogWriter<TransmitterPdu> transmitterPduWriter;
	private LogWriter<SignalPdu> signalPduWriter;
	private LogWriter<ReceiverPdu> receiverPduWriter;
	private LogWriter<IntercomControlPdu> intercomControlPduWriter;
	private LogWriter<EntityManagementFamilyPdu> entityManagementFamilyPduWriter;
	private LogWriter<AggregateStatePdu> aggregateStatePduWriter;
	private LogWriter<IsGroupOfPdu> isGroupOfPduWriter;
	private LogWriter<TransferControlRequestPdu> transferControlRequestPduWriter;
	private LogWriter<IsPartOfPdu> isPartOfPduWriter;
	private LogWriter<MinefieldFamilyPdu> minefieldFamilyPduWriter;
	private LogWriter<MinefieldStatePdu> minefieldStatePduWriter;
	private LogWriter<MinefieldQueryPdu> minefieldQueryPduWriter;
	private LogWriter<MinefieldDataPdu> minefieldDataPduWriter;
	private LogWriter<MinefieldResponseNackPdu> minefieldResponseNackPduWriter;
	private LogWriter<SyntheticEnvironmentFamilyPdu> syntheticEnvironmentFamilyPduWriter;
	private LogWriter<EnvironmentalProcessPdu> environmentalProcessPduWriter;
	private LogWriter<GriddedDataPdu> griddedDataPduWriter;
	private LogWriter<PointObjectStatePdu> pointObjectStatePduWriter;
	private LogWriter<LinearObjectStatePdu> linearObjectStatePduWriter;
	private LogWriter<ArealObjectStatePdu> arealObjectStatePduWriter;
	private LogWriter<SimulationManagementWithReliabilityFamilyPdu> simulationManagementWithReliabilityFamilyPduWriter;
	private LogWriter<CreateEntityReliablePdu> createEntityReliablePduWriter;
	private LogWriter<RemoveEntityReliablePdu> removeEntityReliablePduWriter;
	private LogWriter<StartResumeReliablePdu> startResumeReliablePduWriter;
	private LogWriter<StopFreezeReliablePdu> stopFreezeReliablePduWriter;
	private LogWriter<AcknowledgeReliablePdu> acknowledgeReliablePduWriter;
	private LogWriter<ActionRequestReliablePdu> actionRequestReliablePduWriter;
	private LogWriter<ActionResponseReliablePdu> actionResponseReliablePduWriter;
	private LogWriter<DataQueryReliablePdu> dataQueryReliablePduWriter;
	private LogWriter<SetDataReliablePdu> setDataReliablePduWriter;
	private LogWriter<DataReliablePdu> dataReliablePduWriter;
	private LogWriter<EventReportReliablePdu> eventReportReliablePduWriter;
	private LogWriter<CommentReliablePdu> commentReliablePduWriter;
	private LogWriter<RecordQueryReliablePdu> recordQueryReliablePduWriter;
	private LogWriter<SetRecordReliablePdu> setRecordReliablePduWriter;
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
		case 1:
			entityStatePduWriter.getQueue().add((EntityStatePdu)pduObject);
		break;
		case 4:
			collisionPduWriter.getQueue().add((CollisionPdu)pduObject);
		break;
		case 66:
			collisionElasticPduWriter.getQueue().add((CollisionElasticPdu)pduObject);
		break;
		case 67:
			entityStateUpdatePduWriter.getQueue().add((EntityStateUpdatePdu)pduObject);
		break;
		case 2:
			firePduWriter.getQueue().add((FirePdu)pduObject);
		break;
		case 3:
			detonationPduWriter.getQueue().add((DetonationPdu)pduObject);
		break;
		case 5:
			serviceRequestPduWriter.getQueue().add((ServiceRequestPdu)pduObject);
		break;
		case 6:
			resupplyOfferPduWriter.getQueue().add((ResupplyOfferPdu)pduObject);
		break;
		case 7:
			resupplyReceivedPduWriter.getQueue().add((ResupplyReceivedPdu)pduObject);
		break;
		case 8:
			resupplyCancelPduWriter.getQueue().add((ResupplyCancelPdu)pduObject);
		break;
		case 9:
			repairCompletePduWriter.getQueue().add((RepairCompletePdu)pduObject);
		break;
		case 10:
			repairResponsePduWriter.getQueue().add((RepairResponsePdu)pduObject);
		break;
		case 11:
			createEntityPduWriter.getQueue().add((CreateEntityPdu)pduObject);
		break;
		case 12:
			removeEntityPduWriter.getQueue().add((RemoveEntityPdu)pduObject);
		break;
		case 13:
			startResumePduWriter.getQueue().add((StartResumePdu)pduObject);
		break;
		case 14:
			stopFreezePduWriter.getQueue().add((StopFreezePdu)pduObject);
		break;
		case 15:
			acknowledgePduWriter.getQueue().add((AcknowledgePdu)pduObject);
		break;
		case 16:
			actionRequestPduWriter.getQueue().add((ActionRequestPdu)pduObject);
		break;
		case 17:
			actionResponsePduWriter.getQueue().add((ActionResponsePdu)pduObject);
		break;
		case 18:
			dataQueryPduWriter.getQueue().add((DataQueryPdu)pduObject);
		break;
		case 19:
			setDataPduWriter.getQueue().add((SetDataPdu)pduObject);
		break;
		case 20:
			dataPduWriter.getQueue().add((DataPdu)pduObject);
		break;
		case 21:
			eventReportPduWriter.getQueue().add((EventReportPdu)pduObject);
		break;
		case 22:
			commentPduWriter.getQueue().add((CommentPdu)pduObject);
		break;
		case 23:
			electronicEmissionsPduWriter.getQueue().add((ElectronicEmissionsPdu)pduObject);
		break;
		case 24:
			designatorPduWriter.getQueue().add((DesignatorPdu)pduObject);
		break;
		case 29:
			uaPduWriter.getQueue().add((UaPdu)pduObject);
		break;
		case 28:
			iffAtcNavAidsLayer1PduWriter.getQueue().add((IffAtcNavAidsLayer1Pdu)pduObject);
		break;
		case 30:
			seesPduWriter.getQueue().add((SeesPdu)pduObject);
		break;
		case 31:
			intercomSignalPduWriter.getQueue().add((IntercomSignalPdu)pduObject);
		break;
		case 25:
			transmitterPduWriter.getQueue().add((TransmitterPdu)pduObject);
		break;
		case 26:
			signalPduWriter.getQueue().add((SignalPdu)pduObject);
		break;
		case 27:
			receiverPduWriter.getQueue().add((ReceiverPdu)pduObject);
		break;
		case 32:
			intercomControlPduWriter.getQueue().add((IntercomControlPdu)pduObject);
		break;
		case 33:
			aggregateStatePduWriter.getQueue().add((AggregateStatePdu)pduObject);
		break;
		case 34:
			isGroupOfPduWriter.getQueue().add((IsGroupOfPdu)pduObject);
		break;
		case 35:
			transferControlRequestPduWriter.getQueue().add((TransferControlRequestPdu)pduObject);
		break;
		case 36:
			isPartOfPduWriter.getQueue().add((IsPartOfPdu)pduObject);
		break;
		case 37:
			minefieldStatePduWriter.getQueue().add((MinefieldStatePdu)pduObject);
		break;
		case 38:
			minefieldQueryPduWriter.getQueue().add((MinefieldQueryPdu)pduObject);
		break;
		case 39:
			minefieldDataPduWriter.getQueue().add((MinefieldDataPdu)pduObject);
		break;
		case 40:
			minefieldResponseNackPduWriter.getQueue().add((MinefieldResponseNackPdu)pduObject);
		break;
		case 41:
			environmentalProcessPduWriter.getQueue().add((EnvironmentalProcessPdu)pduObject);
		break;
		case 42:
			griddedDataPduWriter.getQueue().add((GriddedDataPdu)pduObject);
		break;
		case 43:
			pointObjectStatePduWriter.getQueue().add((PointObjectStatePdu)pduObject);
		break;
		case 44:
			linearObjectStatePduWriter.getQueue().add((LinearObjectStatePdu)pduObject);
		break;
		case 45:
			arealObjectStatePduWriter.getQueue().add((ArealObjectStatePdu)pduObject);
		break;
		case 51:
			createEntityReliablePduWriter.getQueue().add((CreateEntityReliablePdu)pduObject);
		break;
		case 52:
			removeEntityReliablePduWriter.getQueue().add((RemoveEntityReliablePdu)pduObject);
		break;
		case 53:
			startResumeReliablePduWriter.getQueue().add((StartResumeReliablePdu)pduObject);
		break;
		case 54:
			stopFreezeReliablePduWriter.getQueue().add((StopFreezeReliablePdu)pduObject);
		break;
		case 55:
			acknowledgeReliablePduWriter.getQueue().add((AcknowledgeReliablePdu)pduObject);
		break;
		case 56:
			actionRequestReliablePduWriter.getQueue().add((ActionRequestReliablePdu)pduObject);
		break;
		case 57:
			actionResponseReliablePduWriter.getQueue().add((ActionResponseReliablePdu)pduObject);
		break;
		case 58:
			dataQueryReliablePduWriter.getQueue().add((DataQueryReliablePdu)pduObject);
		break;
		case 59:
			setDataReliablePduWriter.getQueue().add((SetDataReliablePdu)pduObject);
		break;
		case 60:
			dataReliablePduWriter.getQueue().add((DataReliablePdu)pduObject);
		break;
		case 61:
			eventReportReliablePduWriter.getQueue().add((EventReportReliablePdu)pduObject);
		break;
		case 62:
			commentReliablePduWriter.getQueue().add((CommentReliablePdu)pduObject);
		break;
		case 65:
			recordQueryReliablePduWriter.getQueue().add((RecordQueryReliablePdu)pduObject);
		break;
		case 64:
			setRecordReliablePduWriter.getQueue().add((SetRecordReliablePdu)pduObject);
		break;
		}
	}
	
	private void startWriters() {
		
	pduWriter = new LogWriter<Pdu>(threadGroup, outputDirectory + File.separator + "Pdu."+ extension, Pdu.getClassSchema());
	writers.add(pduWriter);
	pduWriter.start();
	entityInformationFamilyPduWriter = new LogWriter<EntityInformationFamilyPdu>(threadGroup, outputDirectory + File.separator + "EntityInformationFamilyPdu."+ extension, EntityInformationFamilyPdu.getClassSchema());
	writers.add(entityInformationFamilyPduWriter);
	entityInformationFamilyPduWriter.start();
	entityStatePduWriter = new LogWriter<EntityStatePdu>(threadGroup, outputDirectory + File.separator + "EntityStatePdu."+ extension, EntityStatePdu.getClassSchema());
	writers.add(entityStatePduWriter);
	entityStatePduWriter.start();
	collisionPduWriter = new LogWriter<CollisionPdu>(threadGroup, outputDirectory + File.separator + "CollisionPdu."+ extension, CollisionPdu.getClassSchema());
	writers.add(collisionPduWriter);
	collisionPduWriter.start();
	collisionElasticPduWriter = new LogWriter<CollisionElasticPdu>(threadGroup, outputDirectory + File.separator + "CollisionElasticPdu."+ extension, CollisionElasticPdu.getClassSchema());
	writers.add(collisionElasticPduWriter);
	collisionElasticPduWriter.start();
	entityStateUpdatePduWriter = new LogWriter<EntityStateUpdatePdu>(threadGroup, outputDirectory + File.separator + "EntityStateUpdatePdu."+ extension, EntityStateUpdatePdu.getClassSchema());
	writers.add(entityStateUpdatePduWriter);
	entityStateUpdatePduWriter.start();
	warfareFamilyPduWriter = new LogWriter<WarfareFamilyPdu>(threadGroup, outputDirectory + File.separator + "WarfareFamilyPdu."+ extension, WarfareFamilyPdu.getClassSchema());
	writers.add(warfareFamilyPduWriter);
	warfareFamilyPduWriter.start();
	firePduWriter = new LogWriter<FirePdu>(threadGroup, outputDirectory + File.separator + "FirePdu."+ extension, FirePdu.getClassSchema());
	writers.add(firePduWriter);
	firePduWriter.start();
	detonationPduWriter = new LogWriter<DetonationPdu>(threadGroup, outputDirectory + File.separator + "DetonationPdu."+ extension, DetonationPdu.getClassSchema());
	writers.add(detonationPduWriter);
	detonationPduWriter.start();
	logisticsFamilyPduWriter = new LogWriter<LogisticsFamilyPdu>(threadGroup, outputDirectory + File.separator + "LogisticsFamilyPdu."+ extension, LogisticsFamilyPdu.getClassSchema());
	writers.add(logisticsFamilyPduWriter);
	logisticsFamilyPduWriter.start();
	serviceRequestPduWriter = new LogWriter<ServiceRequestPdu>(threadGroup, outputDirectory + File.separator + "ServiceRequestPdu."+ extension, ServiceRequestPdu.getClassSchema());
	writers.add(serviceRequestPduWriter);
	serviceRequestPduWriter.start();
	resupplyOfferPduWriter = new LogWriter<ResupplyOfferPdu>(threadGroup, outputDirectory + File.separator + "ResupplyOfferPdu."+ extension, ResupplyOfferPdu.getClassSchema());
	writers.add(resupplyOfferPduWriter);
	resupplyOfferPduWriter.start();
	resupplyReceivedPduWriter = new LogWriter<ResupplyReceivedPdu>(threadGroup, outputDirectory + File.separator + "ResupplyReceivedPdu."+ extension, ResupplyReceivedPdu.getClassSchema());
	writers.add(resupplyReceivedPduWriter);
	resupplyReceivedPduWriter.start();
	resupplyCancelPduWriter = new LogWriter<ResupplyCancelPdu>(threadGroup, outputDirectory + File.separator + "ResupplyCancelPdu."+ extension, ResupplyCancelPdu.getClassSchema());
	writers.add(resupplyCancelPduWriter);
	resupplyCancelPduWriter.start();
	repairCompletePduWriter = new LogWriter<RepairCompletePdu>(threadGroup, outputDirectory + File.separator + "RepairCompletePdu."+ extension, RepairCompletePdu.getClassSchema());
	writers.add(repairCompletePduWriter);
	repairCompletePduWriter.start();
	repairResponsePduWriter = new LogWriter<RepairResponsePdu>(threadGroup, outputDirectory + File.separator + "RepairResponsePdu."+ extension, RepairResponsePdu.getClassSchema());
	writers.add(repairResponsePduWriter);
	repairResponsePduWriter.start();
	simulationManagementFamilyPduWriter = new LogWriter<SimulationManagementFamilyPdu>(threadGroup, outputDirectory + File.separator + "SimulationManagementFamilyPdu."+ extension, SimulationManagementFamilyPdu.getClassSchema());
	writers.add(simulationManagementFamilyPduWriter);
	simulationManagementFamilyPduWriter.start();
	createEntityPduWriter = new LogWriter<CreateEntityPdu>(threadGroup, outputDirectory + File.separator + "CreateEntityPdu."+ extension, CreateEntityPdu.getClassSchema());
	writers.add(createEntityPduWriter);
	createEntityPduWriter.start();
	removeEntityPduWriter = new LogWriter<RemoveEntityPdu>(threadGroup, outputDirectory + File.separator + "RemoveEntityPdu."+ extension, RemoveEntityPdu.getClassSchema());
	writers.add(removeEntityPduWriter);
	removeEntityPduWriter.start();
	startResumePduWriter = new LogWriter<StartResumePdu>(threadGroup, outputDirectory + File.separator + "StartResumePdu."+ extension, StartResumePdu.getClassSchema());
	writers.add(startResumePduWriter);
	startResumePduWriter.start();
	stopFreezePduWriter = new LogWriter<StopFreezePdu>(threadGroup, outputDirectory + File.separator + "StopFreezePdu."+ extension, StopFreezePdu.getClassSchema());
	writers.add(stopFreezePduWriter);
	stopFreezePduWriter.start();
	acknowledgePduWriter = new LogWriter<AcknowledgePdu>(threadGroup, outputDirectory + File.separator + "AcknowledgePdu."+ extension, AcknowledgePdu.getClassSchema());
	writers.add(acknowledgePduWriter);
	acknowledgePduWriter.start();
	actionRequestPduWriter = new LogWriter<ActionRequestPdu>(threadGroup, outputDirectory + File.separator + "ActionRequestPdu."+ extension, ActionRequestPdu.getClassSchema());
	writers.add(actionRequestPduWriter);
	actionRequestPduWriter.start();
	actionResponsePduWriter = new LogWriter<ActionResponsePdu>(threadGroup, outputDirectory + File.separator + "ActionResponsePdu."+ extension, ActionResponsePdu.getClassSchema());
	writers.add(actionResponsePduWriter);
	actionResponsePduWriter.start();
	dataQueryPduWriter = new LogWriter<DataQueryPdu>(threadGroup, outputDirectory + File.separator + "DataQueryPdu."+ extension, DataQueryPdu.getClassSchema());
	writers.add(dataQueryPduWriter);
	dataQueryPduWriter.start();
	setDataPduWriter = new LogWriter<SetDataPdu>(threadGroup, outputDirectory + File.separator + "SetDataPdu."+ extension, SetDataPdu.getClassSchema());
	writers.add(setDataPduWriter);
	setDataPduWriter.start();
	dataPduWriter = new LogWriter<DataPdu>(threadGroup, outputDirectory + File.separator + "DataPdu."+ extension, DataPdu.getClassSchema());
	writers.add(dataPduWriter);
	dataPduWriter.start();
	eventReportPduWriter = new LogWriter<EventReportPdu>(threadGroup, outputDirectory + File.separator + "EventReportPdu."+ extension, EventReportPdu.getClassSchema());
	writers.add(eventReportPduWriter);
	eventReportPduWriter.start();
	commentPduWriter = new LogWriter<CommentPdu>(threadGroup, outputDirectory + File.separator + "CommentPdu."+ extension, CommentPdu.getClassSchema());
	writers.add(commentPduWriter);
	commentPduWriter.start();
	distributedEmissionsFamilyPduWriter = new LogWriter<DistributedEmissionsFamilyPdu>(threadGroup, outputDirectory + File.separator + "DistributedEmissionsFamilyPdu."+ extension, DistributedEmissionsFamilyPdu.getClassSchema());
	writers.add(distributedEmissionsFamilyPduWriter);
	distributedEmissionsFamilyPduWriter.start();
	electronicEmissionsPduWriter = new LogWriter<ElectronicEmissionsPdu>(threadGroup, outputDirectory + File.separator + "ElectronicEmissionsPdu."+ extension, ElectronicEmissionsPdu.getClassSchema());
	writers.add(electronicEmissionsPduWriter);
	electronicEmissionsPduWriter.start();
	designatorPduWriter = new LogWriter<DesignatorPdu>(threadGroup, outputDirectory + File.separator + "DesignatorPdu."+ extension, DesignatorPdu.getClassSchema());
	writers.add(designatorPduWriter);
	designatorPduWriter.start();
	uaPduWriter = new LogWriter<UaPdu>(threadGroup, outputDirectory + File.separator + "UaPdu."+ extension, UaPdu.getClassSchema());
	writers.add(uaPduWriter);
	uaPduWriter.start();
	iffAtcNavAidsLayer1PduWriter = new LogWriter<IffAtcNavAidsLayer1Pdu>(threadGroup, outputDirectory + File.separator + "IffAtcNavAidsLayer1Pdu."+ extension, IffAtcNavAidsLayer1Pdu.getClassSchema());
	writers.add(iffAtcNavAidsLayer1PduWriter);
	iffAtcNavAidsLayer1PduWriter.start();
	iffAtcNavAidsLayer2PduWriter = new LogWriter<IffAtcNavAidsLayer2Pdu>(threadGroup, outputDirectory + File.separator + "IffAtcNavAidsLayer2Pdu."+ extension, IffAtcNavAidsLayer2Pdu.getClassSchema());
	writers.add(iffAtcNavAidsLayer2PduWriter);
	iffAtcNavAidsLayer2PduWriter.start();
	seesPduWriter = new LogWriter<SeesPdu>(threadGroup, outputDirectory + File.separator + "SeesPdu."+ extension, SeesPdu.getClassSchema());
	writers.add(seesPduWriter);
	seesPduWriter.start();
	radioCommunicationsFamilyPduWriter = new LogWriter<RadioCommunicationsFamilyPdu>(threadGroup, outputDirectory + File.separator + "RadioCommunicationsFamilyPdu."+ extension, RadioCommunicationsFamilyPdu.getClassSchema());
	writers.add(radioCommunicationsFamilyPduWriter);
	radioCommunicationsFamilyPduWriter.start();
	intercomSignalPduWriter = new LogWriter<IntercomSignalPdu>(threadGroup, outputDirectory + File.separator + "IntercomSignalPdu."+ extension, IntercomSignalPdu.getClassSchema());
	writers.add(intercomSignalPduWriter);
	intercomSignalPduWriter.start();
	transmitterPduWriter = new LogWriter<TransmitterPdu>(threadGroup, outputDirectory + File.separator + "TransmitterPdu."+ extension, TransmitterPdu.getClassSchema());
	writers.add(transmitterPduWriter);
	transmitterPduWriter.start();
	signalPduWriter = new LogWriter<SignalPdu>(threadGroup, outputDirectory + File.separator + "SignalPdu."+ extension, SignalPdu.getClassSchema());
	writers.add(signalPduWriter);
	signalPduWriter.start();
	receiverPduWriter = new LogWriter<ReceiverPdu>(threadGroup, outputDirectory + File.separator + "ReceiverPdu."+ extension, ReceiverPdu.getClassSchema());
	writers.add(receiverPduWriter);
	receiverPduWriter.start();
	intercomControlPduWriter = new LogWriter<IntercomControlPdu>(threadGroup, outputDirectory + File.separator + "IntercomControlPdu."+ extension, IntercomControlPdu.getClassSchema());
	writers.add(intercomControlPduWriter);
	intercomControlPduWriter.start();
	entityManagementFamilyPduWriter = new LogWriter<EntityManagementFamilyPdu>(threadGroup, outputDirectory + File.separator + "EntityManagementFamilyPdu."+ extension, EntityManagementFamilyPdu.getClassSchema());
	writers.add(entityManagementFamilyPduWriter);
	entityManagementFamilyPduWriter.start();
	aggregateStatePduWriter = new LogWriter<AggregateStatePdu>(threadGroup, outputDirectory + File.separator + "AggregateStatePdu."+ extension, AggregateStatePdu.getClassSchema());
	writers.add(aggregateStatePduWriter);
	aggregateStatePduWriter.start();
	isGroupOfPduWriter = new LogWriter<IsGroupOfPdu>(threadGroup, outputDirectory + File.separator + "IsGroupOfPdu."+ extension, IsGroupOfPdu.getClassSchema());
	writers.add(isGroupOfPduWriter);
	isGroupOfPduWriter.start();
	transferControlRequestPduWriter = new LogWriter<TransferControlRequestPdu>(threadGroup, outputDirectory + File.separator + "TransferControlRequestPdu."+ extension, TransferControlRequestPdu.getClassSchema());
	writers.add(transferControlRequestPduWriter);
	transferControlRequestPduWriter.start();
	isPartOfPduWriter = new LogWriter<IsPartOfPdu>(threadGroup, outputDirectory + File.separator + "IsPartOfPdu."+ extension, IsPartOfPdu.getClassSchema());
	writers.add(isPartOfPduWriter);
	isPartOfPduWriter.start();
	minefieldFamilyPduWriter = new LogWriter<MinefieldFamilyPdu>(threadGroup, outputDirectory + File.separator + "MinefieldFamilyPdu."+ extension, MinefieldFamilyPdu.getClassSchema());
	writers.add(minefieldFamilyPduWriter);
	minefieldFamilyPduWriter.start();
	minefieldStatePduWriter = new LogWriter<MinefieldStatePdu>(threadGroup, outputDirectory + File.separator + "MinefieldStatePdu."+ extension, MinefieldStatePdu.getClassSchema());
	writers.add(minefieldStatePduWriter);
	minefieldStatePduWriter.start();
	minefieldQueryPduWriter = new LogWriter<MinefieldQueryPdu>(threadGroup, outputDirectory + File.separator + "MinefieldQueryPdu."+ extension, MinefieldQueryPdu.getClassSchema());
	writers.add(minefieldQueryPduWriter);
	minefieldQueryPduWriter.start();
	minefieldDataPduWriter = new LogWriter<MinefieldDataPdu>(threadGroup, outputDirectory + File.separator + "MinefieldDataPdu."+ extension, MinefieldDataPdu.getClassSchema());
	writers.add(minefieldDataPduWriter);
	minefieldDataPduWriter.start();
	minefieldResponseNackPduWriter = new LogWriter<MinefieldResponseNackPdu>(threadGroup, outputDirectory + File.separator + "MinefieldResponseNackPdu."+ extension, MinefieldResponseNackPdu.getClassSchema());
	writers.add(minefieldResponseNackPduWriter);
	minefieldResponseNackPduWriter.start();
	syntheticEnvironmentFamilyPduWriter = new LogWriter<SyntheticEnvironmentFamilyPdu>(threadGroup, outputDirectory + File.separator + "SyntheticEnvironmentFamilyPdu."+ extension, SyntheticEnvironmentFamilyPdu.getClassSchema());
	writers.add(syntheticEnvironmentFamilyPduWriter);
	syntheticEnvironmentFamilyPduWriter.start();
	environmentalProcessPduWriter = new LogWriter<EnvironmentalProcessPdu>(threadGroup, outputDirectory + File.separator + "EnvironmentalProcessPdu."+ extension, EnvironmentalProcessPdu.getClassSchema());
	writers.add(environmentalProcessPduWriter);
	environmentalProcessPduWriter.start();
	griddedDataPduWriter = new LogWriter<GriddedDataPdu>(threadGroup, outputDirectory + File.separator + "GriddedDataPdu."+ extension, GriddedDataPdu.getClassSchema());
	writers.add(griddedDataPduWriter);
	griddedDataPduWriter.start();
	pointObjectStatePduWriter = new LogWriter<PointObjectStatePdu>(threadGroup, outputDirectory + File.separator + "PointObjectStatePdu."+ extension, PointObjectStatePdu.getClassSchema());
	writers.add(pointObjectStatePduWriter);
	pointObjectStatePduWriter.start();
	linearObjectStatePduWriter = new LogWriter<LinearObjectStatePdu>(threadGroup, outputDirectory + File.separator + "LinearObjectStatePdu."+ extension, LinearObjectStatePdu.getClassSchema());
	writers.add(linearObjectStatePduWriter);
	linearObjectStatePduWriter.start();
	arealObjectStatePduWriter = new LogWriter<ArealObjectStatePdu>(threadGroup, outputDirectory + File.separator + "ArealObjectStatePdu."+ extension, ArealObjectStatePdu.getClassSchema());
	writers.add(arealObjectStatePduWriter);
	arealObjectStatePduWriter.start();
	simulationManagementWithReliabilityFamilyPduWriter = new LogWriter<SimulationManagementWithReliabilityFamilyPdu>(threadGroup, outputDirectory + File.separator + "SimulationManagementWithReliabilityFamilyPdu."+ extension, SimulationManagementWithReliabilityFamilyPdu.getClassSchema());
	writers.add(simulationManagementWithReliabilityFamilyPduWriter);
	simulationManagementWithReliabilityFamilyPduWriter.start();
	createEntityReliablePduWriter = new LogWriter<CreateEntityReliablePdu>(threadGroup, outputDirectory + File.separator + "CreateEntityReliablePdu."+ extension, CreateEntityReliablePdu.getClassSchema());
	writers.add(createEntityReliablePduWriter);
	createEntityReliablePduWriter.start();
	removeEntityReliablePduWriter = new LogWriter<RemoveEntityReliablePdu>(threadGroup, outputDirectory + File.separator + "RemoveEntityReliablePdu."+ extension, RemoveEntityReliablePdu.getClassSchema());
	writers.add(removeEntityReliablePduWriter);
	removeEntityReliablePduWriter.start();
	startResumeReliablePduWriter = new LogWriter<StartResumeReliablePdu>(threadGroup, outputDirectory + File.separator + "StartResumeReliablePdu."+ extension, StartResumeReliablePdu.getClassSchema());
	writers.add(startResumeReliablePduWriter);
	startResumeReliablePduWriter.start();
	stopFreezeReliablePduWriter = new LogWriter<StopFreezeReliablePdu>(threadGroup, outputDirectory + File.separator + "StopFreezeReliablePdu."+ extension, StopFreezeReliablePdu.getClassSchema());
	writers.add(stopFreezeReliablePduWriter);
	stopFreezeReliablePduWriter.start();
	acknowledgeReliablePduWriter = new LogWriter<AcknowledgeReliablePdu>(threadGroup, outputDirectory + File.separator + "AcknowledgeReliablePdu."+ extension, AcknowledgeReliablePdu.getClassSchema());
	writers.add(acknowledgeReliablePduWriter);
	acknowledgeReliablePduWriter.start();
	actionRequestReliablePduWriter = new LogWriter<ActionRequestReliablePdu>(threadGroup, outputDirectory + File.separator + "ActionRequestReliablePdu."+ extension, ActionRequestReliablePdu.getClassSchema());
	writers.add(actionRequestReliablePduWriter);
	actionRequestReliablePduWriter.start();
	actionResponseReliablePduWriter = new LogWriter<ActionResponseReliablePdu>(threadGroup, outputDirectory + File.separator + "ActionResponseReliablePdu."+ extension, ActionResponseReliablePdu.getClassSchema());
	writers.add(actionResponseReliablePduWriter);
	actionResponseReliablePduWriter.start();
	dataQueryReliablePduWriter = new LogWriter<DataQueryReliablePdu>(threadGroup, outputDirectory + File.separator + "DataQueryReliablePdu."+ extension, DataQueryReliablePdu.getClassSchema());
	writers.add(dataQueryReliablePduWriter);
	dataQueryReliablePduWriter.start();
	setDataReliablePduWriter = new LogWriter<SetDataReliablePdu>(threadGroup, outputDirectory + File.separator + "SetDataReliablePdu."+ extension, SetDataReliablePdu.getClassSchema());
	writers.add(setDataReliablePduWriter);
	setDataReliablePduWriter.start();
	dataReliablePduWriter = new LogWriter<DataReliablePdu>(threadGroup, outputDirectory + File.separator + "DataReliablePdu."+ extension, DataReliablePdu.getClassSchema());
	writers.add(dataReliablePduWriter);
	dataReliablePduWriter.start();
	eventReportReliablePduWriter = new LogWriter<EventReportReliablePdu>(threadGroup, outputDirectory + File.separator + "EventReportReliablePdu."+ extension, EventReportReliablePdu.getClassSchema());
	writers.add(eventReportReliablePduWriter);
	eventReportReliablePduWriter.start();
	commentReliablePduWriter = new LogWriter<CommentReliablePdu>(threadGroup, outputDirectory + File.separator + "CommentReliablePdu."+ extension, CommentReliablePdu.getClassSchema());
	writers.add(commentReliablePduWriter);
	commentReliablePduWriter.start();
	recordQueryReliablePduWriter = new LogWriter<RecordQueryReliablePdu>(threadGroup, outputDirectory + File.separator + "RecordQueryReliablePdu."+ extension, RecordQueryReliablePdu.getClassSchema());
	writers.add(recordQueryReliablePduWriter);
	recordQueryReliablePduWriter.start();
	setRecordReliablePduWriter = new LogWriter<SetRecordReliablePdu>(threadGroup, outputDirectory + File.separator + "SetRecordReliablePdu."+ extension, SetRecordReliablePdu.getClassSchema());
	writers.add(setRecordReliablePduWriter);
	setRecordReliablePduWriter.start();
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
