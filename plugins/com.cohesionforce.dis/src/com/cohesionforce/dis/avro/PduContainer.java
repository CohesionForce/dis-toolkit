/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PduContainer extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PduContainer\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"numberOfPdus\",\"type\":\"int\"},{\"name\":\"pdus\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Pdu\",\"fields\":[{\"name\":\"protocolVersion\",\"type\":\"int\"},{\"name\":\"exerciseID\",\"type\":\"int\"},{\"name\":\"pduType\",\"type\":\"int\"},{\"name\":\"protocolFamily\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"pduLength\",\"type\":\"int\"},{\"name\":\"padding\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int numberOfPdus;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.Pdu> pdus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public PduContainer() {}

  /**
   * All-args constructor.
   */
  public PduContainer(java.lang.Integer numberOfPdus, java.util.List<com.cohesionforce.dis.avro.Pdu> pdus) {
    this.numberOfPdus = numberOfPdus;
    this.pdus = pdus;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return numberOfPdus;
    case 1: return pdus;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: numberOfPdus = (java.lang.Integer)value$; break;
    case 1: pdus = (java.util.List<com.cohesionforce.dis.avro.Pdu>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'numberOfPdus' field.
   */
  public java.lang.Integer getNumberOfPdus() {
    return numberOfPdus;
  }

  /**
   * Sets the value of the 'numberOfPdus' field.
   * @param value the value to set.
   */
  public void setNumberOfPdus(java.lang.Integer value) {
    this.numberOfPdus = value;
  }

  /**
   * Gets the value of the 'pdus' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.Pdu> getPdus() {
    return pdus;
  }

  /**
   * Sets the value of the 'pdus' field.
   * @param value the value to set.
   */
  public void setPdus(java.util.List<com.cohesionforce.dis.avro.Pdu> value) {
    this.pdus = value;
  }

  /** Creates a new PduContainer RecordBuilder */
  public static com.cohesionforce.dis.avro.PduContainer.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.PduContainer.Builder();
  }
  
  /** Creates a new PduContainer RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.PduContainer.Builder newBuilder(com.cohesionforce.dis.avro.PduContainer.Builder other) {
    return new com.cohesionforce.dis.avro.PduContainer.Builder(other);
  }
  
  /** Creates a new PduContainer RecordBuilder by copying an existing PduContainer instance */
  public static com.cohesionforce.dis.avro.PduContainer.Builder newBuilder(com.cohesionforce.dis.avro.PduContainer other) {
    return new com.cohesionforce.dis.avro.PduContainer.Builder(other);
  }
  
  /**
   * RecordBuilder for PduContainer instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PduContainer>
    implements org.apache.avro.data.RecordBuilder<PduContainer> {

    private int numberOfPdus;
    private java.util.List<com.cohesionforce.dis.avro.Pdu> pdus;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.PduContainer.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.PduContainer.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.numberOfPdus)) {
        this.numberOfPdus = data().deepCopy(fields()[0].schema(), other.numberOfPdus);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pdus)) {
        this.pdus = data().deepCopy(fields()[1].schema(), other.pdus);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing PduContainer instance */
    private Builder(com.cohesionforce.dis.avro.PduContainer other) {
            super(com.cohesionforce.dis.avro.PduContainer.SCHEMA$);
      if (isValidValue(fields()[0], other.numberOfPdus)) {
        this.numberOfPdus = data().deepCopy(fields()[0].schema(), other.numberOfPdus);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pdus)) {
        this.pdus = data().deepCopy(fields()[1].schema(), other.pdus);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'numberOfPdus' field */
    public java.lang.Integer getNumberOfPdus() {
      return numberOfPdus;
    }
    
    /** Sets the value of the 'numberOfPdus' field */
    public com.cohesionforce.dis.avro.PduContainer.Builder setNumberOfPdus(int value) {
      validate(fields()[0], value);
      this.numberOfPdus = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfPdus' field has been set */
    public boolean hasNumberOfPdus() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'numberOfPdus' field */
    public com.cohesionforce.dis.avro.PduContainer.Builder clearNumberOfPdus() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'pdus' field */
    public java.util.List<com.cohesionforce.dis.avro.Pdu> getPdus() {
      return pdus;
    }
    
    /** Sets the value of the 'pdus' field */
    public com.cohesionforce.dis.avro.PduContainer.Builder setPdus(java.util.List<com.cohesionforce.dis.avro.Pdu> value) {
      validate(fields()[1], value);
      this.pdus = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'pdus' field has been set */
    public boolean hasPdus() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'pdus' field */
    public com.cohesionforce.dis.avro.PduContainer.Builder clearPdus() {
      pdus = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public PduContainer build() {
      try {
        PduContainer record = new PduContainer();
        record.numberOfPdus = fieldSetFlags()[0] ? this.numberOfPdus : (java.lang.Integer) defaultValue(fields()[0]);
        record.pdus = fieldSetFlags()[1] ? this.pdus : (java.util.List<com.cohesionforce.dis.avro.Pdu>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}