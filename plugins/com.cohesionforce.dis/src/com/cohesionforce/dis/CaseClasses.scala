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

case class AngularVelocityVector(
	var x: Float = 0,
	var y: Float = 0,
	var z: Float = 0
)

case class AntennaLocation(
	var antennaLocation: Vector3Double = null,
	var relativeAntennaLocation: Vector3Float = null
)

case class BeamAntennaPattern(
	var beamDirection: Orientation = null,
	var azimuthBeamwidth: Float = 0,
	var elevationBeamwidth: Float = 0,
	var referenceSystem: Float = 0,
	var padding1: Short = 0,
	var padding2: Byte = 0,
	var ez: Float = 0,
	var ex: Float = 0,
	var phase: Float = 0
)

case class SphericalHarmonicAntennaPattern(
	var harmonicOrder: Byte = 0
)

case class ArticulationParameter(
	var parameterTypeDesignator: Short = 0,
	var changeIndicator: Short = 0,
	var partAttachedTo: Int = 0,
	var parameterType: Int = 0,
	var parameterValue: Double = 0
)

case class BurstDescriptor(
	var munition: EntityType = null,
	var warhead: Int = 0,
	var fuse: Int = 0,
	var quantity: Int = 0,
	var rate: Int = 0
)

case class ClockTime(
	var hour: Int = 0,
	var timePastHour: Long = 0
)

case class EmitterSystem(
	var emitterName: Int = 0,
	var function: Short = 0,
	var emitterIdNumber: Short = 0
)

case class SimulationAddress(
	var site: Int = 0,
	var application: Int = 0
)

case class EntityType(
	var entityKind: Short = 0,
	var domain: Short = 0,
	var country: Int = 0,
	var category: Short = 0,
	var subcategory: Short = 0,
	var spec: Short = 0,
	var extra: Short = 0
)

case class ObjectType(
	var entityKind: Short = 0,
	var domain: Short = 0,
	var country: Int = 0,
	var category: Short = 0,
	var subcategory: Short = 0
)

case class Orientation(
	var psi: Float = 0,
	var theta: Float = 0,
	var phi: Float = 0
)

case class EventID(
	var site: Int = 0,
	var application: Int = 0,
	var eventNumber: Int = 0
)

case class FixedDatum(
	var fixedDatumID: Long = 0,
	var fixedDatumValue: Long = 0
)

case class FundamentalParameterData(
	var frequency: Float = 0,
	var frequencyRange: Float = 0,
	var effectiveRadiatedPower: Float = 0,
	var pulseRepetitionFrequency: Float = 0,
	var pulseWidth: Float = 0,
	var beamAzimuthCenter: Float = 0,
	var beamAzimuthSweep: Float = 0,
	var beamElevationCenter: Float = 0,
	var beamElevationSweep: Float = 0,
	var beamSweepSync: Float = 0
)

case class RadioEntityType(
	var entityKind: Short = 0,
	var domain: Short = 0,
	var country: Int = 0,
	var category: Short = 0,
	var nomenclatureVersion: Short = 0,
	var nomenclature: Int = 0
)

case class SupplyQuantity(
	var supplyType: EntityType = null,
	var quantity: Short = 0
)

case class VariableDatum(
	var variableDatumID: Long = 0,
	var variableDatumLength: Long = 0,
	var variableData: List[Byte] = null
)

case class AcousticEmitter(
	var acousticName: Int = 0,
	var function: Short = 0,
	var acousticIdNumber: Short = 0
)

case class TrackJamTarget(
	var trackJam: EntityID = null,
	var emitterID: Short = 0,
	var beamID: Short = 0
)

case class ElectronicEmissionBeamData(
	var beamDataLength: Short = 0,
	var beamIDNumber: Short = 0,
	var beamParameterIndex: Int = 0,
	var fundamentalParameterData: FundamentalParameterData = null,
	var beamFunction: Short = 0,
	var numberOfTrackJamTargets: Short = 0,
	var highDensityTrackJam: Short = 0,
	var pad4: Short = 0,
	var jammingModeSequence: Long = 0,
	var trackJamTargets: List[TrackJamTarget] = null
)

