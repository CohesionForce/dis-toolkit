/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class GridAxisRecordRepresentation1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"GridAxisRecordRepresentation1\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"sampleType\",\"type\":\"int\"},{\"name\":\"dataRepresentation\",\"type\":\"int\"},{\"name\":\"fieldScale\",\"type\":\"float\"},{\"name\":\"fieldOffset\",\"type\":\"float\"},{\"name\":\"numberOfDataValues\",\"type\":\"int\"},{\"name\":\"dataValues\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TwoByteChunk\",\"fields\":[{\"name\":\"otherParameters\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}]}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int sampleType;
  @Deprecated public int dataRepresentation;
  @Deprecated public float fieldScale;
  @Deprecated public float fieldOffset;
  @Deprecated public int numberOfDataValues;
  @Deprecated public java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> dataValues;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public GridAxisRecordRepresentation1() {}

  /**
   * All-args constructor.
   */
  public GridAxisRecordRepresentation1(java.lang.Integer sampleType, java.lang.Integer dataRepresentation, java.lang.Float fieldScale, java.lang.Float fieldOffset, java.lang.Integer numberOfDataValues, java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> dataValues) {
    this.sampleType = sampleType;
    this.dataRepresentation = dataRepresentation;
    this.fieldScale = fieldScale;
    this.fieldOffset = fieldOffset;
    this.numberOfDataValues = numberOfDataValues;
    this.dataValues = dataValues;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sampleType;
    case 1: return dataRepresentation;
    case 2: return fieldScale;
    case 3: return fieldOffset;
    case 4: return numberOfDataValues;
    case 5: return dataValues;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sampleType = (java.lang.Integer)value$; break;
    case 1: dataRepresentation = (java.lang.Integer)value$; break;
    case 2: fieldScale = (java.lang.Float)value$; break;
    case 3: fieldOffset = (java.lang.Float)value$; break;
    case 4: numberOfDataValues = (java.lang.Integer)value$; break;
    case 5: dataValues = (java.util.List<com.cohesionforce.dis.avro.TwoByteChunk>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'sampleType' field.
   */
  public java.lang.Integer getSampleType() {
    return sampleType;
  }

  /**
   * Sets the value of the 'sampleType' field.
   * @param value the value to set.
   */
  public void setSampleType(java.lang.Integer value) {
    this.sampleType = value;
  }

  /**
   * Gets the value of the 'dataRepresentation' field.
   */
  public java.lang.Integer getDataRepresentation() {
    return dataRepresentation;
  }

  /**
   * Sets the value of the 'dataRepresentation' field.
   * @param value the value to set.
   */
  public void setDataRepresentation(java.lang.Integer value) {
    this.dataRepresentation = value;
  }

  /**
   * Gets the value of the 'fieldScale' field.
   */
  public java.lang.Float getFieldScale() {
    return fieldScale;
  }

  /**
   * Sets the value of the 'fieldScale' field.
   * @param value the value to set.
   */
  public void setFieldScale(java.lang.Float value) {
    this.fieldScale = value;
  }

  /**
   * Gets the value of the 'fieldOffset' field.
   */
  public java.lang.Float getFieldOffset() {
    return fieldOffset;
  }

  /**
   * Sets the value of the 'fieldOffset' field.
   * @param value the value to set.
   */
  public void setFieldOffset(java.lang.Float value) {
    this.fieldOffset = value;
  }

  /**
   * Gets the value of the 'numberOfDataValues' field.
   */
  public java.lang.Integer getNumberOfDataValues() {
    return numberOfDataValues;
  }

  /**
   * Sets the value of the 'numberOfDataValues' field.
   * @param value the value to set.
   */
  public void setNumberOfDataValues(java.lang.Integer value) {
    this.numberOfDataValues = value;
  }

  /**
   * Gets the value of the 'dataValues' field.
   */
  public java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> getDataValues() {
    return dataValues;
  }

  /**
   * Sets the value of the 'dataValues' field.
   * @param value the value to set.
   */
  public void setDataValues(java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> value) {
    this.dataValues = value;
  }

  /** Creates a new GridAxisRecordRepresentation1 RecordBuilder */
  public static com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder();
  }
  
  /** Creates a new GridAxisRecordRepresentation1 RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder newBuilder(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder other) {
    return new com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder(other);
  }
  
  /** Creates a new GridAxisRecordRepresentation1 RecordBuilder by copying an existing GridAxisRecordRepresentation1 instance */
  public static com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder newBuilder(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1 other) {
    return new com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder(other);
  }
  
  /**
   * RecordBuilder for GridAxisRecordRepresentation1 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<GridAxisRecordRepresentation1>
    implements org.apache.avro.data.RecordBuilder<GridAxisRecordRepresentation1> {

    private int sampleType;
    private int dataRepresentation;
    private float fieldScale;
    private float fieldOffset;
    private int numberOfDataValues;
    private java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> dataValues;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sampleType)) {
        this.sampleType = data().deepCopy(fields()[0].schema(), other.sampleType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dataRepresentation)) {
        this.dataRepresentation = data().deepCopy(fields()[1].schema(), other.dataRepresentation);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fieldScale)) {
        this.fieldScale = data().deepCopy(fields()[2].schema(), other.fieldScale);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fieldOffset)) {
        this.fieldOffset = data().deepCopy(fields()[3].schema(), other.fieldOffset);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.numberOfDataValues)) {
        this.numberOfDataValues = data().deepCopy(fields()[4].schema(), other.numberOfDataValues);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.dataValues)) {
        this.dataValues = data().deepCopy(fields()[5].schema(), other.dataValues);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing GridAxisRecordRepresentation1 instance */
    private Builder(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1 other) {
            super(com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.SCHEMA$);
      if (isValidValue(fields()[0], other.sampleType)) {
        this.sampleType = data().deepCopy(fields()[0].schema(), other.sampleType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dataRepresentation)) {
        this.dataRepresentation = data().deepCopy(fields()[1].schema(), other.dataRepresentation);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fieldScale)) {
        this.fieldScale = data().deepCopy(fields()[2].schema(), other.fieldScale);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.fieldOffset)) {
        this.fieldOffset = data().deepCopy(fields()[3].schema(), other.fieldOffset);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.numberOfDataValues)) {
        this.numberOfDataValues = data().deepCopy(fields()[4].schema(), other.numberOfDataValues);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.dataValues)) {
        this.dataValues = data().deepCopy(fields()[5].schema(), other.dataValues);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'sampleType' field */
    public java.lang.Integer getSampleType() {
      return sampleType;
    }
    
    /** Sets the value of the 'sampleType' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setSampleType(int value) {
      validate(fields()[0], value);
      this.sampleType = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'sampleType' field has been set */
    public boolean hasSampleType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'sampleType' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearSampleType() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'dataRepresentation' field */
    public java.lang.Integer getDataRepresentation() {
      return dataRepresentation;
    }
    
    /** Sets the value of the 'dataRepresentation' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setDataRepresentation(int value) {
      validate(fields()[1], value);
      this.dataRepresentation = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'dataRepresentation' field has been set */
    public boolean hasDataRepresentation() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'dataRepresentation' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearDataRepresentation() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'fieldScale' field */
    public java.lang.Float getFieldScale() {
      return fieldScale;
    }
    
    /** Sets the value of the 'fieldScale' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setFieldScale(float value) {
      validate(fields()[2], value);
      this.fieldScale = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'fieldScale' field has been set */
    public boolean hasFieldScale() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'fieldScale' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearFieldScale() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'fieldOffset' field */
    public java.lang.Float getFieldOffset() {
      return fieldOffset;
    }
    
    /** Sets the value of the 'fieldOffset' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setFieldOffset(float value) {
      validate(fields()[3], value);
      this.fieldOffset = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'fieldOffset' field has been set */
    public boolean hasFieldOffset() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'fieldOffset' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearFieldOffset() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'numberOfDataValues' field */
    public java.lang.Integer getNumberOfDataValues() {
      return numberOfDataValues;
    }
    
    /** Sets the value of the 'numberOfDataValues' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setNumberOfDataValues(int value) {
      validate(fields()[4], value);
      this.numberOfDataValues = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'numberOfDataValues' field has been set */
    public boolean hasNumberOfDataValues() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'numberOfDataValues' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearNumberOfDataValues() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'dataValues' field */
    public java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> getDataValues() {
      return dataValues;
    }
    
    /** Sets the value of the 'dataValues' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder setDataValues(java.util.List<com.cohesionforce.dis.avro.TwoByteChunk> value) {
      validate(fields()[5], value);
      this.dataValues = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'dataValues' field has been set */
    public boolean hasDataValues() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'dataValues' field */
    public com.cohesionforce.dis.avro.GridAxisRecordRepresentation1.Builder clearDataValues() {
      dataValues = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public GridAxisRecordRepresentation1 build() {
      try {
        GridAxisRecordRepresentation1 record = new GridAxisRecordRepresentation1();
        record.sampleType = fieldSetFlags()[0] ? this.sampleType : (java.lang.Integer) defaultValue(fields()[0]);
        record.dataRepresentation = fieldSetFlags()[1] ? this.dataRepresentation : (java.lang.Integer) defaultValue(fields()[1]);
        record.fieldScale = fieldSetFlags()[2] ? this.fieldScale : (java.lang.Float) defaultValue(fields()[2]);
        record.fieldOffset = fieldSetFlags()[3] ? this.fieldOffset : (java.lang.Float) defaultValue(fields()[3]);
        record.numberOfDataValues = fieldSetFlags()[4] ? this.numberOfDataValues : (java.lang.Integer) defaultValue(fields()[4]);
        record.dataValues = fieldSetFlags()[5] ? this.dataValues : (java.util.List<com.cohesionforce.dis.avro.TwoByteChunk>) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}