/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BeamAntennaPattern extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BeamAntennaPattern\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"beamDirection\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Orientation\",\"fields\":[{\"name\":\"psi\",\"type\":\"float\"},{\"name\":\"theta\",\"type\":\"float\"},{\"name\":\"phi\",\"type\":\"float\"}]}]},{\"name\":\"azimuthBeamwidth\",\"type\":\"float\"},{\"name\":\"elevationBeamwidth\",\"type\":\"float\"},{\"name\":\"referenceSystem\",\"type\":\"float\"},{\"name\":\"padding1\",\"type\":\"int\"},{\"name\":\"padding2\",\"type\":\"int\"},{\"name\":\"ez\",\"type\":\"float\"},{\"name\":\"ex\",\"type\":\"float\"},{\"name\":\"phase\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.cohesionforce.dis.avro.Orientation beamDirection;
  @Deprecated public float azimuthBeamwidth;
  @Deprecated public float elevationBeamwidth;
  @Deprecated public float referenceSystem;
  @Deprecated public int padding1;
  @Deprecated public int padding2;
  @Deprecated public float ez;
  @Deprecated public float ex;
  @Deprecated public float phase;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public BeamAntennaPattern() {}

  /**
   * All-args constructor.
   */
  public BeamAntennaPattern(com.cohesionforce.dis.avro.Orientation beamDirection, java.lang.Float azimuthBeamwidth, java.lang.Float elevationBeamwidth, java.lang.Float referenceSystem, java.lang.Integer padding1, java.lang.Integer padding2, java.lang.Float ez, java.lang.Float ex, java.lang.Float phase) {
    this.beamDirection = beamDirection;
    this.azimuthBeamwidth = azimuthBeamwidth;
    this.elevationBeamwidth = elevationBeamwidth;
    this.referenceSystem = referenceSystem;
    this.padding1 = padding1;
    this.padding2 = padding2;
    this.ez = ez;
    this.ex = ex;
    this.phase = phase;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return beamDirection;
    case 1: return azimuthBeamwidth;
    case 2: return elevationBeamwidth;
    case 3: return referenceSystem;
    case 4: return padding1;
    case 5: return padding2;
    case 6: return ez;
    case 7: return ex;
    case 8: return phase;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: beamDirection = (com.cohesionforce.dis.avro.Orientation)value$; break;
    case 1: azimuthBeamwidth = (java.lang.Float)value$; break;
    case 2: elevationBeamwidth = (java.lang.Float)value$; break;
    case 3: referenceSystem = (java.lang.Float)value$; break;
    case 4: padding1 = (java.lang.Integer)value$; break;
    case 5: padding2 = (java.lang.Integer)value$; break;
    case 6: ez = (java.lang.Float)value$; break;
    case 7: ex = (java.lang.Float)value$; break;
    case 8: phase = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'beamDirection' field.
   */
  public com.cohesionforce.dis.avro.Orientation getBeamDirection() {
    return beamDirection;
  }

  /**
   * Sets the value of the 'beamDirection' field.
   * @param value the value to set.
   */
  public void setBeamDirection(com.cohesionforce.dis.avro.Orientation value) {
    this.beamDirection = value;
  }

  /**
   * Gets the value of the 'azimuthBeamwidth' field.
   */
  public java.lang.Float getAzimuthBeamwidth() {
    return azimuthBeamwidth;
  }

  /**
   * Sets the value of the 'azimuthBeamwidth' field.
   * @param value the value to set.
   */
  public void setAzimuthBeamwidth(java.lang.Float value) {
    this.azimuthBeamwidth = value;
  }

  /**
   * Gets the value of the 'elevationBeamwidth' field.
   */
  public java.lang.Float getElevationBeamwidth() {
    return elevationBeamwidth;
  }

  /**
   * Sets the value of the 'elevationBeamwidth' field.
   * @param value the value to set.
   */
  public void setElevationBeamwidth(java.lang.Float value) {
    this.elevationBeamwidth = value;
  }

  /**
   * Gets the value of the 'referenceSystem' field.
   */
  public java.lang.Float getReferenceSystem() {
    return referenceSystem;
  }

  /**
   * Sets the value of the 'referenceSystem' field.
   * @param value the value to set.
   */
  public void setReferenceSystem(java.lang.Float value) {
    this.referenceSystem = value;
  }

  /**
   * Gets the value of the 'padding1' field.
   */
  public java.lang.Integer getPadding1() {
    return padding1;
  }

  /**
   * Sets the value of the 'padding1' field.
   * @param value the value to set.
   */
  public void setPadding1(java.lang.Integer value) {
    this.padding1 = value;
  }

  /**
   * Gets the value of the 'padding2' field.
   */
  public java.lang.Integer getPadding2() {
    return padding2;
  }

  /**
   * Sets the value of the 'padding2' field.
   * @param value the value to set.
   */
  public void setPadding2(java.lang.Integer value) {
    this.padding2 = value;
  }

  /**
   * Gets the value of the 'ez' field.
   */
  public java.lang.Float getEz() {
    return ez;
  }

  /**
   * Sets the value of the 'ez' field.
   * @param value the value to set.
   */
  public void setEz(java.lang.Float value) {
    this.ez = value;
  }

  /**
   * Gets the value of the 'ex' field.
   */
  public java.lang.Float getEx() {
    return ex;
  }

  /**
   * Sets the value of the 'ex' field.
   * @param value the value to set.
   */
  public void setEx(java.lang.Float value) {
    this.ex = value;
  }

  /**
   * Gets the value of the 'phase' field.
   */
  public java.lang.Float getPhase() {
    return phase;
  }

  /**
   * Sets the value of the 'phase' field.
   * @param value the value to set.
   */
  public void setPhase(java.lang.Float value) {
    this.phase = value;
  }

  /** Creates a new BeamAntennaPattern RecordBuilder */
  public static com.cohesionforce.dis.avro.BeamAntennaPattern.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.BeamAntennaPattern.Builder();
  }
  
  /** Creates a new BeamAntennaPattern RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.BeamAntennaPattern.Builder newBuilder(com.cohesionforce.dis.avro.BeamAntennaPattern.Builder other) {
    return new com.cohesionforce.dis.avro.BeamAntennaPattern.Builder(other);
  }
  
  /** Creates a new BeamAntennaPattern RecordBuilder by copying an existing BeamAntennaPattern instance */
  public static com.cohesionforce.dis.avro.BeamAntennaPattern.Builder newBuilder(com.cohesionforce.dis.avro.BeamAntennaPattern other) {
    return new com.cohesionforce.dis.avro.BeamAntennaPattern.Builder(other);
  }
  
  /**
   * RecordBuilder for BeamAntennaPattern instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BeamAntennaPattern>
    implements org.apache.avro.data.RecordBuilder<BeamAntennaPattern> {

    private com.cohesionforce.dis.avro.Orientation beamDirection;
    private float azimuthBeamwidth;
    private float elevationBeamwidth;
    private float referenceSystem;
    private int padding1;
    private int padding2;
    private float ez;
    private float ex;
    private float phase;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.BeamAntennaPattern.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.BeamAntennaPattern.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.beamDirection)) {
        this.beamDirection = data().deepCopy(fields()[0].schema(), other.beamDirection);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.azimuthBeamwidth)) {
        this.azimuthBeamwidth = data().deepCopy(fields()[1].schema(), other.azimuthBeamwidth);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.elevationBeamwidth)) {
        this.elevationBeamwidth = data().deepCopy(fields()[2].schema(), other.elevationBeamwidth);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.referenceSystem)) {
        this.referenceSystem = data().deepCopy(fields()[3].schema(), other.referenceSystem);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.padding1)) {
        this.padding1 = data().deepCopy(fields()[4].schema(), other.padding1);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.padding2)) {
        this.padding2 = data().deepCopy(fields()[5].schema(), other.padding2);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ez)) {
        this.ez = data().deepCopy(fields()[6].schema(), other.ez);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.ex)) {
        this.ex = data().deepCopy(fields()[7].schema(), other.ex);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.phase)) {
        this.phase = data().deepCopy(fields()[8].schema(), other.phase);
        fieldSetFlags()[8] = true;
      }
    }
    
    /** Creates a Builder by copying an existing BeamAntennaPattern instance */
    private Builder(com.cohesionforce.dis.avro.BeamAntennaPattern other) {
            super(com.cohesionforce.dis.avro.BeamAntennaPattern.SCHEMA$);
      if (isValidValue(fields()[0], other.beamDirection)) {
        this.beamDirection = data().deepCopy(fields()[0].schema(), other.beamDirection);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.azimuthBeamwidth)) {
        this.azimuthBeamwidth = data().deepCopy(fields()[1].schema(), other.azimuthBeamwidth);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.elevationBeamwidth)) {
        this.elevationBeamwidth = data().deepCopy(fields()[2].schema(), other.elevationBeamwidth);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.referenceSystem)) {
        this.referenceSystem = data().deepCopy(fields()[3].schema(), other.referenceSystem);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.padding1)) {
        this.padding1 = data().deepCopy(fields()[4].schema(), other.padding1);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.padding2)) {
        this.padding2 = data().deepCopy(fields()[5].schema(), other.padding2);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.ez)) {
        this.ez = data().deepCopy(fields()[6].schema(), other.ez);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.ex)) {
        this.ex = data().deepCopy(fields()[7].schema(), other.ex);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.phase)) {
        this.phase = data().deepCopy(fields()[8].schema(), other.phase);
        fieldSetFlags()[8] = true;
      }
    }

    /** Gets the value of the 'beamDirection' field */
    public com.cohesionforce.dis.avro.Orientation getBeamDirection() {
      return beamDirection;
    }
    
    /** Sets the value of the 'beamDirection' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setBeamDirection(com.cohesionforce.dis.avro.Orientation value) {
      validate(fields()[0], value);
      this.beamDirection = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'beamDirection' field has been set */
    public boolean hasBeamDirection() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'beamDirection' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearBeamDirection() {
      beamDirection = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'azimuthBeamwidth' field */
    public java.lang.Float getAzimuthBeamwidth() {
      return azimuthBeamwidth;
    }
    
    /** Sets the value of the 'azimuthBeamwidth' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setAzimuthBeamwidth(float value) {
      validate(fields()[1], value);
      this.azimuthBeamwidth = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'azimuthBeamwidth' field has been set */
    public boolean hasAzimuthBeamwidth() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'azimuthBeamwidth' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearAzimuthBeamwidth() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'elevationBeamwidth' field */
    public java.lang.Float getElevationBeamwidth() {
      return elevationBeamwidth;
    }
    
    /** Sets the value of the 'elevationBeamwidth' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setElevationBeamwidth(float value) {
      validate(fields()[2], value);
      this.elevationBeamwidth = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'elevationBeamwidth' field has been set */
    public boolean hasElevationBeamwidth() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'elevationBeamwidth' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearElevationBeamwidth() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'referenceSystem' field */
    public java.lang.Float getReferenceSystem() {
      return referenceSystem;
    }
    
    /** Sets the value of the 'referenceSystem' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setReferenceSystem(float value) {
      validate(fields()[3], value);
      this.referenceSystem = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'referenceSystem' field has been set */
    public boolean hasReferenceSystem() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'referenceSystem' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearReferenceSystem() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'padding1' field */
    public java.lang.Integer getPadding1() {
      return padding1;
    }
    
    /** Sets the value of the 'padding1' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setPadding1(int value) {
      validate(fields()[4], value);
      this.padding1 = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'padding1' field has been set */
    public boolean hasPadding1() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'padding1' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearPadding1() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'padding2' field */
    public java.lang.Integer getPadding2() {
      return padding2;
    }
    
    /** Sets the value of the 'padding2' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setPadding2(int value) {
      validate(fields()[5], value);
      this.padding2 = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'padding2' field has been set */
    public boolean hasPadding2() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'padding2' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearPadding2() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'ez' field */
    public java.lang.Float getEz() {
      return ez;
    }
    
    /** Sets the value of the 'ez' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setEz(float value) {
      validate(fields()[6], value);
      this.ez = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'ez' field has been set */
    public boolean hasEz() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'ez' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearEz() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'ex' field */
    public java.lang.Float getEx() {
      return ex;
    }
    
    /** Sets the value of the 'ex' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setEx(float value) {
      validate(fields()[7], value);
      this.ex = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'ex' field has been set */
    public boolean hasEx() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'ex' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearEx() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'phase' field */
    public java.lang.Float getPhase() {
      return phase;
    }
    
    /** Sets the value of the 'phase' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder setPhase(float value) {
      validate(fields()[8], value);
      this.phase = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'phase' field has been set */
    public boolean hasPhase() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'phase' field */
    public com.cohesionforce.dis.avro.BeamAntennaPattern.Builder clearPhase() {
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public BeamAntennaPattern build() {
      try {
        BeamAntennaPattern record = new BeamAntennaPattern();
        record.beamDirection = fieldSetFlags()[0] ? this.beamDirection : (com.cohesionforce.dis.avro.Orientation) defaultValue(fields()[0]);
        record.azimuthBeamwidth = fieldSetFlags()[1] ? this.azimuthBeamwidth : (java.lang.Float) defaultValue(fields()[1]);
        record.elevationBeamwidth = fieldSetFlags()[2] ? this.elevationBeamwidth : (java.lang.Float) defaultValue(fields()[2]);
        record.referenceSystem = fieldSetFlags()[3] ? this.referenceSystem : (java.lang.Float) defaultValue(fields()[3]);
        record.padding1 = fieldSetFlags()[4] ? this.padding1 : (java.lang.Integer) defaultValue(fields()[4]);
        record.padding2 = fieldSetFlags()[5] ? this.padding2 : (java.lang.Integer) defaultValue(fields()[5]);
        record.ez = fieldSetFlags()[6] ? this.ez : (java.lang.Float) defaultValue(fields()[6]);
        record.ex = fieldSetFlags()[7] ? this.ex : (java.lang.Float) defaultValue(fields()[7]);
        record.phase = fieldSetFlags()[8] ? this.phase : (java.lang.Float) defaultValue(fields()[8]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
