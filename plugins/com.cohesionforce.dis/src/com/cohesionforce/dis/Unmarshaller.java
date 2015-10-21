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

import com.cohesionforce.dis.avro.AngularVelocityVector;
import com.cohesionforce.dis.avro.AntennaLocation;
import com.cohesionforce.dis.avro.BeamAntennaPattern;
import com.cohesionforce.dis.avro.SphericalHarmonicAntennaPattern;
import com.cohesionforce.dis.avro.ArticulationParameter;
import com.cohesionforce.dis.avro.BurstDescriptor;
import com.cohesionforce.dis.avro.ClockTime;
import com.cohesionforce.dis.avro.EmitterSystem;
import com.cohesionforce.dis.avro.SimulationAddress;
import com.cohesionforce.dis.avro.EntityType;
import com.cohesionforce.dis.avro.ObjectType;
import com.cohesionforce.dis.avro.Orientation;
import com.cohesionforce.dis.avro.EventID;
import com.cohesionforce.dis.avro.FixedDatum;
import com.cohesionforce.dis.avro.FundamentalParameterData;
import com.cohesionforce.dis.avro.RadioEntityType;
import com.cohesionforce.dis.avro.SupplyQuantity;
import com.cohesionforce.dis.avro.VariableDatum;
import com.cohesionforce.dis.avro.AcousticEmitter;
import com.cohesionforce.dis.avro.TrackJamTarget;
import com.cohesionforce.dis.avro.ElectronicEmissionBeamData;
import com.cohesionforce.dis.avro.ElectronicEmissionSystemData;
import com.cohesionforce.dis.avro.AggregateID;
import com.cohesionforce.dis.avro.Marking;
import com.cohesionforce.dis.avro.AggregateMarking;
import com.cohesionforce.dis.avro.AggregateType;
import com.cohesionforce.dis.avro.BeamData;
import com.cohesionforce.dis.avro.Environment;
import com.cohesionforce.dis.avro.Vector3Float;
import com.cohesionforce.dis.avro.Vector3Double;
import com.cohesionforce.dis.avro.EntityID;
import com.cohesionforce.dis.avro.ShaftRPMs;
import com.cohesionforce.dis.avro.PropulsionSystemData;
import com.cohesionforce.dis.avro.VectoringNozzleSystemData;
import com.cohesionforce.dis.avro.AcousticEmitterSystem;
import com.cohesionforce.dis.avro.AcousticEmitterSystemData;
import com.cohesionforce.dis.avro.AcousticBeamData;
import com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter;
import com.cohesionforce.dis.avro.ApaData;
import com.cohesionforce.dis.avro.IffFundamentalData;
import com.cohesionforce.dis.avro.IntercomCommunicationsParameters;
import com.cohesionforce.dis.avro.LayerHeader;
import com.cohesionforce.dis.avro.SystemID;
import com.cohesionforce.dis.avro.FundamentalParameterDataIff;
import com.cohesionforce.dis.avro.GridAxis;
import com.cohesionforce.dis.avro.GridAxisRecord;
import com.cohesionforce.dis.avro.GridAxisRecordRepresentation0;
import com.cohesionforce.dis.avro.GridAxisRecordRepresentation1;
import com.cohesionforce.dis.avro.GridAxisRecordRepresentation2;
import com.cohesionforce.dis.avro.SixByteChunk;
import com.cohesionforce.dis.avro.LinearSegmentParameter;
import com.cohesionforce.dis.avro.EightByteChunk;
import com.cohesionforce.dis.avro.OneByteChunk;
import com.cohesionforce.dis.avro.TwoByteChunk;
import com.cohesionforce.dis.avro.FourByteChunk;
import com.cohesionforce.dis.avro.Point;
import com.cohesionforce.dis.avro.ModulationType;
import com.cohesionforce.dis.avro.Relationship;
import com.cohesionforce.dis.avro.NamedLocation;
import com.cohesionforce.dis.avro.DeadReckoningParameter;
import com.cohesionforce.dis.avro.RecordSet;
import com.cohesionforce.dis.avro.PduStream;
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
import com.cohesionforce.dis.avro.PduContainer;

