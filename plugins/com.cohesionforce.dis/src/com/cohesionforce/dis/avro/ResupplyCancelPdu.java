/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ResupplyCancelPdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ResupplyCancelPdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"receivingEntityID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"supplyingEntityID\",\"type\":[\"null\",\"EntityID\"]}]}");
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
  @Deprecated public com.cohesionforce.dis.avro.EntityID receivingEntityID;
  @Deprecated public com.cohesionforce.dis.avro.EntityID supplyingEntityID;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ResupplyCancelPdu() {}

  /**
   * All-args constructor.
   */
  public ResupplyCancelPdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID receivingEntityID, com.cohesionforce.dis.avro.EntityID supplyingEntityID) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.receivingEntityID = receivingEntityID;
    this.supplyingEntityID = supplyingEntityID;
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
    case 9: return receivingEntityID;
    case 10: return supplyingEntityID;
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
    case 9: receivingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: supplyingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
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
   * Gets the value of the 'supplyingEntityID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getSupplyingEntityID() {
    return supplyingEntityID;
  }

  /**
   * Sets the value of the 'supplyingEntityID' field.
   * @param value the value to set.
   */
  public void setSupplyingEntityID(com.cohesionforce.dis.avro.EntityID value) {
    this.supplyingEntityID = value;
  }

  /** Creates a new ResupplyCancelPdu RecordBuilder */
  public static com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder();
  }
  
  /** Creates a new ResupplyCancelPdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder newBuilder(com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder other) {
    return new com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder(other);
  }
  
  /** Creates a new ResupplyCancelPdu RecordBuilder by copying an existing ResupplyCancelPdu instance */
  public static com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder newBuilder(com.cohesionforce.dis.avro.ResupplyCancelPdu other) {
    return new com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder(other);
  }
  
  /**
   * RecordBuilder for ResupplyCancelPdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ResupplyCancelPdu>
    implements org.apache.avro.data.RecordBuilder<ResupplyCancelPdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID receivingEntityID;
    private com.cohesionforce.dis.avro.EntityID supplyingEntityID;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ResupplyCancelPdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder other) {
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
      if (isValidValue(fields()[9], other.receivingEntityID)) {
        this.receivingEntityID = data().deepCopy(fields()[9].schema(), other.receivingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.supplyingEntityID)) {
        this.supplyingEntityID = data().deepCopy(fields()[10].schema(), other.supplyingEntityID);
        fieldSetFlags()[10] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ResupplyCancelPdu instance */
    private Builder(com.cohesionforce.dis.avro.ResupplyCancelPdu other) {
            super(com.cohesionforce.dis.avro.ResupplyCancelPdu.SCHEMA$);
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
      if (isValidValue(fields()[9], other.receivingEntityID)) {
        this.receivingEntityID = data().deepCopy(fields()[9].schema(), other.receivingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.supplyingEntityID)) {
        this.supplyingEntityID = data().deepCopy(fields()[10].schema(), other.supplyingEntityID);
        fieldSetFlags()[10] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getReceivingEntityID() {
      return receivingEntityID;
    }
    
    /** Sets the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setReceivingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.receivingEntityID = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'receivingEntityID' field has been set */
    public boolean hasReceivingEntityID() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'receivingEntityID' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearReceivingEntityID() {
      receivingEntityID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'supplyingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getSupplyingEntityID() {
      return supplyingEntityID;
    }
    
    /** Sets the value of the 'supplyingEntityID' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder setSupplyingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[10], value);
      this.supplyingEntityID = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'supplyingEntityID' field has been set */
    public boolean hasSupplyingEntityID() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'supplyingEntityID' field */
    public com.cohesionforce.dis.avro.ResupplyCancelPdu.Builder clearSupplyingEntityID() {
      supplyingEntityID = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    public ResupplyCancelPdu build() {
      try {
        ResupplyCancelPdu record = new ResupplyCancelPdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.receivingEntityID = fieldSetFlags()[9] ? this.receivingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.supplyingEntityID = fieldSetFlags()[10] ? this.supplyingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[10]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
