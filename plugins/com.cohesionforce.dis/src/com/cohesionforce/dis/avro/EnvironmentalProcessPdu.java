/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EnvironmentalProcessPdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EnvironmentalProcessPdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"environementalProcessID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"environmentType\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityType\",\"fields\":[{\"name\":\"entityKind\",\"type\":\"int\"},{\"name\":\"domain\",\"type\":\"int\"},{\"name\":\"country\",\"type\":\"int\"},{\"name\":\"category\",\"type\":\"int\"},{\"name\":\"subcategory\",\"type\":\"int\"},{\"name\":\"spec\",\"type\":\"int\"},{\"name\":\"extra\",\"type\":\"int\"}]}]},{\"name\":\"modelType\",\"type\":\"int\"},{\"name\":\"environmentStatus\",\"type\":\"int\"},{\"name\":\"numberOfEnvironmentRecords\",\"type\":\"int\"},{\"name\":\"sequenceNumber\",\"type\":\"int\"},{\"name\":\"environmentRecords\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Environment\",\"fields\":[{\"name\":\"environmentType\",\"type\":\"long\"},{\"name\":\"length\",\"type\":\"int\"},{\"name\":\"recordIndex\",\"type\":\"int\"},{\"name\":\"padding1\",\"type\":\"int\"},{\"name\":\"geometry\",\"type\":\"int\"},{\"name\":\"padding2\",\"type\":\"int\"}]}}]}]}");
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
  @Deprecated public com.cohesionforce.dis.avro.EntityID environementalProcessID;
  @Deprecated public com.cohesionforce.dis.avro.EntityType environmentType;
  @Deprecated public int modelType;
  @Deprecated public int environmentStatus;
  @Deprecated public int numberOfEnvironmentRecords;
  @Deprecated public int sequenceNumber;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.Environment> environmentRecords;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EnvironmentalProcessPdu() {}

  /**
   * All-args constructor.
   */
  public EnvironmentalProcessPdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID environementalProcessID, com.cohesionforce.dis.avro.EntityType environmentType, java.lang.Integer modelType, java.lang.Integer environmentStatus, java.lang.Integer numberOfEnvironmentRecords, java.lang.Integer sequenceNumber, java.util.List<com.cohesionforce.dis.avro.Environment> environmentRecords) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.environementalProcessID = environementalProcessID;
    this.environmentType = environmentType;
    this.modelType = modelType;
    this.environmentStatus = environmentStatus;
    this.numberOfEnvironmentRecords = numberOfEnvironmentRecords;
    this.sequenceNumber = sequenceNumber;
    this.environmentRecords = environmentRecords;
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
    case 9: return environementalProcessID;
    case 10: return environmentType;
    case 11: return modelType;
    case 12: return environmentStatus;
    case 13: return numberOfEnvironmentRecords;
    case 14: return sequenceNumber;
    case 15: return environmentRecords;
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
    case 9: environementalProcessID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: environmentType = (com.cohesionforce.dis.avro.EntityType)value$; break;
    case 11: modelType = (java.lang.Integer)value$; break;
    case 12: environmentStatus = (java.lang.Integer)value$; break;
    case 13: numberOfEnvironmentRecords = (java.lang.Integer)value$; break;
    case 14: sequenceNumber = (java.lang.Integer)value$; break;
    case 15: environmentRecords = (java.util.List<com.cohesionforce.dis.avro.Environment>)value$; break;
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
   * Gets the value of the 'environementalProcessID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getEnvironementalProcessID() {
    return environementalProcessID;
  }

  /**
   * Sets the value of the 'environementalProcessID' field.
   * @param value the value to set.
   */
  public void setEnvironementalProcessID(com.cohesionforce.dis.avro.EntityID value) {
    this.environementalProcessID = value;
  }

  /**
   * Gets the value of the 'environmentType' field.
   */
  public com.cohesionforce.dis.avro.EntityType getEnvironmentType() {
    return environmentType;
  }

  /**
   * Sets the value of the 'environmentType' field.
   * @param value the value to set.
   */
  public void setEnvironmentType(com.cohesionforce.dis.avro.EntityType value) {
    this.environmentType = value;
  }

  /**
   * Gets the value of the 'modelType' field.
   */
  public java.lang.Integer getModelType() {
    return modelType;
  }

  /**
   * Sets the value of the 'modelType' field.
   * @param value the value to set.
   */
  public void setModelType(java.lang.Integer value) {
    this.modelType = value;
  }

  /**
   * Gets the value of the 'environmentStatus' field.
   */
  public java.lang.Integer getEnvironmentStatus() {
    return environmentStatus;
  }

  /**
   * Sets the value of the 'environmentStatus' field.
   * @param value the value to set.
   */
  public void setEnvironmentStatus(java.lang.Integer value) {
    this.environmentStatus = value;
  }

  /**
   * Gets the value of the 'numberOfEnvironmentRecords' field.
   */
  public java.lang.Integer getNumberOfEnvironmentRecords() {
    return numberOfEnvironmentRecords;
  }

  /**
   * Sets the value of the 'numberOfEnvironmentRecords' field.
   * @param value the value to set.
   */
  public void setNumberOfEnvironmentRecords(java.lang.Integer value) {
    this.numberOfEnvironmentRecords = value;
  }

  /**
   * Gets the value of the 'sequenceNumber' field.
   */
  public java.lang.Integer getSequenceNumber() {
    return sequenceNumber;
  }

  /**
   * Sets the value of the 'sequenceNumber' field.
   * @param value the value to set.
   */
  public void setSequenceNumber(java.lang.Integer value) {
    this.sequenceNumber = value;
  }

  /**
   * Gets the value of the 'environmentRecords' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.Environment> getEnvironmentRecords() {
    return environmentRecords;
  }

  /**
   * Sets the value of the 'environmentRecords' field.
   * @param value the value to set.
   */
  public void setEnvironmentRecords(java.util.List<com.cohesionforce.dis.avro.Environment> value) {
    this.environmentRecords = value;
  }

  /** Creates a new EnvironmentalProcessPdu RecordBuilder */
  public static com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder();
  }
  
  /** Creates a new EnvironmentalProcessPdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder newBuilder(com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder other) {
    return new com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder(other);
  }
  
  /** Creates a new EnvironmentalProcessPdu RecordBuilder by copying an existing EnvironmentalProcessPdu instance */
  public static com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder newBuilder(com.cohesionforce.dis.avro.EnvironmentalProcessPdu other) {
    return new com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder(other);
  }
  
  /**
   * RecordBuilder for EnvironmentalProcessPdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EnvironmentalProcessPdu>
    implements org.apache.avro.data.RecordBuilder<EnvironmentalProcessPdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID environementalProcessID;
    private com.cohesionforce.dis.avro.EntityType environmentType;
    private int modelType;
    private int environmentStatus;
    private int numberOfEnvironmentRecords;
    private int sequenceNumber;
    private java.util.List<com.cohesionforce.dis.avro.Environment> environmentRecords;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.EnvironmentalProcessPdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder other) {
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
      if (isValidValue(fields()[9], other.environementalProcessID)) {
        this.environementalProcessID = data().deepCopy(fields()[9].schema(), other.environementalProcessID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.environmentType)) {
        this.environmentType = data().deepCopy(fields()[10].schema(), other.environmentType);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.modelType)) {
        this.modelType = data().deepCopy(fields()[11].schema(), other.modelType);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.environmentStatus)) {
        this.environmentStatus = data().deepCopy(fields()[12].schema(), other.environmentStatus);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.numberOfEnvironmentRecords)) {
        this.numberOfEnvironmentRecords = data().deepCopy(fields()[13].schema(), other.numberOfEnvironmentRecords);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.sequenceNumber)) {
        this.sequenceNumber = data().deepCopy(fields()[14].schema(), other.sequenceNumber);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.environmentRecords)) {
        this.environmentRecords = data().deepCopy(fields()[15].schema(), other.environmentRecords);
        fieldSetFlags()[15] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EnvironmentalProcessPdu instance */
    private Builder(com.cohesionforce.dis.avro.EnvironmentalProcessPdu other) {
            super(com.cohesionforce.dis.avro.EnvironmentalProcessPdu.SCHEMA$);
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
      if (isValidValue(fields()[9], other.environementalProcessID)) {
        this.environementalProcessID = data().deepCopy(fields()[9].schema(), other.environementalProcessID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.environmentType)) {
        this.environmentType = data().deepCopy(fields()[10].schema(), other.environmentType);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.modelType)) {
        this.modelType = data().deepCopy(fields()[11].schema(), other.modelType);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.environmentStatus)) {
        this.environmentStatus = data().deepCopy(fields()[12].schema(), other.environmentStatus);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.numberOfEnvironmentRecords)) {
        this.numberOfEnvironmentRecords = data().deepCopy(fields()[13].schema(), other.numberOfEnvironmentRecords);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.sequenceNumber)) {
        this.sequenceNumber = data().deepCopy(fields()[14].schema(), other.sequenceNumber);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.environmentRecords)) {
        this.environmentRecords = data().deepCopy(fields()[15].schema(), other.environmentRecords);
        fieldSetFlags()[15] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'environementalProcessID' field */
    public com.cohesionforce.dis.avro.EntityID getEnvironementalProcessID() {
      return environementalProcessID;
    }
    
    /** Sets the value of the 'environementalProcessID' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setEnvironementalProcessID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.environementalProcessID = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'environementalProcessID' field has been set */
    public boolean hasEnvironementalProcessID() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'environementalProcessID' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearEnvironementalProcessID() {
      environementalProcessID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'environmentType' field */
    public com.cohesionforce.dis.avro.EntityType getEnvironmentType() {
      return environmentType;
    }
    
    /** Sets the value of the 'environmentType' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setEnvironmentType(com.cohesionforce.dis.avro.EntityType value) {
      validate(fields()[10], value);
      this.environmentType = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'environmentType' field has been set */
    public boolean hasEnvironmentType() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'environmentType' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearEnvironmentType() {
      environmentType = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'modelType' field */
    public java.lang.Integer getModelType() {
      return modelType;
    }
    
    /** Sets the value of the 'modelType' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setModelType(int value) {
      validate(fields()[11], value);
      this.modelType = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'modelType' field has been set */
    public boolean hasModelType() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'modelType' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearModelType() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'environmentStatus' field */
    public java.lang.Integer getEnvironmentStatus() {
      return environmentStatus;
    }
    
    /** Sets the value of the 'environmentStatus' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setEnvironmentStatus(int value) {
      validate(fields()[12], value);
      this.environmentStatus = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'environmentStatus' field has been set */
    public boolean hasEnvironmentStatus() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'environmentStatus' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearEnvironmentStatus() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'numberOfEnvironmentRecords' field */
    public java.lang.Integer getNumberOfEnvironmentRecords() {
      return numberOfEnvironmentRecords;
    }
    
    /** Sets the value of the 'numberOfEnvironmentRecords' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setNumberOfEnvironmentRecords(int value) {
      validate(fields()[13], value);
      this.numberOfEnvironmentRecords = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfEnvironmentRecords' field has been set */
    public boolean hasNumberOfEnvironmentRecords() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'numberOfEnvironmentRecords' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearNumberOfEnvironmentRecords() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'sequenceNumber' field */
    public java.lang.Integer getSequenceNumber() {
      return sequenceNumber;
    }
    
    /** Sets the value of the 'sequenceNumber' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setSequenceNumber(int value) {
      validate(fields()[14], value);
      this.sequenceNumber = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'sequenceNumber' field has been set */
    public boolean hasSequenceNumber() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'sequenceNumber' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearSequenceNumber() {
      fieldSetFlags()[14] = false;
      return this;
    }

    /** Gets the value of the 'environmentRecords' field */
    public java.util.List<com.cohesionforce.dis.avro.Environment> getEnvironmentRecords() {
      return environmentRecords;
    }
    
    /** Sets the value of the 'environmentRecords' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder setEnvironmentRecords(java.util.List<com.cohesionforce.dis.avro.Environment> value) {
      validate(fields()[15], value);
      this.environmentRecords = value;
      fieldSetFlags()[15] = true;
      return this; 
    }
    
    /** Checks whether the 'environmentRecords' field has been set */
    public boolean hasEnvironmentRecords() {
      return fieldSetFlags()[15];
    }
    
    /** Clears the value of the 'environmentRecords' field */
    public com.cohesionforce.dis.avro.EnvironmentalProcessPdu.Builder clearEnvironmentRecords() {
      environmentRecords = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    @Override
    public EnvironmentalProcessPdu build() {
      try {
        EnvironmentalProcessPdu record = new EnvironmentalProcessPdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.environementalProcessID = fieldSetFlags()[9] ? this.environementalProcessID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.environmentType = fieldSetFlags()[10] ? this.environmentType : (com.cohesionforce.dis.avro.EntityType) defaultValue(fields()[10]);
        record.modelType = fieldSetFlags()[11] ? this.modelType : (java.lang.Integer) defaultValue(fields()[11]);
        record.environmentStatus = fieldSetFlags()[12] ? this.environmentStatus : (java.lang.Integer) defaultValue(fields()[12]);
        record.numberOfEnvironmentRecords = fieldSetFlags()[13] ? this.numberOfEnvironmentRecords : (java.lang.Integer) defaultValue(fields()[13]);
        record.sequenceNumber = fieldSetFlags()[14] ? this.sequenceNumber : (java.lang.Integer) defaultValue(fields()[14]);
        record.environmentRecords = fieldSetFlags()[15] ? this.environmentRecords : (java.util.List<com.cohesionforce.dis.avro.Environment>) defaultValue(fields()[15]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
