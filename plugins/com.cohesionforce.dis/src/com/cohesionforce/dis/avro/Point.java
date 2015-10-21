/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Point extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Point\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"x\",\"type\":\"float\"},{\"name\":\"y\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public float x;
  @Deprecated public float y;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Point() {}

  /**
   * All-args constructor.
   */
  public Point(java.lang.Float x, java.lang.Float y) {
    this.x = x;
    this.y = y;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return x;
    case 1: return y;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: x = (java.lang.Float)value$; break;
    case 1: y = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'x' field.
   */
  public java.lang.Float getX() {
    return x;
  }

  /**
   * Sets the value of the 'x' field.
   * @param value the value to set.
   */
  public void setX(java.lang.Float value) {
    this.x = value;
  }

  /**
   * Gets the value of the 'y' field.
   */
  public java.lang.Float getY() {
    return y;
  }

  /**
   * Sets the value of the 'y' field.
   * @param value the value to set.
   */
  public void setY(java.lang.Float value) {
    this.y = value;
  }

  /** Creates a new Point RecordBuilder */
  public static com.cohesionforce.dis.avro.Point.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.Point.Builder();
  }
  
  /** Creates a new Point RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.Point.Builder newBuilder(com.cohesionforce.dis.avro.Point.Builder other) {
    return new com.cohesionforce.dis.avro.Point.Builder(other);
  }
  
  /** Creates a new Point RecordBuilder by copying an existing Point instance */
  public static com.cohesionforce.dis.avro.Point.Builder newBuilder(com.cohesionforce.dis.avro.Point other) {
    return new com.cohesionforce.dis.avro.Point.Builder(other);
  }
  
  /**
   * RecordBuilder for Point instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Point>
    implements org.apache.avro.data.RecordBuilder<Point> {

    private float x;
    private float y;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.Point.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.Point.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.x)) {
        this.x = data().deepCopy(fields()[0].schema(), other.x);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.y)) {
        this.y = data().deepCopy(fields()[1].schema(), other.y);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Point instance */
    private Builder(com.cohesionforce.dis.avro.Point other) {
            super(com.cohesionforce.dis.avro.Point.SCHEMA$);
      if (isValidValue(fields()[0], other.x)) {
        this.x = data().deepCopy(fields()[0].schema(), other.x);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.y)) {
        this.y = data().deepCopy(fields()[1].schema(), other.y);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'x' field */
    public java.lang.Float getX() {
      return x;
    }
    
    /** Sets the value of the 'x' field */
    public com.cohesionforce.dis.avro.Point.Builder setX(float value) {
      validate(fields()[0], value);
      this.x = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'x' field has been set */
    public boolean hasX() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'x' field */
    public com.cohesionforce.dis.avro.Point.Builder clearX() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'y' field */
    public java.lang.Float getY() {
      return y;
    }
    
    /** Sets the value of the 'y' field */
    public com.cohesionforce.dis.avro.Point.Builder setY(float value) {
      validate(fields()[1], value);
      this.y = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'y' field has been set */
    public boolean hasY() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'y' field */
    public com.cohesionforce.dis.avro.Point.Builder clearY() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Point build() {
      try {
        Point record = new Point();
        record.x = fieldSetFlags()[0] ? this.x : (java.lang.Float) defaultValue(fields()[0]);
        record.y = fieldSetFlags()[1] ? this.y : (java.lang.Float) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}