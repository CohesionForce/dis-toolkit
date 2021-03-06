/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SignalPdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SignalPdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"entityId\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"radioId\",\"type\":\"int\"},{\"name\":\"encodingScheme\",\"type\":\"int\"},{\"name\":\"tdlType\",\"type\":\"int\"},{\"name\":\"sampleRate\",\"type\":\"long\"},{\"name\":\"numberOfData\",\"type\":\"int\"},{\"name\":\"samples\",\"type\":\"int\"},{\"name\":\"data\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OneByteChunk\",\"fields\":[{\"name\":\"otherParameters\",\"type\":\"int\"}]}}]}]}");
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
  @Deprecated public com.cohesionforce.dis.avro.EntityID entityId;
  @Deprecated public int radioId;
  @Deprecated public int encodingScheme;
  @Deprecated public int tdlType;
  @Deprecated public long sampleRate;
  @Deprecated public int numberOfData;
  @Deprecated public int samples;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.OneByteChunk> data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public SignalPdu() {}

  /**
   * All-args constructor.
   */
  public SignalPdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID entityId, java.lang.Integer radioId, java.lang.Integer encodingScheme, java.lang.Integer tdlType, java.lang.Long sampleRate, java.lang.Integer numberOfData, java.lang.Integer samples, java.util.List<com.cohesionforce.dis.avro.OneByteChunk> data) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.entityId = entityId;
    this.radioId = radioId;
    this.encodingScheme = encodingScheme;
    this.tdlType = tdlType;
    this.sampleRate = sampleRate;
    this.numberOfData = numberOfData;
    this.samples = samples;
    this.data = data;
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
    case 9: return entityId;
    case 10: return radioId;
    case 11: return encodingScheme;
    case 12: return tdlType;
    case 13: return sampleRate;
    case 14: return numberOfData;
    case 15: return samples;
    case 16: return data;
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
    case 9: entityId = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: radioId = (java.lang.Integer)value$; break;
    case 11: encodingScheme = (java.lang.Integer)value$; break;
    case 12: tdlType = (java.lang.Integer)value$; break;
    case 13: sampleRate = (java.lang.Long)value$; break;
    case 14: numberOfData = (java.lang.Integer)value$; break;
    case 15: samples = (java.lang.Integer)value$; break;
    case 16: data = (java.util.List<com.cohesionforce.dis.avro.OneByteChunk>)value$; break;
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
   * Gets the value of the 'entityId' field.
   */
  public com.cohesionforce.dis.avro.EntityID getEntityId() {
    return entityId;
  }

  /**
   * Sets the value of the 'entityId' field.
   * @param value the value to set.
   */
  public void setEntityId(com.cohesionforce.dis.avro.EntityID value) {
    this.entityId = value;
  }

  /**
   * Gets the value of the 'radioId' field.
   */
  public java.lang.Integer getRadioId() {
    return radioId;
  }

  /**
   * Sets the value of the 'radioId' field.
   * @param value the value to set.
   */
  public void setRadioId(java.lang.Integer value) {
    this.radioId = value;
  }

  /**
   * Gets the value of the 'encodingScheme' field.
   */
  public java.lang.Integer getEncodingScheme() {
    return encodingScheme;
  }

  /**
   * Sets the value of the 'encodingScheme' field.
   * @param value the value to set.
   */
  public void setEncodingScheme(java.lang.Integer value) {
    this.encodingScheme = value;
  }

  /**
   * Gets the value of the 'tdlType' field.
   */
  public java.lang.Integer getTdlType() {
    return tdlType;
  }

  /**
   * Sets the value of the 'tdlType' field.
   * @param value the value to set.
   */
  public void setTdlType(java.lang.Integer value) {
    this.tdlType = value;
  }

  /**
   * Gets the value of the 'sampleRate' field.
   */
  public java.lang.Long getSampleRate() {
    return sampleRate;
  }

  /**
   * Sets the value of the 'sampleRate' field.
   * @param value the value to set.
   */
  public void setSampleRate(java.lang.Long value) {
    this.sampleRate = value;
  }

  /**
   * Gets the value of the 'numberOfData' field.
   */
  public java.lang.Integer getNumberOfData() {
    return numberOfData;
  }

  /**
   * Sets the value of the 'numberOfData' field.
   * @param value the value to set.
   */
  public void setNumberOfData(java.lang.Integer value) {
    this.numberOfData = value;
  }

  /**
   * Gets the value of the 'samples' field.
   */
  public java.lang.Integer getSamples() {
    return samples;
  }

  /**
   * Sets the value of the 'samples' field.
   * @param value the value to set.
   */
  public void setSamples(java.lang.Integer value) {
    this.samples = value;
  }

  /**
   * Gets the value of the 'data' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.OneByteChunk> getData() {
    return data;
  }

  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(java.util.List<com.cohesionforce.dis.avro.OneByteChunk> value) {
    this.data = value;
  }

  /** Creates a new SignalPdu RecordBuilder */
  public static com.cohesionforce.dis.avro.SignalPdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.SignalPdu.Builder();
  }
  
  /** Creates a new SignalPdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.SignalPdu.Builder newBuilder(com.cohesionforce.dis.avro.SignalPdu.Builder other) {
    return new com.cohesionforce.dis.avro.SignalPdu.Builder(other);
  }
  
  /** Creates a new SignalPdu RecordBuilder by copying an existing SignalPdu instance */
  public static com.cohesionforce.dis.avro.SignalPdu.Builder newBuilder(com.cohesionforce.dis.avro.SignalPdu other) {
    return new com.cohesionforce.dis.avro.SignalPdu.Builder(other);
  }
  
  /**
   * RecordBuilder for SignalPdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SignalPdu>
    implements org.apache.avro.data.RecordBuilder<SignalPdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID entityId;
    private int radioId;
    private int encodingScheme;
    private int tdlType;
    private long sampleRate;
    private int numberOfData;
    private int samples;
    private java.util.List<com.cohesionforce.dis.avro.OneByteChunk> data;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.SignalPdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.SignalPdu.Builder other) {
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
      if (isValidValue(fields()[9], other.entityId)) {
        this.entityId = data().deepCopy(fields()[9].schema(), other.entityId);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.radioId)) {
        this.radioId = data().deepCopy(fields()[10].schema(), other.radioId);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.encodingScheme)) {
        this.encodingScheme = data().deepCopy(fields()[11].schema(), other.encodingScheme);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.tdlType)) {
        this.tdlType = data().deepCopy(fields()[12].schema(), other.tdlType);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.sampleRate)) {
        this.sampleRate = data().deepCopy(fields()[13].schema(), other.sampleRate);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.numberOfData)) {
        this.numberOfData = data().deepCopy(fields()[14].schema(), other.numberOfData);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.samples)) {
        this.samples = data().deepCopy(fields()[15].schema(), other.samples);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.data)) {
        this.data = data().deepCopy(fields()[16].schema(), other.data);
        fieldSetFlags()[16] = true;
      }
    }
    
    /** Creates a Builder by copying an existing SignalPdu instance */
    private Builder(com.cohesionforce.dis.avro.SignalPdu other) {
            super(com.cohesionforce.dis.avro.SignalPdu.SCHEMA$);
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
      if (isValidValue(fields()[9], other.entityId)) {
        this.entityId = data().deepCopy(fields()[9].schema(), other.entityId);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.radioId)) {
        this.radioId = data().deepCopy(fields()[10].schema(), other.radioId);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.encodingScheme)) {
        this.encodingScheme = data().deepCopy(fields()[11].schema(), other.encodingScheme);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.tdlType)) {
        this.tdlType = data().deepCopy(fields()[12].schema(), other.tdlType);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.sampleRate)) {
        this.sampleRate = data().deepCopy(fields()[13].schema(), other.sampleRate);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.numberOfData)) {
        this.numberOfData = data().deepCopy(fields()[14].schema(), other.numberOfData);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.samples)) {
        this.samples = data().deepCopy(fields()[15].schema(), other.samples);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.data)) {
        this.data = data().deepCopy(fields()[16].schema(), other.data);
        fieldSetFlags()[16] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'entityId' field */
    public com.cohesionforce.dis.avro.EntityID getEntityId() {
      return entityId;
    }
    
    /** Sets the value of the 'entityId' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setEntityId(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.entityId = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'entityId' field has been set */
    public boolean hasEntityId() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'entityId' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearEntityId() {
      entityId = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'radioId' field */
    public java.lang.Integer getRadioId() {
      return radioId;
    }
    
    /** Sets the value of the 'radioId' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setRadioId(int value) {
      validate(fields()[10], value);
      this.radioId = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'radioId' field has been set */
    public boolean hasRadioId() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'radioId' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearRadioId() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'encodingScheme' field */
    public java.lang.Integer getEncodingScheme() {
      return encodingScheme;
    }
    
    /** Sets the value of the 'encodingScheme' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setEncodingScheme(int value) {
      validate(fields()[11], value);
      this.encodingScheme = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'encodingScheme' field has been set */
    public boolean hasEncodingScheme() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'encodingScheme' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearEncodingScheme() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'tdlType' field */
    public java.lang.Integer getTdlType() {
      return tdlType;
    }
    
    /** Sets the value of the 'tdlType' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setTdlType(int value) {
      validate(fields()[12], value);
      this.tdlType = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'tdlType' field has been set */
    public boolean hasTdlType() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'tdlType' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearTdlType() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'sampleRate' field */
    public java.lang.Long getSampleRate() {
      return sampleRate;
    }
    
    /** Sets the value of the 'sampleRate' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setSampleRate(long value) {
      validate(fields()[13], value);
      this.sampleRate = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'sampleRate' field has been set */
    public boolean hasSampleRate() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'sampleRate' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearSampleRate() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'numberOfData' field */
    public java.lang.Integer getNumberOfData() {
      return numberOfData;
    }
    
    /** Sets the value of the 'numberOfData' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setNumberOfData(int value) {
      validate(fields()[14], value);
      this.numberOfData = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfData' field has been set */
    public boolean hasNumberOfData() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'numberOfData' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearNumberOfData() {
      fieldSetFlags()[14] = false;
      return this;
    }

    /** Gets the value of the 'samples' field */
    public java.lang.Integer getSamples() {
      return samples;
    }
    
    /** Sets the value of the 'samples' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setSamples(int value) {
      validate(fields()[15], value);
      this.samples = value;
      fieldSetFlags()[15] = true;
      return this; 
    }
    
    /** Checks whether the 'samples' field has been set */
    public boolean hasSamples() {
      return fieldSetFlags()[15];
    }
    
    /** Clears the value of the 'samples' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearSamples() {
      fieldSetFlags()[15] = false;
      return this;
    }

    /** Gets the value of the 'data' field */
    public java.util.List<com.cohesionforce.dis.avro.OneByteChunk> getData() {
      return data;
    }
    
    /** Sets the value of the 'data' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder setData(java.util.List<com.cohesionforce.dis.avro.OneByteChunk> value) {
      validate(fields()[16], value);
      this.data = value;
      fieldSetFlags()[16] = true;
      return this; 
    }
    
    /** Checks whether the 'data' field has been set */
    public boolean hasData() {
      return fieldSetFlags()[16];
    }
    
    /** Clears the value of the 'data' field */
    public com.cohesionforce.dis.avro.SignalPdu.Builder clearData() {
      data = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    @Override
    public SignalPdu build() {
      try {
        SignalPdu record = new SignalPdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.entityId = fieldSetFlags()[9] ? this.entityId : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.radioId = fieldSetFlags()[10] ? this.radioId : (java.lang.Integer) defaultValue(fields()[10]);
        record.encodingScheme = fieldSetFlags()[11] ? this.encodingScheme : (java.lang.Integer) defaultValue(fields()[11]);
        record.tdlType = fieldSetFlags()[12] ? this.tdlType : (java.lang.Integer) defaultValue(fields()[12]);
        record.sampleRate = fieldSetFlags()[13] ? this.sampleRate : (java.lang.Long) defaultValue(fields()[13]);
        record.numberOfData = fieldSetFlags()[14] ? this.numberOfData : (java.lang.Integer) defaultValue(fields()[14]);
        record.samples = fieldSetFlags()[15] ? this.samples : (java.lang.Integer) defaultValue(fields()[15]);
        record.data = fieldSetFlags()[16] ? this.data : (java.util.List<com.cohesionforce.dis.avro.OneByteChunk>) defaultValue(fields()[16]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
