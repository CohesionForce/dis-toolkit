/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class FundamentalParameterData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FundamentalParameterData\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"frequency\",\"type\":\"float\"},{\"name\":\"frequencyRange\",\"type\":\"float\"},{\"name\":\"effectiveRadiatedPower\",\"type\":\"float\"},{\"name\":\"pulseRepetitionFrequency\",\"type\":\"float\"},{\"name\":\"pulseWidth\",\"type\":\"float\"},{\"name\":\"beamAzimuthCenter\",\"type\":\"float\"},{\"name\":\"beamAzimuthSweep\",\"type\":\"float\"},{\"name\":\"beamElevationCenter\",\"type\":\"float\"},{\"name\":\"beamElevationSweep\",\"type\":\"float\"},{\"name\":\"beamSweepSync\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public float frequency;
  @Deprecated public float frequencyRange;
  @Deprecated public float effectiveRadiatedPower;
  @Deprecated public float pulseRepetitionFrequency;
  @Deprecated public float pulseWidth;
  @Deprecated public float beamAzimuthCenter;
  @Deprecated public float beamAzimuthSweep;
  @Deprecated public float beamElevationCenter;
  @Deprecated public float beamElevationSweep;
  @Deprecated public float beamSweepSync;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public FundamentalParameterData() {}

  /**
   * All-args constructor.
   */
  public FundamentalParameterData(java.lang.Float frequency, java.lang.Float frequencyRange, java.lang.Float effectiveRadiatedPower, java.lang.Float pulseRepetitionFrequency, java.lang.Float pulseWidth, java.lang.Float beamAzimuthCenter, java.lang.Float beamAzimuthSweep, java.lang.Float beamElevationCenter, java.lang.Float beamElevationSweep, java.lang.Float beamSweepSync) {
    this.frequency = frequency;
    this.frequencyRange = frequencyRange;
    this.effectiveRadiatedPower = effectiveRadiatedPower;
    this.pulseRepetitionFrequency = pulseRepetitionFrequency;
    this.pulseWidth = pulseWidth;
    this.beamAzimuthCenter = beamAzimuthCenter;
    this.beamAzimuthSweep = beamAzimuthSweep;
    this.beamElevationCenter = beamElevationCenter;
    this.beamElevationSweep = beamElevationSweep;
    this.beamSweepSync = beamSweepSync;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return frequency;
    case 1: return frequencyRange;
    case 2: return effectiveRadiatedPower;
    case 3: return pulseRepetitionFrequency;
    case 4: return pulseWidth;
    case 5: return beamAzimuthCenter;
    case 6: return beamAzimuthSweep;
    case 7: return beamElevationCenter;
    case 8: return beamElevationSweep;
    case 9: return beamSweepSync;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: frequency = (java.lang.Float)value$; break;
    case 1: frequencyRange = (java.lang.Float)value$; break;
    case 2: effectiveRadiatedPower = (java.lang.Float)value$; break;
    case 3: pulseRepetitionFrequency = (java.lang.Float)value$; break;
    case 4: pulseWidth = (java.lang.Float)value$; break;
    case 5: beamAzimuthCenter = (java.lang.Float)value$; break;
    case 6: beamAzimuthSweep = (java.lang.Float)value$; break;
    case 7: beamElevationCenter = (java.lang.Float)value$; break;
    case 8: beamElevationSweep = (java.lang.Float)value$; break;
    case 9: beamSweepSync = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'frequency' field.
   */
  public java.lang.Float getFrequency() {
    return frequency;
  }

  /**
   * Sets the value of the 'frequency' field.
   * @param value the value to set.
   */
  public void setFrequency(java.lang.Float value) {
    this.frequency = value;
  }

  /**
   * Gets the value of the 'frequencyRange' field.
   */
  public java.lang.Float getFrequencyRange() {
    return frequencyRange;
  }

  /**
   * Sets the value of the 'frequencyRange' field.
   * @param value the value to set.
   */
  public void setFrequencyRange(java.lang.Float value) {
    this.frequencyRange = value;
  }

  /**
   * Gets the value of the 'effectiveRadiatedPower' field.
   */
  public java.lang.Float getEffectiveRadiatedPower() {
    return effectiveRadiatedPower;
  }

  /**
   * Sets the value of the 'effectiveRadiatedPower' field.
   * @param value the value to set.
   */
  public void setEffectiveRadiatedPower(java.lang.Float value) {
    this.effectiveRadiatedPower = value;
  }

  /**
   * Gets the value of the 'pulseRepetitionFrequency' field.
   */
  public java.lang.Float getPulseRepetitionFrequency() {
    return pulseRepetitionFrequency;
  }

  /**
   * Sets the value of the 'pulseRepetitionFrequency' field.
   * @param value the value to set.
   */
  public void setPulseRepetitionFrequency(java.lang.Float value) {
    this.pulseRepetitionFrequency = value;
  }

  /**
   * Gets the value of the 'pulseWidth' field.
   */
  public java.lang.Float getPulseWidth() {
    return pulseWidth;
  }

  /**
   * Sets the value of the 'pulseWidth' field.
   * @param value the value to set.
   */
  public void setPulseWidth(java.lang.Float value) {
    this.pulseWidth = value;
  }

  /**
   * Gets the value of the 'beamAzimuthCenter' field.
   */
  public java.lang.Float getBeamAzimuthCenter() {
    return beamAzimuthCenter;
  }

  /**
   * Sets the value of the 'beamAzimuthCenter' field.
   * @param value the value to set.
   */
  public void setBeamAzimuthCenter(java.lang.Float value) {
    this.beamAzimuthCenter = value;
  }

  /**
   * Gets the value of the 'beamAzimuthSweep' field.
   */
  public java.lang.Float getBeamAzimuthSweep() {
    return beamAzimuthSweep;
  }

  /**
   * Sets the value of the 'beamAzimuthSweep' field.
   * @param value the value to set.
   */
  public void setBeamAzimuthSweep(java.lang.Float value) {
    this.beamAzimuthSweep = value;
  }

  /**
   * Gets the value of the 'beamElevationCenter' field.
   */
  public java.lang.Float getBeamElevationCenter() {
    return beamElevationCenter;
  }

  /**
   * Sets the value of the 'beamElevationCenter' field.
   * @param value the value to set.
   */
  public void setBeamElevationCenter(java.lang.Float value) {
    this.beamElevationCenter = value;
  }

  /**
   * Gets the value of the 'beamElevationSweep' field.
   */
  public java.lang.Float getBeamElevationSweep() {
    return beamElevationSweep;
  }

  /**
   * Sets the value of the 'beamElevationSweep' field.
   * @param value the value to set.
   */
  public void setBeamElevationSweep(java.lang.Float value) {
    this.beamElevationSweep = value;
  }

  /**
   * Gets the value of the 'beamSweepSync' field.
   */
  public java.lang.Float getBeamSweepSync() {
    return beamSweepSync;
  }

  /**
   * Sets the value of the 'beamSweepSync' field.
   * @param value the value to set.
   */
  public void setBeamSweepSync(java.lang.Float value) {
    this.beamSweepSync = value;
  }

  /** Creates a new FundamentalParameterData RecordBuilder */
  public static com.cohesionforce.dis.avro.FundamentalParameterData.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.FundamentalParameterData.Builder();
  }
  
  /** Creates a new FundamentalParameterData RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.FundamentalParameterData.Builder newBuilder(com.cohesionforce.dis.avro.FundamentalParameterData.Builder other) {
    return new com.cohesionforce.dis.avro.FundamentalParameterData.Builder(other);
  }
  
  /** Creates a new FundamentalParameterData RecordBuilder by copying an existing FundamentalParameterData instance */
  public static com.cohesionforce.dis.avro.FundamentalParameterData.Builder newBuilder(com.cohesionforce.dis.avro.FundamentalParameterData other) {
    return new com.cohesionforce.dis.avro.FundamentalParameterData.Builder(other);
  }
  
  /**
   * RecordBuilder for FundamentalParameterData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FundamentalParameterData>
    implements org.apache.avro.data.RecordBuilder<FundamentalParameterData> {

    private float frequency;
    private float frequencyRange;
    private float effectiveRadiatedPower;
    private float pulseRepetitionFrequency;
    private float pulseWidth;
    private float beamAzimuthCenter;
    private float beamAzimuthSweep;
    private float beamElevationCenter;
    private float beamElevationSweep;
    private float beamSweepSync;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.FundamentalParameterData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.FundamentalParameterData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.frequency)) {
        this.frequency = data().deepCopy(fields()[0].schema(), other.frequency);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.frequencyRange)) {
        this.frequencyRange = data().deepCopy(fields()[1].schema(), other.frequencyRange);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.effectiveRadiatedPower)) {
        this.effectiveRadiatedPower = data().deepCopy(fields()[2].schema(), other.effectiveRadiatedPower);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.pulseRepetitionFrequency)) {
        this.pulseRepetitionFrequency = data().deepCopy(fields()[3].schema(), other.pulseRepetitionFrequency);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.pulseWidth)) {
        this.pulseWidth = data().deepCopy(fields()[4].schema(), other.pulseWidth);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.beamAzimuthCenter)) {
        this.beamAzimuthCenter = data().deepCopy(fields()[5].schema(), other.beamAzimuthCenter);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.beamAzimuthSweep)) {
        this.beamAzimuthSweep = data().deepCopy(fields()[6].schema(), other.beamAzimuthSweep);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.beamElevationCenter)) {
        this.beamElevationCenter = data().deepCopy(fields()[7].schema(), other.beamElevationCenter);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.beamElevationSweep)) {
        this.beamElevationSweep = data().deepCopy(fields()[8].schema(), other.beamElevationSweep);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.beamSweepSync)) {
        this.beamSweepSync = data().deepCopy(fields()[9].schema(), other.beamSweepSync);
        fieldSetFlags()[9] = true;
      }
    }
    
    /** Creates a Builder by copying an existing FundamentalParameterData instance */
    private Builder(com.cohesionforce.dis.avro.FundamentalParameterData other) {
            super(com.cohesionforce.dis.avro.FundamentalParameterData.SCHEMA$);
      if (isValidValue(fields()[0], other.frequency)) {
        this.frequency = data().deepCopy(fields()[0].schema(), other.frequency);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.frequencyRange)) {
        this.frequencyRange = data().deepCopy(fields()[1].schema(), other.frequencyRange);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.effectiveRadiatedPower)) {
        this.effectiveRadiatedPower = data().deepCopy(fields()[2].schema(), other.effectiveRadiatedPower);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.pulseRepetitionFrequency)) {
        this.pulseRepetitionFrequency = data().deepCopy(fields()[3].schema(), other.pulseRepetitionFrequency);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.pulseWidth)) {
        this.pulseWidth = data().deepCopy(fields()[4].schema(), other.pulseWidth);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.beamAzimuthCenter)) {
        this.beamAzimuthCenter = data().deepCopy(fields()[5].schema(), other.beamAzimuthCenter);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.beamAzimuthSweep)) {
        this.beamAzimuthSweep = data().deepCopy(fields()[6].schema(), other.beamAzimuthSweep);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.beamElevationCenter)) {
        this.beamElevationCenter = data().deepCopy(fields()[7].schema(), other.beamElevationCenter);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.beamElevationSweep)) {
        this.beamElevationSweep = data().deepCopy(fields()[8].schema(), other.beamElevationSweep);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.beamSweepSync)) {
        this.beamSweepSync = data().deepCopy(fields()[9].schema(), other.beamSweepSync);
        fieldSetFlags()[9] = true;
      }
    }

    /** Gets the value of the 'frequency' field */
    public java.lang.Float getFrequency() {
      return frequency;
    }
    
    /** Sets the value of the 'frequency' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setFrequency(float value) {
      validate(fields()[0], value);
      this.frequency = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'frequency' field has been set */
    public boolean hasFrequency() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'frequency' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearFrequency() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'frequencyRange' field */
    public java.lang.Float getFrequencyRange() {
      return frequencyRange;
    }
    
    /** Sets the value of the 'frequencyRange' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setFrequencyRange(float value) {
      validate(fields()[1], value);
      this.frequencyRange = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'frequencyRange' field has been set */
    public boolean hasFrequencyRange() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'frequencyRange' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearFrequencyRange() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'effectiveRadiatedPower' field */
    public java.lang.Float getEffectiveRadiatedPower() {
      return effectiveRadiatedPower;
    }
    
    /** Sets the value of the 'effectiveRadiatedPower' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setEffectiveRadiatedPower(float value) {
      validate(fields()[2], value);
      this.effectiveRadiatedPower = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'effectiveRadiatedPower' field has been set */
    public boolean hasEffectiveRadiatedPower() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'effectiveRadiatedPower' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearEffectiveRadiatedPower() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'pulseRepetitionFrequency' field */
    public java.lang.Float getPulseRepetitionFrequency() {
      return pulseRepetitionFrequency;
    }
    
    /** Sets the value of the 'pulseRepetitionFrequency' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setPulseRepetitionFrequency(float value) {
      validate(fields()[3], value);
      this.pulseRepetitionFrequency = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'pulseRepetitionFrequency' field has been set */
    public boolean hasPulseRepetitionFrequency() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'pulseRepetitionFrequency' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearPulseRepetitionFrequency() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'pulseWidth' field */
    public java.lang.Float getPulseWidth() {
      return pulseWidth;
    }
    
    /** Sets the value of the 'pulseWidth' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setPulseWidth(float value) {
      validate(fields()[4], value);
      this.pulseWidth = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'pulseWidth' field has been set */
    public boolean hasPulseWidth() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'pulseWidth' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearPulseWidth() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'beamAzimuthCenter' field */
    public java.lang.Float getBeamAzimuthCenter() {
      return beamAzimuthCenter;
    }
    
    /** Sets the value of the 'beamAzimuthCenter' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setBeamAzimuthCenter(float value) {
      validate(fields()[5], value);
      this.beamAzimuthCenter = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'beamAzimuthCenter' field has been set */
    public boolean hasBeamAzimuthCenter() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'beamAzimuthCenter' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearBeamAzimuthCenter() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'beamAzimuthSweep' field */
    public java.lang.Float getBeamAzimuthSweep() {
      return beamAzimuthSweep;
    }
    
    /** Sets the value of the 'beamAzimuthSweep' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setBeamAzimuthSweep(float value) {
      validate(fields()[6], value);
      this.beamAzimuthSweep = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'beamAzimuthSweep' field has been set */
    public boolean hasBeamAzimuthSweep() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'beamAzimuthSweep' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearBeamAzimuthSweep() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'beamElevationCenter' field */
    public java.lang.Float getBeamElevationCenter() {
      return beamElevationCenter;
    }
    
    /** Sets the value of the 'beamElevationCenter' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setBeamElevationCenter(float value) {
      validate(fields()[7], value);
      this.beamElevationCenter = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'beamElevationCenter' field has been set */
    public boolean hasBeamElevationCenter() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'beamElevationCenter' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearBeamElevationCenter() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'beamElevationSweep' field */
    public java.lang.Float getBeamElevationSweep() {
      return beamElevationSweep;
    }
    
    /** Sets the value of the 'beamElevationSweep' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setBeamElevationSweep(float value) {
      validate(fields()[8], value);
      this.beamElevationSweep = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'beamElevationSweep' field has been set */
    public boolean hasBeamElevationSweep() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'beamElevationSweep' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearBeamElevationSweep() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'beamSweepSync' field */
    public java.lang.Float getBeamSweepSync() {
      return beamSweepSync;
    }
    
    /** Sets the value of the 'beamSweepSync' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder setBeamSweepSync(float value) {
      validate(fields()[9], value);
      this.beamSweepSync = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'beamSweepSync' field has been set */
    public boolean hasBeamSweepSync() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'beamSweepSync' field */
    public com.cohesionforce.dis.avro.FundamentalParameterData.Builder clearBeamSweepSync() {
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    public FundamentalParameterData build() {
      try {
        FundamentalParameterData record = new FundamentalParameterData();
        record.frequency = fieldSetFlags()[0] ? this.frequency : (java.lang.Float) defaultValue(fields()[0]);
        record.frequencyRange = fieldSetFlags()[1] ? this.frequencyRange : (java.lang.Float) defaultValue(fields()[1]);
        record.effectiveRadiatedPower = fieldSetFlags()[2] ? this.effectiveRadiatedPower : (java.lang.Float) defaultValue(fields()[2]);
        record.pulseRepetitionFrequency = fieldSetFlags()[3] ? this.pulseRepetitionFrequency : (java.lang.Float) defaultValue(fields()[3]);
        record.pulseWidth = fieldSetFlags()[4] ? this.pulseWidth : (java.lang.Float) defaultValue(fields()[4]);
        record.beamAzimuthCenter = fieldSetFlags()[5] ? this.beamAzimuthCenter : (java.lang.Float) defaultValue(fields()[5]);
        record.beamAzimuthSweep = fieldSetFlags()[6] ? this.beamAzimuthSweep : (java.lang.Float) defaultValue(fields()[6]);
        record.beamElevationCenter = fieldSetFlags()[7] ? this.beamElevationCenter : (java.lang.Float) defaultValue(fields()[7]);
        record.beamElevationSweep = fieldSetFlags()[8] ? this.beamElevationSweep : (java.lang.Float) defaultValue(fields()[8]);
        record.beamSweepSync = fieldSetFlags()[9] ? this.beamSweepSync : (java.lang.Float) defaultValue(fields()[9]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}