public class Unmarshaller {

public Object getPdu(byte[] data) throws IOException {
    // Promote a signed byte to an int, then do a bitwise AND to wipe out everthing but the 
    // first eight bits. This effectively lets us read this as an unsigned byte
     // The pdu type is a one-byte, unsigned byte in the third byte position.
    int pduType = 0x000000FF & (int) data[2];

    DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));

	switch(pduType) {
case 1:
	EntityStatePdu newEntityStatePdu = unMarshallEntityStatePdu(dis);
	return newEntityStatePdu;
case 4:
	CollisionPdu newCollisionPdu = unMarshallCollisionPdu(dis);
	return newCollisionPdu;
case 66:
	CollisionElasticPdu newCollisionElasticPdu = unMarshallCollisionElasticPdu(dis);
	return newCollisionElasticPdu;
case 67:
	EntityStateUpdatePdu newEntityStateUpdatePdu = unMarshallEntityStateUpdatePdu(dis);
	return newEntityStateUpdatePdu;
case 2:
	FirePdu newFirePdu = unMarshallFirePdu(dis);
	return newFirePdu;
case 3:
	DetonationPdu newDetonationPdu = unMarshallDetonationPdu(dis);
	return newDetonationPdu;
case 5:
	ServiceRequestPdu newServiceRequestPdu = unMarshallServiceRequestPdu(dis);
	return newServiceRequestPdu;
case 6:
	ResupplyOfferPdu newResupplyOfferPdu = unMarshallResupplyOfferPdu(dis);
	return newResupplyOfferPdu;
case 7:
	ResupplyReceivedPdu newResupplyReceivedPdu = unMarshallResupplyReceivedPdu(dis);
	return newResupplyReceivedPdu;
case 8:
	ResupplyCancelPdu newResupplyCancelPdu = unMarshallResupplyCancelPdu(dis);
	return newResupplyCancelPdu;
case 9:
	RepairCompletePdu newRepairCompletePdu = unMarshallRepairCompletePdu(dis);
	return newRepairCompletePdu;
case 10:
	RepairResponsePdu newRepairResponsePdu = unMarshallRepairResponsePdu(dis);
	return newRepairResponsePdu;
case 11:
	CreateEntityPdu newCreateEntityPdu = unMarshallCreateEntityPdu(dis);
	return newCreateEntityPdu;
case 12:
	RemoveEntityPdu newRemoveEntityPdu = unMarshallRemoveEntityPdu(dis);
	return newRemoveEntityPdu;
case 13:
	StartResumePdu newStartResumePdu = unMarshallStartResumePdu(dis);
	return newStartResumePdu;
case 14:
	StopFreezePdu newStopFreezePdu = unMarshallStopFreezePdu(dis);
	return newStopFreezePdu;
case 15:
	AcknowledgePdu newAcknowledgePdu = unMarshallAcknowledgePdu(dis);
	return newAcknowledgePdu;
case 16:
	ActionRequestPdu newActionRequestPdu = unMarshallActionRequestPdu(dis);
	return newActionRequestPdu;
case 17:
	ActionResponsePdu newActionResponsePdu = unMarshallActionResponsePdu(dis);
	return newActionResponsePdu;
case 18:
	DataQueryPdu newDataQueryPdu = unMarshallDataQueryPdu(dis);
	return newDataQueryPdu;
case 19:
	SetDataPdu newSetDataPdu = unMarshallSetDataPdu(dis);
	return newSetDataPdu;
case 20:
	DataPdu newDataPdu = unMarshallDataPdu(dis);
	return newDataPdu;
case 21:
	EventReportPdu newEventReportPdu = unMarshallEventReportPdu(dis);
	return newEventReportPdu;
case 22:
	CommentPdu newCommentPdu = unMarshallCommentPdu(dis);
	return newCommentPdu;
case 23:
	ElectronicEmissionsPdu newElectronicEmissionsPdu = unMarshallElectronicEmissionsPdu(dis);
	return newElectronicEmissionsPdu;
case 24:
	DesignatorPdu newDesignatorPdu = unMarshallDesignatorPdu(dis);
	return newDesignatorPdu;
case 29:
	UaPdu newUaPdu = unMarshallUaPdu(dis);
	return newUaPdu;
case 28:
	IffAtcNavAidsLayer1Pdu newIffAtcNavAidsLayer1Pdu = unMarshallIffAtcNavAidsLayer1Pdu(dis);
	return newIffAtcNavAidsLayer1Pdu;
case 30:
	SeesPdu newSeesPdu = unMarshallSeesPdu(dis);
	return newSeesPdu;
case 31:
	IntercomSignalPdu newIntercomSignalPdu = unMarshallIntercomSignalPdu(dis);
	return newIntercomSignalPdu;
case 25:
	TransmitterPdu newTransmitterPdu = unMarshallTransmitterPdu(dis);
	return newTransmitterPdu;
case 26:
	SignalPdu newSignalPdu = unMarshallSignalPdu(dis);
	return newSignalPdu;
case 27:
	ReceiverPdu newReceiverPdu = unMarshallReceiverPdu(dis);
	return newReceiverPdu;
case 32:
	IntercomControlPdu newIntercomControlPdu = unMarshallIntercomControlPdu(dis);
	return newIntercomControlPdu;
case 33:
	AggregateStatePdu newAggregateStatePdu = unMarshallAggregateStatePdu(dis);
	return newAggregateStatePdu;
case 34:
	IsGroupOfPdu newIsGroupOfPdu = unMarshallIsGroupOfPdu(dis);
	return newIsGroupOfPdu;
case 35:
	TransferControlRequestPdu newTransferControlRequestPdu = unMarshallTransferControlRequestPdu(dis);
	return newTransferControlRequestPdu;
case 36:
	IsPartOfPdu newIsPartOfPdu = unMarshallIsPartOfPdu(dis);
	return newIsPartOfPdu;
case 37:
	MinefieldStatePdu newMinefieldStatePdu = unMarshallMinefieldStatePdu(dis);
	return newMinefieldStatePdu;
case 38:
	MinefieldQueryPdu newMinefieldQueryPdu = unMarshallMinefieldQueryPdu(dis);
	return newMinefieldQueryPdu;
case 39:
	MinefieldDataPdu newMinefieldDataPdu = unMarshallMinefieldDataPdu(dis);
	return newMinefieldDataPdu;
case 40:
	MinefieldResponseNackPdu newMinefieldResponseNackPdu = unMarshallMinefieldResponseNackPdu(dis);
	return newMinefieldResponseNackPdu;
case 41:
	EnvironmentalProcessPdu newEnvironmentalProcessPdu = unMarshallEnvironmentalProcessPdu(dis);
	return newEnvironmentalProcessPdu;
case 42:
	GriddedDataPdu newGriddedDataPdu = unMarshallGriddedDataPdu(dis);
	return newGriddedDataPdu;
case 43:
	PointObjectStatePdu newPointObjectStatePdu = unMarshallPointObjectStatePdu(dis);
	return newPointObjectStatePdu;
case 44:
	LinearObjectStatePdu newLinearObjectStatePdu = unMarshallLinearObjectStatePdu(dis);
	return newLinearObjectStatePdu;
case 45:
	ArealObjectStatePdu newArealObjectStatePdu = unMarshallArealObjectStatePdu(dis);
	return newArealObjectStatePdu;
case 51:
	CreateEntityReliablePdu newCreateEntityReliablePdu = unMarshallCreateEntityReliablePdu(dis);
	return newCreateEntityReliablePdu;
case 52:
	RemoveEntityReliablePdu newRemoveEntityReliablePdu = unMarshallRemoveEntityReliablePdu(dis);
	return newRemoveEntityReliablePdu;
case 53:
	StartResumeReliablePdu newStartResumeReliablePdu = unMarshallStartResumeReliablePdu(dis);
	return newStartResumeReliablePdu;
case 54:
	StopFreezeReliablePdu newStopFreezeReliablePdu = unMarshallStopFreezeReliablePdu(dis);
	return newStopFreezeReliablePdu;
case 55:
	AcknowledgeReliablePdu newAcknowledgeReliablePdu = unMarshallAcknowledgeReliablePdu(dis);
	return newAcknowledgeReliablePdu;
case 56:
	ActionRequestReliablePdu newActionRequestReliablePdu = unMarshallActionRequestReliablePdu(dis);
	return newActionRequestReliablePdu;
case 57:
	ActionResponseReliablePdu newActionResponseReliablePdu = unMarshallActionResponseReliablePdu(dis);
	return newActionResponseReliablePdu;
case 58:
	DataQueryReliablePdu newDataQueryReliablePdu = unMarshallDataQueryReliablePdu(dis);
	return newDataQueryReliablePdu;
case 59:
	SetDataReliablePdu newSetDataReliablePdu = unMarshallSetDataReliablePdu(dis);
	return newSetDataReliablePdu;
case 60:
	DataReliablePdu newDataReliablePdu = unMarshallDataReliablePdu(dis);
	return newDataReliablePdu;
case 61:
	EventReportReliablePdu newEventReportReliablePdu = unMarshallEventReportReliablePdu(dis);
	return newEventReportReliablePdu;
case 62:
	CommentReliablePdu newCommentReliablePdu = unMarshallCommentReliablePdu(dis);
	return newCommentReliablePdu;
case 65:
	RecordQueryReliablePdu newRecordQueryReliablePdu = unMarshallRecordQueryReliablePdu(dis);
	return newRecordQueryReliablePdu;
case 64:
	SetRecordReliablePdu newSetRecordReliablePdu = unMarshallSetRecordReliablePdu(dis);
	return newSetRecordReliablePdu;
	}
	return null;
}

