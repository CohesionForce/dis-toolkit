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
import java.io.DataOutputStream;
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

public class Marshaller {

public void writePdu(Object pdu, int pduType, DataOutputStream dos) throws IOException {

	switch(pduType) {
case 1:
	marshallEntityStatePdu((com.cohesionforce.dis.avro.EntityStatePdu)pdu, dos);
	break;
case 4:
	marshallCollisionPdu((com.cohesionforce.dis.avro.CollisionPdu)pdu, dos);
	break;
case 66:
	marshallCollisionElasticPdu((com.cohesionforce.dis.avro.CollisionElasticPdu)pdu, dos);
	break;
case 67:
	marshallEntityStateUpdatePdu((com.cohesionforce.dis.avro.EntityStateUpdatePdu)pdu, dos);
	break;
case 2:
	marshallFirePdu((com.cohesionforce.dis.avro.FirePdu)pdu, dos);
	break;
case 3:
	marshallDetonationPdu((com.cohesionforce.dis.avro.DetonationPdu)pdu, dos);
	break;
case 5:
	marshallServiceRequestPdu((com.cohesionforce.dis.avro.ServiceRequestPdu)pdu, dos);
	break;
case 6:
	marshallResupplyOfferPdu((com.cohesionforce.dis.avro.ResupplyOfferPdu)pdu, dos);
	break;
case 7:
	marshallResupplyReceivedPdu((com.cohesionforce.dis.avro.ResupplyReceivedPdu)pdu, dos);
	break;
case 8:
	marshallResupplyCancelPdu((com.cohesionforce.dis.avro.ResupplyCancelPdu)pdu, dos);
	break;
case 9:
	marshallRepairCompletePdu((com.cohesionforce.dis.avro.RepairCompletePdu)pdu, dos);
	break;
case 10:
	marshallRepairResponsePdu((com.cohesionforce.dis.avro.RepairResponsePdu)pdu, dos);
	break;
case 11:
	marshallCreateEntityPdu((com.cohesionforce.dis.avro.CreateEntityPdu)pdu, dos);
	break;
case 12:
	marshallRemoveEntityPdu((com.cohesionforce.dis.avro.RemoveEntityPdu)pdu, dos);
	break;
case 13:
	marshallStartResumePdu((com.cohesionforce.dis.avro.StartResumePdu)pdu, dos);
	break;
case 14:
	marshallStopFreezePdu((com.cohesionforce.dis.avro.StopFreezePdu)pdu, dos);
	break;
case 15:
	marshallAcknowledgePdu((com.cohesionforce.dis.avro.AcknowledgePdu)pdu, dos);
	break;
case 16:
	marshallActionRequestPdu((com.cohesionforce.dis.avro.ActionRequestPdu)pdu, dos);
	break;
case 17:
	marshallActionResponsePdu((com.cohesionforce.dis.avro.ActionResponsePdu)pdu, dos);
	break;
case 18:
	marshallDataQueryPdu((com.cohesionforce.dis.avro.DataQueryPdu)pdu, dos);
	break;
case 19:
	marshallSetDataPdu((com.cohesionforce.dis.avro.SetDataPdu)pdu, dos);
	break;
case 20:
	marshallDataPdu((com.cohesionforce.dis.avro.DataPdu)pdu, dos);
	break;
case 21:
	marshallEventReportPdu((com.cohesionforce.dis.avro.EventReportPdu)pdu, dos);
	break;
case 22:
	marshallCommentPdu((com.cohesionforce.dis.avro.CommentPdu)pdu, dos);
	break;
case 23:
	marshallElectronicEmissionsPdu((com.cohesionforce.dis.avro.ElectronicEmissionsPdu)pdu, dos);
	break;
case 24:
	marshallDesignatorPdu((com.cohesionforce.dis.avro.DesignatorPdu)pdu, dos);
	break;
case 29:
	marshallUaPdu((com.cohesionforce.dis.avro.UaPdu)pdu, dos);
	break;
case 28:
	marshallIffAtcNavAidsLayer1Pdu((com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu)pdu, dos);
	break;
case 30:
	marshallSeesPdu((com.cohesionforce.dis.avro.SeesPdu)pdu, dos);
	break;
case 31:
	marshallIntercomSignalPdu((com.cohesionforce.dis.avro.IntercomSignalPdu)pdu, dos);
	break;
case 25:
	marshallTransmitterPdu((com.cohesionforce.dis.avro.TransmitterPdu)pdu, dos);
	break;
case 26:
	marshallSignalPdu((com.cohesionforce.dis.avro.SignalPdu)pdu, dos);
	break;
case 27:
	marshallReceiverPdu((com.cohesionforce.dis.avro.ReceiverPdu)pdu, dos);
	break;
case 32:
	marshallIntercomControlPdu((com.cohesionforce.dis.avro.IntercomControlPdu)pdu, dos);
	break;
case 33:
	marshallAggregateStatePdu((com.cohesionforce.dis.avro.AggregateStatePdu)pdu, dos);
	break;
case 34:
	marshallIsGroupOfPdu((com.cohesionforce.dis.avro.IsGroupOfPdu)pdu, dos);
	break;
case 35:
	marshallTransferControlRequestPdu((com.cohesionforce.dis.avro.TransferControlRequestPdu)pdu, dos);
	break;
case 36:
	marshallIsPartOfPdu((com.cohesionforce.dis.avro.IsPartOfPdu)pdu, dos);
	break;
case 37:
	marshallMinefieldStatePdu((com.cohesionforce.dis.avro.MinefieldStatePdu)pdu, dos);
	break;
case 38:
	marshallMinefieldQueryPdu((com.cohesionforce.dis.avro.MinefieldQueryPdu)pdu, dos);
	break;
case 39:
	marshallMinefieldDataPdu((com.cohesionforce.dis.avro.MinefieldDataPdu)pdu, dos);
	break;
case 40:
	marshallMinefieldResponseNackPdu((com.cohesionforce.dis.avro.MinefieldResponseNackPdu)pdu, dos);
	break;
case 41:
	marshallEnvironmentalProcessPdu((com.cohesionforce.dis.avro.EnvironmentalProcessPdu)pdu, dos);
	break;
case 42:
	marshallGriddedDataPdu((com.cohesionforce.dis.avro.GriddedDataPdu)pdu, dos);
	break;
case 43:
	marshallPointObjectStatePdu((com.cohesionforce.dis.avro.PointObjectStatePdu)pdu, dos);
	break;
case 44:
	marshallLinearObjectStatePdu((com.cohesionforce.dis.avro.LinearObjectStatePdu)pdu, dos);
	break;
case 45:
	marshallArealObjectStatePdu((com.cohesionforce.dis.avro.ArealObjectStatePdu)pdu, dos);
	break;
case 51:
	marshallCreateEntityReliablePdu((com.cohesionforce.dis.avro.CreateEntityReliablePdu)pdu, dos);
	break;
case 52:
	marshallRemoveEntityReliablePdu((com.cohesionforce.dis.avro.RemoveEntityReliablePdu)pdu, dos);
	break;
case 53:
	marshallStartResumeReliablePdu((com.cohesionforce.dis.avro.StartResumeReliablePdu)pdu, dos);
	break;
case 54:
	marshallStopFreezeReliablePdu((com.cohesionforce.dis.avro.StopFreezeReliablePdu)pdu, dos);
	break;
case 55:
	marshallAcknowledgeReliablePdu((com.cohesionforce.dis.avro.AcknowledgeReliablePdu)pdu, dos);
	break;
case 56:
	marshallActionRequestReliablePdu((com.cohesionforce.dis.avro.ActionRequestReliablePdu)pdu, dos);
	break;
case 57:
	marshallActionResponseReliablePdu((com.cohesionforce.dis.avro.ActionResponseReliablePdu)pdu, dos);
	break;
case 58:
	marshallDataQueryReliablePdu((com.cohesionforce.dis.avro.DataQueryReliablePdu)pdu, dos);
	break;
case 59:
	marshallSetDataReliablePdu((com.cohesionforce.dis.avro.SetDataReliablePdu)pdu, dos);
	break;
case 60:
	marshallDataReliablePdu((com.cohesionforce.dis.avro.DataReliablePdu)pdu, dos);
	break;
case 61:
	marshallEventReportReliablePdu((com.cohesionforce.dis.avro.EventReportReliablePdu)pdu, dos);
	break;
case 62:
	marshallCommentReliablePdu((com.cohesionforce.dis.avro.CommentReliablePdu)pdu, dos);
	break;
case 65:
	marshallRecordQueryReliablePdu((com.cohesionforce.dis.avro.RecordQueryReliablePdu)pdu, dos);
	break;
case 64:
	marshallSetRecordReliablePdu((com.cohesionforce.dis.avro.SetRecordReliablePdu)pdu, dos);
	break;
	}
}

public void marshallAngularVelocityVector(com.cohesionforce.dis.avro.AngularVelocityVector pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getX());
	dos.writeFloat(pdu.getY());
	dos.writeFloat(pdu.getZ());
}

