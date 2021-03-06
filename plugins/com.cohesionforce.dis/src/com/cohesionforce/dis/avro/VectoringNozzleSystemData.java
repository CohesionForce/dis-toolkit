/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class VectoringNozzleSystemData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"VectoringNozzleSystemData\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"horizontalDeflectionAngle\",\"type\":\"float\"},{\"name\":\"verticalDeflectionAngle\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public float horizontalDeflectionAngle;
  @Deprecated public float verticalDeflectionAngle;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public VectoringNozzleSystemData() {}

  /**
   * All-args constructor.
   */
  public VectoringNozzleSystemData(java.lang.Float horizontalDeflectionAngle, java.lang.Float verticalDeflectionAngle) {
    this.horizontalDeflectionAngle = horizontalDeflectionAngle;
    this.verticalDeflectionAngle = verticalDeflectionAngle;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return horizontalDeflectionAngle;
    case 1: return verticalDeflectionAngle;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: horizontalDeflectionAngle = (java.lang.Float)value$; break;
    case 1: verticalDeflectionAngle = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'horizontalDeflectionAngle' field.
   */
  public java.lang.Float getHorizontalDeflectionAngle() {
    return horizontalDeflectionAngle;
  }

  /**
   * Sets the value of the 'horizontalDeflectionAngle' field.
   * @param value the value to set.
   */
  public void setHorizontalDeflectionAngle(java.lang.Float value) {
    this.horizontalDeflectionAngle = value;
  }

  /**
   * Gets the value of the 'verticalDeflectionAngle' field.
   */
  public java.lang.Float getVerticalDeflectionAngle() {
    return verticalDeflectionAngle;
  }

  /**
   * Sets the value of the 'verticalDeflectionAngle' field.
   * @param value the value to set.
   */
  public void setVerticalDeflectionAngle(java.lang.Float value) {
    this.verticalDeflectionAngle = value;
  }

  /** Creates a new VectoringNozzleSystemData RecordBuilder */
  public static com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder();
  }
  
  /** Creates a new VectoringNozzleSystemData RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder newBuilder(com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder other) {
    return new com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder(other);
  }
  
  /** Creates a new VectoringNozzleSystemData RecordBuilder by copying an existing VectoringNozzleSystemData instance */
  public static com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder newBuilder(com.cohesionforce.dis.avro.VectoringNozzleSystemData other) {
    return new com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder(other);
  }
  
  /**
   * RecordBuilder for VectoringNozzleSystemData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<VectoringNozzleSystemData>
    implements org.apache.avro.data.RecordBuilder<VectoringNozzleSystemData> {

    private float horizontalDeflectionAngle;
    private float verticalDeflectionAngle;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.VectoringNozzleSystemData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.horizontalDeflectionAngle)) {
        this.horizontalDeflectionAngle = data().deepCopy(fields()[0].schema(), other.horizontalDeflectionAngle);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.verticalDeflectionAngle)) {
        this.verticalDeflectionAngle = data().deepCopy(fields()[1].schema(), other.verticalDeflectionAngle);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing VectoringNozzleSystemData instance */
    private Builder(com.cohesionforce.dis.avro.VectoringNozzleSystemData other) {
            super(com.cohesionforce.dis.avro.VectoringNozzleSystemData.SCHEMA$);
      if (isValidValue(fields()[0], other.horizontalDeflectionAngle)) {
        this.horizontalDeflectionAngle = data().deepCopy(fields()[0].schema(), other.horizontalDeflectionAngle);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.verticalDeflectionAngle)) {
        this.verticalDeflectionAngle = data().deepCopy(fields()[1].schema(), other.verticalDeflectionAngle);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'horizontalDeflectionAngle' field */
    public java.lang.Float getHorizontalDeflectionAngle() {
      return horizontalDeflectionAngle;
    }
    
    /** Sets the value of the 'horizontalDeflectionAngle' field */
    public com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder setHorizontalDeflectionAngle(float value) {
      validate(fields()[0], value);
      this.horizontalDeflectionAngle = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'horizontalDeflectionAngle' field has been set */
    public boolean hasHorizontalDeflectionAngle() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'horizontalDeflectionAngle' field */
    public com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder clearHorizontalDeflectionAngle() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'verticalDeflectionAngle' field */
    public java.lang.Float getVerticalDeflectionAngle() {
      return verticalDeflectionAngle;
    }
    
    /** Sets the value of the 'verticalDeflectionAngle' field */
    public com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder setVerticalDeflectionAngle(float value) {
      validate(fields()[1], value);
      this.verticalDeflectionAngle = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'verticalDeflectionAngle' field has been set */
    public boolean hasVerticalDeflectionAngle() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'verticalDeflectionAngle' field */
    public com.cohesionforce.dis.avro.VectoringNozzleSystemData.Builder clearVerticalDeflectionAngle() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public VectoringNozzleSystemData build() {
      try {
        VectoringNozzleSystemData record = new VectoringNozzleSystemData();
        record.horizontalDeflectionAngle = fieldSetFlags()[0] ? this.horizontalDeflectionAngle : (java.lang.Float) defaultValue(fields()[0]);
        record.verticalDeflectionAngle = fieldSetFlags()[1] ? this.verticalDeflectionAngle : (java.lang.Float) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
