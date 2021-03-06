/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Marking extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Marking\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"characterSet\",\"type\":\"int\"},{\"name\":\"characters\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int characterSet;
  @Deprecated public java.util.List<java.lang.Integer> characters;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Marking() {}

  /**
   * All-args constructor.
   */
  public Marking(java.lang.Integer characterSet, java.util.List<java.lang.Integer> characters) {
    this.characterSet = characterSet;
    this.characters = characters;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return characterSet;
    case 1: return characters;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: characterSet = (java.lang.Integer)value$; break;
    case 1: characters = (java.util.List<java.lang.Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'characterSet' field.
   */
  public java.lang.Integer getCharacterSet() {
    return characterSet;
  }

  /**
   * Sets the value of the 'characterSet' field.
   * @param value the value to set.
   */
  public void setCharacterSet(java.lang.Integer value) {
    this.characterSet = value;
  }

  /**
   * Gets the value of the 'characters' field.
   */
  public java.util.List<java.lang.Integer> getCharacters() {
    return characters;
  }

  /**
   * Sets the value of the 'characters' field.
   * @param value the value to set.
   */
  public void setCharacters(java.util.List<java.lang.Integer> value) {
    this.characters = value;
  }

  /** Creates a new Marking RecordBuilder */
  public static com.cohesionforce.dis.avro.Marking.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.Marking.Builder();
  }
  
  /** Creates a new Marking RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.Marking.Builder newBuilder(com.cohesionforce.dis.avro.Marking.Builder other) {
    return new com.cohesionforce.dis.avro.Marking.Builder(other);
  }
  
  /** Creates a new Marking RecordBuilder by copying an existing Marking instance */
  public static com.cohesionforce.dis.avro.Marking.Builder newBuilder(com.cohesionforce.dis.avro.Marking other) {
    return new com.cohesionforce.dis.avro.Marking.Builder(other);
  }
  
  /**
   * RecordBuilder for Marking instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Marking>
    implements org.apache.avro.data.RecordBuilder<Marking> {

    private int characterSet;
    private java.util.List<java.lang.Integer> characters;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.Marking.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.Marking.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.characterSet)) {
        this.characterSet = data().deepCopy(fields()[0].schema(), other.characterSet);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.characters)) {
        this.characters = data().deepCopy(fields()[1].schema(), other.characters);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Marking instance */
    private Builder(com.cohesionforce.dis.avro.Marking other) {
            super(com.cohesionforce.dis.avro.Marking.SCHEMA$);
      if (isValidValue(fields()[0], other.characterSet)) {
        this.characterSet = data().deepCopy(fields()[0].schema(), other.characterSet);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.characters)) {
        this.characters = data().deepCopy(fields()[1].schema(), other.characters);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'characterSet' field */
    public java.lang.Integer getCharacterSet() {
      return characterSet;
    }
    
    /** Sets the value of the 'characterSet' field */
    public com.cohesionforce.dis.avro.Marking.Builder setCharacterSet(int value) {
      validate(fields()[0], value);
      this.characterSet = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'characterSet' field has been set */
    public boolean hasCharacterSet() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'characterSet' field */
    public com.cohesionforce.dis.avro.Marking.Builder clearCharacterSet() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'characters' field */
    public java.util.List<java.lang.Integer> getCharacters() {
      return characters;
    }
    
    /** Sets the value of the 'characters' field */
    public com.cohesionforce.dis.avro.Marking.Builder setCharacters(java.util.List<java.lang.Integer> value) {
      validate(fields()[1], value);
      this.characters = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'characters' field has been set */
    public boolean hasCharacters() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'characters' field */
    public com.cohesionforce.dis.avro.Marking.Builder clearCharacters() {
      characters = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Marking build() {
      try {
        Marking record = new Marking();
        record.characterSet = fieldSetFlags()[0] ? this.characterSet : (java.lang.Integer) defaultValue(fields()[0]);
        record.characters = fieldSetFlags()[1] ? this.characters : (java.util.List<java.lang.Integer>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
