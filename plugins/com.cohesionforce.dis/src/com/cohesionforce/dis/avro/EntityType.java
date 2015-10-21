/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EntityType extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EntityType\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"entityKind\",\"type\":\"int\"},{\"name\":\"domain\",\"type\":\"int\"},{\"name\":\"country\",\"type\":\"int\"},{\"name\":\"category\",\"type\":\"int\"},{\"name\":\"subcategory\",\"type\":\"int\"},{\"name\":\"spec\",\"type\":\"int\"},{\"name\":\"extra\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int entityKind;
  @Deprecated public int domain;
  @Deprecated public int country;
  @Deprecated public int category;
  @Deprecated public int subcategory;
  @Deprecated public int spec;
  @Deprecated public int extra;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EntityType() {}

  /**
   * All-args constructor.
   */
  public EntityType(java.lang.Integer entityKind, java.lang.Integer domain, java.lang.Integer country, java.lang.Integer category, java.lang.Integer subcategory, java.lang.Integer spec, java.lang.Integer extra) {
    this.entityKind = entityKind;
    this.domain = domain;
    this.country = country;
    this.category = category;
    this.subcategory = subcategory;
    this.spec = spec;
    this.extra = extra;
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
    case 5: return spec;
    case 6: return extra;
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
    case 5: spec = (java.lang.Integer)value$; break;
    case 6: extra = (java.lang.Integer)value$; break;
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

  /**
   * Gets the value of the 'spec' field.
   */
  public java.lang.Integer getSpec() {
    return spec;
  }

  /**
   * Sets the value of the 'spec' field.
   * @param value the value to set.
   */
  public void setSpec(java.lang.Integer value) {
    this.spec = value;
  }

  /**
   * Gets the value of the 'extra' field.
   */
  public java.lang.Integer getExtra() {
    return extra;
  }

  /**
   * Sets the value of the 'extra' field.
   * @param value the value to set.
   */
  public void setExtra(java.lang.Integer value) {
    this.extra = value;
  }

  /** Creates a new EntityType RecordBuilder */
  public static com.cohesionforce.dis.avro.EntityType.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.EntityType.Builder();
  }
  
  /** Creates a new EntityType RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.EntityType.Builder newBuilder(com.cohesionforce.dis.avro.EntityType.Builder other) {
    return new com.cohesionforce.dis.avro.EntityType.Builder(other);
  }
  
  /** Creates a new EntityType RecordBuilder by copying an existing EntityType instance */
  public static com.cohesionforce.dis.avro.EntityType.Builder newBuilder(com.cohesionforce.dis.avro.EntityType other) {
    return new com.cohesionforce.dis.avro.EntityType.Builder(other);
  }
  
  /**
   * RecordBuilder for EntityType instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EntityType>
    implements org.apache.avro.data.RecordBuilder<EntityType> {

    private int entityKind;
    private int domain;
    private int country;
    private int category;
    private int subcategory;
    private int spec;
    private int extra;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.EntityType.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.EntityType.Builder other) {
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
      if (isValidValue(fields()[5], other.spec)) {
        this.spec = data().deepCopy(fields()[5].schema(), other.spec);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.extra)) {
        this.extra = data().deepCopy(fields()[6].schema(), other.extra);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EntityType instance */
    private Builder(com.cohesionforce.dis.avro.EntityType other) {
            super(com.cohesionforce.dis.avro.EntityType.SCHEMA$);
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
      if (isValidValue(fields()[5], other.spec)) {
        this.spec = data().deepCopy(fields()[5].schema(), other.spec);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.extra)) {
        this.extra = data().deepCopy(fields()[6].schema(), other.extra);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'entityKind' field */
    public java.lang.Integer getEntityKind() {
      return entityKind;
    }
    
    /** Sets the value of the 'entityKind' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setEntityKind(int value) {
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
    public com.cohesionforce.dis.avro.EntityType.Builder clearEntityKind() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'domain' field */
    public java.lang.Integer getDomain() {
      return domain;
    }
    
    /** Sets the value of the 'domain' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setDomain(int value) {
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
    public com.cohesionforce.dis.avro.EntityType.Builder clearDomain() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'country' field */
    public java.lang.Integer getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setCountry(int value) {
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
    public com.cohesionforce.dis.avro.EntityType.Builder clearCountry() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'category' field */
    public java.lang.Integer getCategory() {
      return category;
    }
    
    /** Sets the value of the 'category' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setCategory(int value) {
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
    public com.cohesionforce.dis.avro.EntityType.Builder clearCategory() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'subcategory' field */
    public java.lang.Integer getSubcategory() {
      return subcategory;
    }
    
    /** Sets the value of the 'subcategory' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setSubcategory(int value) {
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
    public com.cohesionforce.dis.avro.EntityType.Builder clearSubcategory() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'spec' field */
    public java.lang.Integer getSpec() {
      return spec;
    }
    
    /** Sets the value of the 'spec' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setSpec(int value) {
      validate(fields()[5], value);
      this.spec = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'spec' field has been set */
    public boolean hasSpec() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'spec' field */
    public com.cohesionforce.dis.avro.EntityType.Builder clearSpec() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'extra' field */
    public java.lang.Integer getExtra() {
      return extra;
    }
    
    /** Sets the value of the 'extra' field */
    public com.cohesionforce.dis.avro.EntityType.Builder setExtra(int value) {
      validate(fields()[6], value);
      this.extra = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'extra' field has been set */
    public boolean hasExtra() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'extra' field */
    public com.cohesionforce.dis.avro.EntityType.Builder clearExtra() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public EntityType build() {
      try {
        EntityType record = new EntityType();
        record.entityKind = fieldSetFlags()[0] ? this.entityKind : (java.lang.Integer) defaultValue(fields()[0]);
        record.domain = fieldSetFlags()[1] ? this.domain : (java.lang.Integer) defaultValue(fields()[1]);
        record.country = fieldSetFlags()[2] ? this.country : (java.lang.Integer) defaultValue(fields()[2]);
        record.category = fieldSetFlags()[3] ? this.category : (java.lang.Integer) defaultValue(fields()[3]);
        record.subcategory = fieldSetFlags()[4] ? this.subcategory : (java.lang.Integer) defaultValue(fields()[4]);
        record.spec = fieldSetFlags()[5] ? this.spec : (java.lang.Integer) defaultValue(fields()[5]);
        record.extra = fieldSetFlags()[6] ? this.extra : (java.lang.Integer) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}