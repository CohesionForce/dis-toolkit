/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BeamData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BeamData\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"beamAzimuthCenter\",\"type\":\"float\"},{\"name\":\"beamAzimuthSweep\",\"type\":\"float\"},{\"name\":\"beamElevationCenter\",\"type\":\"float\"},{\"name\":\"beamElevationSweep\",\"type\":\"float\"},{\"name\":\"beamSweepSync\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
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
  public BeamData() {}

  /**
   * All-args constructor.
   */
  public BeamData(java.lang.Float beamAzimuthCenter, java.lang.Float beamAzimuthSweep, java.lang.Float beamElevationCenter, java.lang.Float beamElevationSweep, java.lang.Float beamSweepSync) {
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
    case 0: return beamAzimuthCenter;
    case 1: return beamAzimuthSweep;
    case 2: return beamElevationCenter;
    case 3: return beamElevationSweep;
    case 4: return beamSweepSync;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: beamAzimuthCenter = (java.lang.Float)value$; break;
    case 1: beamAzimuthSweep = (java.lang.Float)value$; break;
    case 2: beamElevationCenter = (java.lang.Float)value$; break;
    case 3: beamElevationSweep = (java.lang.Float)value$; break;
    case 4: beamSweepSync = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
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

  /** Creates a new BeamData RecordBuilder */
  public static com.cohesionforce.dis.avro.BeamData.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.BeamData.Builder();
  }
  
  /** Creates a new BeamData RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.BeamData.Builder newBuilder(com.cohesionforce.dis.avro.BeamData.Builder other) {
    return new com.cohesionforce.dis.avro.BeamData.Builder(other);
  }
  
  /** Creates a new BeamData RecordBuilder by copying an existing BeamData instance */
  public static com.cohesionforce.dis.avro.BeamData.Builder newBuilder(com.cohesionforce.dis.avro.BeamData other) {
    return new com.cohesionforce.dis.avro.BeamData.Builder(other);
  }
  
  /**
   * RecordBuilder for BeamData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BeamData>
    implements org.apache.avro.data.RecordBuilder<BeamData> {

    private float beamAzimuthCenter;
    private float beamAzimuthSweep;
    private float beamElevationCenter;
    private float beamElevationSweep;
    private float beamSweepSync;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.BeamData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.BeamData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.beamAzimuthCenter)) {
        this.beamAzimuthCenter = data().deepCopy(fields()[0].schema(), other.beamAzimuthCenter);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamAzimuthSweep)) {
        this.beamAzimuthSweep = data().deepCopy(fields()[1].schema(), other.beamAzimuthSweep);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.beamElevationCenter)) {
        this.beamElevationCenter = data().deepCopy(fields()[2].schema(), other.beamElevationCenter);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.beamElevationSweep)) {
        this.beamElevationSweep = data().deepCopy(fields()[3].schema(), other.beamElevationSweep);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.beamSweepSync)) {
        this.beamSweepSync = data().deepCopy(fields()[4].schema(), other.beamSweepSync);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing BeamData instance */
    private Builder(com.cohesionforce.dis.avro.BeamData other) {
            super(com.cohesionforce.dis.avro.BeamData.SCHEMA$);
      if (isValidValue(fields()[0], other.beamAzimuthCenter)) {
        this.beamAzimuthCenter = data().deepCopy(fields()[0].schema(), other.beamAzimuthCenter);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.beamAzimuthSweep)) {
        this.beamAzimuthSweep = data().deepCopy(fields()[1].schema(), other.beamAzimuthSweep);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.beamElevationCenter)) {
        this.beamElevationCenter = data().deepCopy(fields()[2].schema(), other.beamElevationCenter);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.beamElevationSweep)) {
        this.beamElevationSweep = data().deepCopy(fields()[3].schema(), other.beamElevationSweep);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.beamSweepSync)) {
        this.beamSweepSync = data().deepCopy(fields()[4].schema(), other.beamSweepSync);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'beamAzimuthCenter' field */
    public java.lang.Float getBeamAzimuthCenter() {
      return beamAzimuthCenter;
    }
    
    /** Sets the value of the 'beamAzimuthCenter' field */
    public com.cohesionforce.dis.avro.BeamData.Builder setBeamAzimuthCenter(float value) {
      validate(fields()[0], value);
      this.beamAzimuthCenter = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'beamAzimuthCenter' field has been set */
    public boolean hasBeamAzimuthCenter() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'beamAzimuthCenter' field */
    public com.cohesionforce.dis.avro.BeamData.Builder clearBeamAzimuthCenter() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'beamAzimuthSweep' field */
    public java.lang.Float getBeamAzimuthSweep() {
      return beamAzimuthSweep;
    }
    
    /** Sets the value of the 'beamAzimuthSweep' field */
    public com.cohesionforce.dis.avro.BeamData.Builder setBeamAzimuthSweep(float value) {
      validate(fields()[1], value);
      this.beamAzimuthSweep = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'beamAzimuthSweep' field has been set */
    public boolean hasBeamAzimuthSweep() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'beamAzimuthSweep' field */
    public com.cohesionforce.dis.avro.BeamData.Builder clearBeamAzimuthSweep() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'beamElevationCenter' field */
    public java.lang.Float getBeamElevationCenter() {
      return beamElevationCenter;
    }
    
    /** Sets the value of the 'beamElevationCenter' field */
    public com.cohesionforce.dis.avro.BeamData.Builder setBeamElevationCenter(float value) {
      validate(fields()[2], value);
      this.beamElevationCenter = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'beamElevationCenter' field has been set */
    public boolean hasBeamElevationCenter() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'beamElevationCenter' field */
    public com.cohesionforce.dis.avro.BeamData.Builder clearBeamElevationCenter() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'beamElevationSweep' field */
    public java.lang.Float getBeamElevationSweep() {
      return beamElevationSweep;
    }
    
    /** Sets the value of the 'beamElevationSweep' field */
    public com.cohesionforce.dis.avro.BeamData.Builder setBeamElevationSweep(float value) {
      validate(fields()[3], value);
      this.beamElevationSweep = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'beamElevationSweep' field has been set */
    public boolean hasBeamElevationSweep() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'beamElevationSweep' field */
    public com.cohesionforce.dis.avro.BeamData.Builder clearBeamElevationSweep() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'beamSweepSync' field */
    public java.lang.Float getBeamSweepSync() {
      return beamSweepSync;
    }
    
    /** Sets the value of the 'beamSweepSync' field */
    public com.cohesionforce.dis.avro.BeamData.Builder setBeamSweepSync(float value) {
      validate(fields()[4], value);
      this.beamSweepSync = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'beamSweepSync' field has been set */
    public boolean hasBeamSweepSync() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'beamSweepSync' field */
    public com.cohesionforce.dis.avro.BeamData.Builder clearBeamSweepSync() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public BeamData build() {
      try {
        BeamData record = new BeamData();
        record.beamAzimuthCenter = fieldSetFlags()[0] ? this.beamAzimuthCenter : (java.lang.Float) defaultValue(fields()[0]);
        record.beamAzimuthSweep = fieldSetFlags()[1] ? this.beamAzimuthSweep : (java.lang.Float) defaultValue(fields()[1]);
        record.beamElevationCenter = fieldSetFlags()[2] ? this.beamElevationCenter : (java.lang.Float) defaultValue(fields()[2]);
        record.beamElevationSweep = fieldSetFlags()[3] ? this.beamElevationSweep : (java.lang.Float) defaultValue(fields()[3]);
        record.beamSweepSync = fieldSetFlags()[4] ? this.beamSweepSync : (java.lang.Float) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
