/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SixByteChunk extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SixByteChunk\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"otherParameters\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<java.lang.Integer> otherParameters;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public SixByteChunk() {}

  /**
   * All-args constructor.
   */
  public SixByteChunk(java.util.List<java.lang.Integer> otherParameters) {
    this.otherParameters = otherParameters;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return otherParameters;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: otherParameters = (java.util.List<java.lang.Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'otherParameters' field.
   */
  public java.util.List<java.lang.Integer> getOtherParameters() {
    return otherParameters;
  }

  /**
   * Sets the value of the 'otherParameters' field.
   * @param value the value to set.
   */
  public void setOtherParameters(java.util.List<java.lang.Integer> value) {
    this.otherParameters = value;
  }

  /** Creates a new SixByteChunk RecordBuilder */
  public static com.cohesionforce.dis.avro.SixByteChunk.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.SixByteChunk.Builder();
  }
  
  /** Creates a new SixByteChunk RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.SixByteChunk.Builder newBuilder(com.cohesionforce.dis.avro.SixByteChunk.Builder other) {
    return new com.cohesionforce.dis.avro.SixByteChunk.Builder(other);
  }
  
  /** Creates a new SixByteChunk RecordBuilder by copying an existing SixByteChunk instance */
  public static com.cohesionforce.dis.avro.SixByteChunk.Builder newBuilder(com.cohesionforce.dis.avro.SixByteChunk other) {
    return new com.cohesionforce.dis.avro.SixByteChunk.Builder(other);
  }
  
  /**
   * RecordBuilder for SixByteChunk instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SixByteChunk>
    implements org.apache.avro.data.RecordBuilder<SixByteChunk> {

    private java.util.List<java.lang.Integer> otherParameters;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.SixByteChunk.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.SixByteChunk.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.otherParameters)) {
        this.otherParameters = data().deepCopy(fields()[0].schema(), other.otherParameters);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing SixByteChunk instance */
    private Builder(com.cohesionforce.dis.avro.SixByteChunk other) {
            super(com.cohesionforce.dis.avro.SixByteChunk.SCHEMA$);
      if (isValidValue(fields()[0], other.otherParameters)) {
        this.otherParameters = data().deepCopy(fields()[0].schema(), other.otherParameters);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'otherParameters' field */
    public java.util.List<java.lang.Integer> getOtherParameters() {
      return otherParameters;
    }
    
    /** Sets the value of the 'otherParameters' field */
    public com.cohesionforce.dis.avro.SixByteChunk.Builder setOtherParameters(java.util.List<java.lang.Integer> value) {
      validate(fields()[0], value);
      this.otherParameters = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'otherParameters' field has been set */
    public boolean hasOtherParameters() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'otherParameters' field */
    public com.cohesionforce.dis.avro.SixByteChunk.Builder clearOtherParameters() {
      otherParameters = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public SixByteChunk build() {
      try {
        SixByteChunk record = new SixByteChunk();
        record.otherParameters = fieldSetFlags()[0] ? this.otherParameters : (java.util.List<java.lang.Integer>) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