public void marshallAntennaLocation(com.cohesionforce.dis.avro.AntennaLocation pdu,
	DataOutputStream dos) throws IOException {

	marshallVector3Double(pdu.getAntennaLocation(), dos);
	marshallVector3Float(pdu.getRelativeAntennaLocation(), dos);
}

public void marshallBeamAntennaPattern(com.cohesionforce.dis.avro.BeamAntennaPattern pdu,
	DataOutputStream dos) throws IOException {

	marshallOrientation(pdu.getBeamDirection(), dos);
	dos.writeFloat(pdu.getAzimuthBeamwidth());
	dos.writeFloat(pdu.getElevationBeamwidth());
	dos.writeFloat(pdu.getReferenceSystem());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
	dos.writeFloat(pdu.getEz());
	dos.writeFloat(pdu.getEx());
	dos.writeFloat(pdu.getPhase());
}

public void marshallSphericalHarmonicAntennaPattern(com.cohesionforce.dis.avro.SphericalHarmonicAntennaPattern pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getHarmonicOrder());
}

public void marshallArticulationParameter(com.cohesionforce.dis.avro.ArticulationParameter pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getParameterTypeDesignator());
	dos.writeByte(pdu.getChangeIndicator());
	dos.writeShort(pdu.getPartAttachedTo());
	dos.writeInt(pdu.getParameterType());
	dos.writeDouble(pdu.getParameterValue());
}

public void marshallBurstDescriptor(com.cohesionforce.dis.avro.BurstDescriptor pdu,
	DataOutputStream dos) throws IOException {

	marshallEntityType(pdu.getMunition(), dos);
	dos.writeShort(pdu.getWarhead());
	dos.writeShort(pdu.getFuse());
	dos.writeShort(pdu.getQuantity());
	dos.writeShort(pdu.getRate());
}

public void marshallClockTime(com.cohesionforce.dis.avro.ClockTime pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getHour());
	dos.writeInt(pdu.getTimePastHour().intValue());
}

public void marshallEmitterSystem(com.cohesionforce.dis.avro.EmitterSystem pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getEmitterName());
	dos.writeByte(pdu.getFunction());
	dos.writeByte(pdu.getEmitterIdNumber());
}

public void marshallSimulationAddress(com.cohesionforce.dis.avro.SimulationAddress pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSite());
	dos.writeShort(pdu.getApplication());
}

public void marshallEntityType(com.cohesionforce.dis.avro.EntityType pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getEntityKind());
	dos.writeByte(pdu.getDomain());
	dos.writeShort(pdu.getCountry());
	dos.writeByte(pdu.getCategory());
	dos.writeByte(pdu.getSubcategory());
	dos.writeByte(pdu.getSpec());
	dos.writeByte(pdu.getExtra());
}

public void marshallObjectType(com.cohesionforce.dis.avro.ObjectType pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getEntityKind());
	dos.writeByte(pdu.getDomain());
	dos.writeShort(pdu.getCountry());
	dos.writeByte(pdu.getCategory());
	dos.writeByte(pdu.getSubcategory());
}

public void marshallOrientation(com.cohesionforce.dis.avro.Orientation pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getPsi());
	dos.writeFloat(pdu.getTheta());
	dos.writeFloat(pdu.getPhi());
}

public void marshallEventID(com.cohesionforce.dis.avro.EventID pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSite());
	dos.writeShort(pdu.getApplication());
	dos.writeShort(pdu.getEventNumber());
}

public void marshallFixedDatum(com.cohesionforce.dis.avro.FixedDatum pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getFixedDatumID().intValue());
	dos.writeInt(pdu.getFixedDatumValue().intValue());
}

public void marshallFundamentalParameterData(com.cohesionforce.dis.avro.FundamentalParameterData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getFrequency());
	dos.writeFloat(pdu.getFrequencyRange());
	dos.writeFloat(pdu.getEffectiveRadiatedPower());
	dos.writeFloat(pdu.getPulseRepetitionFrequency());
	dos.writeFloat(pdu.getPulseWidth());
	dos.writeFloat(pdu.getBeamAzimuthCenter());
	dos.writeFloat(pdu.getBeamAzimuthSweep());
	dos.writeFloat(pdu.getBeamElevationCenter());
	dos.writeFloat(pdu.getBeamElevationSweep());
	dos.writeFloat(pdu.getBeamSweepSync());
}

