/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ModulationType extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ModulationType\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"spreadSpectrum\",\"type\":\"int\"},{\"name\":\"major\",\"type\":\"int\"},{\"name\":\"detail\",\"type\":\"int\"},{\"name\":\"system\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int spreadSpectrum;
  @Deprecated public int major;
  @Deprecated public int detail;
  @Deprecated public int system;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ModulationType() {}

  /**
   * All-args constructor.
   */
  public ModulationType(java.lang.Integer spreadSpectrum, java.lang.Integer major, java.lang.Integer detail, java.lang.Integer system) {
    this.spreadSpectrum = spreadSpectrum;
    this.major = major;
    this.detail = detail;
    this.system = system;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return spreadSpectrum;
    case 1: return major;
    case 2: return detail;
    case 3: return system;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: spreadSpectrum = (java.lang.Integer)value$; break;
    case 1: major = (java.lang.Integer)value$; break;
    case 2: detail = (java.lang.Integer)value$; break;
    case 3: system = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'spreadSpectrum' field.
   */
  public java.lang.Integer getSpreadSpectrum() {
    return spreadSpectrum;
  }

  /**
   * Sets the value of the 'spreadSpectrum' field.
   * @param value the value to set.
   */
  public void setSpreadSpectrum(java.lang.Integer value) {
    this.spreadSpectrum = value;
  }

  /**
   * Gets the value of the 'major' field.
   */
  public java.lang.Integer getMajor() {
    return major;
  }

  /**
   * Sets the value of the 'major' field.
   * @param value the value to set.
   */
  public void setMajor(java.lang.Integer value) {
    this.major = value;
  }

  /**
   * Gets the value of the 'detail' field.
   */
  public java.lang.Integer getDetail() {
    return detail;
  }

  /**
   * Sets the value of the 'detail' field.
   * @param value the value to set.
   */
  public void setDetail(java.lang.Integer value) {
    this.detail = value;
  }

  /**
   * Gets the value of the 'system' field.
   */
  public java.lang.Integer getSystem() {
    return system;
  }

  /**
   * Sets the value of the 'system' field.
   * @param value the value to set.
   */
  public void setSystem(java.lang.Integer value) {
    this.system = value;
  }

  /** Creates a new ModulationType RecordBuilder */
  public static com.cohesionforce.dis.avro.ModulationType.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ModulationType.Builder();
  }
  
  /** Creates a new ModulationType RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ModulationType.Builder newBuilder(com.cohesionforce.dis.avro.ModulationType.Builder other) {
    return new com.cohesionforce.dis.avro.ModulationType.Builder(other);
  }
  
  /** Creates a new ModulationType RecordBuilder by copying an existing ModulationType instance */
  public static com.cohesionforce.dis.avro.ModulationType.Builder newBuilder(com.cohesionforce.dis.avro.ModulationType other) {
    return new com.cohesionforce.dis.avro.ModulationType.Builder(other);
  }
  
  /**
   * RecordBuilder for ModulationType instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ModulationType>
    implements org.apache.avro.data.RecordBuilder<ModulationType> {

    private int spreadSpectrum;
    private int major;
    private int detail;
    private int system;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ModulationType.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ModulationType.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.spreadSpectrum)) {
        this.spreadSpectrum = data().deepCopy(fields()[0].schema(), other.spreadSpectrum);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.major)) {
        this.major = data().deepCopy(fields()[1].schema(), other.major);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.detail)) {
        this.detail = data().deepCopy(fields()[2].schema(), other.detail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.system)) {
        this.system = data().deepCopy(fields()[3].schema(), other.system);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ModulationType instance */
    private Builder(com.cohesionforce.dis.avro.ModulationType other) {
            super(com.cohesionforce.dis.avro.ModulationType.SCHEMA$);
      if (isValidValue(fields()[0], other.spreadSpectrum)) {
        this.spreadSpectrum = data().deepCopy(fields()[0].schema(), other.spreadSpectrum);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.major)) {
        this.major = data().deepCopy(fields()[1].schema(), other.major);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.detail)) {
        this.detail = data().deepCopy(fields()[2].schema(), other.detail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.system)) {
        this.system = data().deepCopy(fields()[3].schema(), other.system);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'spreadSpectrum' field */
    public java.lang.Integer getSpreadSpectrum() {
      return spreadSpectrum;
    }
    
    /** Sets the value of the 'spreadSpectrum' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder setSpreadSpectrum(int value) {
      validate(fields()[0], value);
      this.spreadSpectrum = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'spreadSpectrum' field has been set */
    public boolean hasSpreadSpectrum() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'spreadSpectrum' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder clearSpreadSpectrum() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'major' field */
    public java.lang.Integer getMajor() {
      return major;
    }
    
    /** Sets the value of the 'major' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder setMajor(int value) {
      validate(fields()[1], value);
      this.major = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'major' field has been set */
    public boolean hasMajor() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'major' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder clearMajor() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'detail' field */
    public java.lang.Integer getDetail() {
      return detail;
    }
    
    /** Sets the value of the 'detail' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder setDetail(int value) {
      validate(fields()[2], value);
      this.detail = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'detail' field has been set */
    public boolean hasDetail() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'detail' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder clearDetail() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'system' field */
    public java.lang.Integer getSystem() {
      return system;
    }
    
    /** Sets the value of the 'system' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder setSystem(int value) {
      validate(fields()[3], value);
      this.system = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'system' field has been set */
    public boolean hasSystem() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'system' field */
    public com.cohesionforce.dis.avro.ModulationType.Builder clearSystem() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public ModulationType build() {
      try {
        ModulationType record = new ModulationType();
        record.spreadSpectrum = fieldSetFlags()[0] ? this.spreadSpectrum : (java.lang.Integer) defaultValue(fields()[0]);
        record.major = fieldSetFlags()[1] ? this.major : (java.lang.Integer) defaultValue(fields()[1]);
        record.detail = fieldSetFlags()[2] ? this.detail : (java.lang.Integer) defaultValue(fields()[2]);
        record.system = fieldSetFlags()[3] ? this.system : (java.lang.Integer) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