case class ElectronicEmissionSystemData(
	var systemDataLength: Short = 0,
	var numberOfBeamDataRecords: Short = 0,
	var emissionsPadding2: Int = 0,
	var emitterSystem: EmitterSystem = null,
	var location: Vector3Float = null,
	var beamDataRecords: List[ElectronicEmissionBeamData] = null
)

case class AggregateID(
	var site: Int = 0,
	var application: Int = 0,
	var aggregateID: Int = 0
)

case class Marking(
	var characterSet: Short = 0,
	var characters: List[Byte] = null
)

case class AggregateMarking(
	var characterSet: Short = 0,
	var characters: List[Byte] = null
)

case class AggregateType(
	var aggregateKind: Short = 0,
	var domain: Short = 0,
	var country: Int = 0,
	var category: Short = 0,
	var subcategory: Short = 0,
	var specificInfo: Short = 0,
	var extra: Short = 0
)

case class BeamData(
	var beamAzimuthCenter: Float = 0,
	var beamAzimuthSweep: Float = 0,
	var beamElevationCenter: Float = 0,
	var beamElevationSweep: Float = 0,
	var beamSweepSync: Float = 0
)

case class Environment(
	var environmentType: Long = 0,
	var length: Short = 0,
	var recordIndex: Short = 0,
	var padding1: Short = 0,
	var geometry: Short = 0,
	var padding2: Short = 0
)

case class Vector3Float(
	var x: Float = 0,
	var y: Float = 0,
	var z: Float = 0
)

case class Vector3Double(
	var x: Double = 0,
	var y: Double = 0,
	var z: Double = 0
)

case class EntityID(
	var site: Int = 0,
	var application: Int = 0,
	var entity: Int = 0
)

case class ShaftRPMs(
	var currentShaftRPMs: Short = 0,
	var orderedShaftRPMs: Short = 0,
	var shaftRPMRateOfChange: Float = 0
)

case class PropulsionSystemData(
	var powerSetting: Float = 0,
	var engineRpm: Float = 0
)

case class VectoringNozzleSystemData(
	var horizontalDeflectionAngle: Float = 0,
	var verticalDeflectionAngle: Float = 0
)

case class AcousticEmitterSystem(
	var acousticName: Int = 0,
	var acousticFunction: Short = 0,
	var acousticID: Short = 0
)

case class AcousticEmitterSystemData(
	var emitterSystemDataLength: Short = 0,
	var numberOfBeamRecords: Short = 0,
	var pad2: Int = 0,
	var acousticEmitterSystem: AcousticEmitterSystem = null,
	var emitterLocation: Vector3Float = null,
	var beamRecords: List[AcousticBeamData] = null
)

case class AcousticBeamData(
	var beamDataLength: Int = 0,
	var beamIDNumber: Short = 0,
	var pad2: Int = 0,
	var fundamentalDataParameters: AcousticBeamFundamentalParameter = null
)

case class AcousticBeamFundamentalParameter(
	var activeEmissionParameterIndex: Int = 0,
	var scanPattern: Int = 0,
	var beamCenterAzimuth: Float = 0,
	var azimuthalBeamwidth: Float = 0,
	var beamCenterDE: Float = 0,
	var deBeamwidth: Float = 0
)

case class ApaData(
	var parameterIndex: Int = 0,
	var parameterValue: Short = 0
)

case class IffFundamentalData(
	var systemStatus: Short = 0,
	var alternateParameter4: Short = 0,
	var informationLayers: Short = 0,
	var modifier: Short = 0,
	var parameter1: Int = 0,
	var parameter2: Int = 0,
	var parameter3: Int = 0,
	var parameter4: Int = 0,
	var parameter5: Int = 0,
	var parameter6: Int = 0
)