public void marshallRadioEntityType(com.cohesionforce.dis.avro.RadioEntityType pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getEntityKind());
	dos.writeByte(pdu.getDomain());
	dos.writeShort(pdu.getCountry());
	dos.writeByte(pdu.getCategory());
	dos.writeByte(pdu.getNomenclatureVersion());
	dos.writeShort(pdu.getNomenclature());
}

public void marshallSupplyQuantity(com.cohesionforce.dis.avro.SupplyQuantity pdu,
	DataOutputStream dos) throws IOException {

	marshallEntityType(pdu.getSupplyType(), dos);
	dos.writeByte(pdu.getQuantity());
}

public void marshallVariableDatum(com.cohesionforce.dis.avro.VariableDatum pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getVariableDatumID().intValue());
	dos.writeInt(pdu.getVariableDatumLength().intValue());
}

public void marshallAcousticEmitter(com.cohesionforce.dis.avro.AcousticEmitter pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getAcousticName());
	dos.writeByte(pdu.getFunction());
	dos.writeByte(pdu.getAcousticIdNumber());
}

public void marshallTrackJamTarget(com.cohesionforce.dis.avro.TrackJamTarget pdu,
	DataOutputStream dos) throws IOException {

	marshallEntityID(pdu.getTrackJam(), dos);
	dos.writeByte(pdu.getEmitterID());
	dos.writeByte(pdu.getBeamID());
}

public void marshallElectronicEmissionBeamData(com.cohesionforce.dis.avro.ElectronicEmissionBeamData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getBeamDataLength());
	dos.writeByte(pdu.getBeamIDNumber());
	dos.writeShort(pdu.getBeamParameterIndex());
	marshallFundamentalParameterData(pdu.getFundamentalParameterData(), dos);
	dos.writeByte(pdu.getBeamFunction());
	dos.writeByte(pdu.getNumberOfTrackJamTargets());
	dos.writeByte(pdu.getHighDensityTrackJam());
	dos.writeByte(pdu.getPad4());
	dos.writeInt(pdu.getJammingModeSequence().intValue());
}

public void marshallElectronicEmissionSystemData(com.cohesionforce.dis.avro.ElectronicEmissionSystemData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getSystemDataLength());
	dos.writeByte(pdu.getNumberOfBeamDataRecords());
	dos.writeShort(pdu.getEmissionsPadding2());
	marshallEmitterSystem(pdu.getEmitterSystem(), dos);
	marshallVector3Float(pdu.getLocation(), dos);
}

public void marshallAggregateID(com.cohesionforce.dis.avro.AggregateID pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSite());
	dos.writeShort(pdu.getApplication());
	dos.writeShort(pdu.getAggregateID());
}

public void marshallMarking(com.cohesionforce.dis.avro.Marking pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getCharacterSet());
}

public void marshallAggregateMarking(com.cohesionforce.dis.avro.AggregateMarking pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getCharacterSet());
}

public void marshallAggregateType(com.cohesionforce.dis.avro.AggregateType pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getAggregateKind());
	dos.writeByte(pdu.getDomain());
	dos.writeShort(pdu.getCountry());
	dos.writeByte(pdu.getCategory());
	dos.writeByte(pdu.getSubcategory());
	dos.writeByte(pdu.getSpecificInfo());
	dos.writeByte(pdu.getExtra());
}

public void marshallBeamData(com.cohesionforce.dis.avro.BeamData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getBeamAzimuthCenter());
	dos.writeFloat(pdu.getBeamAzimuthSweep());
	dos.writeFloat(pdu.getBeamElevationCenter());
	dos.writeFloat(pdu.getBeamElevationSweep());
	dos.writeFloat(pdu.getBeamSweepSync());
}

public void marshallEnvironment(com.cohesionforce.dis.avro.Environment pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getEnvironmentType().intValue());
	dos.writeByte(pdu.getLength());
	dos.writeByte(pdu.getRecordIndex());
	dos.writeByte(pdu.getPadding1());
	dos.writeByte(pdu.getGeometry());
	dos.writeByte(pdu.getPadding2());
}

public void marshallVector3Float(com.cohesionforce.dis.avro.Vector3Float pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getX());
	dos.writeFloat(pdu.getY());
	dos.writeFloat(pdu.getZ());
}

public void marshallVector3Double(com.cohesionforce.dis.avro.Vector3Double pdu,
	DataOutputStream dos) throws IOException {

	dos.writeDouble(pdu.getX());
	dos.writeDouble(pdu.getY());
	dos.writeDouble(pdu.getZ());
}

public void marshallEntityID(com.cohesionforce.dis.avro.EntityID pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSite());
	dos.writeShort(pdu.getApplication());
	dos.writeShort(pdu.getEntity());
}

public void marshallShaftRPMs(com.cohesionforce.dis.avro.ShaftRPMs pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getCurrentShaftRPMs());
	dos.writeShort(pdu.getOrderedShaftRPMs());
	dos.writeFloat(pdu.getShaftRPMRateOfChange());
}

public void marshallPropulsionSystemData(com.cohesionforce.dis.avro.PropulsionSystemData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getPowerSetting());
	dos.writeFloat(pdu.getEngineRpm());
}

public void marshallVectoringNozzleSystemData(com.cohesionforce.dis.avro.VectoringNozzleSystemData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getHorizontalDeflectionAngle());
	dos.writeFloat(pdu.getVerticalDeflectionAngle());
}

public void marshallAcousticEmitterSystem(com.cohesionforce.dis.avro.AcousticEmitterSystem pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getAcousticName());
	dos.writeByte(pdu.getAcousticFunction());
	dos.writeByte(pdu.getAcousticID());
}

public void marshallAcousticEmitterSystemData(com.cohesionforce.dis.avro.AcousticEmitterSystemData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getEmitterSystemDataLength());
	dos.writeByte(pdu.getNumberOfBeamRecords());
	dos.writeShort(pdu.getPad2());
	marshallAcousticEmitterSystem(pdu.getAcousticEmitterSystem(), dos);
	marshallVector3Float(pdu.getEmitterLocation(), dos);
}

public void marshallAcousticBeamData(com.cohesionforce.dis.avro.AcousticBeamData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getBeamDataLength());
	dos.writeByte(pdu.getBeamIDNumber());
	dos.writeShort(pdu.getPad2());
	marshallAcousticBeamFundamentalParameter(pdu.getFundamentalDataParameters(), dos);
}

public void marshallAcousticBeamFundamentalParameter(com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getActiveEmissionParameterIndex());
	dos.writeShort(pdu.getScanPattern());
	dos.writeFloat(pdu.getBeamCenterAzimuth());
	dos.writeFloat(pdu.getAzimuthalBeamwidth());
	dos.writeFloat(pdu.getBeamCenterDE());
	dos.writeFloat(pdu.getDeBeamwidth());
}

