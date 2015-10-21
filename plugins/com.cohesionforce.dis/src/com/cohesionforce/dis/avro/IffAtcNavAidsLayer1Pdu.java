/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class IffAtcNavAidsLayer1Pdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IffAtcNavAidsLayer1Pdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"emittingEntityId\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"eventID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EventID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"eventNumber\",\"type\":\"int\"}]}]},{\"name\":\"location\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Vector3Float\",\"fields\":[{\"name\":\"x\",\"type\":\"float\"},{\"name\":\"y\",\"type\":\"float\"},{\"name\":\"z\",\"type\":\"float\"}]}]},{\"name\":\"systemID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"SystemID\",\"fields\":[{\"name\":\"systemType\",\"type\":\"int\"},{\"name\":\"systemName\",\"type\":\"int\"},{\"name\":\"systemMode\",\"type\":\"int\"},{\"name\":\"changeOptions\",\"type\":\"int\"}]}]},{\"name\":\"pad2\",\"type\":\"int\"},{\"name\":\"fundamentalParameters\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"IffFundamentalData\",\"fields\":[{\"name\":\"systemStatus\",\"type\":\"int\"},{\"name\":\"alternateParameter4\",\"type\":\"int\"},{\"name\":\"informationLayers\",\"type\":\"int\"},{\"name\":\"modifier\",\"type\":\"int\"},{\"name\":\"parameter1\",\"type\":\"int\"},{\"name\":\"parameter2\",\"type\":\"int\"},{\"name\":\"parameter3\",\"type\":\"int\"},{\"name\":\"parameter4\",\"type\":\"int\"},{\"name\":\"parameter5\",\"type\":\"int\"},{\"name\":\"parameter6\",\"type\":\"int\"}]}]}]}");
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
  @Deprecated public com.cohesionforce.dis.avro.EntityID emittingEntityId;
  @Deprecated public com.cohesionforce.dis.avro.EventID eventID;
  @Deprecated public com.cohesionforce.dis.avro.Vector3Float location;
  @Deprecated public com.cohesionforce.dis.avro.SystemID systemID;
  @Deprecated public int pad2;
  @Deprecated public com.cohesionforce.dis.avro.IffFundamentalData fundamentalParameters;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public IffAtcNavAidsLayer1Pdu() {}

  /**
   * All-args constructor.
   */
  public IffAtcNavAidsLayer1Pdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID emittingEntityId, com.cohesionforce.dis.avro.EventID eventID, com.cohesionforce.dis.avro.Vector3Float location, com.cohesionforce.dis.avro.SystemID systemID, java.lang.Integer pad2, com.cohesionforce.dis.avro.IffFundamentalData fundamentalParameters) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.emittingEntityId = emittingEntityId;
    this.eventID = eventID;
    this.location = location;
    this.systemID = systemID;
    this.pad2 = pad2;
    this.fundamentalParameters = fundamentalParameters;
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
    case 9: return emittingEntityId;
    case 10: return eventID;
    case 11: return location;
    case 12: return systemID;
    case 13: return pad2;
    case 14: return fundamentalParameters;
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
    case 9: emittingEntityId = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: eventID = (com.cohesionforce.dis.avro.EventID)value$; break;
    case 11: location = (com.cohesionforce.dis.avro.Vector3Float)value$; break;
    case 12: systemID = (com.cohesionforce.dis.avro.SystemID)value$; break;
    case 13: pad2 = (java.lang.Integer)value$; break;
    case 14: fundamentalParameters = (com.cohesionforce.dis.avro.IffFundamentalData)value$; break;
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
   * Gets the value of the 'emittingEntityId' field.
   */
  public com.cohesionforce.dis.avro.EntityID getEmittingEntityId() {
    return emittingEntityId;
  }

  /**
   * Sets the value of the 'emittingEntityId' field.
   * @param value the value to set.
   */
  public void setEmittingEntityId(com.cohesionforce.dis.avro.EntityID value) {
    this.emittingEntityId = value;
  }

  /**
   * Gets the value of the 'eventID' field.
   */
  public com.cohesionforce.dis.avro.EventID getEventID() {
    return eventID;
  }

  /**
   * Sets the value of the 'eventID' field.
   * @param value the value to set.
   */
  public void setEventID(com.cohesionforce.dis.avro.EventID value) {
    this.eventID = value;
  }

  /**
   * Gets the value of the 'location' field.
   */
  public com.cohesionforce.dis.avro.Vector3Float getLocation() {
    return location;
  }

  /**
   * Sets the value of the 'location' field.
   * @param value the value to set.
   */
  public void setLocation(com.cohesionforce.dis.avro.Vector3Float value) {
    this.location = value;
  }

  /**
   * Gets the value of the 'systemID' field.
   */
  public com.cohesionforce.dis.avro.SystemID getSystemID() {
    return systemID;
  }

  /**
   * Sets the value of the 'systemID' field.
   * @param value the value to set.
   */
  public void setSystemID(com.cohesionforce.dis.avro.SystemID value) {
    this.systemID = value;
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
   * Gets the value of the 'fundamentalParameters' field.
   */
  public com.cohesionforce.dis.avro.IffFundamentalData getFundamentalParameters() {
    return fundamentalParameters;
  }

  /**
   * Sets the value of the 'fundamentalParameters' field.
   * @param value the value to set.
   */
  public void setFundamentalParameters(com.cohesionforce.dis.avro.IffFundamentalData value) {
    this.fundamentalParameters = value;
  }

  /** Creates a new IffAtcNavAidsLayer1Pdu RecordBuilder */
  public static com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder();
  }
  
  /** Creates a new IffAtcNavAidsLayer1Pdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder newBuilder(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder other) {
    return new com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder(other);
  }
  
  /** Creates a new IffAtcNavAidsLayer1Pdu RecordBuilder by copying an existing IffAtcNavAidsLayer1Pdu instance */
  public static com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder newBuilder(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu other) {
    return new com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder(other);
  }
  
  /**
   * RecordBuilder for IffAtcNavAidsLayer1Pdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IffAtcNavAidsLayer1Pdu>
    implements org.apache.avro.data.RecordBuilder<IffAtcNavAidsLayer1Pdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID emittingEntityId;
    private com.cohesionforce.dis.avro.EventID eventID;
    private com.cohesionforce.dis.avro.Vector3Float location;
    private com.cohesionforce.dis.avro.SystemID systemID;
    private int pad2;
    private com.cohesionforce.dis.avro.IffFundamentalData fundamentalParameters;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder other) {
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
      if (isValidValue(fields()[9], other.emittingEntityId)) {
        this.emittingEntityId = data().deepCopy(fields()[9].schema(), other.emittingEntityId);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.eventID)) {
        this.eventID = data().deepCopy(fields()[10].schema(), other.eventID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.location)) {
        this.location = data().deepCopy(fields()[11].schema(), other.location);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.systemID)) {
        this.systemID = data().deepCopy(fields()[12].schema(), other.systemID);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[13].schema(), other.pad2);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.fundamentalParameters)) {
        this.fundamentalParameters = data().deepCopy(fields()[14].schema(), other.fundamentalParameters);
        fieldSetFlags()[14] = true;
      }
    }
    
    /** Creates a Builder by copying an existing IffAtcNavAidsLayer1Pdu instance */
    private Builder(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu other) {
            super(com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.SCHEMA$);
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
      if (isValidValue(fields()[9], other.emittingEntityId)) {
        this.emittingEntityId = data().deepCopy(fields()[9].schema(), other.emittingEntityId);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.eventID)) {
        this.eventID = data().deepCopy(fields()[10].schema(), other.eventID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.location)) {
        this.location = data().deepCopy(fields()[11].schema(), other.location);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.systemID)) {
        this.systemID = data().deepCopy(fields()[12].schema(), other.systemID);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[13].schema(), other.pad2);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.fundamentalParameters)) {
        this.fundamentalParameters = data().deepCopy(fields()[14].schema(), other.fundamentalParameters);
        fieldSetFlags()[14] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'emittingEntityId' field */
    public com.cohesionforce.dis.avro.EntityID getEmittingEntityId() {
      return emittingEntityId;
    }
    
    /** Sets the value of the 'emittingEntityId' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setEmittingEntityId(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.emittingEntityId = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'emittingEntityId' field has been set */
    public boolean hasEmittingEntityId() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'emittingEntityId' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearEmittingEntityId() {
      emittingEntityId = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'eventID' field */
    public com.cohesionforce.dis.avro.EventID getEventID() {
      return eventID;
    }
    
    /** Sets the value of the 'eventID' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setEventID(com.cohesionforce.dis.avro.EventID value) {
      validate(fields()[10], value);
      this.eventID = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'eventID' field has been set */
    public boolean hasEventID() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'eventID' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearEventID() {
      eventID = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'location' field */
    public com.cohesionforce.dis.avro.Vector3Float getLocation() {
      return location;
    }
    
    /** Sets the value of the 'location' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setLocation(com.cohesionforce.dis.avro.Vector3Float value) {
      validate(fields()[11], value);
      this.location = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'location' field has been set */
    public boolean hasLocation() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'location' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearLocation() {
      location = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'systemID' field */
    public com.cohesionforce.dis.avro.SystemID getSystemID() {
      return systemID;
    }
    
    /** Sets the value of the 'systemID' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setSystemID(com.cohesionforce.dis.avro.SystemID value) {
      validate(fields()[12], value);
      this.systemID = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'systemID' field has been set */
    public boolean hasSystemID() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'systemID' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearSystemID() {
      systemID = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'pad2' field */
    public java.lang.Integer getPad2() {
      return pad2;
    }
    
    /** Sets the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setPad2(int value) {
      validate(fields()[13], value);
      this.pad2 = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'pad2' field has been set */
    public boolean hasPad2() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearPad2() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'fundamentalParameters' field */
    public com.cohesionforce.dis.avro.IffFundamentalData getFundamentalParameters() {
      return fundamentalParameters;
    }
    
    /** Sets the value of the 'fundamentalParameters' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder setFundamentalParameters(com.cohesionforce.dis.avro.IffFundamentalData value) {
      validate(fields()[14], value);
      this.fundamentalParameters = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'fundamentalParameters' field has been set */
    public boolean hasFundamentalParameters() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'fundamentalParameters' field */
    public com.cohesionforce.dis.avro.IffAtcNavAidsLayer1Pdu.Builder clearFundamentalParameters() {
      fundamentalParameters = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    public IffAtcNavAidsLayer1Pdu build() {
      try {
        IffAtcNavAidsLayer1Pdu record = new IffAtcNavAidsLayer1Pdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.emittingEntityId = fieldSetFlags()[9] ? this.emittingEntityId : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.eventID = fieldSetFlags()[10] ? this.eventID : (com.cohesionforce.dis.avro.EventID) defaultValue(fields()[10]);
        record.location = fieldSetFlags()[11] ? this.location : (com.cohesionforce.dis.avro.Vector3Float) defaultValue(fields()[11]);
        record.systemID = fieldSetFlags()[12] ? this.systemID : (com.cohesionforce.dis.avro.SystemID) defaultValue(fields()[12]);
        record.pad2 = fieldSetFlags()[13] ? this.pad2 : (java.lang.Integer) defaultValue(fields()[13]);
        record.fundamentalParameters = fieldSetFlags()[14] ? this.fundamentalParameters : (com.cohesionforce.dis.avro.IffFundamentalData) defaultValue(fields()[14]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}