case class IntercomCommunicationsParameters(
	var recordType: Int = 0,
	var recordLength: Int = 0,
	var recordSpecificField: Long = 0
)

case class LayerHeader(
	var layerNumber: Short = 0,
	var layerSpecificInformaiton: Short = 0,
	var length: Int = 0
)

case class SystemID(
	var systemType: Int = 0,
	var systemName: Int = 0,
	var systemMode: Short = 0,
	var changeOptions: Short = 0
)

case class FundamentalParameterDataIff(
	var erp: Float = 0,
	var frequency: Float = 0,
	var pgrf: Float = 0,
	var pulseWidth: Float = 0,
	var burstLength: Long = 0,
	var applicableModes: Short = 0,
	var pad2: Int = 0,
	var pad3: Short = 0
)

case class GridAxis(
	var domainInitialXi: Double = 0,
	var domainFinalXi: Double = 0,
	var domainPointsXi: Int = 0,
	var interleafFactor: Short = 0,
	var axisType: Short = 0,
	var numberOfPointsOnXiAxis: Int = 0,
	var initialIndex: Int = 0
)

case class GridAxisRecord(
	var sampleType: Int = 0,
	var dataRepresentation: Int = 0
)

case class GridAxisRecordRepresentation0(
	var sampleType: Int = 0,
	var dataRepresentation: Int = 0,
	var numberOfDataValues: Int = 0,
	var dataValues: List[OneByteChunk] = null
)

case class GridAxisRecordRepresentation1(
	var sampleType: Int = 0,
	var dataRepresentation: Int = 0,
	var fieldScale: Float = 0,
	var fieldOffset: Float = 0,
	var numberOfDataValues: Int = 0,
	var dataValues: List[TwoByteChunk] = null
)

case class GridAxisRecordRepresentation2(
	var sampleType: Int = 0,
	var dataRepresentation: Int = 0,
	var numberOfDataValues: Int = 0,
	var dataValues: List[FourByteChunk] = null
)

case class SixByteChunk(
	var otherParameters: List[Byte] = null
)

case class LinearSegmentParameter(
	var segmentNumber: Short = 0,
	var segmentAppearance: SixByteChunk = null,
	var location: Vector3Double = null,
	var orientation: Orientation = null,
	var segmentLength: Int = 0,
	var segmentWidth: Int = 0,
	var segmentHeight: Int = 0,
	var segmentDepth: Int = 0,
	var pad1: Long = 0
)

case class EightByteChunk(
	var otherParameters: List[Byte] = null
)

case class OneByteChunk(
	var otherParameters: Byte = 0
)

case class TwoByteChunk(
	var otherParameters: List[Byte] = null
)

case class FourByteChunk(
	var otherParameters: List[Byte] = null
)

case class Point(
	var x: Float = 0,
	var y: Float = 0
)

case class ModulationType(
	var spreadSpectrum: Int = 0,
	var major: Int = 0,
	var detail: Int = 0,
	var system: Int = 0
)

case class Relationship(
	var nature: Int = 0,
	var position: Int = 0
)

case class NamedLocation(
	var stationName: Int = 0,
	var stationNumber: Int = 0
)

case class DeadReckoningParameter(
	var deadReckoningAlgorithm: Short = 0,
	var otherParameters: List[Byte] = null,
	var entityLinearAcceleration: Vector3Float = null,
	var entityAngularVelocity: Vector3Float = null
)

case class RecordSet(
	var recordID: Long = 0,
	var recordSetSerialNumber: Long = 0,
	var recordLength: Int = 0,
	var recordCount: Int = 0,
	var recordValues: Int = 0,
	var pad4: Short = 0
)

case class PduStream(
	var description: List[Byte] = null,
	var name: List[Byte] = null,
	var startTime: Long = 0,
	var stopTime: Long = 0
)