public void marshallApaData(com.cohesionforce.dis.avro.ApaData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getParameterIndex());
	dos.writeShort(pdu.getParameterValue());
}

public void marshallIffFundamentalData(com.cohesionforce.dis.avro.IffFundamentalData pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getSystemStatus());
	dos.writeByte(pdu.getAlternateParameter4());
	dos.writeByte(pdu.getInformationLayers());
	dos.writeByte(pdu.getModifier());
	dos.writeShort(pdu.getParameter1());
	dos.writeShort(pdu.getParameter2());
	dos.writeShort(pdu.getParameter3());
	dos.writeShort(pdu.getParameter4());
	dos.writeShort(pdu.getParameter5());
	dos.writeShort(pdu.getParameter6());
}

public void marshallIntercomCommunicationsParameters(com.cohesionforce.dis.avro.IntercomCommunicationsParameters pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getRecordType());
	dos.writeShort(pdu.getRecordLength());
	dos.writeInt(pdu.getRecordSpecificField().intValue());
}

public void marshallLayerHeader(com.cohesionforce.dis.avro.LayerHeader pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getLayerNumber());
	dos.writeByte(pdu.getLayerSpecificInformaiton());
	dos.writeShort(pdu.getLength());
}

public void marshallSystemID(com.cohesionforce.dis.avro.SystemID pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSystemType());
	dos.writeShort(pdu.getSystemName());
	dos.writeByte(pdu.getSystemMode());
	dos.writeByte(pdu.getChangeOptions());
}

public void marshallFundamentalParameterDataIff(com.cohesionforce.dis.avro.FundamentalParameterDataIff pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getErp());
	dos.writeFloat(pdu.getFrequency());
	dos.writeFloat(pdu.getPgrf());
	dos.writeFloat(pdu.getPulseWidth());
	dos.writeInt(pdu.getBurstLength().intValue());
	dos.writeByte(pdu.getApplicableModes());
	dos.writeShort(pdu.getPad2());
	dos.writeByte(pdu.getPad3());
}

public void marshallGridAxis(com.cohesionforce.dis.avro.GridAxis pdu,
	DataOutputStream dos) throws IOException {

	dos.writeDouble(pdu.getDomainInitialXi());
	dos.writeDouble(pdu.getDomainFinalXi());
	dos.writeShort(pdu.getDomainPointsXi());
	dos.writeByte(pdu.getInterleafFactor());
	dos.writeByte(pdu.getAxisType());
	dos.writeShort(pdu.getNumberOfPointsOnXiAxis());
	dos.writeShort(pdu.getInitialIndex());
}

public void marshallGridAxisRecord(com.cohesionforce.dis.avro.GridAxisRecord pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSampleType());
	dos.writeShort(pdu.getDataRepresentation());
}

public void marshallGridAxisRecordRepresentation0(com.cohesionforce.dis.avro.GridAxisRecordRepresentation0 pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSampleType());
	dos.writeShort(pdu.getDataRepresentation());
	dos.writeShort(pdu.getNumberOfDataValues());
}

public void marshallGridAxisRecordRepresentation1(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1 pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSampleType());
	dos.writeShort(pdu.getDataRepresentation());
	dos.writeFloat(pdu.getFieldScale());
	dos.writeFloat(pdu.getFieldOffset());
	dos.writeShort(pdu.getNumberOfDataValues());
}

public void marshallGridAxisRecordRepresentation2(com.cohesionforce.dis.avro.GridAxisRecordRepresentation2 pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSampleType());
	dos.writeShort(pdu.getDataRepresentation());
	dos.writeShort(pdu.getNumberOfDataValues());
}

public void marshallSixByteChunk(com.cohesionforce.dis.avro.SixByteChunk pdu,
	DataOutputStream dos) throws IOException {

}

public void marshallLinearSegmentParameter(com.cohesionforce.dis.avro.LinearSegmentParameter pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getSegmentNumber());
	marshallSixByteChunk(pdu.getSegmentAppearance(), dos);
	marshallVector3Double(pdu.getLocation(), dos);
	marshallOrientation(pdu.getOrientation(), dos);
	dos.writeShort(pdu.getSegmentLength());
	dos.writeShort(pdu.getSegmentWidth());
	dos.writeShort(pdu.getSegmentHeight());
	dos.writeShort(pdu.getSegmentDepth());
	dos.writeInt(pdu.getPad1().intValue());
}

public void marshallEightByteChunk(com.cohesionforce.dis.avro.EightByteChunk pdu,
	DataOutputStream dos) throws IOException {

}

public void marshallOneByteChunk(com.cohesionforce.dis.avro.OneByteChunk pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getOtherParameters());
}

public void marshallTwoByteChunk(com.cohesionforce.dis.avro.TwoByteChunk pdu,
	DataOutputStream dos) throws IOException {

}

public void marshallFourByteChunk(com.cohesionforce.dis.avro.FourByteChunk pdu,
	DataOutputStream dos) throws IOException {

}

public void marshallPoint(com.cohesionforce.dis.avro.Point pdu,
	DataOutputStream dos) throws IOException {

	dos.writeFloat(pdu.getX());
	dos.writeFloat(pdu.getY());
}

public void marshallModulationType(com.cohesionforce.dis.avro.ModulationType pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getSpreadSpectrum());
	dos.writeShort(pdu.getMajor());
	dos.writeShort(pdu.getDetail());
	dos.writeShort(pdu.getSystem());
}

public void marshallRelationship(com.cohesionforce.dis.avro.Relationship pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getNature());
	dos.writeShort(pdu.getPosition());
}

public void marshallNamedLocation(com.cohesionforce.dis.avro.NamedLocation pdu,
	DataOutputStream dos) throws IOException {

	dos.writeShort(pdu.getStationName());
	dos.writeShort(pdu.getStationNumber());
}

public void marshallDeadReckoningParameter(com.cohesionforce.dis.avro.DeadReckoningParameter pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getDeadReckoningAlgorithm());
	marshallVector3Float(pdu.getEntityLinearAcceleration(), dos);
	marshallVector3Float(pdu.getEntityAngularVelocity(), dos);
}

public void marshallRecordSet(com.cohesionforce.dis.avro.RecordSet pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getRecordID().intValue());
	dos.writeInt(pdu.getRecordSetSerialNumber().intValue());
	dos.writeShort(pdu.getRecordLength());
	dos.writeShort(pdu.getRecordCount());
	dos.writeShort(pdu.getRecordValues());
	dos.writeByte(pdu.getPad4());
}

public void marshallPduStream(com.cohesionforce.dis.avro.PduStream pdu,
	DataOutputStream dos) throws IOException {

	dos.writeLong(pdu.getStartTime());
	dos.writeLong(pdu.getStopTime());
}

