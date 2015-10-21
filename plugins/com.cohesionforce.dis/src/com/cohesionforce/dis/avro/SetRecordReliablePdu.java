/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SetRecordReliablePdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SetRecordReliablePdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"originatingEntityID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"receivingEntityID\",\"type\":[\"null\",\"EntityID\"]},{\"name\":\"requestID\",\"type\":\"long\"},{\"name\":\"requiredReliabilityService\",\"type\":\"int\"},{\"name\":\"pad1\",\"type\":\"int\"},{\"name\":\"pad2\",\"type\":\"int\"},{\"name\":\"numberOfRecordSets\",\"type\":\"long\"},{\"name\":\"recordSets\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RecordSet\",\"fields\":[{\"name\":\"recordID\",\"type\":\"long\"},{\"name\":\"recordSetSerialNumber\",\"type\":\"long\"},{\"name\":\"recordLength\",\"type\":\"int\"},{\"name\":\"recordCount\",\"type\":\"int\"},{\"name\":\"recordValues\",\"type\":\"int\"},{\"name\":\"pad4\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.cohesionforce.dis.avro.Time_t reception_timestamp;
  @Deprecated public com.cohesionforce.dis.avro.Time_t source_timestamp;
  @Deprecated public int protocolVersion;
  @Deprecated public int exerciseID;
  @Deprecated public int pduType;
  @Deprecated public int protocolFamily;
  @Deprecated public long timestamp;
  @Deprecated public int pduLength;
  @Deprecated public int padding;
  @Deprecated public com.cohesionforce.dis.avro.EntityID originatingEntityID;
  @Deprecated public com.cohesionforce.dis.avro.EntityID receivingEntityID;
  @Deprecated public long requestID;
  @Deprecated public int requiredReliabilityService;
  @Deprecated public int pad1;
  @Deprecated public int pad2;
  @Deprecated public long numberOfRecordSets;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.RecordSet> recordSets;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public SetRecordReliablePdu() {}

  /**
   * All-args constructor.
   */
  public SetRecordReliablePdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID originatingEntityID, com.cohesionforce.dis.avro.EntityID receivingEntityID, java.lang.Long requestID, java.lang.Integer requiredReliabilityService, java.lang.Integer pad1, java.lang.Integer pad2, java.lang.Long numberOfRecordSets, java.util.List<com.cohesionforce.dis.avro.RecordSet> recordSets) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.originatingEntityID = originatingEntityID;
    this.receivingEntityID = receivingEntityID;
    this.requestID = requestID;
    this.requiredReliabilityService = requiredReliabilityService;
    this.pad1 = pad1;
    this.pad2 = pad2;
    this.numberOfRecordSets = numberOfRecordSets;
    this.recordSets = recordSets;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return reception_timestamp;
    case 1: return source_timestamp;
    case 2: return protocolVersion;
    case 3: return exerciseID;
    case 4: return pduType;
    case 5: return protocolFamily;
    case 6: return timestamp;
    case 7: return pduLength;
    case 8: return padding;
    case 9: return originatingEntityID;
    case 10: return receivingEntityID;
    case 11: return requestID;
    case 12: return requiredReliabilityService;
    case 13: return pad1;
    case 14: return pad2;
    case 15: return numberOfRecordSets;
    case 16: return recordSets;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: reception_timestamp = (com.cohesionforce.dis.avro.Time_t)value$; break;
    case 1: source_timestamp = (com.cohesionforce.dis.avro.Time_t)value$; break;
    case 2: protocolVersion = (java.lang.Integer)value$; break;
    case 3: exerciseID = (java.lang.Integer)value$; break;
    case 4: pduType = (java.lang.Integer)value$; break;
    case 5: protocolFamily = (java.lang.Integer)value$; break;
    case 6: timestamp = (java.lang.Long)value$; break;
    case 7: pduLength = (java.lang.Integer)value$; break;
    case 8: padding = (java.lang.Integer)value$; break;
    case 9: originatingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: receivingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 11: requestID = (java.lang.Long)value$; break;
    case 12: requiredReliabilityService = (java.lang.Integer)value$; break;
    case 13: pad1 = (java.lang.Integer)value$; break;
    case 14: pad2 = (java.lang.Integer)value$; break;
    case 15: numberOfRecordSets = (java.lang.Long)value$; break;
    case 16: recordSets = (java.util.List<com.cohesionforce.dis.avro.RecordSet>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'reception_timestamp' field.
   */
  public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
    return reception_timestamp;
  }

  /**
   * Sets the value of the 'reception_timestamp' field.
   * @param value the value to set.
   */
  public void setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
    this.reception_timestamp = value;
  }

  /**
   * Gets the value of the 'source_timestamp' field.
   */
  public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
    return source_timestamp;
  }

  /**
   * Sets the value of the 'source_timestamp' field.
   * @param value the value to set.
   */
  public void setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
    this.source_timestamp = value;
  }

  /**
   * Gets the value of the 'protocolVersion' field.
   */
  public java.lang.Integer getProtocolVersion() {
    return protocolVersion;
  }

  /**
   * Sets the value of the 'protocolVersion' field.
   * @param value the value to set.
   */
  public void setProtocolVersion(java.lang.Integer value) {
    this.protocolVersion = value;
  }

  /**
   * Gets the value of the 'exerciseID' field.
   */
  public java.lang.Integer getExerciseID() {
    return exerciseID;
  }

  /**
   * Sets the value of the 'exerciseID' field.
   * @param value the value to set.
   */
  public void setExerciseID(java.lang.Integer value) {
    this.exerciseID = value;
  }

  /**
   * Gets the value of the 'pduType' field.
   */
  public java.lang.Integer getPduType() {
    return pduType;
  }

  /**
   * Sets the value of the 'pduType' field.
   * @param value the value to set.
   */
  public void setPduType(java.lang.Integer value) {
    this.pduType = value;
  }

  /**
   * Gets the value of the 'protocolFamily' field.
   */
  public java.lang.Integer getProtocolFamily() {
    return protocolFamily;
  }

  /**
   * Sets the value of the 'protocolFamily' field.
   * @param value the value to set.
   */
  public void setProtocolFamily(java.lang.Integer value) {
    this.protocolFamily = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'pduLength' field.
   */
  public java.lang.Integer getPduLength() {
    return pduLength;
  }

  /**
   * Sets the value of the 'pduLength' field.
   * @param value the value to set.
   */
  public void setPduLength(java.lang.Integer value) {
    this.pduLength = value;
  }

  /**
   * Gets the value of the 'padding' field.
   */
  public java.lang.Integer getPadding() {
    return padding;
  }

  /**
   * Sets the value of the 'padding' field.
   * @param value the value to set.
   */
  public void setPadding(java.lang.Integer value) {
    this.padding = value;
  }

  /**
   * Gets the value of the 'originatingEntityID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getOriginatingEntityID() {
    return originatingEntityID;
  }

  /**
   * Sets the value of the 'originatingEntityID' field.
   * @param value the value to set.
   */
  public void setOriginatingEntityID(com.cohesionforce.dis.avro.EntityID value) {
    this.originatingEntityID = value;
  }

  /**
   * Gets the value of the 'receivingEntityID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getReceivingEntityID() {
    return receivingEntityID;
  }

  /**
   * Sets the value of the 'receivingEntityID' field.
   * @param value the value to set.
   */
  public void setReceivingEntityID(com.cohesionforce.dis.avro.EntityID value) {
    this.receivingEntityID = value;
  }

  /**
   * Gets the value of the 'requestID' field.
   */
  public java.lang.Long getRequestID() {
    return requestID;
  }

  /**
   * Sets the value of the 'requestID' field.
   * @param value the value to set.
   */
  public void setRequestID(java.lang.Long value) {
    this.requestID = value;
  }

  /**
   * Gets the value of the 'requiredReliabilityService' field.
   */
  public java.lang.Integer getRequiredReliabilityService() {
    return requiredReliabilityService;
  }

  /**
   * Sets the value of the 'requiredReliabilityService' field.
   * @param value the value to set.
   */
  public void setRequiredReliabilityService(java.lang.Integer value) {
    this.requiredReliabilityService = value;
  }

  /**
   * Gets the value of the 'pad1' field.
   */
  public java.lang.Integer getPad1() {
    return pad1;
  }

  /**
   * Sets the value of the 'pad1' field.
   * @param value the value to set.
   */
  public void setPad1(java.lang.Integer value) {
    this.pad1 = value;
  }

  /**
   * Gets the value of the 'pad2' field.
   */
  public java.lang.Integer getPad2() {
    return pad2;
  }

  /**
   * Sets the value of the 'pad2' field.
   * @param value the value to set.
   */
  public void setPad2(java.lang.Integer value) {
    this.pad2 = value;
  }

  /**
   * Gets the value of the 'numberOfRecordSets' field.
   */
  public java.lang.Long getNumberOfRecordSets() {
    return numberOfRecordSets;
  }

  /**
   * Sets the value of the 'numberOfRecordSets' field.
   * @param value the value to set.
   */
  public void setNumberOfRecordSets(java.lang.Long value) {
    this.numberOfRecordSets = value;
  }

  /**
   * Gets the value of the 'recordSets' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.RecordSet> getRecordSets() {
    return recordSets;
  }

  /**
   * Sets the value of the 'recordSets' field.
   * @param value the value to set.
   */
  public void setRecordSets(java.util.List<com.cohesionforce.dis.avro.RecordSet> value) {
    this.recordSets = value;
  }

  /** Creates a new SetRecordReliablePdu RecordBuilder */
  public static com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder();
  }
  
  /** Creates a new SetRecordReliablePdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder newBuilder(com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder other) {
    return new com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder(other);
  }
  
  /** Creates a new SetRecordReliablePdu RecordBuilder by copying an existing SetRecordReliablePdu instance */
  public static com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder newBuilder(com.cohesionforce.dis.avro.SetRecordReliablePdu other) {
    return new com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder(other);
  }
  
  /**
   * RecordBuilder for SetRecordReliablePdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SetRecordReliablePdu>
    implements org.apache.avro.data.RecordBuilder<SetRecordReliablePdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID originatingEntityID;
    private com.cohesionforce.dis.avro.EntityID receivingEntityID;
    private long requestID;
    private int requiredReliabilityService;
    private int pad1;
    private int pad2;
    private long numberOfRecordSets;
    private java.util.List<com.cohesionforce.dis.avro.RecordSet> recordSets;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.SetRecordReliablePdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.reception_timestamp)) {
        this.reception_timestamp = data().deepCopy(fields()[0].schema(), other.reception_timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source_timestamp)) {
        this.source_timestamp = data().deepCopy(fields()[1].schema(), other.source_timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.protocolVersion)) {
        this.protocolVersion = data().deepCopy(fields()[2].schema(), other.protocolVersion);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.exerciseID)) {
        this.exerciseID = data().deepCopy(fields()[3].schema(), other.exerciseID);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.pduType)) {
        this.pduType = data().deepCopy(fields()[4].schema(), other.pduType);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.protocolFamily)) {
        this.protocolFamily = data().deepCopy(fields()[5].schema(), other.protocolFamily);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[6].schema(), other.timestamp);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.pduLength)) {
        this.pduLength = data().deepCopy(fields()[7].schema(), other.pduLength);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.padding)) {
        this.padding = data().deepCopy(fields()[8].schema(), other.padding);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.originatingEntityID)) {
        this.originatingEntityID = data().deepCopy(fields()[9].schema(), other.originatingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.receivingEntityID)) {
        this.receivingEntityID = data().deepCopy(fields()[10].schema(), other.receivingEntityID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.requestID)) {
        this.requestID = data().deepCopy(fields()[11].schema(), other.requestID);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.requiredReliabilityService)) {
        this.requiredReliabilityService = data().deepCopy(fields()[12].schema(), other.requiredReliabilityService);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.pad1)) {
        this.pad1 = data().deepCopy(fields()[13].schema(), other.pad1);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[14].schema(), other.pad2);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.numberOfRecordSets)) {
        this.numberOfRecordSets = data().deepCopy(fields()[15].schema(), other.numberOfRecordSets);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.recordSets)) {
        this.recordSets = data().deepCopy(fields()[16].schema(), other.recordSets);
        fieldSetFlags()[16] = true;
      }
    }
    
    /** Creates a Builder by copying an existing SetRecordReliablePdu instance */
    private Builder(com.cohesionforce.dis.avro.SetRecordReliablePdu other) {
            super(com.cohesionforce.dis.avro.SetRecordReliablePdu.SCHEMA$);
      if (isValidValue(fields()[0], other.reception_timestamp)) {
        this.reception_timestamp = data().deepCopy(fields()[0].schema(), other.reception_timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source_timestamp)) {
        this.source_timestamp = data().deepCopy(fields()[1].schema(), other.source_timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.protocolVersion)) {
        this.protocolVersion = data().deepCopy(fields()[2].schema(), other.protocolVersion);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.exerciseID)) {
        this.exerciseID = data().deepCopy(fields()[3].schema(), other.exerciseID);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.pduType)) {
        this.pduType = data().deepCopy(fields()[4].schema(), other.pduType);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.protocolFamily)) {
        this.protocolFamily = data().deepCopy(fields()[5].schema(), other.protocolFamily);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[6].schema(), other.timestamp);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.pduLength)) {
        this.pduLength = data().deepCopy(fields()[7].schema(), other.pduLength);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.padding)) {
        this.padding = data().deepCopy(fields()[8].schema(), other.padding);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.originatingEntityID)) {
        this.originatingEntityID = data().deepCopy(fields()[9].schema(), other.originatingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.receivingEntityID)) {
        this.receivingEntityID = data().deepCopy(fields()[10].schema(), other.receivingEntityID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.requestID)) {
        this.requestID = data().deepCopy(fields()[11].schema(), other.requestID);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.requiredReliabilityService)) {
        this.requiredReliabilityService = data().deepCopy(fields()[12].schema(), other.requiredReliabilityService);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.pad1)) {
        this.pad1 = data().deepCopy(fields()[13].schema(), other.pad1);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[14].schema(), other.pad2);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.numberOfRecordSets)) {
        this.numberOfRecordSets = data().deepCopy(fields()[15].schema(), other.numberOfRecordSets);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.recordSets)) {
        this.recordSets = data().deepCopy(fields()[16].schema(), other.recordSets);
        fieldSetFlags()[16] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
      validate(fields()[0], value);
      this.reception_timestamp = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'reception_timestamp' field has been set */
    public boolean hasReceptionTimestamp() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
      validate(fields()[1], value);
      this.source_timestamp = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'source_timestamp' field has been set */
    public boolean hasSourceTimestamp() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setProtocolVersion(int value) {
      validate(fields()[2], value);
      this.protocolVersion = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'protocolVersion' field has been set */
    public boolean hasProtocolVersion() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setExerciseID(int value) {
      validate(fields()[3], value);
      this.exerciseID = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'exerciseID' field has been set */
    public boolean hasExerciseID() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setPduType(int value) {
      validate(fields()[4], value);
      this.pduType = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'pduType' field has been set */
    public boolean hasPduType() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setProtocolFamily(int value) {
      validate(fields()[5], value);
      this.protocolFamily = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'protocolFamily' field has been set */
    public boolean hasProtocolFamily() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setTimestamp(long value) {
      validate(fields()[6], value);
      this.timestamp = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setPduLength(int value) {
      validate(fields()[7], value);
      this.pduLength = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'pduLength' field has been set */
    public boolean hasPduLength() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setPadding(int value) {
      validate(fields()[8], value);
      this.padding = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'padding' field has been set */
    public boolean hasPadding() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'padding' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'originatingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getOriginatingEntityID() {
      return originatingEntityID;
    }
    
    /** Sets the value of the 'originatingEntityID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setOriginatingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.originatingEntityID = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'originatingEntityID' field has been set */
    public boolean hasOriginatingEntityID() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'originatingEntityID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearOriginatingEntityID() {
      originatingEntityID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getReceivingEntityID() {
      return receivingEntityID;
    }
    
    /** Sets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setReceivingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[10], value);
      this.receivingEntityID = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'receivingEntityID' field has been set */
    public boolean hasReceivingEntityID() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearReceivingEntityID() {
      receivingEntityID = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'requestID' field */
    public java.lang.Long getRequestID() {
      return requestID;
    }
    
    /** Sets the value of the 'requestID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setRequestID(long value) {
      validate(fields()[11], value);
      this.requestID = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'requestID' field has been set */
    public boolean hasRequestID() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'requestID' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearRequestID() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'requiredReliabilityService' field */
    public java.lang.Integer getRequiredReliabilityService() {
      return requiredReliabilityService;
    }
    
    /** Sets the value of the 'requiredReliabilityService' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setRequiredReliabilityService(int value) {
      validate(fields()[12], value);
      this.requiredReliabilityService = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'requiredReliabilityService' field has been set */
    public boolean hasRequiredReliabilityService() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'requiredReliabilityService' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearRequiredReliabilityService() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'pad1' field */
    public java.lang.Integer getPad1() {
      return pad1;
    }
    
    /** Sets the value of the 'pad1' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setPad1(int value) {
      validate(fields()[13], value);
      this.pad1 = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'pad1' field has been set */
    public boolean hasPad1() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'pad1' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearPad1() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'pad2' field */
    public java.lang.Integer getPad2() {
      return pad2;
    }
    
    /** Sets the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setPad2(int value) {
      validate(fields()[14], value);
      this.pad2 = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'pad2' field has been set */
    public boolean hasPad2() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearPad2() {
      fieldSetFlags()[14] = false;
      return this;
    }

    /** Gets the value of the 'numberOfRecordSets' field */
    public java.lang.Long getNumberOfRecordSets() {
      return numberOfRecordSets;
    }
    
    /** Sets the value of the 'numberOfRecordSets' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setNumberOfRecordSets(long value) {
      validate(fields()[15], value);
      this.numberOfRecordSets = value;
      fieldSetFlags()[15] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfRecordSets' field has been set */
    public boolean hasNumberOfRecordSets() {
      return fieldSetFlags()[15];
    }
    
    /** Clears the value of the 'numberOfRecordSets' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearNumberOfRecordSets() {
      fieldSetFlags()[15] = false;
      return this;
    }

    /** Gets the value of the 'recordSets' field */
    public java.util.List<com.cohesionforce.dis.avro.RecordSet> getRecordSets() {
      return recordSets;
    }
    
    /** Sets the value of the 'recordSets' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder setRecordSets(java.util.List<com.cohesionforce.dis.avro.RecordSet> value) {
      validate(fields()[16], value);
      this.recordSets = value;
      fieldSetFlags()[16] = true;
      return this; 
    }
    
    /** Checks whether the 'recordSets' field has been set */
    public boolean hasRecordSets() {
      return fieldSetFlags()[16];
    }
    
    /** Clears the value of the 'recordSets' field */
    public com.cohesionforce.dis.avro.SetRecordReliablePdu.Builder clearRecordSets() {
      recordSets = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    @Override
    public SetRecordReliablePdu build() {
      try {
        SetRecordReliablePdu record = new SetRecordReliablePdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.originatingEntityID = fieldSetFlags()[9] ? this.originatingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.receivingEntityID = fieldSetFlags()[10] ? this.receivingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[10]);
        record.requestID = fieldSetFlags()[11] ? this.requestID : (java.lang.Long) defaultValue(fields()[11]);
        record.requiredReliabilityService = fieldSetFlags()[12] ? this.requiredReliabilityService : (java.lang.Integer) defaultValue(fields()[12]);
        record.pad1 = fieldSetFlags()[13] ? this.pad1 : (java.lang.Integer) defaultValue(fields()[13]);
        record.pad2 = fieldSetFlags()[14] ? this.pad2 : (java.lang.Integer) defaultValue(fields()[14]);
        record.numberOfRecordSets = fieldSetFlags()[15] ? this.numberOfRecordSets : (java.lang.Long) defaultValue(fields()[15]);
        record.recordSets = fieldSetFlags()[16] ? this.recordSets : (java.util.List<com.cohesionforce.dis.avro.RecordSet>) defaultValue(fields()[16]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}