case class Pdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class EntityInformationFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class EntityStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityID: EntityID = null,
	var forceId: Short = 0,
	var numberOfArticulationParameters: Byte = 0,
	var entityType: EntityType = null,
	var alternativeEntityType: EntityType = null,
	var entityLinearVelocity: Vector3Float = null,
	var entityLocation: Vector3Double = null,
	var entityOrientation: Orientation = null,
	var entityAppearance: Int = 0,
	var deadReckoningParameters: DeadReckoningParameter = null,
	var marking: Marking = null,
	var capabilities: Int = 0,
	var articulationParameters: List[ArticulationParameter] = null
)

case class CollisionPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var issuingEntityID: EntityID = null,
	var collidingEntityID: EntityID = null,
	var eventID: EventID = null,
	var collisionType: Short = 0,
	var pad: Byte = 0,
	var velocity: Vector3Float = null,
	var mass: Float = 0,
	var location: Vector3Float = null
)

case class CollisionElasticPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var issuingEntityID: EntityID = null,
	var collidingEntityID: EntityID = null,
	var collisionEventID: EventID = null,
	var pad: Short = 0,
	var contactVelocity: Vector3Float = null,
	var mass: Float = 0,
	var location: Vector3Float = null,
	var collisionResultXX: Float = 0,
	var collisionResultXY: Float = 0,
	var collisionResultXZ: Float = 0,
	var collisionResultYY: Float = 0,
	var collisionResultYZ: Float = 0,
	var collisionResultZZ: Float = 0,
	var unitSurfaceNormal: Vector3Float = null,
	var coefficientOfRestitution: Float = 0
)

case class EntityStateUpdatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityID: EntityID = null,
	var padding1: Byte = 0,
	var numberOfArticulationParameters: Short = 0,
	var entityLinearVelocity: Vector3Float = null,
	var entityLocation: Vector3Double = null,
	var entityOrientation: Orientation = null,
	var entityAppearance: Int = 0,
	var articulationParameters: List[ArticulationParameter] = null
)

case class WarfareFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var firingEntityID: EntityID = null,
	var targetEntityID: EntityID = null
)

case class FirePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var firingEntityID: EntityID = null,
	var targetEntityID: EntityID = null,
	var munitionID: EntityID = null,
	var eventID: EventID = null,
	var fireMissionIndex: Int = 0,
	var locationInWorldCoordinates: Vector3Double = null,
	var burstDescriptor: BurstDescriptor = null,
	var velocity: Vector3Float = null,
	var rangeToTarget: Float = 0
)

case class DetonationPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var firingEntityID: EntityID = null,
	var targetEntityID: EntityID = null,
	var munitionID: EntityID = null,
	var eventID: EventID = null,
	var velocity: Vector3Float = null,
	var locationInWorldCoordinates: Vector3Double = null,
	var burstDescriptor: BurstDescriptor = null,
	var locationInEntityCoordinates: Vector3Float = null,
	var detonationResult: Short = 0,
	var numberOfArticulationParameters: Short = 0,
	var pad: Short = 0,
	var articulationParameters: List[ArticulationParameter] = null
)

case class LogisticsFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class ServiceRequestPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var requestingEntityID: EntityID = null,
	var servicingEntityID: EntityID = null,
	var serviceTypeRequested: Short = 0,
	var numberOfSupplies: Short = 0,
	var serviceRequestPadding: Short = 0,
	var supplies: List[SupplyQuantity] = null
)

case class ResupplyOfferPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var receivingEntityID: EntityID = null,
	var supplyingEntityID: EntityID = null,
	var numberOfSupplies: Short = 0,
	var padding1: Short = 0,
	var padding2: Byte = 0,
	var supplies: List[SupplyQuantity] = null
)

case class ResupplyReceivedPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var receivingEntityID: EntityID = null,
	var supplyingEntityID: EntityID = null,
	var numberOfSupplies: Short = 0,
	var padding1: Short = 0,
	var padding2: Byte = 0,
	var supplies: List[SupplyQuantity] = null
)

