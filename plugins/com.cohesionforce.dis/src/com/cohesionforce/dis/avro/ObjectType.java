/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ObjectType extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ObjectType\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"entityKind\",\"type\":\"int\"},{\"name\":\"domain\",\"type\":\"int\"},{\"name\":\"country\",\"type\":\"int\"},{\"name\":\"category\",\"type\":\"int\"},{\"name\":\"subcategory\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int entityKind;
  @Deprecated public int domain;
  @Deprecated public int country;
  @Deprecated public int category;
  @Deprecated public int subcategory;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ObjectType() {}

  /**
   * All-args constructor.
   */
  public ObjectType(java.lang.Integer entityKind, java.lang.Integer domain, java.lang.Integer country, java.lang.Integer category, java.lang.Integer subcategory) {
    this.entityKind = entityKind;
    this.domain = domain;
    this.country = country;
    this.category = category;
    this.subcategory = subcategory;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return entityKind;
    case 1: return domain;
    case 2: return country;
    case 3: return category;
    case 4: return subcategory;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: entityKind = (java.lang.Integer)value$; break;
    case 1: domain = (java.lang.Integer)value$; break;
    case 2: country = (java.lang.Integer)value$; break;
    case 3: category = (java.lang.Integer)value$; break;
    case 4: subcategory = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'entityKind' field.
   */
  public java.lang.Integer getEntityKind() {
    return entityKind;
  }

  /**
   * Sets the value of the 'entityKind' field.
   * @param value the value to set.
   */
  public void setEntityKind(java.lang.Integer value) {
    this.entityKind = value;
  }

  /**
   * Gets the value of the 'domain' field.
   */
  public java.lang.Integer getDomain() {
    return domain;
  }

  /**
   * Sets the value of the 'domain' field.
   * @param value the value to set.
   */
  public void setDomain(java.lang.Integer value) {
    this.domain = value;
  }

  /**
   * Gets the value of the 'country' field.
   */
  public java.lang.Integer getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.Integer value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'category' field.
   */
  public java.lang.Integer getCategory() {
    return category;
  }

  /**
   * Sets the value of the 'category' field.
   * @param value the value to set.
   */
  public void setCategory(java.lang.Integer value) {
    this.category = value;
  }

  /**
   * Gets the value of the 'subcategory' field.
   */
  public java.lang.Integer getSubcategory() {
    return subcategory;
  }

  /**
   * Sets the value of the 'subcategory' field.
   * @param value the value to set.
   */
  public void setSubcategory(java.lang.Integer value) {
    this.subcategory = value;
  }

  /** Creates a new ObjectType RecordBuilder */
  public static com.cohesionforce.dis.avro.ObjectType.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.ObjectType.Builder();
  }
  
  /** Creates a new ObjectType RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.ObjectType.Builder newBuilder(com.cohesionforce.dis.avro.ObjectType.Builder other) {
    return new com.cohesionforce.dis.avro.ObjectType.Builder(other);
  }
  
  /** Creates a new ObjectType RecordBuilder by copying an existing ObjectType instance */
  public static com.cohesionforce.dis.avro.ObjectType.Builder newBuilder(com.cohesionforce.dis.avro.ObjectType other) {
    return new com.cohesionforce.dis.avro.ObjectType.Builder(other);
  }
  
  /**
   * RecordBuilder for ObjectType instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ObjectType>
    implements org.apache.avro.data.RecordBuilder<ObjectType> {

    private int entityKind;
    private int domain;
    private int country;
    private int category;
    private int subcategory;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.ObjectType.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.ObjectType.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.entityKind)) {
        this.entityKind = data().deepCopy(fields()[0].schema(), other.entityKind);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.domain)) {
        this.domain = data().deepCopy(fields()[1].schema(), other.domain);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.country)) {
        this.country = data().deepCopy(fields()[2].schema(), other.country);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.subcategory)) {
        this.subcategory = data().deepCopy(fields()[4].schema(), other.subcategory);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ObjectType instance */
    private Builder(com.cohesionforce.dis.avro.ObjectType other) {
            super(com.cohesionforce.dis.avro.ObjectType.SCHEMA$);
      if (isValidValue(fields()[0], other.entityKind)) {
        this.entityKind = data().deepCopy(fields()[0].schema(), other.entityKind);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.domain)) {
        this.domain = data().deepCopy(fields()[1].schema(), other.domain);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.country)) {
        this.country = data().deepCopy(fields()[2].schema(), other.country);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.subcategory)) {
        this.subcategory = data().deepCopy(fields()[4].schema(), other.subcategory);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'entityKind' field */
    public java.lang.Integer getEntityKind() {
      return entityKind;
    }
    
    /** Sets the value of the 'entityKind' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder setEntityKind(int value) {
      validate(fields()[0], value);
      this.entityKind = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'entityKind' field has been set */
    public boolean hasEntityKind() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'entityKind' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder clearEntityKind() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'domain' field */
    public java.lang.Integer getDomain() {
      return domain;
    }
    
    /** Sets the value of the 'domain' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder setDomain(int value) {
      validate(fields()[1], value);
      this.domain = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'domain' field has been set */
    public boolean hasDomain() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'domain' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder clearDomain() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'country' field */
    public java.lang.Integer getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder setCountry(int value) {
      validate(fields()[2], value);
      this.country = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'country' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder clearCountry() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'category' field */
    public java.lang.Integer getCategory() {
      return category;
    }
    
    /** Sets the value of the 'category' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder setCategory(int value) {
      validate(fields()[3], value);
      this.category = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'category' field has been set */
    public boolean hasCategory() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'category' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder clearCategory() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'subcategory' field */
    public java.lang.Integer getSubcategory() {
      return subcategory;
    }
    
    /** Sets the value of the 'subcategory' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder setSubcategory(int value) {
      validate(fields()[4], value);
      this.subcategory = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'subcategory' field has been set */
    public boolean hasSubcategory() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'subcategory' field */
    public com.cohesionforce.dis.avro.ObjectType.Builder clearSubcategory() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public ObjectType build() {
      try {
        ObjectType record = new ObjectType();
        record.entityKind = fieldSetFlags()[0] ? this.entityKind : (java.lang.Integer) defaultValue(fields()[0]);
        record.domain = fieldSetFlags()[1] ? this.domain : (java.lang.Integer) defaultValue(fields()[1]);
        record.country = fieldSetFlags()[2] ? this.country : (java.lang.Integer) defaultValue(fields()[2]);
        record.category = fieldSetFlags()[3] ? this.category : (java.lang.Integer) defaultValue(fields()[3]);
        record.subcategory = fieldSetFlags()[4] ? this.subcategory : (java.lang.Integer) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