public void marshallPdu(com.cohesionforce.dis.avro.Pdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallEntityInformationFamilyPdu(com.cohesionforce.dis.avro.EntityInformationFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallEntityStatePdu(com.cohesionforce.dis.avro.EntityStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityID(), dos);
	dos.writeByte(pdu.getForceId());
	dos.writeByte(pdu.getNumberOfArticulationParameters());
	marshallEntityType(pdu.getEntityType(), dos);
	marshallEntityType(pdu.getAlternativeEntityType(), dos);
	marshallVector3Float(pdu.getEntityLinearVelocity(), dos);
	marshallVector3Double(pdu.getEntityLocation(), dos);
	marshallOrientation(pdu.getEntityOrientation(), dos);
	dos.writeInt(pdu.getEntityAppearance());
	marshallDeadReckoningParameter(pdu.getDeadReckoningParameters(), dos);
	marshallMarking(pdu.getMarking(), dos);
	dos.writeInt(pdu.getCapabilities());
}

public void marshallCollisionPdu(com.cohesionforce.dis.avro.CollisionPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getIssuingEntityID(), dos);
	marshallEntityID(pdu.getCollidingEntityID(), dos);
	marshallEventID(pdu.getEventID(), dos);
	dos.writeByte(pdu.getCollisionType());
	dos.writeByte(pdu.getPad());
	marshallVector3Float(pdu.getVelocity(), dos);
	dos.writeFloat(pdu.getMass());
	marshallVector3Float(pdu.getLocation(), dos);
}

public void marshallCollisionElasticPdu(com.cohesionforce.dis.avro.CollisionElasticPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getIssuingEntityID(), dos);
	marshallEntityID(pdu.getCollidingEntityID(), dos);
	marshallEventID(pdu.getCollisionEventID(), dos);
	dos.writeShort(pdu.getPad());
	marshallVector3Float(pdu.getContactVelocity(), dos);
	dos.writeFloat(pdu.getMass());
	marshallVector3Float(pdu.getLocation(), dos);
	dos.writeFloat(pdu.getCollisionResultXX());
	dos.writeFloat(pdu.getCollisionResultXY());
	dos.writeFloat(pdu.getCollisionResultXZ());
	dos.writeFloat(pdu.getCollisionResultYY());
	dos.writeFloat(pdu.getCollisionResultYZ());
	dos.writeFloat(pdu.getCollisionResultZZ());
	marshallVector3Float(pdu.getUnitSurfaceNormal(), dos);
	dos.writeFloat(pdu.getCoefficientOfRestitution());
}

public void marshallEntityStateUpdatePdu(com.cohesionforce.dis.avro.EntityStateUpdatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityID(), dos);
	dos.writeByte(pdu.getPadding1());
	dos.writeByte(pdu.getNumberOfArticulationParameters());
	marshallVector3Float(pdu.getEntityLinearVelocity(), dos);
	marshallVector3Double(pdu.getEntityLocation(), dos);
	marshallOrientation(pdu.getEntityOrientation(), dos);
	dos.writeInt(pdu.getEntityAppearance());
}

public void marshallWarfareFamilyPdu(com.cohesionforce.dis.avro.WarfareFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getFiringEntityID(), dos);
	marshallEntityID(pdu.getTargetEntityID(), dos);
}

public void marshallFirePdu(com.cohesionforce.dis.avro.FirePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getFiringEntityID(), dos);
	marshallEntityID(pdu.getTargetEntityID(), dos);
	marshallEntityID(pdu.getMunitionID(), dos);
	marshallEventID(pdu.getEventID(), dos);
	dos.writeInt(pdu.getFireMissionIndex());
	marshallVector3Double(pdu.getLocationInWorldCoordinates(), dos);
	marshallBurstDescriptor(pdu.getBurstDescriptor(), dos);
	marshallVector3Float(pdu.getVelocity(), dos);
	dos.writeFloat(pdu.getRangeToTarget());
}

public void marshallDetonationPdu(com.cohesionforce.dis.avro.DetonationPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getFiringEntityID(), dos);
	marshallEntityID(pdu.getTargetEntityID(), dos);
	marshallEntityID(pdu.getMunitionID(), dos);
	marshallEventID(pdu.getEventID(), dos);
	marshallVector3Float(pdu.getVelocity(), dos);
	marshallVector3Double(pdu.getLocationInWorldCoordinates(), dos);
	marshallBurstDescriptor(pdu.getBurstDescriptor(), dos);
	marshallVector3Float(pdu.getLocationInEntityCoordinates(), dos);
	dos.writeByte(pdu.getDetonationResult());
	dos.writeByte(pdu.getNumberOfArticulationParameters());
	dos.writeShort(pdu.getPad());
}

public void marshallLogisticsFamilyPdu(com.cohesionforce.dis.avro.LogisticsFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallServiceRequestPdu(com.cohesionforce.dis.avro.ServiceRequestPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getRequestingEntityID(), dos);
	marshallEntityID(pdu.getServicingEntityID(), dos);
	dos.writeByte(pdu.getServiceTypeRequested());
	dos.writeByte(pdu.getNumberOfSupplies());
	dos.writeShort(pdu.getServiceRequestPadding());
}

public void marshallResupplyOfferPdu(com.cohesionforce.dis.avro.ResupplyOfferPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallEntityID(pdu.getSupplyingEntityID(), dos);
	dos.writeByte(pdu.getNumberOfSupplies());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
}

public void marshallResupplyReceivedPdu(com.cohesionforce.dis.avro.ResupplyReceivedPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallEntityID(pdu.getSupplyingEntityID(), dos);
	dos.writeByte(pdu.getNumberOfSupplies());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
}

public void marshallResupplyCancelPdu(com.cohesionforce.dis.avro.ResupplyCancelPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallEntityID(pdu.getSupplyingEntityID(), dos);
}

public void marshallRepairCompletePdu(com.cohesionforce.dis.avro.RepairCompletePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallEntityID(pdu.getRepairingEntityID(), dos);
	dos.writeShort(pdu.getRepair());
	dos.writeShort(pdu.getPadding2());
}

public void marshallRepairResponsePdu(com.cohesionforce.dis.avro.RepairResponsePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallEntityID(pdu.getRepairingEntityID(), dos);
	dos.writeByte(pdu.getRepairResult());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
}

public void marshallSimulationManagementFamilyPdu(com.cohesionforce.dis.avro.SimulationManagementFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
}