case class ResupplyCancelPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var receivingEntityID: EntityID = null,
	var supplyingEntityID: EntityID = null
)

case class RepairCompletePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var receivingEntityID: EntityID = null,
	var repairingEntityID: EntityID = null,
	var repair: Int = 0,
	var padding2: Short = 0
)

case class RepairResponsePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var receivingEntityID: EntityID = null,
	var repairingEntityID: EntityID = null,
	var repairResult: Short = 0,
	var padding1: Short = 0,
	var padding2: Byte = 0
)

case class SimulationManagementFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null
)

case class CreateEntityPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0
)

case class RemoveEntityPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0
)

case class StartResumePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var realWorldTime: ClockTime = null,
	var simulationTime: ClockTime = null,
	var requestID: Long = 0
)

case class StopFreezePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var realWorldTime: ClockTime = null,
	var reason: Short = 0,
	var frozenBehavior: Short = 0,
	var padding1: Short = 0,
	var requestID: Long = 0
)

case class AcknowledgePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var acknowledgeFlag: Int = 0,
	var responseFlag: Int = 0,
	var requestID: Long = 0
)

case class ActionRequestPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var actionID: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class ActionResponsePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var requestStatus: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class DataQueryPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var timeInterval: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class SetDataPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var padding1: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class DataPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var padding1: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class EventReportPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var eventType: Long = 0,
	var padding1: Long = 0,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class CommentPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var numberOfFixedDatums: Long = 0,
	var numberOfVariableDatums: Long = 0,
	var fixedDatums: List[FixedDatum] = null,
	var variableDatums: List[VariableDatum] = null
)

case class DistributedEmissionsFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class ElectronicEmissionsPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var emittingEntityID: EntityID = null,
	var eventID: EventID = null,
	var stateUpdateIndicator: Short = 0,
	var numberOfSystems: Short = 0,
	var paddingForEmissionsPdu: Int = 0,
	var systems: List[ElectronicEmissionSystemData] = null
)

case class DesignatorPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var designatingEntityID: EntityID = null,
	var codeName: Int = 0,
	var designatedEntityID: EntityID = null,
	var designatorCode: Int = 0,
	var designatorPower: Float = 0,
	var designatorWavelength: Float = 0,
	var designatorSpotWrtDesignated: Vector3Float = null,
	var designatorSpotLocation: Vector3Double = null,
	var deadReckoningAlgorithm: Byte = 0,
	var padding1: Int = 0,
	var padding2: Byte = 0,
	var entityLinearAcceleration: Vector3Float = null
)

case class UaPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var emittingEntityID: EntityID = null,
	var eventID: EventID = null,
	var stateChangeIndicator: Byte = 0,
	var pad: Byte = 0,
	var passiveParameterIndex: Int = 0,
	var propulsionPlantConfiguration: Short = 0,
	var numberOfShaftRPMs: Short = 0,
	var numberOfApaData: Short = 0,
	var numberOfEmitterSystems: Short = 0,
	var shaftRPMs: List[ShaftRPMs] = null,
	var apaData: List[ApaData] = null,
	var emitterSystems: List[AcousticEmitterSystemData] = null
)

case class IffAtcNavAidsLayer1Pdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var emittingEntityId: EntityID = null,
	var eventID: EventID = null,
	var location: Vector3Float = null,
	var systemID: SystemID = null,
	var pad2: Int = 0,
	var fundamentalParameters: IffFundamentalData = null
)

case class IffAtcNavAidsLayer2Pdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var emittingEntityId: EntityID = null,
	var eventID: EventID = null,
	var location: Vector3Float = null,
	var systemID: SystemID = null,
	var pad2: Int = 0,
	var fundamentalParameters: IffFundamentalData = null,
	var layerHeader: LayerHeader = null,
	var beamData: BeamData = null,
	var secondaryOperationalData: BeamData = null,
	var fundamentalIffParameters: List[FundamentalParameterDataIff] = null
)

