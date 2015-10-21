/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ServiceRequestPdu extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ServiceRequestPdu\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"reception_timestamp\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Time_t\",\"fields\":[{\"name\":\"sec\",\"type\":\"int\"},{\"name\":\"nanosec\",\"type\":\"int\"}]}]},{\"name\":\"source_timestamp\",\"type\":[\"null\",\"Time_t\"]},{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"},{\"name\":\"requestingEntityID\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"servicingEntityID\",\"type\":[\"null\",\"EntityID\"]},{\"name\":\"serviceTypeRequested\",\"type\":\"int\"},{\"name\":\"numberOfSupplies\",\"type\":\"int\"},{\"name\":\"serviceRequestPadding\",\"type\":\"int\"},{\"name\":\"supplies\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SupplyQuantity\",\"fields\":[{\"name\":\"supplyType\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityType\",\"fields\":[{\"name\":\"entityKind\",\"type\":\"int\"},{\"name\":\"domain\",\"type\":\"int\"},{\"name\":\"country\",\"type\":\"int\"},{\"name\":\"category\",\"type\":\"int\"},{\"name\":\"subcategory\",\"type\":\"int\"},{\"name\":\"spec\",\"type\":\"int\"},{\"name\":\"extra\",\"type\":\"int\"}]}]},{\"name\":\"quantity\",\"type\":\"int\"}]}}]}]}");
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
  @Deprecated public com.cohesionforce.dis.avro.EntityID requestingEntityID;
  @Deprecated public com.cohesionforce.dis.avro.EntityID servicingEntityID;
  @Deprecated public int serviceTypeRequested;
  @Deprecated public int numberOfSupplies;
  @Deprecated public int serviceRequestPadding;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> supplies;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ServiceRequestPdu() {}

  /**
   * All-args constructor.
   */
  public ServiceRequestPdu(com.cohesionforce.dis.avro.Time_t reception_timestamp, com.cohesionforce.dis.avro.Time_t source_timestamp, java.lang.Integer protocolVersion, java.lang.Integer exerciseID, java.lang.Integer pduType, java.lang.Integer protocolFamily, java.lang.Long timestamp, java.lang.Integer pduLength, java.lang.Integer padding, com.cohesionforce.dis.avro.EntityID requestingEntityID, com.cohesionforce.dis.avro.EntityID servicingEntityID, java.lang.Integer serviceTypeRequested, java.lang.Integer numberOfSupplies, java.lang.Integer serviceRequestPadding, java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> supplies) {
    this.reception_timestamp = reception_timestamp;
    this.source_timestamp = source_timestamp;
    this.protocolVersion = protocolVersion;
    this.exerciseID = exerciseID;
    this.pduType = pduType;
    this.protocolFamily = protocolFamily;
    this.timestamp = timestamp;
    this.pduLength = pduLength;
    this.padding = padding;
    this.requestingEntityID = requestingEntityID;
    this.servicingEntityID = servicingEntityID;
    this.serviceTypeRequested = serviceTypeRequested;
    this.numberOfSupplies = numberOfSupplies;
    this.serviceRequestPadding = serviceRequestPadding;
    this.supplies = supplies;
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
    case 9: return requestingEntityID;
    case 10: return servicingEntityID;
    case 11: return serviceTypeRequested;
    case 12: return numberOfSupplies;
    case 13: return serviceRequestPadding;
    case 14: return supplies;
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
    case 9: requestingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 10: servicingEntityID = (com.cohesionforce.dis.avro.EntityID)value$; break;
    case 11: serviceTypeRequested = (java.lang.Integer)value$; break;
    case 12: numberOfSupplies = (java.lang.Integer)value$; break;
    case 13: serviceRequestPadding = (java.lang.Integer)value$; break;
    case 14: supplies = (java.util.List<com.cohesionforce.dis.avro.SupplyQuantity>)value$; break;
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
   * Gets the value of the 'requestingEntityID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getRequestingEntityID() {
    return requestingEntityID;
  }

  /**
   * Sets the value of the 'requestingEntityID' field.
   * @param value the value to set.
   */
  public void setRequestingEntityID(com.cohesionforce.dis.avro.EntityID value) {
    this.requestingEntityID = value;
  }

  /**
   * Gets the value of the 'servicingEntityID' field.
   */
  public com.cohesionforce.dis.avro.EntityID getServicingEntityID() {
    return servicingEntityID;
  }

  /**
   * Sets the value of the 'servicingEntityID' field.
   * @param value the value to set.
   */
  public void setServicingEntityID(com.cohesionforce.dis.avro.EntityID value) {
    this.servicingEntityID = value;
  }

  /**
   * Gets the value of the 'serviceTypeRequested' field.
   */
  public java.lang.Integer getServiceTypeRequested() {
    return serviceTypeRequested;
  }

  /**
   * Sets the value of the 'serviceTypeRequested' field.
   * @param value the value to set.
   */
  public void setServiceTypeRequested(java.lang.Integer value) {
    this.serviceTypeRequested = value;
  }

  /**
   * Gets the value of the 'numberOfSupplies' field.
   */
  public java.lang.Integer getNumberOfSupplies() {
    return numberOfSupplies;
  }

  /**
   * Sets the value of the 'numberOfSupplies' field.
   * @param value the value to set.
   */
  public void setNumberOfSupplies(java.lang.Integer value) {
    this.numberOfSupplies = value;
  }

  /**
   * Gets the value of the 'serviceRequestPadding' field.
   */
  public java.lang.Integer getServiceRequestPadding() {
    return serviceRequestPadding;
  }

  /**
   * Sets the value of the 'serviceRequestPadding' field.
   * @param value the value to set.
   */
  public void setServiceRequestPadding(java.lang.Integer value) {
    this.serviceRequestPadding = value;
  }

  /**
   * Gets the value of the 'supplies' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> getSupplies() {
    return supplies;
  }

  /**
   * Sets the value of the 'supplies' field.
   * @param value the value to set.
   */
  public void setSupplies(java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> value) {
    this.supplies = value;
  }

  /** Creates a new ServiceRequestPdu RecordBuilder */
  public static com.cohesionforce.dis.avro.ServiceRequestPdu.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ServiceRequestPdu.Builder();
  }
  
  /** Creates a new ServiceRequestPdu RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ServiceRequestPdu.Builder newBuilder(com.cohesionforce.dis.avro.ServiceRequestPdu.Builder other) {
    return new com.cohesionforce.dis.avro.ServiceRequestPdu.Builder(other);
  }
  
  /** Creates a new ServiceRequestPdu RecordBuilder by copying an existing ServiceRequestPdu instance */
  public static com.cohesionforce.dis.avro.ServiceRequestPdu.Builder newBuilder(com.cohesionforce.dis.avro.ServiceRequestPdu other) {
    return new com.cohesionforce.dis.avro.ServiceRequestPdu.Builder(other);
  }
  
  /**
   * RecordBuilder for ServiceRequestPdu instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ServiceRequestPdu>
    implements org.apache.avro.data.RecordBuilder<ServiceRequestPdu> {

    private com.cohesionforce.dis.avro.Time_t reception_timestamp;
    private com.cohesionforce.dis.avro.Time_t source_timestamp;
    private int protocolVersion;
    private int exerciseID;
    private int pduType;
    private int protocolFamily;
    private long timestamp;
    private int pduLength;
    private int padding;
    private com.cohesionforce.dis.avro.EntityID requestingEntityID;
    private com.cohesionforce.dis.avro.EntityID servicingEntityID;
    private int serviceTypeRequested;
    private int numberOfSupplies;
    private int serviceRequestPadding;
    private java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> supplies;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ServiceRequestPdu.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ServiceRequestPdu.Builder other) {
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
      if (isValidValue(fields()[9], other.requestingEntityID)) {
        this.requestingEntityID = data().deepCopy(fields()[9].schema(), other.requestingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.servicingEntityID)) {
        this.servicingEntityID = data().deepCopy(fields()[10].schema(), other.servicingEntityID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.serviceTypeRequested)) {
        this.serviceTypeRequested = data().deepCopy(fields()[11].schema(), other.serviceTypeRequested);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.numberOfSupplies)) {
        this.numberOfSupplies = data().deepCopy(fields()[12].schema(), other.numberOfSupplies);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.serviceRequestPadding)) {
        this.serviceRequestPadding = data().deepCopy(fields()[13].schema(), other.serviceRequestPadding);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.supplies)) {
        this.supplies = data().deepCopy(fields()[14].schema(), other.supplies);
        fieldSetFlags()[14] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ServiceRequestPdu instance */
    private Builder(com.cohesionforce.dis.avro.ServiceRequestPdu other) {
            super(com.cohesionforce.dis.avro.ServiceRequestPdu.SCHEMA$);
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
      if (isValidValue(fields()[9], other.requestingEntityID)) {
        this.requestingEntityID = data().deepCopy(fields()[9].schema(), other.requestingEntityID);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.servicingEntityID)) {
        this.servicingEntityID = data().deepCopy(fields()[10].schema(), other.servicingEntityID);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.serviceTypeRequested)) {
        this.serviceTypeRequested = data().deepCopy(fields()[11].schema(), other.serviceTypeRequested);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.numberOfSupplies)) {
        this.numberOfSupplies = data().deepCopy(fields()[12].schema(), other.numberOfSupplies);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.serviceRequestPadding)) {
        this.serviceRequestPadding = data().deepCopy(fields()[13].schema(), other.serviceRequestPadding);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.supplies)) {
        this.supplies = data().deepCopy(fields()[14].schema(), other.supplies);
        fieldSetFlags()[14] = true;
      }
    }

    /** Gets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getReceptionTimestamp() {
      return reception_timestamp;
    }
    
    /** Sets the value of the 'reception_timestamp' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setReceptionTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearReceptionTimestamp() {
      reception_timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.Time_t getSourceTimestamp() {
      return source_timestamp;
    }
    
    /** Sets the value of the 'source_timestamp' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setSourceTimestamp(com.cohesionforce.dis.avro.Time_t value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearSourceTimestamp() {
      source_timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'protocolVersion' field */
    public java.lang.Integer getProtocolVersion() {
      return protocolVersion;
    }
    
    /** Sets the value of the 'protocolVersion' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setProtocolVersion(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearProtocolVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'exerciseID' field */
    public java.lang.Integer getExerciseID() {
      return exerciseID;
    }
    
    /** Sets the value of the 'exerciseID' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setExerciseID(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearExerciseID() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pduType' field */
    public java.lang.Integer getPduType() {
      return pduType;
    }
    
    /** Sets the value of the 'pduType' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setPduType(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearPduType() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'protocolFamily' field */
    public java.lang.Integer getProtocolFamily() {
      return protocolFamily;
    }
    
    /** Sets the value of the 'protocolFamily' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setProtocolFamily(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearProtocolFamily() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setTimestamp(long value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearTimestamp() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pduLength' field */
    public java.lang.Integer getPduLength() {
      return pduLength;
    }
    
    /** Sets the value of the 'pduLength' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setPduLength(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearPduLength() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'padding' field */
    public java.lang.Integer getPadding() {
      return padding;
    }
    
    /** Sets the value of the 'padding' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setPadding(int value) {
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
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearPadding() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'requestingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getRequestingEntityID() {
      return requestingEntityID;
    }
    
    /** Sets the value of the 'requestingEntityID' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setRequestingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[9], value);
      this.requestingEntityID = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'requestingEntityID' field has been set */
    public boolean hasRequestingEntityID() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'requestingEntityID' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearRequestingEntityID() {
      requestingEntityID = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'servicingEntityID' field */
    public com.cohesionforce.dis.avro.EntityID getServicingEntityID() {
      return servicingEntityID;
    }
    
    /** Sets the value of the 'servicingEntityID' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setServicingEntityID(com.cohesionforce.dis.avro.EntityID value) {
      validate(fields()[10], value);
      this.servicingEntityID = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'servicingEntityID' field has been set */
    public boolean hasServicingEntityID() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'servicingEntityID' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearServicingEntityID() {
      servicingEntityID = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'serviceTypeRequested' field */
    public java.lang.Integer getServiceTypeRequested() {
      return serviceTypeRequested;
    }
    
    /** Sets the value of the 'serviceTypeRequested' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setServiceTypeRequested(int value) {
      validate(fields()[11], value);
      this.serviceTypeRequested = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'serviceTypeRequested' field has been set */
    public boolean hasServiceTypeRequested() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'serviceTypeRequested' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearServiceTypeRequested() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'numberOfSupplies' field */
    public java.lang.Integer getNumberOfSupplies() {
      return numberOfSupplies;
    }
    
    /** Sets the value of the 'numberOfSupplies' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setNumberOfSupplies(int value) {
      validate(fields()[12], value);
      this.numberOfSupplies = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfSupplies' field has been set */
    public boolean hasNumberOfSupplies() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'numberOfSupplies' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearNumberOfSupplies() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'serviceRequestPadding' field */
    public java.lang.Integer getServiceRequestPadding() {
      return serviceRequestPadding;
    }
    
    /** Sets the value of the 'serviceRequestPadding' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setServiceRequestPadding(int value) {
      validate(fields()[13], value);
      this.serviceRequestPadding = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'serviceRequestPadding' field has been set */
    public boolean hasServiceRequestPadding() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'serviceRequestPadding' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearServiceRequestPadding() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'supplies' field */
    public java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> getSupplies() {
      return supplies;
    }
    
    /** Sets the value of the 'supplies' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder setSupplies(java.util.List<com.cohesionforce.dis.avro.SupplyQuantity> value) {
      validate(fields()[14], value);
      this.supplies = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'supplies' field has been set */
    public boolean hasSupplies() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'supplies' field */
    public com.cohesionforce.dis.avro.ServiceRequestPdu.Builder clearSupplies() {
      supplies = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    public ServiceRequestPdu build() {
      try {
        ServiceRequestPdu record = new ServiceRequestPdu();
        record.reception_timestamp = fieldSetFlags()[0] ? this.reception_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[0]);
        record.source_timestamp = fieldSetFlags()[1] ? this.source_timestamp : (com.cohesionforce.dis.avro.Time_t) defaultValue(fields()[1]);
        record.protocolVersion = fieldSetFlags()[2] ? this.protocolVersion : (java.lang.Integer) defaultValue(fields()[2]);
        record.exerciseID = fieldSetFlags()[3] ? this.exerciseID : (java.lang.Integer) defaultValue(fields()[3]);
        record.pduType = fieldSetFlags()[4] ? this.pduType : (java.lang.Integer) defaultValue(fields()[4]);
        record.protocolFamily = fieldSetFlags()[5] ? this.protocolFamily : (java.lang.Integer) defaultValue(fields()[5]);
        record.timestamp = fieldSetFlags()[6] ? this.timestamp : (java.lang.Long) defaultValue(fields()[6]);
        record.pduLength = fieldSetFlags()[7] ? this.pduLength : (java.lang.Integer) defaultValue(fields()[7]);
        record.padding = fieldSetFlags()[8] ? this.padding : (java.lang.Integer) defaultValue(fields()[8]);
        record.requestingEntityID = fieldSetFlags()[9] ? this.requestingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[9]);
        record.servicingEntityID = fieldSetFlags()[10] ? this.servicingEntityID : (com.cohesionforce.dis.avro.EntityID) defaultValue(fields()[10]);
        record.serviceTypeRequested = fieldSetFlags()[11] ? this.serviceTypeRequested : (java.lang.Integer) defaultValue(fields()[11]);
        record.numberOfSupplies = fieldSetFlags()[12] ? this.numberOfSupplies : (java.lang.Integer) defaultValue(fields()[12]);
        record.serviceRequestPadding = fieldSetFlags()[13] ? this.serviceRequestPadding : (java.lang.Integer) defaultValue(fields()[13]);
        record.supplies = fieldSetFlags()[14] ? this.supplies : (java.util.List<com.cohesionforce.dis.avro.SupplyQuantity>) defaultValue(fields()[14]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}