public void marshallCreateEntityPdu(com.cohesionforce.dis.avro.CreateEntityPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallRemoveEntityPdu(com.cohesionforce.dis.avro.RemoveEntityPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallStartResumePdu(com.cohesionforce.dis.avro.StartResumePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallClockTime(pdu.getRealWorldTime(), dos);
	marshallClockTime(pdu.getSimulationTime(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallStopFreezePdu(com.cohesionforce.dis.avro.StopFreezePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallClockTime(pdu.getRealWorldTime(), dos);
	dos.writeByte(pdu.getReason());
	dos.writeByte(pdu.getFrozenBehavior());
	dos.writeShort(pdu.getPadding1());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallAcknowledgePdu(com.cohesionforce.dis.avro.AcknowledgePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeShort(pdu.getAcknowledgeFlag());
	dos.writeShort(pdu.getResponseFlag());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallActionRequestPdu(com.cohesionforce.dis.avro.ActionRequestPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getActionID().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallActionResponsePdu(com.cohesionforce.dis.avro.ActionResponsePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getRequestStatus().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallDataQueryPdu(com.cohesionforce.dis.avro.DataQueryPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getTimeInterval().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallSetDataPdu(com.cohesionforce.dis.avro.SetDataPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getPadding1().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallDataPdu(com.cohesionforce.dis.avro.DataPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getPadding1().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallEventReportPdu(com.cohesionforce.dis.avro.EventReportPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getEventType().intValue());
	dos.writeInt(pdu.getPadding1().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallCommentPdu(com.cohesionforce.dis.avro.CommentPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getNumberOfFixedDatums().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatums().intValue());
}

public void marshallDistributedEmissionsFamilyPdu(com.cohesionforce.dis.avro.DistributedEmissionsFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallElectronicEmissionsPdu(com.cohesionforce.dis.avro.ElectronicEmissionsPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEmittingEntityID(), dos);
	marshallEventID(pdu.getEventID(), dos);
	dos.writeByte(pdu.getStateUpdateIndicator());
	dos.writeByte(pdu.getNumberOfSystems());
	dos.writeShort(pdu.getPaddingForEmissionsPdu());
}

public void marshallDesignatorPdu(com.cohesionforce.dis.avro.DesignatorPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getDesignatingEntityID(), dos);
	dos.writeShort(pdu.getCodeName());
	marshallEntityID(pdu.getDesignatedEntityID(), dos);
	dos.writeShort(pdu.getDesignatorCode());
	dos.writeFloat(pdu.getDesignatorPower());
	dos.writeFloat(pdu.getDesignatorWavelength());
	marshallVector3Float(pdu.getDesignatorSpotWrtDesignated(), dos);
	marshallVector3Double(pdu.getDesignatorSpotLocation(), dos);
	dos.writeByte(pdu.getDeadReckoningAlgorithm());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
	marshallVector3Float(pdu.getEntityLinearAcceleration(), dos);
}

public void marshallUaPdu(com.cohesionforce.dis.avro.UaPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEmittingEntityID(), dos);
	marshallEventID(pdu.getEventID(), dos);
	dos.writeByte(pdu.getStateChangeIndicator());
	dos.writeByte(pdu.getPad());
	dos.writeShort(pdu.getPassiveParameterIndex());
	dos.writeByte(pdu.getPropulsionPlantConfiguration());
	dos.writeByte(pdu.getNumberOfShaftRPMs());
	dos.writeByte(pdu.getNumberOfApaData());
	dos.writeByte(pdu.getNumberOfEmitterSystems());
}

public void marshallIffAtcNavAidsLayer1Pdu(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEmittingEntityId(), dos);
	marshallEventID(pdu.getEventID(), dos);
	marshallVector3Float(pdu.getLocation(), dos);
	marshallSystemID(pdu.getSystemID(), dos);
	dos.writeShort(pdu.getPad2());
	marshallIffFundamentalData(pdu.getFundamentalParameters(), dos);
}

public void marshallIffAtcNavAidsLayer2Pdu(com.cohesionforce.dis.avro.IffAtcNavAidsLayer2Pdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEmittingEntityId(), dos);
	marshallEventID(pdu.getEventID(), dos);
	marshallVector3Float(pdu.getLocation(), dos);
	marshallSystemID(pdu.getSystemID(), dos);
	dos.writeShort(pdu.getPad2());
	marshallIffFundamentalData(pdu.getFundamentalParameters(), dos);
	marshallLayerHeader(pdu.getLayerHeader(), dos);
	marshallBeamData(pdu.getBeamData(), dos);
	marshallBeamData(pdu.getSecondaryOperationalData(), dos);
}

public void marshallSeesPdu(com.cohesionforce.dis.avro.SeesPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOrginatingEntityID(), dos);
	dos.writeShort(pdu.getInfraredSignatureRepresentationIndex());
	dos.writeShort(pdu.getAcousticSignatureRepresentationIndex());
	dos.writeShort(pdu.getRadarCrossSectionSignatureRepresentationIndex());
	dos.writeShort(pdu.getNumberOfPropulsionSystemData());
	dos.writeShort(pdu.getNumberOfVectoringSystemData());
}

public void marshallRadioCommunicationsFamilyPdu(com.cohesionforce.dis.avro.RadioCommunicationsFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
}

public void marshallIntercomSignalPdu(com.cohesionforce.dis.avro.IntercomSignalPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
	marshallEntityID(pdu.getEntityID1(), dos);
	dos.writeShort(pdu.getCommunicationsDeviceID());
	dos.writeShort(pdu.getEncodingScheme());
	dos.writeShort(pdu.getTdlType());
	dos.writeInt(pdu.getSampleRate().intValue());
	dos.writeShort(pdu.getNumberOfData());
	dos.writeShort(pdu.getSamples());
}

public void marshallTransmitterPdu(com.cohesionforce.dis.avro.TransmitterPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
	marshallRadioEntityType(pdu.getRadioEntityType(), dos);
	dos.writeByte(pdu.getTransmitState());
	dos.writeByte(pdu.getInputSource());
	dos.writeShort(pdu.getPadding1());
	marshallVector3Double(pdu.getAntennaLocation(), dos);
	marshallVector3Float(pdu.getRelativeAntennaLocation(), dos);
	dos.writeShort(pdu.getAntennaPatternType());
	dos.writeShort(pdu.getNumberOfAntennaPatternList());
	dos.writeLong(pdu.getFrequency());
	dos.writeFloat(pdu.getTransmitFrequencyBandwidth());
	dos.writeFloat(pdu.getPower());
	marshallModulationType(pdu.getModulationType(), dos);
	dos.writeShort(pdu.getCryptoSystem());
	dos.writeShort(pdu.getCryptoKeyId());
	dos.writeByte(pdu.getNumberOfModulationParametersList());
	dos.writeShort(pdu.getPadding2());
	dos.writeByte(pdu.getPadding3());
}

public void marshallSignalPdu(com.cohesionforce.dis.avro.SignalPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
	dos.writeShort(pdu.getEncodingScheme());
	dos.writeShort(pdu.getTdlType());
	dos.writeInt(pdu.getSampleRate().intValue());
	dos.writeShort(pdu.getNumberOfData());
	dos.writeShort(pdu.getSamples());
}

public void marshallReceiverPdu(com.cohesionforce.dis.avro.ReceiverPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
	dos.writeShort(pdu.getReceiverState());
	dos.writeShort(pdu.getPadding1());
	dos.writeFloat(pdu.getReceivedPoser());
	marshallEntityID(pdu.getTransmitterEntityId(), dos);
	dos.writeShort(pdu.getTransmitterRadioId());
}

public void marshallIntercomControlPdu(com.cohesionforce.dis.avro.IntercomControlPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEntityId(), dos);
	dos.writeShort(pdu.getRadioId());
	dos.writeByte(pdu.getControlType());
	dos.writeByte(pdu.getCommunicationsChannelType());
	marshallEntityID(pdu.getSourceEntityID(), dos);
	dos.writeByte(pdu.getSourceCommunicationsDeviceID());
	dos.writeByte(pdu.getSourceLineID());
	dos.writeByte(pdu.getTransmitPriority());
	dos.writeByte(pdu.getTransmitLineState());
	dos.writeByte(pdu.getCommand());
	marshallEntityID(pdu.getMasterEntityID(), dos);
	dos.writeShort(pdu.getMasterCommunicationsDeviceID());
	dos.writeInt(pdu.getNumberOfIntercomParameters().intValue());
}

public void marshallEntityManagementFamilyPdu(com.cohesionforce.dis.avro.EntityManagementFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallAggregateStatePdu(com.cohesionforce.dis.avro.AggregateStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getAggregateID(), dos);
	dos.writeByte(pdu.getForceID());
	dos.writeByte(pdu.getAggregateState());
	marshallEntityType(pdu.getAggregateType(), dos);
	dos.writeInt(pdu.getFormation().intValue());
	marshallAggregateMarking(pdu.getAggregateMarking(), dos);
	marshallVector3Float(pdu.getDimensions(), dos);
	marshallOrientation(pdu.getOrientation(), dos);
	marshallVector3Double(pdu.getCenterOfMass(), dos);
	marshallVector3Float(pdu.getVelocity(), dos);
	dos.writeShort(pdu.getNumberOfAggregateIDList());
	dos.writeShort(pdu.getNumberOfEntityIDList());
	dos.writeShort(pdu.getNumberOfSilentAggregateSystemList());
	dos.writeShort(pdu.getNumberOfSilentEntitySystemList());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getNumberOfVariableDatumList().intValue());
}

public void marshallIsGroupOfPdu(com.cohesionforce.dis.avro.IsGroupOfPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getGroupEntityID(), dos);
	dos.writeByte(pdu.getGroupedEntityCategory());
	dos.writeByte(pdu.getNumberOfGroupedEntityDescriptions());
	dos.writeInt(pdu.getPad2().intValue());
	dos.writeDouble(pdu.getLatitude());
	dos.writeDouble(pdu.getLongitude());
}

public void marshallTransferControlRequestPdu(com.cohesionforce.dis.avro.TransferControlRequestPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOrginatingEntityID(), dos);
	marshallEntityID(pdu.getRecevingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeByte(pdu.getTranferType());
	marshallEntityID(pdu.getTransferEntityID(), dos);
	dos.writeByte(pdu.getNumberOfRecordSets());
}

public void marshallIsPartOfPdu(com.cohesionforce.dis.avro.IsPartOfPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOrginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallRelationship(pdu.getRelationship(), dos);
	marshallVector3Float(pdu.getPartLocation(), dos);
	marshallNamedLocation(pdu.getNamedLocationID(), dos);
	marshallEntityType(pdu.getPartEntityType(), dos);
}

public void marshallMinefieldFamilyPdu(com.cohesionforce.dis.avro.MinefieldFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallMinefieldStatePdu(com.cohesionforce.dis.avro.MinefieldStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getMinefieldID(), dos);
	dos.writeShort(pdu.getMinefieldSequence());
	dos.writeByte(pdu.getForceID());
	dos.writeByte(pdu.getNumberOfPerimeterPoints());
	marshallEntityType(pdu.getMinefieldType(), dos);
	dos.writeShort(pdu.getNumberOfMineType());
	marshallVector3Double(pdu.getMinefieldLocation(), dos);
	marshallOrientation(pdu.getMinefieldOrientation(), dos);
	dos.writeShort(pdu.getAppearance());
	dos.writeShort(pdu.getProtocolMode());
}

public void marshallMinefieldQueryPdu(com.cohesionforce.dis.avro.MinefieldQueryPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getMinefieldID(), dos);
	marshallEntityID(pdu.getRequestingEntityID(), dos);
	dos.writeByte(pdu.getRequestID());
	dos.writeByte(pdu.getNumberOfRequestedPerimeterPoints());
	dos.writeByte(pdu.getPad2());
	dos.writeByte(pdu.getNumberOfSensorTypes());
	dos.writeInt(pdu.getDataFilter().intValue());
	marshallEntityType(pdu.getRequestedMineType(), dos);
}

public void marshallMinefieldDataPdu(com.cohesionforce.dis.avro.MinefieldDataPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getMinefieldID(), dos);
	marshallEntityID(pdu.getRequestingEntityID(), dos);
	dos.writeShort(pdu.getMinefieldSequenceNumbeer());
	dos.writeByte(pdu.getRequestID());
	dos.writeByte(pdu.getPduSequenceNumber());
	dos.writeByte(pdu.getNumberOfPdus());
	dos.writeByte(pdu.getNumberOfMineLocation());
	dos.writeByte(pdu.getNumberOfSensorTypes());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getDataFilter().intValue());
	marshallEntityType(pdu.getMineType(), dos);
	dos.writeByte(pdu.getPad3());
}

public void marshallMinefieldResponseNackPdu(com.cohesionforce.dis.avro.MinefieldResponseNackPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getMinefieldID(), dos);
	marshallEntityID(pdu.getRequestingEntityID(), dos);
	dos.writeByte(pdu.getRequestID());
	dos.writeByte(pdu.getNumberOfMissingPduSequenceNumbers());
}