case class SeesPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var orginatingEntityID: EntityID = null,
	var infraredSignatureRepresentationIndex: Int = 0,
	var acousticSignatureRepresentationIndex: Int = 0,
	var radarCrossSectionSignatureRepresentationIndex: Int = 0,
	var numberOfPropulsionSystemData: Int = 0,
	var numberOfVectoringSystemData: Int = 0,
	var propulsionSystemData: List[PropulsionSystemData] = null,
	var vectoringSystemData: List[VectoringNozzleSystemData] = null
)

case class RadioCommunicationsFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0
)

case class IntercomSignalPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0,
	var entityID1: EntityID = null,
	var communicationsDeviceID: Int = 0,
	var encodingScheme: Int = 0,
	var tdlType: Int = 0,
	var sampleRate: Long = 0,
	var numberOfData: Int = 0,
	var samples: Int = 0,
	var data: List[OneByteChunk] = null
)

case class TransmitterPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0,
	var radioEntityType: RadioEntityType = null,
	var transmitState: Short = 0,
	var inputSource: Short = 0,
	var padding1: Int = 0,
	var antennaLocation: Vector3Double = null,
	var relativeAntennaLocation: Vector3Float = null,
	var antennaPatternType: Int = 0,
	var numberOfAntennaPatternList: Int = 0,
	var frequency: Long = 0,
	var transmitFrequencyBandwidth: Float = 0,
	var power: Float = 0,
	var modulationType: ModulationType = null,
	var cryptoSystem: Int = 0,
	var cryptoKeyId: Int = 0,
	var numberOfModulationParametersList: Short = 0,
	var padding2: Int = 0,
	var padding3: Short = 0,
	var modulationParametersList: List[Vector3Float] = null,
	var antennaPatternList: List[Vector3Float] = null
)

case class SignalPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0,
	var encodingScheme: Int = 0,
	var tdlType: Int = 0,
	var sampleRate: Long = 0,
	var numberOfData: Short = 0,
	var samples: Short = 0,
	var data: List[OneByteChunk] = null
)

case class ReceiverPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0,
	var receiverState: Int = 0,
	var padding1: Int = 0,
	var receivedPoser: Float = 0,
	var transmitterEntityId: EntityID = null,
	var transmitterRadioId: Int = 0
)

case class IntercomControlPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var entityId: EntityID = null,
	var radioId: Int = 0,
	var controlType: Short = 0,
	var communicationsChannelType: Short = 0,
	var sourceEntityID: EntityID = null,
	var sourceCommunicationsDeviceID: Short = 0,
	var sourceLineID: Short = 0,
	var transmitPriority: Short = 0,
	var transmitLineState: Short = 0,
	var command: Short = 0,
	var masterEntityID: EntityID = null,
	var masterCommunicationsDeviceID: Int = 0,
	var numberOfIntercomParameters: Long = 0,
	var intercomParameters: List[IntercomCommunicationsParameters] = null
)

case class EntityManagementFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class AggregateStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var aggregateID: EntityID = null,
	var forceID: Short = 0,
	var aggregateState: Short = 0,
	var aggregateType: EntityType = null,
	var formation: Long = 0,
	var aggregateMarking: AggregateMarking = null,
	var dimensions: Vector3Float = null,
	var orientation: Orientation = null,
	var centerOfMass: Vector3Double = null,
	var velocity: Vector3Float = null,
	var numberOfAggregateIDList: Int = 0,
	var numberOfEntityIDList: Int = 0,
	var numberOfSilentAggregateSystemList: Int = 0,
	var numberOfSilentEntitySystemList: Int = 0,
	var aggregateIDList: List[AggregateID] = null,
	var entityIDList: List[EntityID] = null,
	var pad2: Short = 0,
	var silentAggregateSystemList: List[EntityType] = null,
	var silentEntitySystemList: List[EntityType] = null,
	var numberOfVariableDatumList: Long = 0,
	var variableDatumList: List[VariableDatum] = null
)

