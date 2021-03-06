/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Pdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Pdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int protocolVersion;
  @Deprecated public int exerciseID;
  @Deprecated public int pduType;
  @Deprecated public int protocolFamily;
  @Deprecated public long timestamp;
  @Deprecated public int pduLength;
  @Deprecated public int padding;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Pdu() {}

  /**
   * All-args constructor.
   */
  public Pdu(java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding) {
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return protocolVersion;
    case 1: return exerciseID;
    case 2: return pduType;
    case 3: return protocolFamily;
    case 4: return timestamp;
    case 5: return pduLength;
    case 6: return padding;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: protocolVersion = (java.lang.Integer)value$; break;
    case 1: exerciseID = (java.lang.Integer)value$; break;
    case 2: pduType = (java.lang.Integer)value$; break;
    case 3: protocolFamily = (java.lang.Integer)value$; break;
    case 4: timestamp = (java.lang.Long)value$; break;
    case 5: pduLength = (java.lang.Integer)value$; break;
    case 6: padding = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
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

  /** Creates a new Pdu RecordBuilder */
  public static com.cohesionforce.dis.avro.Pdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.Pdu.Builder();
  }
  
  /** Creates a new Pdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.Pdu.Builder newBuilder(com.cohesionforce.dis.avro.Pdu.Builder other) {
    return new com.cohesionforce.dis.avro.Pdu.Builder(other);
  }
  
  /** Creates a new Pdu RecordBuilder by copying an existing Pdu instance */
  public static com.cohesionforce.dis.avro.Pdu.Builder newBuilder(com.cohesionforce.dis.avro.Pdu other) {
    return new com.cohesionforce.dis.avro.Pdu.Builder(other);
  }
  
  /**
   * RecordBuilder for Pdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Pdu>
    implements org.apache.avro.data.RecordBuilder<Pdu> {

    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.Pdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.Pdu.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.protocolVersion)) {
        this.protocolVersion = data().deepCopy(fields()[0].schema(), other.protocolVersion);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.exerciseID)) {
        this.exerciseID = data().deepCopy(fields()[1].schema(), other.exerciseID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pduType)) {
        this.pduType = data().deepCopy(fields()[2].schema(), other.pduType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.protocolFamily)) {
        this.protocolFamily = data().deepCopy(fields()[3].schema(), other.protocolFamily);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.pduLength)) {
        this.pduLength = data().deepCopy(fields()[5].schema(), other.pduLength);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.padding)) {
        this.padding = data().deepCopy(fields()[6].schema(), other.padding);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Pdu instance */
    private Builder(com.cohesionforce.dis.avro.Pdu other) {
            super(com.cohesionforce.dis.avro.Pdu.SCHEMA$);
      if (isValidValue(fields()[0], other.protocolVersion)) {
        this.protocolVersion = data().deepCopy(fields()[0].schema(), other.protocolVersion);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.exerciseID)) {
        this.exerciseID = data().deepCopy(fields()[1].schema(), other.exerciseID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pduType)) {
        this.pduType = data().deepCopy(fields()[2].schema(), other.pduType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.protocolFamily)) {
        this.protocolFamily = data().deepCopy(fields()[3].schema(), other.protocolFamily);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.pduLength)) {
        this.pduLength = data().deepCopy(fields()[5].schema(), other.pduLength);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.padding)) {
        this.padding = data().deepCopy(fields()[6].schema(), other.padding);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setProtocolVersion(int value) {
      validate(fields()[0], value);
      this.protocolVersion = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'protocolVersion' field has been set */
    public boolean hasProtocolVersion() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearProtocolVersion() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setExerciseID(int value) {
      validate(fields()[1], value);
      this.exerciseID = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'exerciseID' field has been set */
    public boolean hasExerciseID() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearExerciseID() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setPduType(int value) {
      validate(fields()[2], value);
      this.pduType = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'pduType' field has been set */
    public boolean hasPduType() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearPduType() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setProtocolFamily(int value) {
      validate(fields()[3], value);
      this.protocolFamily = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'protocolFamily' field has been set */
    public boolean hasProtocolFamily() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearProtocolFamily() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setTimestamp(long value) {
      validate(fields()[4], value);
      this.timestamp = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearTimestamp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setPduLength(int value) {
      validate(fields()[5], value);
      this.pduLength = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'pduLength' field has been set */
    public boolean hasPduLength() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearPduLength() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.Pdu.Builder setPadding(int value) {
      validate(fields()[6], value);
      this.padding = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'padding' field has been set */
    public boolean hasPadding() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'padding' field */
    public com.cohesionforce.dis.avro.Pdu.Builder clearPadding() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public Pdu build() {
      try {
        Pdu record = new Pdu();
        record.protocolVersion = fieldSetFlags()[0] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[0]);
        record.exerciseID = fieldSetFlags()[1] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[1]);
        record.pduType = fieldSetFlags()[2] ? this.pduType : (java.lang.Integer) defaultValue(fields()[2]);
        record.protocolFamily = fieldSetFlags()[3] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[3]);
        record.timestamp = fieldSetFlags()[4] ? this.timestamp : (java.lang.Long) defaultValue(fields()[4]);
        record.pduLength = fieldSetFlags()[5] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[5]);
        record.padding = fieldSetFlags()[6] ? this.padding : (java.lang.Integer) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
