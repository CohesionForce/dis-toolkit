/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ElectronicEmissionBeamData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ElectronicEmissionBeamData\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"beamDataLength\",\"type\":\"int\"},{\"name\":\"beamIDNumber\",\"type\":\"int\"},{\"name\":\"beamParameterIndex\",\"type\":\"int\"},{\"name\":\"fundamentalParameterData\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"FundamentalParameterData\",\"fields\":[{\"name\":\"frequency\",\"type\":\"float\"},{\"name\":\"frequencyRange\",\"type\":\"float\"},{\"name\":\"effectiveRadiatedPower\",\"type\":\"float\"},{\"name\":\"pulseRepetitionFrequency\",\"type\":\"float\"},{\"name\":\"pulseWidth\",\"type\":\"float\"},{\"name\":\"beamAzimuthCenter\",\"type\":\"float\"},{\"name\":\"beamAzimuthSweep\",\"type\":\"float\"},{\"name\":\"beamElevationCenter\",\"type\":\"float\"},{\"name\":\"beamElevationSweep\",\"type\":\"float\"},{\"name\":\"beamSweepSync\",\"type\":\"float\"}]}]},{\"name\":\"beamFunction\",\"type\":\"int\"},{\"name\":\"numberOfTrackJamTargets\",\"type\":\"int\"},{\"name\":\"highDensityTrackJam\",\"type\":\"int\"},{\"name\":\"pad4\",\"type\":\"int\"},{\"name\":\"jammingModeSequence\",\"type\":\"long\"},{\"name\":\"trackJamTargets\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TrackJamTarget\",\"fields\":[{\"name\":\"trackJam\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"EntityID\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}]},{\"name\":\"emitterID\",\"type\":\"int\"},{\"name\":\"beamID\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int beamDataLength;
  @Deprecated public int beamIDNumber;
  @Deprecated public int beamParameterIndex;
  @Deprecated public com.cohesionforce.dis.avro.FundamentalParameterData fundamentalParameterData;
  @Deprecated public int beamFunction;
  @Deprecated public int numberOfTrackJamTargets;
  @Deprecated public int highDensityTrackJam;
  @Deprecated public int pad4;
  @Deprecated public long jammingModeSequence;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> trackJamTargets;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ElectronicEmissionBeamData() {}

  /**
   * All-args constructor.
   */
  public ElectronicEmissionBeamData(java.lang.Integer beamDataLength, java.lang.Integer beamIDNumber, java.lang.Integer beamParameterIndex, com.cohesionforce.dis.avro.FundamentalParameterData fundamentalParameterData, java.lang.Integer beamFunction, java.lang.Integer numberOfTrackJamTargets, java.lang.Integer highDensityTrackJam, java.lang.Integer pad4, java.lang.Long jammingModeSequence, java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> trackJamTargets) {
    this.beamDataLength = beamDataLength;
    this.beamIDNumber = beamIDNumber;
    this.beamParameterIndex = beamParameterIndex;
    this.fundamentalParameterData = fundamentalParameterData;
    this.beamFunction = beamFunction;
    this.numberOfTrackJamTargets = numberOfTrackJamTargets;
    this.highDensityTrackJam = highDensityTrackJam;
    this.pad4 = pad4;
    this.jammingModeSequence = jammingModeSequence;
    this.trackJamTargets = trackJamTargets;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return beamDataLength;
    case 1: return beamIDNumber;
    case 2: return beamParameterIndex;
    case 3: return fundamentalParameterData;
    case 4: return beamFunction;
    case 5: return numberOfTrackJamTargets;
    case 6: return highDensityTrackJam;
    case 7: return pad4;
    case 8: return jammingModeSequence;
    case 9: return trackJamTargets;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: beamDataLength = (java.lang.Integer)value$; break;
    case 1: beamIDNumber = (java.lang.Integer)value$; break;
    case 2: beamParameterIndex = (java.lang.Integer)value$; break;
    case 3: fundamentalParameterData = (com.cohesionforce.dis.avro.FundamentalParameterData)value$; break;
    case 4: beamFunction = (java.lang.Integer)value$; break;
    case 5: numberOfTrackJamTargets = (java.lang.Integer)value$; break;
    case 6: highDensityTrackJam = (java.lang.Integer)value$; break;
    case 7: pad4 = (java.lang.Integer)value$; break;
    case 8: jammingModeSequence = (java.lang.Long)value$; break;
    case 9: trackJamTargets = (java.util.List<com.cohesionforce.dis.avro.TrackJamTarget>)value$; break;
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
   * Gets the value of the 'beamParameterIndex' field.
   */
  public java.lang.Integer getBeamParameterIndex() {
    return beamParameterIndex;
  }

  /**
   * Sets the value of the 'beamParameterIndex' field.
   * @param value the value to set.
   */
  public void setBeamParameterIndex(java.lang.Integer value) {
    this.beamParameterIndex = value;
  }

  /**
   * Gets the value of the 'fundamentalParameterData' field.
   */
  public com.cohesionforce.dis.avro.FundamentalParameterData getFundamentalParameterData() {
    return fundamentalParameterData;
  }

  /**
   * Sets the value of the 'fundamentalParameterData' field.
   * @param value the value to set.
   */
  public void setFundamentalParameterData(com.cohesionforce.dis.avro.FundamentalParameterData value) {
    this.fundamentalParameterData = value;
  }

  /**
   * Gets the value of the 'beamFunction' field.
   */
  public java.lang.Integer getBeamFunction() {
    return beamFunction;
  }

  /**
   * Sets the value of the 'beamFunction' field.
   * @param value the value to set.
   */
  public void setBeamFunction(java.lang.Integer value) {
    this.beamFunction = value;
  }

  /**
   * Gets the value of the 'numberOfTrackJamTargets' field.
   */
  public java.lang.Integer getNumberOfTrackJamTargets() {
    return numberOfTrackJamTargets;
  }

  /**
   * Sets the value of the 'numberOfTrackJamTargets' field.
   * @param value the value to set.
   */
  public void setNumberOfTrackJamTargets(java.lang.Integer value) {
    this.numberOfTrackJamTargets = value;
  }

  /**
   * Gets the value of the 'highDensityTrackJam' field.
   */
  public java.lang.Integer getHighDensityTrackJam() {
    return highDensityTrackJam;
  }

  /**
   * Sets the value of the 'highDensityTrackJam' field.
   * @param value the value to set.
   */
  public void setHighDensityTrackJam(java.lang.Integer value) {
    this.highDensityTrackJam = value;
  }

  /**
   * Gets the value of the 'pad4' field.
   */
  public java.lang.Integer getPad4() {
    return pad4;
  }

  /**
   * Sets the value of the 'pad4' field.
   * @param value the value to set.
   */
  public void setPad4(java.lang.Integer value) {
    this.pad4 = value;
  }

  /**
   * Gets the value of the 'jammingModeSequence' field.
   */
  public java.lang.Long getJammingModeSequence() {
    return jammingModeSequence;
  }

  /**
   * Sets the value of the 'jammingModeSequence' field.
   * @param value the value to set.
   */
  public void setJammingModeSequence(java.lang.Long value) {
    this.jammingModeSequence = value;
  }

  /**
   * Gets the value of the 'trackJamTargets' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> getTrackJamTargets() {
    return trackJamTargets;
  }

  /**
   * Sets the value of the 'trackJamTargets' field.
   * @param value the value to set.
   */
  public void setTrackJamTargets(java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> value) {
    this.trackJamTargets = value;
  }

  /** Creates a new ElectronicEmissionBeamData RecordBuilder */
  public static com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder();
  }
  
  /** Creates a new ElectronicEmissionBeamData RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder newBuilder(com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder other) {
    return new com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder(other);
  }
  
  /** Creates a new ElectronicEmissionBeamData RecordBuilder by copying an existing ElectronicEmissionBeamData instance */
  public static com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder newBuilder(com.cohesionforce.dis.avro.ElectronicEmissionBeamData other) {
    return new com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder(other);
  }
  
  /**
   * RecordBuilder for ElectronicEmissionBeamData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ElectronicEmissionBeamData>
    implements org.apache.avro.data.RecordBuilder<ElectronicEmissionBeamData> {

    private int beamDataLength;
    private int beamIDNumber;
    private int beamParameterIndex;
    private com.cohesionforce.dis.avro.FundamentalParameterData fundamentalParameterData;
    private int beamFunction;
    private int numberOfTrackJamTargets;
    private int highDensityTrackJam;
    private int pad4;
    private long jammingModeSequence;
    private java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> trackJamTargets;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ElectronicEmissionBeamData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.beamDataLength)) {
        this.beamDataLength = data().deepCopy(fields()[0].schema(), other.beamDataLength);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamIDNumber)) {
        this.beamIDNumber = data().deepCopy(fields()[1].schema(), other.beamIDNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.beamParameterIndex)) {
        this.beamParameterIndex = data().deepCopy(fields()[2].schema(), other.beamParameterIndex);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fundamentalParameterData)) {
        this.fundamentalParameterData = data().deepCopy(fields()[3].schema(), other.fundamentalParameterData);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.beamFunction)) {
        this.beamFunction = data().deepCopy(fields()[4].schema(), other.beamFunction);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.numberOfTrackJamTargets)) {
        this.numberOfTrackJamTargets = data().deepCopy(fields()[5].schema(), other.numberOfTrackJamTargets);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.highDensityTrackJam)) {
        this.highDensityTrackJam = data().deepCopy(fields()[6].schema(), other.highDensityTrackJam);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.pad4)) {
        this.pad4 = data().deepCopy(fields()[7].schema(), other.pad4);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.jammingModeSequence)) {
        this.jammingModeSequence = data().deepCopy(fields()[8].schema(), other.jammingModeSequence);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.trackJamTargets)) {
        this.trackJamTargets = data().deepCopy(fields()[9].schema(), other.trackJamTargets);
        fieldSetFlags()[9] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ElectronicEmissionBeamData instance */
    private Builder(com.cohesionforce.dis.avro.ElectronicEmissionBeamData other) {
            super(com.cohesionforce.dis.avro.ElectronicEmissionBeamData.SCHEMA$);
      if (isValidValue(fields()[0], other.beamDataLength)) {
        this.beamDataLength = data().deepCopy(fields()[0].schema(), other.beamDataLength);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamIDNumber)) {
        this.beamIDNumber = data().deepCopy(fields()[1].schema(), other.beamIDNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.beamParameterIndex)) {
        this.beamParameterIndex = data().deepCopy(fields()[2].schema(), other.beamParameterIndex);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fundamentalParameterData)) {
        this.fundamentalParameterData = data().deepCopy(fields()[3].schema(), other.fundamentalParameterData);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.beamFunction)) {
        this.beamFunction = data().deepCopy(fields()[4].schema(), other.beamFunction);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.numberOfTrackJamTargets)) {
        this.numberOfTrackJamTargets = data().deepCopy(fields()[5].schema(), other.numberOfTrackJamTargets);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.highDensityTrackJam)) {
        this.highDensityTrackJam = data().deepCopy(fields()[6].schema(), other.highDensityTrackJam);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.pad4)) {
        this.pad4 = data().deepCopy(fields()[7].schema(), other.pad4);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.jammingModeSequence)) {
        this.jammingModeSequence = data().deepCopy(fields()[8].schema(), other.jammingModeSequence);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.trackJamTargets)) {
        this.trackJamTargets = data().deepCopy(fields()[9].schema(), other.trackJamTargets);
        fieldSetFlags()[9] = true;
      }
    }

    /** Gets the value of the 'beamDataLength' field */
    public java.lang.Integer getBeamDataLength() {
      return beamDataLength;
    }
    
    /** Sets the value of the 'beamDataLength' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setBeamDataLength(int value) {
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
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearBeamDataLength() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'beamIDNumber' field */
    public java.lang.Integer getBeamIDNumber() {
      return beamIDNumber;
    }
    
    /** Sets the value of the 'beamIDNumber' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setBeamIDNumber(int value) {
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
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearBeamIDNumber() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'beamParameterIndex' field */
    public java.lang.Integer getBeamParameterIndex() {
      return beamParameterIndex;
    }
    
    /** Sets the value of the 'beamParameterIndex' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setBeamParameterIndex(int value) {
      validate(fields()[2], value);
      this.beamParameterIndex = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'beamParameterIndex' field has been set */
    public boolean hasBeamParameterIndex() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'beamParameterIndex' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearBeamParameterIndex() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'fundamentalParameterData' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData getFundamentalParameterData() {
      return fundamentalParameterData;
    }
    
    /** Sets the value of the 'fundamentalParameterData' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setFundamentalParameterData(com.cohesionforce.dis.avro.FundamentalParameterData value) {
      validate(fields()[3], value);
      this.fundamentalParameterData = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'fundamentalParameterData' field has been set */
    public boolean hasFundamentalParameterData() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'fundamentalParameterData' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearFundamentalParameterData() {
      fundamentalParameterData = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'beamFunction' field */
    public java.lang.Integer getBeamFunction() {
      return beamFunction;
    }
    
    /** Sets the value of the 'beamFunction' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setBeamFunction(int value) {
      validate(fields()[4], value);
      this.beamFunction = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'beamFunction' field has been set */
    public boolean hasBeamFunction() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'beamFunction' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearBeamFunction() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'numberOfTrackJamTargets' field */
    public java.lang.Integer getNumberOfTrackJamTargets() {
      return numberOfTrackJamTargets;
    }
    
    /** Sets the value of the 'numberOfTrackJamTargets' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setNumberOfTrackJamTargets(int value) {
      validate(fields()[5], value);
      this.numberOfTrackJamTargets = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfTrackJamTargets' field has been set */
    public boolean hasNumberOfTrackJamTargets() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'numberOfTrackJamTargets' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearNumberOfTrackJamTargets() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'highDensityTrackJam' field */
    public java.lang.Integer getHighDensityTrackJam() {
      return highDensityTrackJam;
    }
    
    /** Sets the value of the 'highDensityTrackJam' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setHighDensityTrackJam(int value) {
      validate(fields()[6], value);
      this.highDensityTrackJam = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'highDensityTrackJam' field has been set */
    public boolean hasHighDensityTrackJam() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'highDensityTrackJam' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearHighDensityTrackJam() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'pad4' field */
    public java.lang.Integer getPad4() {
      return pad4;
    }
    
    /** Sets the value of the 'pad4' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setPad4(int value) {
      validate(fields()[7], value);
      this.pad4 = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'pad4' field has been set */
    public boolean hasPad4() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'pad4' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearPad4() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'jammingModeSequence' field */
    public java.lang.Long getJammingModeSequence() {
      return jammingModeSequence;
    }
    
    /** Sets the value of the 'jammingModeSequence' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setJammingModeSequence(long value) {
      validate(fields()[8], value);
      this.jammingModeSequence = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'jammingModeSequence' field has been set */
    public boolean hasJammingModeSequence() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'jammingModeSequence' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearJammingModeSequence() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'trackJamTargets' field */
    public java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> getTrackJamTargets() {
      return trackJamTargets;
    }
    
    /** Sets the value of the 'trackJamTargets' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder setTrackJamTargets(java.util.List<com.cohesionforce.dis.avro.TrackJamTarget> value) {
      validate(fields()[9], value);
      this.trackJamTargets = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'trackJamTargets' field has been set */
    public boolean hasTrackJamTargets() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'trackJamTargets' field */
    public com.cohesionforce.dis.avro.ElectronicEmissionBeamData.Builder clearTrackJamTargets() {
      trackJamTargets = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    public ElectronicEmissionBeamData build() {
      try {
        ElectronicEmissionBeamData record = new ElectronicEmissionBeamData();
        record.beamDataLength = fieldSetFlags()[0] ? this.beamDataLength : (java.lang.Integer) defaultValue(fields()[0]);
        record.beamIDNumber = fieldSetFlags()[1] ? this.beamIDNumber : (java.lang.Integer) defaultValue(fields()[1]);
        record.beamParameterIndex = fieldSetFlags()[2] ? this.beamParameterIndex : (java.lang.Integer) defaultValue(fields()[2]);
        record.fundamentalParameterData = fieldSetFlags()[3] ? this.fundamentalParameterData : (com.cohesionforce.dis.avro.FundamentalParameterData) defaultValue(fields()[3]);
        record.beamFunction = fieldSetFlags()[4] ? this.beamFunction : (java.lang.Integer) defaultValue(fields()[4]);
        record.numberOfTrackJamTargets = fieldSetFlags()[5] ? this.numberOfTrackJamTargets : (java.lang.Integer) defaultValue(fields()[5]);
        record.highDensityTrackJam = fieldSetFlags()[6] ? this.highDensityTrackJam : (java.lang.Integer) defaultValue(fields()[6]);
        record.pad4 = fieldSetFlags()[7] ? this.pad4 : (java.lang.Integer) defaultValue(fields()[7]);
        record.jammingModeSequence = fieldSetFlags()[8] ? this.jammingModeSequence : (java.lang.Long) defaultValue(fields()[8]);
        record.trackJamTargets = fieldSetFlags()[9] ? this.trackJamTargets : (java.util.List<com.cohesionforce.dis.avro.TrackJamTarget>) defaultValue(fields()[9]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}