case class IsGroupOfPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var groupEntityID: EntityID = null,
	var groupedEntityCategory: Short = 0,
	var numberOfGroupedEntityDescriptions: Short = 0,
	var pad2: Long = 0,
	var latitude: Double = 0,
	var longitude: Double = 0,
	var groupedEntityDescriptions: List[VariableDatum] = null
)

case class TransferControlRequestPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var orginatingEntityID: EntityID = null,
	var recevingEntityID: EntityID = null,
	var requestID: Long = 0,
	var requiredReliabilityService: Short = 0,
	var tranferType: Short = 0,
	var transferEntityID: EntityID = null,
	var numberOfRecordSets: Short = 0,
	var recordSets: List[RecordSet] = null
)

case class IsPartOfPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var orginatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var relationship: Relationship = null,
	var partLocation: Vector3Float = null,
	var namedLocationID: NamedLocation = null,
	var partEntityType: EntityType = null
)

case class MinefieldFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class MinefieldStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var minefieldID: EntityID = null,
	var minefieldSequence: Int = 0,
	var forceID: Short = 0,
	var numberOfPerimeterPoints: Short = 0,
	var minefieldType: EntityType = null,
	var numberOfMineType: Int = 0,
	var minefieldLocation: Vector3Double = null,
	var minefieldOrientation: Orientation = null,
	var appearance: Int = 0,
	var protocolMode: Int = 0,
	var perimeterPoints: List[Point] = null,
	var mineType: List[EntityType] = null
)

case class MinefieldQueryPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var minefieldID: EntityID = null,
	var requestingEntityID: EntityID = null,
	var requestID: Short = 0,
	var numberOfRequestedPerimeterPoints: Short = 0,
	var pad2: Short = 0,
	var numberOfSensorTypes: Short = 0,
	var dataFilter: Long = 0,
	var requestedMineType: EntityType = null,
	var requestedPerimeterPoints: List[Point] = null,
	var sensorTypes: List[TwoByteChunk] = null
)

case class MinefieldDataPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var minefieldID: EntityID = null,
	var requestingEntityID: EntityID = null,
	var minefieldSequenceNumbeer: Int = 0,
	var requestID: Short = 0,
	var pduSequenceNumber: Short = 0,
	var numberOfPdus: Short = 0,
	var numberOfMineLocation: Short = 0,
	var numberOfSensorTypes: Short = 0,
	var pad2: Short = 0,
	var dataFilter: Long = 0,
	var mineType: EntityType = null,
	var sensorTypes: List[TwoByteChunk] = null,
	var pad3: Short = 0,
	var mineLocation: List[Vector3Float] = null
)

case class MinefieldResponseNackPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var minefieldID: EntityID = null,
	var requestingEntityID: EntityID = null,
	var requestID: Short = 0,
	var numberOfMissingPduSequenceNumbers: Short = 0,
	var missingPduSequenceNumbers: List[EightByteChunk] = null
)

case class SyntheticEnvironmentFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0
)

case class EnvironmentalProcessPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var environementalProcessID: EntityID = null,
	var environmentType: EntityType = null,
	var modelType: Short = 0,
	var environmentStatus: Short = 0,
	var numberOfEnvironmentRecords: Short = 0,
	var sequenceNumber: Int = 0,
	var environmentRecords: List[Environment] = null
)

case class GriddedDataPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var environmentalSimulationApplicationID: EntityID = null,
	var fieldNumber: Int = 0,
	var pduNumber: Int = 0,
	var pduTotal: Int = 0,
	var coordinateSystem: Int = 0,
	var numberOfGridDataList: Short = 0,
	var constantGrid: Short = 0,
	var environmentType: EntityType = null,
	var orientation: Orientation = null,
	var sampleTime: Long = 0,
	var totalValues: Long = 0,
	var vectorDimension: Short = 0,
	var padding1: Int = 0,
	var padding2: Short = 0,
	var gridDataList: List[GridAxis] = null
)