public void marshallSyntheticEnvironmentFamilyPdu(com.cohesionforce.dis.avro.SyntheticEnvironmentFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
}

public void marshallEnvironmentalProcessPdu(com.cohesionforce.dis.avro.EnvironmentalProcessPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEnvironementalProcessID(), dos);
	marshallEntityType(pdu.getEnvironmentType(), dos);
	dos.writeByte(pdu.getModelType());
	dos.writeByte(pdu.getEnvironmentStatus());
	dos.writeByte(pdu.getNumberOfEnvironmentRecords());
	dos.writeShort(pdu.getSequenceNumber());
}

public void marshallGriddedDataPdu(com.cohesionforce.dis.avro.GriddedDataPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getEnvironmentalSimulationApplicationID(), dos);
	dos.writeShort(pdu.getFieldNumber());
	dos.writeShort(pdu.getPduNumber());
	dos.writeShort(pdu.getPduTotal());
	dos.writeShort(pdu.getCoordinateSystem());
	dos.writeByte(pdu.getNumberOfGridDataList());
	dos.writeByte(pdu.getConstantGrid());
	marshallEntityType(pdu.getEnvironmentType(), dos);
	marshallOrientation(pdu.getOrientation(), dos);
	dos.writeLong(pdu.getSampleTime());
	dos.writeInt(pdu.getTotalValues().intValue());
	dos.writeByte(pdu.getVectorDimension());
	dos.writeShort(pdu.getPadding1());
	dos.writeByte(pdu.getPadding2());
}