public com.cohesionforce.dis.avro.AngularVelocityVector unMarshallAngularVelocityVector(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AngularVelocityVector output = new com.cohesionforce.dis.avro.AngularVelocityVector();

	output.setX(dis.readFloat());
	output.setY(dis.readFloat());
	output.setZ(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.AntennaLocation unMarshallAntennaLocation(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AntennaLocation output = new com.cohesionforce.dis.avro.AntennaLocation();

	output.setAntennaLocation(unMarshallVector3Double(dis));
	output.setRelativeAntennaLocation(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.BeamAntennaPattern unMarshallBeamAntennaPattern(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.BeamAntennaPattern output = new com.cohesionforce.dis.avro.BeamAntennaPattern();

	output.setBeamDirection(unMarshallOrientation(dis));
	output.setAzimuthBeamwidth(dis.readFloat());
	output.setElevationBeamwidth(dis.readFloat());
	output.setReferenceSystem(dis.readFloat());
	output.setPadding1((int)dis.readShort());
	output.setPadding2((int)dis.readByte());
	output.setEz(dis.readFloat());
	output.setEx(dis.readFloat());
	output.setPhase(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.SphericalHarmonicAntennaPattern unMarshallSphericalHarmonicAntennaPattern(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SphericalHarmonicAntennaPattern output = new com.cohesionforce.dis.avro.SphericalHarmonicAntennaPattern();

	output.setHarmonicOrder((int)dis.readByte());
	return output;
}

public com.cohesionforce.dis.avro.ArticulationParameter unMarshallArticulationParameter(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ArticulationParameter output = new com.cohesionforce.dis.avro.ArticulationParameter();

	output.setParameterTypeDesignator((int)dis.readUnsignedByte());
	output.setChangeIndicator((int)dis.readUnsignedByte());
	output.setPartAttachedTo((int)dis.readUnsignedShort());
	output.setParameterType(dis.readInt());
	output.setParameterValue(dis.readDouble());
	return output;
}

public com.cohesionforce.dis.avro.BurstDescriptor unMarshallBurstDescriptor(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.BurstDescriptor output = new com.cohesionforce.dis.avro.BurstDescriptor();

	output.setMunition(unMarshallEntityType(dis));
	output.setWarhead((int)dis.readUnsignedShort());
	output.setFuse((int)dis.readUnsignedShort());
	output.setQuantity((int)dis.readUnsignedShort());
	output.setRate((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.ClockTime unMarshallClockTime(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ClockTime output = new com.cohesionforce.dis.avro.ClockTime();

	output.setHour(dis.readInt());
	output.setTimePastHour((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.EmitterSystem unMarshallEmitterSystem(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EmitterSystem output = new com.cohesionforce.dis.avro.EmitterSystem();

	output.setEmitterName((int)dis.readUnsignedShort());
	output.setFunction((int)dis.readUnsignedByte());
	output.setEmitterIdNumber((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.SimulationAddress unMarshallSimulationAddress(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SimulationAddress output = new com.cohesionforce.dis.avro.SimulationAddress();

	output.setSite((int)dis.readUnsignedShort());
	output.setApplication((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.EntityType unMarshallEntityType(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityType output = new com.cohesionforce.dis.avro.EntityType();

	output.setEntityKind((int)dis.readUnsignedByte());
	output.setDomain((int)dis.readUnsignedByte());
	output.setCountry((int)dis.readUnsignedShort());
	output.setCategory((int)dis.readUnsignedByte());
	output.setSubcategory((int)dis.readUnsignedByte());
	output.setSpec((int)dis.readUnsignedByte());
	output.setExtra((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.ObjectType unMarshallObjectType(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ObjectType output = new com.cohesionforce.dis.avro.ObjectType();

	output.setEntityKind((int)dis.readUnsignedByte());
	output.setDomain((int)dis.readUnsignedByte());
	output.setCountry((int)dis.readUnsignedShort());
	output.setCategory((int)dis.readUnsignedByte());
	output.setSubcategory((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.Orientation unMarshallOrientation(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Orientation output = new com.cohesionforce.dis.avro.Orientation();

	output.setPsi(dis.readFloat());
	output.setTheta(dis.readFloat());
	output.setPhi(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.EventID unMarshallEventID(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EventID output = new com.cohesionforce.dis.avro.EventID();

	output.setSite((int)dis.readUnsignedShort());
	output.setApplication((int)dis.readUnsignedShort());
	output.setEventNumber((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.FixedDatum unMarshallFixedDatum(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.FixedDatum output = new com.cohesionforce.dis.avro.FixedDatum();

	output.setFixedDatumID((long)dis.readInt());
	output.setFixedDatumValue((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.FundamentalParameterData unMarshallFundamentalParameterData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.FundamentalParameterData output = new com.cohesionforce.dis.avro.FundamentalParameterData();

	output.setFrequency(dis.readFloat());
	output.setFrequencyRange(dis.readFloat());
	output.setEffectiveRadiatedPower(dis.readFloat());
	output.setPulseRepetitionFrequency(dis.readFloat());
	output.setPulseWidth(dis.readFloat());
	output.setBeamAzimuthCenter(dis.readFloat());
	output.setBeamAzimuthSweep(dis.readFloat());
	output.setBeamElevationCenter(dis.readFloat());
	output.setBeamElevationSweep(dis.readFloat());
	output.setBeamSweepSync(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.RadioEntityType unMarshallRadioEntityType(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RadioEntityType output = new com.cohesionforce.dis.avro.RadioEntityType();

	output.setEntityKind((int)dis.readUnsignedByte());
	output.setDomain((int)dis.readUnsignedByte());
	output.setCountry((int)dis.readUnsignedShort());
	output.setCategory((int)dis.readUnsignedByte());
	output.setNomenclatureVersion((int)dis.readUnsignedByte());
	output.setNomenclature((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.SupplyQuantity unMarshallSupplyQuantity(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SupplyQuantity output = new com.cohesionforce.dis.avro.SupplyQuantity();

	output.setSupplyType(unMarshallEntityType(dis));
	output.setQuantity((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.VariableDatum unMarshallVariableDatum(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.VariableDatum output = new com.cohesionforce.dis.avro.VariableDatum();

	output.setVariableDatumID((long)dis.readInt());
	output.setVariableDatumLength((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.AcousticEmitter unMarshallAcousticEmitter(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcousticEmitter output = new com.cohesionforce.dis.avro.AcousticEmitter();

	output.setAcousticName((int)dis.readUnsignedShort());
	output.setFunction((int)dis.readUnsignedByte());
	output.setAcousticIdNumber((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.TrackJamTarget unMarshallTrackJamTarget(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.TrackJamTarget output = new com.cohesionforce.dis.avro.TrackJamTarget();

	output.setTrackJam(unMarshallEntityID(dis));
	output.setEmitterID((int)dis.readUnsignedByte());
	output.setBeamID((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.ElectronicEmissionBeamData unMarshallElectronicEmissionBeamData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ElectronicEmissionBeamData output = new com.cohesionforce.dis.avro.ElectronicEmissionBeamData();

	output.setBeamDataLength((int)dis.readUnsignedByte());
	output.setBeamIDNumber((int)dis.readUnsignedByte());
	output.setBeamParameterIndex((int)dis.readUnsignedShort());
	output.setFundamentalParameterData(unMarshallFundamentalParameterData(dis));
	output.setBeamFunction((int)dis.readUnsignedByte());
	output.setNumberOfTrackJamTargets((int)dis.readUnsignedByte());
	output.setHighDensityTrackJam((int)dis.readUnsignedByte());
	output.setPad4((int)dis.readUnsignedByte());
	output.setJammingModeSequence((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.ElectronicEmissionSystemData unMarshallElectronicEmissionSystemData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ElectronicEmissionSystemData output = new com.cohesionforce.dis.avro.ElectronicEmissionSystemData();

	output.setSystemDataLength((int)dis.readUnsignedByte());
	output.setNumberOfBeamDataRecords((int)dis.readUnsignedByte());
	output.setEmissionsPadding2((int)dis.readUnsignedShort());
	output.setEmitterSystem(unMarshallEmitterSystem(dis));
	output.setLocation(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.AggregateID unMarshallAggregateID(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AggregateID output = new com.cohesionforce.dis.avro.AggregateID();

	output.setSite((int)dis.readUnsignedShort());
	output.setApplication((int)dis.readUnsignedShort());
	output.setAggregateID((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.Marking unMarshallMarking(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Marking output = new com.cohesionforce.dis.avro.Marking();

	output.setCharacterSet((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.AggregateMarking unMarshallAggregateMarking(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AggregateMarking output = new com.cohesionforce.dis.avro.AggregateMarking();

	output.setCharacterSet((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.AggregateType unMarshallAggregateType(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AggregateType output = new com.cohesionforce.dis.avro.AggregateType();

	output.setAggregateKind((int)dis.readUnsignedByte());
	output.setDomain((int)dis.readUnsignedByte());
	output.setCountry((int)dis.readUnsignedShort());
	output.setCategory((int)dis.readUnsignedByte());
	output.setSubcategory((int)dis.readUnsignedByte());
	output.setSpecificInfo((int)dis.readUnsignedByte());
	output.setExtra((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.BeamData unMarshallBeamData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.BeamData output = new com.cohesionforce.dis.avro.BeamData();

	output.setBeamAzimuthCenter(dis.readFloat());
	output.setBeamAzimuthSweep(dis.readFloat());
	output.setBeamElevationCenter(dis.readFloat());
	output.setBeamElevationSweep(dis.readFloat());
	output.setBeamSweepSync(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.Environment unMarshallEnvironment(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Environment output = new com.cohesionforce.dis.avro.Environment();

	output.setEnvironmentType((long)dis.readInt());
	output.setLength((int)dis.readUnsignedByte());
	output.setRecordIndex((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readUnsignedByte());
	output.setGeometry((int)dis.readUnsignedByte());
	output.setPadding2((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.Vector3Float unMarshallVector3Float(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Vector3Float output = new com.cohesionforce.dis.avro.Vector3Float();

	output.setX(dis.readFloat());
	output.setY(dis.readFloat());
	output.setZ(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.Vector3Double unMarshallVector3Double(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Vector3Double output = new com.cohesionforce.dis.avro.Vector3Double();

	output.setX(dis.readDouble());
	output.setY(dis.readDouble());
	output.setZ(dis.readDouble());
	return output;
}

public com.cohesionforce.dis.avro.EntityID unMarshallEntityID(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityID output = new com.cohesionforce.dis.avro.EntityID();

	output.setSite((int)dis.readUnsignedShort());
	output.setApplication((int)dis.readUnsignedShort());
	output.setEntity((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.ShaftRPMs unMarshallShaftRPMs(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ShaftRPMs output = new com.cohesionforce.dis.avro.ShaftRPMs();

	output.setCurrentShaftRPMs((int)dis.readShort());
	output.setOrderedShaftRPMs((int)dis.readShort());
	output.setShaftRPMRateOfChange(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.PropulsionSystemData unMarshallPropulsionSystemData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.PropulsionSystemData output = new com.cohesionforce.dis.avro.PropulsionSystemData();

	output.setPowerSetting(dis.readFloat());
	output.setEngineRpm(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.VectoringNozzleSystemData unMarshallVectoringNozzleSystemData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.VectoringNozzleSystemData output = new com.cohesionforce.dis.avro.VectoringNozzleSystemData();

	output.setHorizontalDeflectionAngle(dis.readFloat());
	output.setVerticalDeflectionAngle(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.AcousticEmitterSystem unMarshallAcousticEmitterSystem(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcousticEmitterSystem output = new com.cohesionforce.dis.avro.AcousticEmitterSystem();

	output.setAcousticName((int)dis.readUnsignedShort());
	output.setAcousticFunction((int)dis.readUnsignedByte());
	output.setAcousticID((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.AcousticEmitterSystemData unMarshallAcousticEmitterSystemData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcousticEmitterSystemData output = new com.cohesionforce.dis.avro.AcousticEmitterSystemData();

	output.setEmitterSystemDataLength((int)dis.readUnsignedByte());
	output.setNumberOfBeamRecords((int)dis.readUnsignedByte());
	output.setPad2((int)dis.readUnsignedShort());
	output.setAcousticEmitterSystem(unMarshallAcousticEmitterSystem(dis));
	output.setEmitterLocation(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.AcousticBeamData unMarshallAcousticBeamData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcousticBeamData output = new com.cohesionforce.dis.avro.AcousticBeamData();

	output.setBeamDataLength((int)dis.readUnsignedShort());
	output.setBeamIDNumber((int)dis.readUnsignedByte());
	output.setPad2((int)dis.readUnsignedShort());
	output.setFundamentalDataParameters(unMarshallAcousticBeamFundamentalParameter(dis));
	return output;
}

public com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter unMarshallAcousticBeamFundamentalParameter(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter output = new com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter();

	output.setActiveEmissionParameterIndex((int)dis.readUnsignedShort());
	output.setScanPattern((int)dis.readUnsignedShort());
	output.setBeamCenterAzimuth(dis.readFloat());
	output.setAzimuthalBeamwidth(dis.readFloat());
	output.setBeamCenterDE(dis.readFloat());
	output.setDeBeamwidth(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.ApaData unMarshallApaData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ApaData output = new com.cohesionforce.dis.avro.ApaData();

	output.setParameterIndex((int)dis.readUnsignedShort());
	output.setParameterValue((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.IffFundamentalData unMarshallIffFundamentalData(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IffFundamentalData output = new com.cohesionforce.dis.avro.IffFundamentalData();

	output.setSystemStatus((int)dis.readUnsignedByte());
	output.setAlternateParameter4((int)dis.readUnsignedByte());
	output.setInformationLayers((int)dis.readUnsignedByte());
	output.setModifier((int)dis.readUnsignedByte());
	output.setParameter1((int)dis.readUnsignedShort());
	output.setParameter2((int)dis.readUnsignedShort());
	output.setParameter3((int)dis.readUnsignedShort());
	output.setParameter4((int)dis.readUnsignedShort());
	output.setParameter5((int)dis.readUnsignedShort());
	output.setParameter6((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.IntercomCommunicationsParameters unMarshallIntercomCommunicationsParameters(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IntercomCommunicationsParameters output = new com.cohesionforce.dis.avro.IntercomCommunicationsParameters();

	output.setRecordType((int)dis.readUnsignedShort());
	output.setRecordLength((int)dis.readUnsignedShort());
	output.setRecordSpecificField((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.LayerHeader unMarshallLayerHeader(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.LayerHeader output = new com.cohesionforce.dis.avro.LayerHeader();

	output.setLayerNumber((int)dis.readUnsignedByte());
	output.setLayerSpecificInformaiton((int)dis.readUnsignedByte());
	output.setLength((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.SystemID unMarshallSystemID(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SystemID output = new com.cohesionforce.dis.avro.SystemID();

	output.setSystemType((int)dis.readUnsignedShort());
	output.setSystemName((int)dis.readUnsignedShort());
	output.setSystemMode((int)dis.readUnsignedByte());
	output.setChangeOptions((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.FundamentalParameterDataIff unMarshallFundamentalParameterDataIff(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.FundamentalParameterDataIff output = new com.cohesionforce.dis.avro.FundamentalParameterDataIff();

	output.setErp(dis.readFloat());
	output.setFrequency(dis.readFloat());
	output.setPgrf(dis.readFloat());
	output.setPulseWidth(dis.readFloat());
	output.setBurstLength((long)dis.readInt());
	output.setApplicableModes((int)dis.readUnsignedByte());
	output.setPad2((int)dis.readUnsignedShort());
	output.setPad3((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.GridAxis unMarshallGridAxis(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GridAxis output = new com.cohesionforce.dis.avro.GridAxis();

	output.setDomainInitialXi(dis.readDouble());
	output.setDomainFinalXi(dis.readDouble());
	output.setDomainPointsXi((int)dis.readUnsignedShort());
	output.setInterleafFactor((int)dis.readUnsignedByte());
	output.setAxisType((int)dis.readUnsignedByte());
	output.setNumberOfPointsOnXiAxis((int)dis.readUnsignedShort());
	output.setInitialIndex((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.GridAxisRecord unMarshallGridAxisRecord(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GridAxisRecord output = new com.cohesionforce.dis.avro.GridAxisRecord();

	output.setSampleType((int)dis.readUnsignedShort());
	output.setDataRepresentation((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.GridAxisRecordRepresentation0 unMarshallGridAxisRecordRepresentation0(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GridAxisRecordRepresentation0 output = new com.cohesionforce.dis.avro.GridAxisRecordRepresentation0();

	output.setSampleType((int)dis.readUnsignedShort());
	output.setDataRepresentation((int)dis.readUnsignedShort());
	output.setNumberOfDataValues((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1 unMarshallGridAxisRecordRepresentation1(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GridAxisRecordRepresentation1 output = new com.cohesionforce.dis.avro.GridAxisRecordRepresentation1();

	output.setSampleType((int)dis.readUnsignedShort());
	output.setDataRepresentation((int)dis.readUnsignedShort());
	output.setFieldScale(dis.readFloat());
	output.setFieldOffset(dis.readFloat());
	output.setNumberOfDataValues((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.GridAxisRecordRepresentation2 unMarshallGridAxisRecordRepresentation2(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GridAxisRecordRepresentation2 output = new com.cohesionforce.dis.avro.GridAxisRecordRepresentation2();

	output.setSampleType((int)dis.readUnsignedShort());
	output.setDataRepresentation((int)dis.readUnsignedShort());
	output.setNumberOfDataValues((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.SixByteChunk unMarshallSixByteChunk(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SixByteChunk output = new com.cohesionforce.dis.avro.SixByteChunk();

	return output;
}

public com.cohesionforce.dis.avro.LinearSegmentParameter unMarshallLinearSegmentParameter(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.LinearSegmentParameter output = new com.cohesionforce.dis.avro.LinearSegmentParameter();

	output.setSegmentNumber((int)dis.readUnsignedByte());
	output.setSegmentAppearance(unMarshallSixByteChunk(dis));
	output.setLocation(unMarshallVector3Double(dis));
	output.setOrientation(unMarshallOrientation(dis));
	output.setSegmentLength((int)dis.readUnsignedShort());
	output.setSegmentWidth((int)dis.readUnsignedShort());
	output.setSegmentHeight((int)dis.readUnsignedShort());
	output.setSegmentDepth((int)dis.readUnsignedShort());
	output.setPad1((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.EightByteChunk unMarshallEightByteChunk(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EightByteChunk output = new com.cohesionforce.dis.avro.EightByteChunk();

	return output;
}

public com.cohesionforce.dis.avro.OneByteChunk unMarshallOneByteChunk(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.OneByteChunk output = new com.cohesionforce.dis.avro.OneByteChunk();

	output.setOtherParameters((int)dis.readByte());
	return output;
}

public com.cohesionforce.dis.avro.TwoByteChunk unMarshallTwoByteChunk(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.TwoByteChunk output = new com.cohesionforce.dis.avro.TwoByteChunk();

	return output;
}

public com.cohesionforce.dis.avro.FourByteChunk unMarshallFourByteChunk(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.FourByteChunk output = new com.cohesionforce.dis.avro.FourByteChunk();

	return output;
}

public com.cohesionforce.dis.avro.Point unMarshallPoint(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Point output = new com.cohesionforce.dis.avro.Point();

	output.setX(dis.readFloat());
	output.setY(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.ModulationType unMarshallModulationType(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ModulationType output = new com.cohesionforce.dis.avro.ModulationType();

	output.setSpreadSpectrum((int)dis.readUnsignedShort());
	output.setMajor((int)dis.readUnsignedShort());
	output.setDetail((int)dis.readUnsignedShort());
	output.setSystem((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.Relationship unMarshallRelationship(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Relationship output = new com.cohesionforce.dis.avro.Relationship();

	output.setNature((int)dis.readUnsignedShort());
	output.setPosition((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.NamedLocation unMarshallNamedLocation(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.NamedLocation output = new com.cohesionforce.dis.avro.NamedLocation();

	output.setStationName((int)dis.readUnsignedShort());
	output.setStationNumber((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.DeadReckoningParameter unMarshallDeadReckoningParameter(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DeadReckoningParameter output = new com.cohesionforce.dis.avro.DeadReckoningParameter();

	output.setDeadReckoningAlgorithm((int)dis.readUnsignedByte());
	output.setEntityLinearAcceleration(unMarshallVector3Float(dis));
	output.setEntityAngularVelocity(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.RecordSet unMarshallRecordSet(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RecordSet output = new com.cohesionforce.dis.avro.RecordSet();

	output.setRecordID((long)dis.readInt());
	output.setRecordSetSerialNumber((long)dis.readInt());
	output.setRecordLength((int)dis.readUnsignedShort());
	output.setRecordCount((int)dis.readUnsignedShort());
	output.setRecordValues((int)dis.readUnsignedShort());
	output.setPad4((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.PduStream unMarshallPduStream(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.PduStream output = new com.cohesionforce.dis.avro.PduStream();

	output.setStartTime((long)dis.readLong());
	output.setStopTime((long)dis.readLong());
	return output;
}

public com.cohesionforce.dis.avro.Pdu unMarshallPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.Pdu output = new com.cohesionforce.dis.avro.Pdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.EntityInformationFamilyPdu unMarshallEntityInformationFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityInformationFamilyPdu output = new com.cohesionforce.dis.avro.EntityInformationFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.EntityStatePdu unMarshallEntityStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityStatePdu output = new com.cohesionforce.dis.avro.EntityStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityID(unMarshallEntityID(dis));
	output.setForceId((int)dis.readUnsignedByte());
	output.setNumberOfArticulationParameters((int)dis.readByte());
	output.setEntityType(unMarshallEntityType(dis));
	output.setAlternativeEntityType(unMarshallEntityType(dis));
	output.setEntityLinearVelocity(unMarshallVector3Float(dis));
	output.setEntityLocation(unMarshallVector3Double(dis));
	output.setEntityOrientation(unMarshallOrientation(dis));
	output.setEntityAppearance(dis.readInt());
	output.setDeadReckoningParameters(unMarshallDeadReckoningParameter(dis));
	output.setMarking(unMarshallMarking(dis));
	output.setCapabilities(dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.CollisionPdu unMarshallCollisionPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CollisionPdu output = new com.cohesionforce.dis.avro.CollisionPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setIssuingEntityID(unMarshallEntityID(dis));
	output.setCollidingEntityID(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setCollisionType((int)dis.readUnsignedByte());
	output.setPad((int)dis.readByte());
	output.setVelocity(unMarshallVector3Float(dis));
	output.setMass(dis.readFloat());
	output.setLocation(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.CollisionElasticPdu unMarshallCollisionElasticPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CollisionElasticPdu output = new com.cohesionforce.dis.avro.CollisionElasticPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setIssuingEntityID(unMarshallEntityID(dis));
	output.setCollidingEntityID(unMarshallEntityID(dis));
	output.setCollisionEventID(unMarshallEventID(dis));
	output.setPad((int)dis.readShort());
	output.setContactVelocity(unMarshallVector3Float(dis));
	output.setMass(dis.readFloat());
	output.setLocation(unMarshallVector3Float(dis));
	output.setCollisionResultXX(dis.readFloat());
	output.setCollisionResultXY(dis.readFloat());
	output.setCollisionResultXZ(dis.readFloat());
	output.setCollisionResultYY(dis.readFloat());
	output.setCollisionResultYZ(dis.readFloat());
	output.setCollisionResultZZ(dis.readFloat());
	output.setUnitSurfaceNormal(unMarshallVector3Float(dis));
	output.setCoefficientOfRestitution(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.EntityStateUpdatePdu unMarshallEntityStateUpdatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityStateUpdatePdu output = new com.cohesionforce.dis.avro.EntityStateUpdatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityID(unMarshallEntityID(dis));
	output.setPadding1((int)dis.readByte());
	output.setNumberOfArticulationParameters((int)dis.readUnsignedByte());
	output.setEntityLinearVelocity(unMarshallVector3Float(dis));
	output.setEntityLocation(unMarshallVector3Double(dis));
	output.setEntityOrientation(unMarshallOrientation(dis));
	output.setEntityAppearance(dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.WarfareFamilyPdu unMarshallWarfareFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.WarfareFamilyPdu output = new com.cohesionforce.dis.avro.WarfareFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setFiringEntityID(unMarshallEntityID(dis));
	output.setTargetEntityID(unMarshallEntityID(dis));
	return output;
}

public com.cohesionforce.dis.avro.FirePdu unMarshallFirePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.FirePdu output = new com.cohesionforce.dis.avro.FirePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setFiringEntityID(unMarshallEntityID(dis));
	output.setTargetEntityID(unMarshallEntityID(dis));
	output.setMunitionID(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setFireMissionIndex(dis.readInt());
	output.setLocationInWorldCoordinates(unMarshallVector3Double(dis));
	output.setBurstDescriptor(unMarshallBurstDescriptor(dis));
	output.setVelocity(unMarshallVector3Float(dis));
	output.setRangeToTarget(dis.readFloat());
	return output;
}

public com.cohesionforce.dis.avro.DetonationPdu unMarshallDetonationPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DetonationPdu output = new com.cohesionforce.dis.avro.DetonationPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setFiringEntityID(unMarshallEntityID(dis));
	output.setTargetEntityID(unMarshallEntityID(dis));
	output.setMunitionID(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setVelocity(unMarshallVector3Float(dis));
	output.setLocationInWorldCoordinates(unMarshallVector3Double(dis));
	output.setBurstDescriptor(unMarshallBurstDescriptor(dis));
	output.setLocationInEntityCoordinates(unMarshallVector3Float(dis));
	output.setDetonationResult((int)dis.readUnsignedByte());
	output.setNumberOfArticulationParameters((int)dis.readUnsignedByte());
	output.setPad((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.LogisticsFamilyPdu unMarshallLogisticsFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.LogisticsFamilyPdu output = new com.cohesionforce.dis.avro.LogisticsFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.ServiceRequestPdu unMarshallServiceRequestPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ServiceRequestPdu output = new com.cohesionforce.dis.avro.ServiceRequestPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setRequestingEntityID(unMarshallEntityID(dis));
	output.setServicingEntityID(unMarshallEntityID(dis));
	output.setServiceTypeRequested((int)dis.readUnsignedByte());
	output.setNumberOfSupplies((int)dis.readUnsignedByte());
	output.setServiceRequestPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.ResupplyOfferPdu unMarshallResupplyOfferPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ResupplyOfferPdu output = new com.cohesionforce.dis.avro.ResupplyOfferPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setSupplyingEntityID(unMarshallEntityID(dis));
	output.setNumberOfSupplies((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readShort());
	output.setPadding2((int)dis.readByte());
	return output;
}

public com.cohesionforce.dis.avro.ResupplyReceivedPdu unMarshallResupplyReceivedPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ResupplyReceivedPdu output = new com.cohesionforce.dis.avro.ResupplyReceivedPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setSupplyingEntityID(unMarshallEntityID(dis));
	output.setNumberOfSupplies((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readShort());
	output.setPadding2((int)dis.readByte());
	return output;
}

public com.cohesionforce.dis.avro.ResupplyCancelPdu unMarshallResupplyCancelPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ResupplyCancelPdu output = new com.cohesionforce.dis.avro.ResupplyCancelPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setSupplyingEntityID(unMarshallEntityID(dis));
	return output;
}

public com.cohesionforce.dis.avro.RepairCompletePdu unMarshallRepairCompletePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RepairCompletePdu output = new com.cohesionforce.dis.avro.RepairCompletePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRepairingEntityID(unMarshallEntityID(dis));
	output.setRepair((int)dis.readUnsignedShort());
	output.setPadding2((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.RepairResponsePdu unMarshallRepairResponsePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RepairResponsePdu output = new com.cohesionforce.dis.avro.RepairResponsePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRepairingEntityID(unMarshallEntityID(dis));
	output.setRepairResult((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readShort());
	output.setPadding2((int)dis.readByte());
	return output;
}

public com.cohesionforce.dis.avro.SimulationManagementFamilyPdu unMarshallSimulationManagementFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SimulationManagementFamilyPdu output = new com.cohesionforce.dis.avro.SimulationManagementFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	return output;
}

public com.cohesionforce.dis.avro.CreateEntityPdu unMarshallCreateEntityPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CreateEntityPdu output = new com.cohesionforce.dis.avro.CreateEntityPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.RemoveEntityPdu unMarshallRemoveEntityPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RemoveEntityPdu output = new com.cohesionforce.dis.avro.RemoveEntityPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.StartResumePdu unMarshallStartResumePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.StartResumePdu output = new com.cohesionforce.dis.avro.StartResumePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRealWorldTime(unMarshallClockTime(dis));
	output.setSimulationTime(unMarshallClockTime(dis));
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.StopFreezePdu unMarshallStopFreezePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.StopFreezePdu output = new com.cohesionforce.dis.avro.StopFreezePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRealWorldTime(unMarshallClockTime(dis));
	output.setReason((int)dis.readUnsignedByte());
	output.setFrozenBehavior((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readShort());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.AcknowledgePdu unMarshallAcknowledgePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcknowledgePdu output = new com.cohesionforce.dis.avro.AcknowledgePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setAcknowledgeFlag((int)dis.readUnsignedShort());
	output.setResponseFlag((int)dis.readUnsignedShort());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.ActionRequestPdu unMarshallActionRequestPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ActionRequestPdu output = new com.cohesionforce.dis.avro.ActionRequestPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setActionID((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.ActionResponsePdu unMarshallActionResponsePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ActionResponsePdu output = new com.cohesionforce.dis.avro.ActionResponsePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setRequestStatus((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.DataQueryPdu unMarshallDataQueryPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DataQueryPdu output = new com.cohesionforce.dis.avro.DataQueryPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setTimeInterval((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.SetDataPdu unMarshallSetDataPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SetDataPdu output = new com.cohesionforce.dis.avro.SetDataPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setPadding1((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.DataPdu unMarshallDataPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DataPdu output = new com.cohesionforce.dis.avro.DataPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setPadding1((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.EventReportPdu unMarshallEventReportPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EventReportPdu output = new com.cohesionforce.dis.avro.EventReportPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setEventType((long)dis.readInt());
	output.setPadding1((long)dis.readInt());
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.CommentPdu unMarshallCommentPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CommentPdu output = new com.cohesionforce.dis.avro.CommentPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setNumberOfFixedDatums((long)dis.readInt());
	output.setNumberOfVariableDatums((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.DistributedEmissionsFamilyPdu unMarshallDistributedEmissionsFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DistributedEmissionsFamilyPdu output = new com.cohesionforce.dis.avro.DistributedEmissionsFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.ElectronicEmissionsPdu unMarshallElectronicEmissionsPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ElectronicEmissionsPdu output = new com.cohesionforce.dis.avro.ElectronicEmissionsPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEmittingEntityID(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setStateUpdateIndicator((int)dis.readUnsignedByte());
	output.setNumberOfSystems((int)dis.readUnsignedByte());
	output.setPaddingForEmissionsPdu((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.DesignatorPdu unMarshallDesignatorPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DesignatorPdu output = new com.cohesionforce.dis.avro.DesignatorPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setDesignatingEntityID(unMarshallEntityID(dis));
	output.setCodeName((int)dis.readUnsignedShort());
	output.setDesignatedEntityID(unMarshallEntityID(dis));
	output.setDesignatorCode((int)dis.readUnsignedShort());
	output.setDesignatorPower(dis.readFloat());
	output.setDesignatorWavelength(dis.readFloat());
	output.setDesignatorSpotWrtDesignated(unMarshallVector3Float(dis));
	output.setDesignatorSpotLocation(unMarshallVector3Double(dis));
	output.setDeadReckoningAlgorithm((int)dis.readByte());
	output.setPadding1((int)dis.readUnsignedShort());
	output.setPadding2((int)dis.readByte());
	output.setEntityLinearAcceleration(unMarshallVector3Float(dis));
	return output;
}

public com.cohesionforce.dis.avro.UaPdu unMarshallUaPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.UaPdu output = new com.cohesionforce.dis.avro.UaPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEmittingEntityID(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setStateChangeIndicator((int)dis.readByte());
	output.setPad((int)dis.readByte());
	output.setPassiveParameterIndex((int)dis.readUnsignedShort());
	output.setPropulsionPlantConfiguration((int)dis.readUnsignedByte());
	output.setNumberOfShaftRPMs((int)dis.readUnsignedByte());
	output.setNumberOfApaData((int)dis.readUnsignedByte());
	output.setNumberOfEmitterSystems((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu unMarshallIffAtcNavAidsLayer1Pdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu output = new com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEmittingEntityId(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setLocation(unMarshallVector3Float(dis));
	output.setSystemID(unMarshallSystemID(dis));
	output.setPad2((int)dis.readUnsignedShort());
	output.setFundamentalParameters(unMarshallIffFundamentalData(dis));
	return output;
}

public com.cohesionforce.dis.avro.IffAtcNavAidsLayer2Pdu unMarshallIffAtcNavAidsLayer2Pdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IffAtcNavAidsLayer2Pdu output = new com.cohesionforce.dis.avro.IffAtcNavAidsLayer2Pdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEmittingEntityId(unMarshallEntityID(dis));
	output.setEventID(unMarshallEventID(dis));
	output.setLocation(unMarshallVector3Float(dis));
	output.setSystemID(unMarshallSystemID(dis));
	output.setPad2((int)dis.readUnsignedShort());
	output.setFundamentalParameters(unMarshallIffFundamentalData(dis));
	output.setLayerHeader(unMarshallLayerHeader(dis));
	output.setBeamData(unMarshallBeamData(dis));
	output.setSecondaryOperationalData(unMarshallBeamData(dis));
	return output;
}

public com.cohesionforce.dis.avro.SeesPdu unMarshallSeesPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SeesPdu output = new com.cohesionforce.dis.avro.SeesPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOrginatingEntityID(unMarshallEntityID(dis));
	output.setInfraredSignatureRepresentationIndex((int)dis.readUnsignedShort());
	output.setAcousticSignatureRepresentationIndex((int)dis.readUnsignedShort());
	output.setRadarCrossSectionSignatureRepresentationIndex((int)dis.readUnsignedShort());
	output.setNumberOfPropulsionSystemData((int)dis.readUnsignedShort());
	output.setNumberOfVectoringSystemData((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.RadioCommunicationsFamilyPdu unMarshallRadioCommunicationsFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RadioCommunicationsFamilyPdu output = new com.cohesionforce.dis.avro.RadioCommunicationsFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.IntercomSignalPdu unMarshallIntercomSignalPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IntercomSignalPdu output = new com.cohesionforce.dis.avro.IntercomSignalPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	output.setEntityID1(unMarshallEntityID(dis));
	output.setCommunicationsDeviceID((int)dis.readUnsignedShort());
	output.setEncodingScheme((int)dis.readUnsignedShort());
	output.setTdlType((int)dis.readUnsignedShort());
	output.setSampleRate((long)dis.readInt());
	output.setNumberOfData((int)dis.readUnsignedShort());
	output.setSamples((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.TransmitterPdu unMarshallTransmitterPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.TransmitterPdu output = new com.cohesionforce.dis.avro.TransmitterPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	output.setRadioEntityType(unMarshallRadioEntityType(dis));
	output.setTransmitState((int)dis.readUnsignedByte());
	output.setInputSource((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readUnsignedShort());
	output.setAntennaLocation(unMarshallVector3Double(dis));
	output.setRelativeAntennaLocation(unMarshallVector3Float(dis));
	output.setAntennaPatternType((int)dis.readUnsignedShort());
	output.setNumberOfAntennaPatternList((int)dis.readUnsignedShort());
	output.setFrequency((long)dis.readLong());
	output.setTransmitFrequencyBandwidth(dis.readFloat());
	output.setPower(dis.readFloat());
	output.setModulationType(unMarshallModulationType(dis));
	output.setCryptoSystem((int)dis.readUnsignedShort());
	output.setCryptoKeyId((int)dis.readUnsignedShort());
	output.setNumberOfModulationParametersList((int)dis.readUnsignedByte());
	output.setPadding2((int)dis.readUnsignedShort());
	output.setPadding3((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.SignalPdu unMarshallSignalPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SignalPdu output = new com.cohesionforce.dis.avro.SignalPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	output.setEncodingScheme((int)dis.readUnsignedShort());
	output.setTdlType((int)dis.readUnsignedShort());
	output.setSampleRate((long)dis.readInt());
	output.setNumberOfData((int)dis.readShort());
	output.setSamples((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.ReceiverPdu unMarshallReceiverPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ReceiverPdu output = new com.cohesionforce.dis.avro.ReceiverPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	output.setReceiverState((int)dis.readUnsignedShort());
	output.setPadding1((int)dis.readUnsignedShort());
	output.setReceivedPoser(dis.readFloat());
	output.setTransmitterEntityId(unMarshallEntityID(dis));
	output.setTransmitterRadioId((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.IntercomControlPdu unMarshallIntercomControlPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IntercomControlPdu output = new com.cohesionforce.dis.avro.IntercomControlPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEntityId(unMarshallEntityID(dis));
	output.setRadioId((int)dis.readUnsignedShort());
	output.setControlType((int)dis.readUnsignedByte());
	output.setCommunicationsChannelType((int)dis.readUnsignedByte());
	output.setSourceEntityID(unMarshallEntityID(dis));
	output.setSourceCommunicationsDeviceID((int)dis.readUnsignedByte());
	output.setSourceLineID((int)dis.readUnsignedByte());
	output.setTransmitPriority((int)dis.readUnsignedByte());
	output.setTransmitLineState((int)dis.readUnsignedByte());
	output.setCommand((int)dis.readUnsignedByte());
	output.setMasterEntityID(unMarshallEntityID(dis));
	output.setMasterCommunicationsDeviceID((int)dis.readUnsignedShort());
	output.setNumberOfIntercomParameters((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.EntityManagementFamilyPdu unMarshallEntityManagementFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EntityManagementFamilyPdu output = new com.cohesionforce.dis.avro.EntityManagementFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.AggregateStatePdu unMarshallAggregateStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AggregateStatePdu output = new com.cohesionforce.dis.avro.AggregateStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setAggregateID(unMarshallEntityID(dis));
	output.setForceID((int)dis.readUnsignedByte());
	output.setAggregateState((int)dis.readUnsignedByte());
	output.setAggregateType(unMarshallEntityType(dis));
	output.setFormation((long)dis.readInt());
	output.setAggregateMarking(unMarshallAggregateMarking(dis));
	output.setDimensions(unMarshallVector3Float(dis));
	output.setOrientation(unMarshallOrientation(dis));
	output.setCenterOfMass(unMarshallVector3Double(dis));
	output.setVelocity(unMarshallVector3Float(dis));
	output.setNumberOfAggregateIDList((int)dis.readUnsignedShort());
	output.setNumberOfEntityIDList((int)dis.readUnsignedShort());
	output.setNumberOfSilentAggregateSystemList((int)dis.readUnsignedShort());
	output.setNumberOfSilentEntitySystemList((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setNumberOfVariableDatumList((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.IsGroupOfPdu unMarshallIsGroupOfPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IsGroupOfPdu output = new com.cohesionforce.dis.avro.IsGroupOfPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setGroupEntityID(unMarshallEntityID(dis));
	output.setGroupedEntityCategory((int)dis.readUnsignedByte());
	output.setNumberOfGroupedEntityDescriptions((int)dis.readUnsignedByte());
	output.setPad2((long)dis.readInt());
	output.setLatitude(dis.readDouble());
	output.setLongitude(dis.readDouble());
	return output;
}

public com.cohesionforce.dis.avro.TransferControlRequestPdu unMarshallTransferControlRequestPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.TransferControlRequestPdu output = new com.cohesionforce.dis.avro.TransferControlRequestPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOrginatingEntityID(unMarshallEntityID(dis));
	output.setRecevingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setTranferType((int)dis.readUnsignedByte());
	output.setTransferEntityID(unMarshallEntityID(dis));
	output.setNumberOfRecordSets((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.IsPartOfPdu unMarshallIsPartOfPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.IsPartOfPdu output = new com.cohesionforce.dis.avro.IsPartOfPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOrginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRelationship(unMarshallRelationship(dis));
	output.setPartLocation(unMarshallVector3Float(dis));
	output.setNamedLocationID(unMarshallNamedLocation(dis));
	output.setPartEntityType(unMarshallEntityType(dis));
	return output;
}

public com.cohesionforce.dis.avro.MinefieldFamilyPdu unMarshallMinefieldFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.MinefieldFamilyPdu output = new com.cohesionforce.dis.avro.MinefieldFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.MinefieldStatePdu unMarshallMinefieldStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.MinefieldStatePdu output = new com.cohesionforce.dis.avro.MinefieldStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setMinefieldID(unMarshallEntityID(dis));
	output.setMinefieldSequence((int)dis.readUnsignedShort());
	output.setForceID((int)dis.readUnsignedByte());
	output.setNumberOfPerimeterPoints((int)dis.readUnsignedByte());
	output.setMinefieldType(unMarshallEntityType(dis));
	output.setNumberOfMineType((int)dis.readUnsignedShort());
	output.setMinefieldLocation(unMarshallVector3Double(dis));
	output.setMinefieldOrientation(unMarshallOrientation(dis));
	output.setAppearance((int)dis.readUnsignedShort());
	output.setProtocolMode((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.MinefieldQueryPdu unMarshallMinefieldQueryPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.MinefieldQueryPdu output = new com.cohesionforce.dis.avro.MinefieldQueryPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setMinefieldID(unMarshallEntityID(dis));
	output.setRequestingEntityID(unMarshallEntityID(dis));
	output.setRequestID((int)dis.readUnsignedByte());
	output.setNumberOfRequestedPerimeterPoints((int)dis.readUnsignedByte());
	output.setPad2((int)dis.readUnsignedByte());
	output.setNumberOfSensorTypes((int)dis.readUnsignedByte());
	output.setDataFilter((long)dis.readInt());
	output.setRequestedMineType(unMarshallEntityType(dis));
	return output;
}

public com.cohesionforce.dis.avro.MinefieldDataPdu unMarshallMinefieldDataPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.MinefieldDataPdu output = new com.cohesionforce.dis.avro.MinefieldDataPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setMinefieldID(unMarshallEntityID(dis));
	output.setRequestingEntityID(unMarshallEntityID(dis));
	output.setMinefieldSequenceNumbeer((int)dis.readUnsignedShort());
	output.setRequestID((int)dis.readUnsignedByte());
	output.setPduSequenceNumber((int)dis.readUnsignedByte());
	output.setNumberOfPdus((int)dis.readUnsignedByte());
	output.setNumberOfMineLocation((int)dis.readUnsignedByte());
	output.setNumberOfSensorTypes((int)dis.readUnsignedByte());
	output.setPad2((int)dis.readUnsignedByte());
	output.setDataFilter((long)dis.readInt());
	output.setMineType(unMarshallEntityType(dis));
	output.setPad3((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.MinefieldResponseNackPdu unMarshallMinefieldResponseNackPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.MinefieldResponseNackPdu output = new com.cohesionforce.dis.avro.MinefieldResponseNackPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setMinefieldID(unMarshallEntityID(dis));
	output.setRequestingEntityID(unMarshallEntityID(dis));
	output.setRequestID((int)dis.readUnsignedByte());
	output.setNumberOfMissingPduSequenceNumbers((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.SyntheticEnvironmentFamilyPdu unMarshallSyntheticEnvironmentFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SyntheticEnvironmentFamilyPdu output = new com.cohesionforce.dis.avro.SyntheticEnvironmentFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	return output;
}

public com.cohesionforce.dis.avro.EnvironmentalProcessPdu unMarshallEnvironmentalProcessPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EnvironmentalProcessPdu output = new com.cohesionforce.dis.avro.EnvironmentalProcessPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEnvironementalProcessID(unMarshallEntityID(dis));
	output.setEnvironmentType(unMarshallEntityType(dis));
	output.setModelType((int)dis.readUnsignedByte());
	output.setEnvironmentStatus((int)dis.readUnsignedByte());
	output.setNumberOfEnvironmentRecords((int)dis.readUnsignedByte());
	output.setSequenceNumber((int)dis.readUnsignedShort());
	return output;
}

public com.cohesionforce.dis.avro.GriddedDataPdu unMarshallGriddedDataPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.GriddedDataPdu output = new com.cohesionforce.dis.avro.GriddedDataPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setEnvironmentalSimulationApplicationID(unMarshallEntityID(dis));
	output.setFieldNumber((int)dis.readUnsignedShort());
	output.setPduNumber((int)dis.readUnsignedShort());
	output.setPduTotal((int)dis.readUnsignedShort());
	output.setCoordinateSystem((int)dis.readUnsignedShort());
	output.setNumberOfGridDataList((int)dis.readUnsignedByte());
	output.setConstantGrid((int)dis.readUnsignedByte());
	output.setEnvironmentType(unMarshallEntityType(dis));
	output.setOrientation(unMarshallOrientation(dis));
	output.setSampleTime((long)dis.readLong());
	output.setTotalValues((long)dis.readInt());
	output.setVectorDimension((int)dis.readUnsignedByte());
	output.setPadding1((int)dis.readUnsignedShort());
	output.setPadding2((int)dis.readUnsignedByte());
	return output;
}

public com.cohesionforce.dis.avro.PointObjectStatePdu unMarshallPointObjectStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.PointObjectStatePdu output = new com.cohesionforce.dis.avro.PointObjectStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setObjectID(unMarshallEntityID(dis));
	output.setReferencedObjectID(unMarshallEntityID(dis));
	output.setUpdateNumber((int)dis.readUnsignedShort());
	output.setForceID((int)dis.readUnsignedByte());
	output.setModifications((int)dis.readUnsignedByte());
	output.setObjectType(unMarshallObjectType(dis));
	output.setObjectLocation(unMarshallVector3Double(dis));
	output.setObjectOrientation(unMarshallOrientation(dis));
	output.setObjectAppearance(dis.readDouble());
	output.setRequesterID(unMarshallSimulationAddress(dis));
	output.setReceivingID(unMarshallSimulationAddress(dis));
	output.setPad2((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.LinearObjectStatePdu unMarshallLinearObjectStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.LinearObjectStatePdu output = new com.cohesionforce.dis.avro.LinearObjectStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setObjectID(unMarshallEntityID(dis));
	output.setReferencedObjectID(unMarshallEntityID(dis));
	output.setUpdateNumber((int)dis.readUnsignedShort());
	output.setForceID((int)dis.readUnsignedByte());
	output.setNumberOfLinearSegmentParameters((int)dis.readUnsignedByte());
	output.setRequesterID(unMarshallSimulationAddress(dis));
	output.setReceivingID(unMarshallSimulationAddress(dis));
	output.setObjectType(unMarshallObjectType(dis));
	return output;
}

public com.cohesionforce.dis.avro.ArealObjectStatePdu unMarshallArealObjectStatePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ArealObjectStatePdu output = new com.cohesionforce.dis.avro.ArealObjectStatePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setObjectID(unMarshallEntityID(dis));
	output.setReferencedObjectID(unMarshallEntityID(dis));
	output.setUpdateNumber((int)dis.readUnsignedShort());
	output.setForceID((int)dis.readUnsignedByte());
	output.setModifications((int)dis.readUnsignedByte());
	output.setObjectType(unMarshallEntityType(dis));
	output.setObjectAppearance(unMarshallSixByteChunk(dis));
	output.setNumberOfObjectLocation((int)dis.readUnsignedShort());
	output.setRequesterID(unMarshallSimulationAddress(dis));
	output.setReceivingID(unMarshallSimulationAddress(dis));
	return output;
}

public com.cohesionforce.dis.avro.SimulationManagementWithReliabilityFamilyPdu unMarshallSimulationManagementWithReliabilityFamilyPdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SimulationManagementWithReliabilityFamilyPdu output = new com.cohesionforce.dis.avro.SimulationManagementWithReliabilityFamilyPdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	return output;
}

public com.cohesionforce.dis.avro.CreateEntityReliablePdu unMarshallCreateEntityReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CreateEntityReliablePdu output = new com.cohesionforce.dis.avro.CreateEntityReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.RemoveEntityReliablePdu unMarshallRemoveEntityReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RemoveEntityReliablePdu output = new com.cohesionforce.dis.avro.RemoveEntityReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.StartResumeReliablePdu unMarshallStartResumeReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.StartResumeReliablePdu output = new com.cohesionforce.dis.avro.StartResumeReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRealWorldTime(unMarshallClockTime(dis));
	output.setSimulationTime(unMarshallClockTime(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.StopFreezeReliablePdu unMarshallStopFreezeReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.StopFreezeReliablePdu output = new com.cohesionforce.dis.avro.StopFreezeReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRealWorldTime(unMarshallClockTime(dis));
	output.setReason((int)dis.readUnsignedByte());
	output.setFrozenBehavior((int)dis.readUnsignedByte());
	output.setRequiredReliablityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.AcknowledgeReliablePdu unMarshallAcknowledgeReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.AcknowledgeReliablePdu output = new com.cohesionforce.dis.avro.AcknowledgeReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setAcknowledgeFlag((int)dis.readUnsignedShort());
	output.setResponseFlag((int)dis.readUnsignedShort());
	output.setRequestID((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.ActionRequestReliablePdu unMarshallActionRequestReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ActionRequestReliablePdu output = new com.cohesionforce.dis.avro.ActionRequestReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	output.setActionID((long)dis.readInt());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.ActionResponseReliablePdu unMarshallActionResponseReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.ActionResponseReliablePdu output = new com.cohesionforce.dis.avro.ActionResponseReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setResponseStatus((long)dis.readInt());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.DataQueryReliablePdu unMarshallDataQueryReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DataQueryReliablePdu output = new com.cohesionforce.dis.avro.DataQueryReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	output.setTimeInterval((long)dis.readInt());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.SetDataReliablePdu unMarshallSetDataReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SetDataReliablePdu output = new com.cohesionforce.dis.avro.SetDataReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setRequestID((long)dis.readInt());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.DataReliablePdu unMarshallDataReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.DataReliablePdu output = new com.cohesionforce.dis.avro.DataReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.EventReportReliablePdu unMarshallEventReportReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.EventReportReliablePdu output = new com.cohesionforce.dis.avro.EventReportReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setEventType((int)dis.readUnsignedShort());
	output.setPad1((long)dis.readInt());
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.CommentReliablePdu unMarshallCommentReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.CommentReliablePdu output = new com.cohesionforce.dis.avro.CommentReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setNumberOfFixedDatumRecords((long)dis.readInt());
	output.setNumberOfVariableDatumRecords((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.RecordQueryReliablePdu unMarshallRecordQueryReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.RecordQueryReliablePdu output = new com.cohesionforce.dis.avro.RecordQueryReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setEventType((int)dis.readUnsignedShort());
	output.setTime((long)dis.readInt());
	output.setNumberOfRecordIDs((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.SetRecordReliablePdu unMarshallSetRecordReliablePdu(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.SetRecordReliablePdu output = new com.cohesionforce.dis.avro.SetRecordReliablePdu();

	output.setProtocolVersion((int)dis.readUnsignedByte());
	output.setExerciseID((int)dis.readUnsignedByte());
	output.setPduType((int)dis.readUnsignedByte());
	output.setProtocolFamily((int)dis.readUnsignedByte());
	output.setTimestamp((long)dis.readInt());
	output.setPduLength((int)dis.readUnsignedShort());
	output.setPadding((int)dis.readShort());
	output.setOriginatingEntityID(unMarshallEntityID(dis));
	output.setReceivingEntityID(unMarshallEntityID(dis));
	output.setRequestID((long)dis.readInt());
	output.setRequiredReliabilityService((int)dis.readUnsignedByte());
	output.setPad1((int)dis.readUnsignedShort());
	output.setPad2((int)dis.readUnsignedByte());
	output.setNumberOfRecordSets((long)dis.readInt());
	return output;
}

public com.cohesionforce.dis.avro.PduContainer unMarshallPduContainer(
	DataInputStream dis) throws IOException {

	com.cohesionforce.dis.avro.PduContainer output = new com.cohesionforce.dis.avro.PduContainer();

	output.setNumberOfPdus(dis.readInt());
	return output;
}

}