case class PointObjectStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var objectID: EntityID = null,
	var referencedObjectID: EntityID = null,
	var updateNumber: Int = 0,
	var forceID: Short = 0,
	var modifications: Short = 0,
	var objectType: ObjectType = null,
	var objectLocation: Vector3Double = null,
	var objectOrientation: Orientation = null,
	var objectAppearance: Double = 0,
	var requesterID: SimulationAddress = null,
	var receivingID: SimulationAddress = null,
	var pad2: Long = 0
)

case class LinearObjectStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var objectID: EntityID = null,
	var referencedObjectID: EntityID = null,
	var updateNumber: Int = 0,
	var forceID: Short = 0,
	var numberOfLinearSegmentParameters: Short = 0,
	var requesterID: SimulationAddress = null,
	var receivingID: SimulationAddress = null,
	var objectType: ObjectType = null,
	var linearSegmentParameters: List[LinearSegmentParameter] = null
)

case class ArealObjectStatePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var objectID: EntityID = null,
	var referencedObjectID: EntityID = null,
	var updateNumber: Int = 0,
	var forceID: Short = 0,
	var modifications: Short = 0,
	var objectType: EntityType = null,
	var objectAppearance: SixByteChunk = null,
	var numberOfObjectLocation: Int = 0,
	var requesterID: SimulationAddress = null,
	var receivingID: SimulationAddress = null,
	var objectLocation: List[Vector3Double] = null
)

case class SimulationManagementWithReliabilityFamilyPdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null
)

case class CreateEntityReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0
)

case class RemoveEntityReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0
)

case class StartResumeReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var realWorldTime: ClockTime = null,
	var simulationTime: ClockTime = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0
)

case class StopFreezeReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var realWorldTime: ClockTime = null,
	var reason: Short = 0,
	var frozenBehavior: Short = 0,
	var requiredReliablityService: Short = 0,
	var pad1: Short = 0,
	var requestID: Long = 0
)

case class AcknowledgeReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var acknowledgeFlag: Int = 0,
	var responseFlag: Int = 0,
	var requestID: Long = 0
)

case class ActionRequestReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0,
	var actionID: Long = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class ActionResponseReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var responseStatus: Long = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class DataQueryReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0,
	var timeInterval: Long = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class SetDataReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var requestID: Long = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class DataReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class EventReportReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var eventType: Int = 0,
	var pad1: Long = 0,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class CommentReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var numberOfFixedDatumRecords: Long = 0,
	var numberOfVariableDatumRecords: Long = 0,
	var fixedDatumRecords: List[FixedDatum] = null,
	var variableDatumRecords: List[VariableDatum] = null
)

case class RecordQueryReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var eventType: Int = 0,
	var time: Long = 0,
	var numberOfRecordIDs: Long = 0,
	var recordIDs: List[FourByteChunk] = null
)

case class SetRecordReliablePdu(
	var protocolVersion: Short = 0,
	var exerciseID: Short = 0,
	var pduType: Short = 0,
	var protocolFamily: Short = 0,
	var timestamp: Long = 0,
	var pduLength: Int = 0,
	var padding: Short = 0,
	var originatingEntityID: EntityID = null,
	var receivingEntityID: EntityID = null,
	var requestID: Long = 0,
	var requiredReliabilityService: Short = 0,
	var pad1: Int = 0,
	var pad2: Short = 0,
	var numberOfRecordSets: Long = 0,
	var recordSets: List[RecordSet] = null
)

case class PduContainer(
	var numberOfPdus: Int = 0,
	var pdus: List[Pdu] = null
)