public void marshallPointObjectStatePdu(com.cohesionforce.dis.avro.PointObjectStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getObjectID(), dos);
	marshallEntityID(pdu.getReferencedObjectID(), dos);
	dos.writeShort(pdu.getUpdateNumber());
	dos.writeByte(pdu.getForceID());
	dos.writeByte(pdu.getModifications());
	marshallObjectType(pdu.getObjectType(), dos);
	marshallVector3Double(pdu.getObjectLocation(), dos);
	marshallOrientation(pdu.getObjectOrientation(), dos);
	dos.writeDouble(pdu.getObjectAppearance());
	marshallSimulationAddress(pdu.getRequesterID(), dos);
	marshallSimulationAddress(pdu.getReceivingID(), dos);
	dos.writeInt(pdu.getPad2().intValue());
}

public void marshallLinearObjectStatePdu(com.cohesionforce.dis.avro.LinearObjectStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getObjectID(), dos);
	marshallEntityID(pdu.getReferencedObjectID(), dos);
	dos.writeShort(pdu.getUpdateNumber());
	dos.writeByte(pdu.getForceID());
	dos.writeByte(pdu.getNumberOfLinearSegmentParameters());
	marshallSimulationAddress(pdu.getRequesterID(), dos);
	marshallSimulationAddress(pdu.getReceivingID(), dos);
	marshallObjectType(pdu.getObjectType(), dos);
}

public void marshallArealObjectStatePdu(com.cohesionforce.dis.avro.ArealObjectStatePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getObjectID(), dos);
	marshallEntityID(pdu.getReferencedObjectID(), dos);
	dos.writeShort(pdu.getUpdateNumber());
	dos.writeByte(pdu.getForceID());
	dos.writeByte(pdu.getModifications());
	marshallEntityType(pdu.getObjectType(), dos);
	marshallSixByteChunk(pdu.getObjectAppearance(), dos);
	dos.writeShort(pdu.getNumberOfObjectLocation());
	marshallSimulationAddress(pdu.getRequesterID(), dos);
	marshallSimulationAddress(pdu.getReceivingID(), dos);
}

public void marshallSimulationManagementWithReliabilityFamilyPdu(com.cohesionforce.dis.avro.SimulationManagementWithReliabilityFamilyPdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
}

public void marshallCreateEntityReliablePdu(com.cohesionforce.dis.avro.CreateEntityReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallRemoveEntityReliablePdu(com.cohesionforce.dis.avro.RemoveEntityReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallStartResumeReliablePdu(com.cohesionforce.dis.avro.StartResumeReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallClockTime(pdu.getRealWorldTime(), dos);
	marshallClockTime(pdu.getSimulationTime(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallStopFreezeReliablePdu(com.cohesionforce.dis.avro.StopFreezeReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	marshallClockTime(pdu.getRealWorldTime(), dos);
	dos.writeByte(pdu.getReason());
	dos.writeByte(pdu.getFrozenBehavior());
	dos.writeByte(pdu.getRequiredReliablityService());
	dos.writeByte(pdu.getPad1());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallAcknowledgeReliablePdu(com.cohesionforce.dis.avro.AcknowledgeReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeShort(pdu.getAcknowledgeFlag());
	dos.writeShort(pdu.getResponseFlag());
	dos.writeInt(pdu.getRequestID().intValue());
}

public void marshallActionRequestReliablePdu(com.cohesionforce.dis.avro.ActionRequestReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getActionID().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallActionResponseReliablePdu(com.cohesionforce.dis.avro.ActionResponseReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getResponseStatus().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallDataQueryReliablePdu(com.cohesionforce.dis.avro.DataQueryReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getTimeInterval().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallSetDataReliablePdu(com.cohesionforce.dis.avro.SetDataReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallDataReliablePdu(com.cohesionforce.dis.avro.DataReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallEventReportReliablePdu(com.cohesionforce.dis.avro.EventReportReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeShort(pdu.getEventType());
	dos.writeInt(pdu.getPad1().intValue());
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallCommentReliablePdu(com.cohesionforce.dis.avro.CommentReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getNumberOfFixedDatumRecords().intValue());
	dos.writeInt(pdu.getNumberOfVariableDatumRecords().intValue());
}

public void marshallRecordQueryReliablePdu(com.cohesionforce.dis.avro.RecordQueryReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeShort(pdu.getEventType());
	dos.writeInt(pdu.getTime().intValue());
	dos.writeInt(pdu.getNumberOfRecordIDs().intValue());
}

public void marshallSetRecordReliablePdu(com.cohesionforce.dis.avro.SetRecordReliablePdu pdu,
	DataOutputStream dos) throws IOException {

	dos.writeByte(pdu.getProtocolVersion());
	dos.writeByte(pdu.getExerciseID());
	dos.writeByte(pdu.getPduType());
	dos.writeByte(pdu.getProtocolFamily());
	dos.writeInt(pdu.getTimestamp().intValue());
	dos.writeShort(pdu.getPduLength());
	dos.writeShort(pdu.getPadding());
	marshallEntityID(pdu.getOriginatingEntityID(), dos);
	marshallEntityID(pdu.getReceivingEntityID(), dos);
	dos.writeInt(pdu.getRequestID().intValue());
	dos.writeByte(pdu.getRequiredReliabilityService());
	dos.writeShort(pdu.getPad1());
	dos.writeByte(pdu.getPad2());
	dos.writeInt(pdu.getNumberOfRecordSets().intValue());
}

public void marshallPduContainer(com.cohesionforce.dis.avro.PduContainer pdu,
	DataOutputStream dos) throws IOException {

	dos.writeInt(pdu.getNumberOfPdus());
}

}
