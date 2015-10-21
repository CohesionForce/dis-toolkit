/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AcousticBeamData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AcousticBeamData\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"beamDataLength\",\"type\":\"int\"},{\"name\":\"beamIDNumber\",\"type\":\"int\"},{\"name\":\"pad2\",\"type\":\"int\"},{\"name\":\"fundamentalDataParameters\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"AcousticBeamFundamentalParameter\",\"fields\":[{\"name\":\"activeEmissionParameterIndex\",\"type\":\"int\"},{\"name\":\"scanPattern\",\"type\":\"int\"},{\"name\":\"beamCenterAzimuth\",\"type\":\"float\"},{\"name\":\"azimuthalBeamwidth\",\"type\":\"float\"},{\"name\":\"beamCenterDE\",\"type\":\"float\"},{\"name\":\"deBeamwidth\",\"type\":\"float\"}]}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int beamDataLength;
  @Deprecated public int beamIDNumber;
  @Deprecated public int pad2;
  @Deprecated public com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter fundamentalDataParameters;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AcousticBeamData() {}

  /**
   * All-args constructor.
   */
  public AcousticBeamData(java.lang.Integer beamDataLength, java.lang.Integer beamIDNumber, java.lang.Integer pad2, com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter fundamentalDataParameters) {
    this.beamDataLength = beamDataLength;
    this.beamIDNumber = beamIDNumber;
    this.pad2 = pad2;
    this.fundamentalDataParameters = fundamentalDataParameters;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return beamDataLength;
    case 1: return beamIDNumber;
    case 2: return pad2;
    case 3: return fundamentalDataParameters;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: beamDataLength = (java.lang.Integer)value$; break;
    case 1: beamIDNumber = (java.lang.Integer)value$; break;
    case 2: pad2 = (java.lang.Integer)value$; break;
    case 3: fundamentalDataParameters = (com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'beamDataLength' field.
   */
  public java.lang.Integer getBeamDataLength() {
    return beamDataLength;
  }

  /**
   * Sets the value of the 'beamDataLength' field.
   * @param value the value to set.
   */
  public void setBeamDataLength(java.lang.Integer value) {
    this.beamDataLength = value;
  }

  /**
   * Gets the value of the 'beamIDNumber' field.
   */
  public java.lang.Integer getBeamIDNumber() {
    return beamIDNumber;
  }

  /**
   * Sets the value of the 'beamIDNumber' field.
   * @param value the value to set.
   */
  public void setBeamIDNumber(java.lang.Integer value) {
    this.beamIDNumber = value;
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
   * Gets the value of the 'fundamentalDataParameters' field.
   */
  public com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter getFundamentalDataParameters() {
    return fundamentalDataParameters;
  }

  /**
   * Sets the value of the 'fundamentalDataParameters' field.
   * @param value the value to set.
   */
  public void setFundamentalDataParameters(com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter value) {
    this.fundamentalDataParameters = value;
  }

  /** Creates a new AcousticBeamData RecordBuilder */
  public static com.cohesionforce.dis.avro.AcousticBeamData.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.AcousticBeamData.Builder();
  }
  
  /** Creates a new AcousticBeamData RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.AcousticBeamData.Builder newBuilder(com.cohesionforce.dis.avro.AcousticBeamData.Builder other) {
    return new com.cohesionforce.dis.avro.AcousticBeamData.Builder(other);
  }
  
  /** Creates a new AcousticBeamData RecordBuilder by copying an existing AcousticBeamData instance */
  public static com.cohesionforce.dis.avro.AcousticBeamData.Builder newBuilder(com.cohesionforce.dis.avro.AcousticBeamData other) {
    return new com.cohesionforce.dis.avro.AcousticBeamData.Builder(other);
  }
  
  /**
   * RecordBuilder for AcousticBeamData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AcousticBeamData>
    implements org.apache.avro.data.RecordBuilder<AcousticBeamData> {

    private int beamDataLength;
    private int beamIDNumber;
    private int pad2;
    private com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter fundamentalDataParameters;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.AcousticBeamData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.AcousticBeamData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.beamDataLength)) {
        this.beamDataLength = data().deepCopy(fields()[0].schema(), other.beamDataLength);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamIDNumber)) {
        this.beamIDNumber = data().deepCopy(fields()[1].schema(), other.beamIDNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[2].schema(), other.pad2);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fundamentalDataParameters)) {
        this.fundamentalDataParameters = data().deepCopy(fields()[3].schema(), other.fundamentalDataParameters);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing AcousticBeamData instance */
    private Builder(com.cohesionforce.dis.avro.AcousticBeamData other) {
            super(com.cohesionforce.dis.avro.AcousticBeamData.SCHEMA$);
      if (isValidValue(fields()[0], other.beamDataLength)) {
        this.beamDataLength = data().deepCopy(fields()[0].schema(), other.beamDataLength);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamIDNumber)) {
        this.beamIDNumber = data().deepCopy(fields()[1].schema(), other.beamIDNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pad2)) {
        this.pad2 = data().deepCopy(fields()[2].schema(), other.pad2);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fundamentalDataParameters)) {
        this.fundamentalDataParameters = data().deepCopy(fields()[3].schema(), other.fundamentalDataParameters);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'beamDataLength' field */
    public java.lang.Integer getBeamDataLength() {
      return beamDataLength;
    }
    
    /** Sets the value of the 'beamDataLength' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder setBeamDataLength(int value) {
      validate(fields()[0], value);
      this.beamDataLength = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'beamDataLength' field has been set */
    public boolean hasBeamDataLength() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'beamDataLength' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder clearBeamDataLength() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'beamIDNumber' field */
    public java.lang.Integer getBeamIDNumber() {
      return beamIDNumber;
    }
    
    /** Sets the value of the 'beamIDNumber' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder setBeamIDNumber(int value) {
      validate(fields()[1], value);
      this.beamIDNumber = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'beamIDNumber' field has been set */
    public boolean hasBeamIDNumber() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'beamIDNumber' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder clearBeamIDNumber() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'pad2' field */
    public java.lang.Integer getPad2() {
      return pad2;
    }
    
    /** Sets the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder setPad2(int value) {
      validate(fields()[2], value);
      this.pad2 = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'pad2' field has been set */
    public boolean hasPad2() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'pad2' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder clearPad2() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'fundamentalDataParameters' field */
    public com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter getFundamentalDataParameters() {
      return fundamentalDataParameters;
    }
    
    /** Sets the value of the 'fundamentalDataParameters' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder setFundamentalDataParameters(com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter value) {
      validate(fields()[3], value);
      this.fundamentalDataParameters = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'fundamentalDataParameters' field has been set */
    public boolean hasFundamentalDataParameters() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'fundamentalDataParameters' field */
    public com.cohesionforce.dis.avro.AcousticBeamData.Builder clearFundamentalDataParameters() {
      fundamentalDataParameters = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public AcousticBeamData build() {
      try {
        AcousticBeamData record = new AcousticBeamData();
        record.beamDataLength = fieldSetFlags()[0] ? this.beamDataLength : (java.lang.Integer) defaultValue(fields()[0]);
        record.beamIDNumber = fieldSetFlags()[1] ? this.beamIDNumber : (java.lang.Integer) defaultValue(fields()[1]);
        record.pad2 = fieldSetFlags()[2] ? this.pad2 : (java.lang.Integer) defaultValue(fields()[2]);
        record.fundamentalDataParameters = fieldSetFlags()[3] ? this.fundamentalDataParameters : (com.cohesionforce.dis.avro.AcousticBeamFundamentalParameter) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}