/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ArticulationParameter extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ArticulationParameter\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"parameterTypeDesignator\",\"type\":\"int\"},{\"name\":\"changeIndicator\",\"type\":\"int\"},{\"name\":\"partAttachedTo\",\"type\":\"int\"},{\"name\":\"parameterType\",\"type\":\"int\"},{\"name\":\"parameterValue\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int parameterTypeDesignator;
  @Deprecated public int changeIndicator;
  @Deprecated public int partAttachedTo;
  @Deprecated public int parameterType;
  @Deprecated public double parameterValue;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ArticulationParameter() {}

  /**
   * All-args constructor.
   */
  public ArticulationParameter(java.lang.Integer parameterTypeDesignator, java.lang.Integer changeIndicator, java.lang.Integer partAttachedTo, java.lang.Integer parameterType, java.lang.Double parameterValue) {
    this.parameterTypeDesignator = parameterTypeDesignator;
    this.changeIndicator = changeIndicator;
    this.partAttachedTo = partAttachedTo;
    this.parameterType = parameterType;
    this.parameterValue = parameterValue;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return parameterTypeDesignator;
    case 1: return changeIndicator;
    case 2: return partAttachedTo;
    case 3: return parameterType;
    case 4: return parameterValue;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: parameterTypeDesignator = (java.lang.Integer)value$; break;
    case 1: changeIndicator = (java.lang.Integer)value$; break;
    case 2: partAttachedTo = (java.lang.Integer)value$; break;
    case 3: parameterType = (java.lang.Integer)value$; break;
    case 4: parameterValue = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'parameterTypeDesignator' field.
   */
  public java.lang.Integer getParameterTypeDesignator() {
    return parameterTypeDesignator;
  }

  /**
   * Sets the value of the 'parameterTypeDesignator' field.
   * @param value the value to set.
   */
  public void setParameterTypeDesignator(java.lang.Integer value) {
    this.parameterTypeDesignator = value;
  }

  /**
   * Gets the value of the 'changeIndicator' field.
   */
  public java.lang.Integer getChangeIndicator() {
    return changeIndicator;
  }

  /**
   * Sets the value of the 'changeIndicator' field.
   * @param value the value to set.
   */
  public void setChangeIndicator(java.lang.Integer value) {
    this.changeIndicator = value;
  }

  /**
   * Gets the value of the 'partAttachedTo' field.
   */
  public java.lang.Integer getPartAttachedTo() {
    return partAttachedTo;
  }

  /**
   * Sets the value of the 'partAttachedTo' field.
   * @param value the value to set.
   */
  public void setPartAttachedTo(java.lang.Integer value) {
    this.partAttachedTo = value;
  }

  /**
   * Gets the value of the 'parameterType' field.
   */
  public java.lang.Integer getParameterType() {
    return parameterType;
  }

  /**
   * Sets the value of the 'parameterType' field.
   * @param value the value to set.
   */
  public void setParameterType(java.lang.Integer value) {
    this.parameterType = value;
  }

  /**
   * Gets the value of the 'parameterValue' field.
   */
  public java.lang.Double getParameterValue() {
    return parameterValue;
  }

  /**
   * Sets the value of the 'parameterValue' field.
   * @param value the value to set.
   */
  public void setParameterValue(java.lang.Double value) {
    this.parameterValue = value;
  }

  /** Creates a new ArticulationParameter RecordBuilder */
  public static com.cohesionforce.dis.avro.ArticulationParameter.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ArticulationParameter.Builder();
  }
  
  /** Creates a new ArticulationParameter RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ArticulationParameter.Builder newBuilder(com.cohesionforce.dis.avro.ArticulationParameter.Builder other) {
    return new com.cohesionforce.dis.avro.ArticulationParameter.Builder(other);
  }
  
  /** Creates a new ArticulationParameter RecordBuilder by copying an existing ArticulationParameter instance */
  public static com.cohesionforce.dis.avro.ArticulationParameter.Builder newBuilder(com.cohesionforce.dis.avro.ArticulationParameter other) {
    return new com.cohesionforce.dis.avro.ArticulationParameter.Builder(other);
  }
  
  /**
   * RecordBuilder for ArticulationParameter instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ArticulationParameter>
    implements org.apache.avro.data.RecordBuilder<ArticulationParameter> {

    private int parameterTypeDesignator;
    private int changeIndicator;
    private int partAttachedTo;
    private int parameterType;
    private double parameterValue;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ArticulationParameter.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ArticulationParameter.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.parameterTypeDesignator)) {
        this.parameterTypeDesignator = data().deepCopy(fields()[0].schema(), other.parameterTypeDesignator);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.changeIndicator)) {
        this.changeIndicator = data().deepCopy(fields()[1].schema(), other.changeIndicator);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.partAttachedTo)) {
        this.partAttachedTo = data().deepCopy(fields()[2].schema(), other.partAttachedTo);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.parameterType)) {
        this.parameterType = data().deepCopy(fields()[3].schema(), other.parameterType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.parameterValue)) {
        this.parameterValue = data().deepCopy(fields()[4].schema(), other.parameterValue);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ArticulationParameter instance */
    private Builder(com.cohesionforce.dis.avro.ArticulationParameter other) {
            super(com.cohesionforce.dis.avro.ArticulationParameter.SCHEMA$);
      if (isValidValue(fields()[0], other.parameterTypeDesignator)) {
        this.parameterTypeDesignator = data().deepCopy(fields()[0].schema(), other.parameterTypeDesignator);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.changeIndicator)) {
        this.changeIndicator = data().deepCopy(fields()[1].schema(), other.changeIndicator);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.partAttachedTo)) {
        this.partAttachedTo = data().deepCopy(fields()[2].schema(), other.partAttachedTo);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.parameterType)) {
        this.parameterType = data().deepCopy(fields()[3].schema(), other.parameterType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.parameterValue)) {
        this.parameterValue = data().deepCopy(fields()[4].schema(), other.parameterValue);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'parameterTypeDesignator' field */
    public java.lang.Integer getParameterTypeDesignator() {
      return parameterTypeDesignator;
    }
    
    /** Sets the value of the 'parameterTypeDesignator' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder setParameterTypeDesignator(int value) {
      validate(fields()[0], value);
      this.parameterTypeDesignator = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'parameterTypeDesignator' field has been set */
    public boolean hasParameterTypeDesignator() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'parameterTypeDesignator' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder clearParameterTypeDesignator() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'changeIndicator' field */
    public java.lang.Integer getChangeIndicator() {
      return changeIndicator;
    }
    
    /** Sets the value of the 'changeIndicator' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder setChangeIndicator(int value) {
      validate(fields()[1], value);
      this.changeIndicator = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'changeIndicator' field has been set */
    public boolean hasChangeIndicator() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'changeIndicator' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder clearChangeIndicator() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'partAttachedTo' field */
    public java.lang.Integer getPartAttachedTo() {
      return partAttachedTo;
    }
    
    /** Sets the value of the 'partAttachedTo' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder setPartAttachedTo(int value) {
      validate(fields()[2], value);
      this.partAttachedTo = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'partAttachedTo' field has been set */
    public boolean hasPartAttachedTo() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'partAttachedTo' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder clearPartAttachedTo() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'parameterType' field */
    public java.lang.Integer getParameterType() {
      return parameterType;
    }
    
    /** Sets the value of the 'parameterType' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder setParameterType(int value) {
      validate(fields()[3], value);
      this.parameterType = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'parameterType' field has been set */
    public boolean hasParameterType() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'parameterType' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder clearParameterType() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'parameterValue' field */
    public java.lang.Double getParameterValue() {
      return parameterValue;
    }
    
    /** Sets the value of the 'parameterValue' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder setParameterValue(double value) {
      validate(fields()[4], value);
      this.parameterValue = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'parameterValue' field has been set */
    public boolean hasParameterValue() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'parameterValue' field */
    public com.cohesionforce.dis.avro.ArticulationParameter.Builder clearParameterValue() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public ArticulationParameter build() {
      try {
        ArticulationParameter record = new ArticulationParameter();
        record.parameterTypeDesignator = fieldSetFlags()[0] ? this.parameterTypeDesignator : (java.lang.Integer) defaultValue(fields()[0]);
        record.changeIndicator = fieldSetFlags()[1] ? this.changeIndicator : (java.lang.Integer) defaultValue(fields()[1]);
        record.partAttachedTo = fieldSetFlags()[2] ? this.partAttachedTo : (java.lang.Integer) defaultValue(fields()[2]);
        record.parameterType = fieldSetFlags()[3] ? this.parameterType : (java.lang.Integer) defaultValue(fields()[3]);
        record.parameterValue = fieldSetFlags()[4] ? this.parameterValue : (java.lang.Double) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
