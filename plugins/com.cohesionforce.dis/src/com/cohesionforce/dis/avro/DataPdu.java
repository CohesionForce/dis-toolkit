/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DataPdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DataPdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"originatingEntityID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"receivingEntityID\",\"type\":[\"null\",\"EntityID\"]},{\"name\":\"requestID\",\"type\":\"long\"},{\"name\":\"padding1\",\"type\":\"long\"},{\"name\":\"numberOfFixedDatums\",\"type\":\"long\"},{\"name\":\"numberOfVariableDatums\",\"type\":\"long\"},{\"name\":\"fixedDatums\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FixedDatum\",\"fields\":[{\"name\":\"fixedDatumID\",\"type\":\"long\"},{\"name\":\"fixedDatumValue\",\"type\":\"long\"}]}}]},{\"name\":\"variableDatums\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"VariableDatum\",\"fields\":[{\"name\":\"variableDatumID\",\"type\":\"long\"},{\"name\":\"variableDatumLength\",\"type\":\"long\"},{\"name\":\"variableData\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}]}]}}]}]}");
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
  @Deprecated public long padding1;
  @Deprecated public long numberOfFixedDatums;
  @Deprecated public long numberOfVariableDatums;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.FixedDatum> fixedDatums;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.VariableDatum> variableDatums;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DataPdu() {}

  /**
   * All-args constructor.
   */
  public DataPdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID originatingEntityID, com.cohesionforce.dis.avro.EntityID receivingEntityID, java.lang.Long requestID, java.lang.Long padding1, java.lang.Long numberOfFixedDatums, java.lang.Long numberOfVariableDatums, java.util.List<com.cohesionforce.dis.avro.FixedDatum> fixedDatums, java.util.List<com.cohesionforce.dis.avro.VariableDatum> variableDatums) {
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
    this.padding1 = padding1;
    this.numberOfFixedDatums = numberOfFixedDatums;
    this.numberOfVariableDatums = numberOfVariableDatums;
    this.fixedDatums = fixedDatums;
    this.variableDatums = variableDatums;
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
    case 12: return padding1;
    case 13: return numberOfFixedDatums;
    case 14: return numberOfVariableDatums;
    case 15: return fixedDatums;
    case 16: return variableDatums;
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
    case 12: padding1 = (java.lang.Long)value$; break;
    case 13: numberOfFixedDatums = (java.lang.Long)value$; break;
    case 14: numberOfVariableDatums = (java.lang.Long)value$; break;
    case 15: fixedDatums = (java.util.List<com.cohesionforce.dis.avro.FixedDatum>)value$; break;
    case 16: variableDatums = (java.util.List<com.cohesionforce.dis.avro.VariableDatum>)value$; break;
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
   * Gets the value of the 'padding1' field.
   */
  public java.lang.Long getPadding1() {
    return padding1;
  }

  /**
   * Sets the value of the 'padding1' field.
   * @param value the value to set.
   */
  public void setPadding1(java.lang.Long value) {
    this.padding1 = value;
  }

  /**
   * Gets the value of the 'numberOfFixedDatums' field.
   */
  public java.lang.Long getNumberOfFixedDatums() {
    return numberOfFixedDatums;
  }

  /**
   * Sets the value of the 'numberOfFixedDatums' field.
   * @param value the value to set.
   */
  public void setNumberOfFixedDatums(java.lang.Long value) {
    this.numberOfFixedDatums = value;
  }

  /**
   * Gets the value of the 'numberOfVariableDatums' field.
   */
  public java.lang.Long getNumberOfVariableDatums() {
    return numberOfVariableDatums;
  }

  /**
   * Sets the value of the 'numberOfVariableDatums' field.
   * @param value the value to set.
   */
  public void setNumberOfVariableDatums(java.lang.Long value) {
    this.numberOfVariableDatums = value;
  }

  /**
   * Gets the value of the 'fixedDatums' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.FixedDatum> getFixedDatums() {
    return fixedDatums;
  }

  /**
   * Sets the value of the 'fixedDatums' field.
   * @param value the value to set.
   */
  public void setFixedDatums(java.util.List<com.cohesionforce.dis.avro.FixedDatum> value) {
    this.fixedDatums = value;
  }

  /**
   * Gets the value of the 'variableDatums' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.VariableDatum> getVariableDatums() {
    return variableDatums;
  }

  /**
   * Sets the value of the 'variableDatums' field.
   * @param value the value to set.
   */
  public void setVariableDatums(java.util.List<com.cohesionforce.dis.avro.VariableDatum> value) {
    this.variableDatums = value;
  }

  /** Creates a new DataPdu RecordBuilder */
  public static com.cohesionforce.dis.avro.DataPdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.DataPdu.Builder();
  }
  
  /** Creates a new DataPdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.DataPdu.Builder newBuilder(com.cohesionforce.dis.avro.DataPdu.Builder other) {
    return new com.cohesionforce.dis.avro.DataPdu.Builder(other);
  }
  
  /** Creates a new DataPdu RecordBuilder by copying an existing DataPdu instance */
  public static com.cohesionforce.dis.avro.DataPdu.Builder newBuilder(com.cohesionforce.dis.avro.DataPdu other) {
    return new com.cohesionforce.dis.avro.DataPdu.Builder(other);
  }
  
  /**
   * RecordBuilder for DataPdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DataPdu>
    implements org.apache.avro.data.RecordBuilder<DataPdu> {

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
    private long padding1;
    private long numberOfFixedDatums;
    private long numberOfVariableDatums;
    private java.util.List<com.cohesionforce.dis.avro.FixedDatum> fixedDatums;
    private java.util.List<com.cohesionforce.dis.avro.VariableDatum> variableDatums;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.DataPdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.DataPdu.Builder other) {
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
      if (isValidValue(fields()[12], other.padding1)) {
        this.padding1 = data().deepCopy(fields()[12].schema(), other.padding1);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.numberOfFixedDatums)) {
        this.numberOfFixedDatums = data().deepCopy(fields()[13].schema(), other.numberOfFixedDatums);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.numberOfVariableDatums)) {
        this.numberOfVariableDatums = data().deepCopy(fields()[14].schema(), other.numberOfVariableDatums);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.fixedDatums)) {
        this.fixedDatums = data().deepCopy(fields()[15].schema(), other.fixedDatums);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.variableDatums)) {
        this.variableDatums = data().deepCopy(fields()[16].schema(), other.variableDatums);
        fieldSetFlags()[16] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DataPdu instance */
    private Builder(com.cohesionforce.dis.avro.DataPdu other) {
            super(com.cohesionforce.dis.avro.DataPdu.SCHEMA$);
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
      if (isValidValue(fields()[12], other.padding1)) {
        this.padding1 = data().deepCopy(fields()[12].schema(), other.padding1);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.numberOfFixedDatums)) {
        this.numberOfFixedDatums = data().deepCopy(fields()[13].schema(), other.numberOfFixedDatums);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.numberOfVariableDatums)) {
        this.numberOfVariableDatums = data().deepCopy(fields()[14].schema(), other.numberOfVariableDatums);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.fixedDatums)) {
        this.fixedDatums = data().deepCopy(fields()[15].schema(), other.fixedDatums);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.variableDatums)) {
        this.variableDatums = data().deepCopy(fields()[16].schema(), other.variableDatums);
        fieldSetFlags()[16] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'originatingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getOriginatingEntityID() {
      return originatingEntityID;
    }
    
    /** Sets the value of the 'originatingEntityID' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setOriginatingEntityID(com.cohesionforce.dis.avro.EntityID value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearOriginatingEntityID() {
      originatingEntityID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getReceivingEntityID() {
      return receivingEntityID;
    }
    
    /** Sets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setReceivingEntityID(com.cohesionforce.dis.avro.EntityID value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearReceivingEntityID() {
      receivingEntityID = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'requestID' field */
    public java.lang.Long getRequestID() {
      return requestID;
    }
    
    /** Sets the value of the 'requestID' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setRequestID(long value) {
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
    public com.cohesionforce.dis.avro.DataPdu.Builder clearRequestID() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'padding1' field */
    public java.lang.Long getPadding1() {
      return padding1;
    }
    
    /** Sets the value of the 'padding1' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setPadding1(long value) {
      validate(fields()[12], value);
      this.padding1 = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'padding1' field has been set */
    public boolean hasPadding1() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'padding1' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder clearPadding1() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'numberOfFixedDatums' field */
    public java.lang.Long getNumberOfFixedDatums() {
      return numberOfFixedDatums;
    }
    
    /** Sets the value of the 'numberOfFixedDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setNumberOfFixedDatums(long value) {
      validate(fields()[13], value);
      this.numberOfFixedDatums = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfFixedDatums' field has been set */
    public boolean hasNumberOfFixedDatums() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'numberOfFixedDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder clearNumberOfFixedDatums() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'numberOfVariableDatums' field */
    public java.lang.Long getNumberOfVariableDatums() {
      return numberOfVariableDatums;
    }
    
    /** Sets the value of the 'numberOfVariableDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setNumberOfVariableDatums(long value) {
      validate(fields()[14], value);
      this.numberOfVariableDatums = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfVariableDatums' field has been set */
    public boolean hasNumberOfVariableDatums() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'numberOfVariableDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder clearNumberOfVariableDatums() {
      fieldSetFlags()[14] = false;
      return this;
    }

    /** Gets the value of the 'fixedDatums' field */
    public java.util.List<com.cohesionforce.dis.avro.FixedDatum> getFixedDatums() {
      return fixedDatums;
    }
    
    /** Sets the value of the 'fixedDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setFixedDatums(java.util.List<com.cohesionforce.dis.avro.FixedDatum> value) {
      validate(fields()[15], value);
      this.fixedDatums = value;
      fieldSetFlags()[15] = true;
      return this; 
    }
    
    /** Checks whether the 'fixedDatums' field has been set */
    public boolean hasFixedDatums() {
      return fieldSetFlags()[15];
    }
    
    /** Clears the value of the 'fixedDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder clearFixedDatums() {
      fixedDatums = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    /** Gets the value of the 'variableDatums' field */
    public java.util.List<com.cohesionforce.dis.avro.VariableDatum> getVariableDatums() {
      return variableDatums;
    }
    
    /** Sets the value of the 'variableDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder setVariableDatums(java.util.List<com.cohesionforce.dis.avro.VariableDatum> value) {
      validate(fields()[16], value);
      this.variableDatums = value;
      fieldSetFlags()[16] = true;
      return this; 
    }
    
    /** Checks whether the 'variableDatums' field has been set */
    public boolean hasVariableDatums() {
      return fieldSetFlags()[16];
    }
    
    /** Clears the value of the 'variableDatums' field */
    public com.cohesionforce.dis.avro.DataPdu.Builder clearVariableDatums() {
      variableDatums = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    @Override
    public DataPdu build() {
      try {
        DataPdu record = new DataPdu();
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
        record.padding1 = fieldSetFlags()[12] ? this.padding1 : (java.lang.Long) defaultValue(fields()[12]);
        record.numberOfFixedDatums = fieldSetFlags()[13] ? this.numberOfFixedDatums : (java.lang.Long) defaultValue(fields()[13]);
        record.numberOfVariableDatums = fieldSetFlags()[14] ? this.numberOfVariableDatums : (java.lang.Long) defaultValue(fields()[14]);
        record.fixedDatums = fieldSetFlags()[15] ? this.fixedDatums : (java.util.List<com.cohesionforce.dis.avro.FixedDatum>) defaultValue(fields()[15]);
        record.variableDatums = fieldSetFlags()[16] ? this.variableDatums : (java.util.List<com.cohesionforce.dis.avro.VariableDatum>) defaultValue(fields()[16]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
