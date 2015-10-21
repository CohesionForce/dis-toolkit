/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cohesionforce.dis.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EntityID extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EntityID\",\"namespace\":\"com.cohesionforce.dis.avro\",\"fields\":[{\"name\":\"site\",\"type\":\"int\"},{\"name\":\"application\",\"type\":\"int\"},{\"name\":\"entity\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int site;
  @Deprecated public int application;
  @Deprecated public int entity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EntityID() {}

  /**
   * All-args constructor.
   */
  public EntityID(java.lang.Integer site, java.lang.Integer application, java.lang.Integer entity) {
    this.site = site;
    this.application = application;
    this.entity = entity;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return site;
    case 1: return application;
    case 2: return entity;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: site = (java.lang.Integer)value$; break;
    case 1: application = (java.lang.Integer)value$; break;
    case 2: entity = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'site' field.
   */
  public java.lang.Integer getSite() {
    return site;
  }

  /**
   * Sets the value of the 'site' field.
   * @param value the value to set.
   */
  public void setSite(java.lang.Integer value) {
    this.site = value;
  }

  /**
   * Gets the value of the 'application' field.
   */
  public java.lang.Integer getApplication() {
    return application;
  }

  /**
   * Sets the value of the 'application' field.
   * @param value the value to set.
   */
  public void setApplication(java.lang.Integer value) {
    this.application = value;
  }

  /**
   * Gets the value of the 'entity' field.
   */
  public java.lang.Integer getEntity() {
    return entity;
  }

  /**
   * Sets the value of the 'entity' field.
   * @param value the value to set.
   */
  public void setEntity(java.lang.Integer value) {
    this.entity = value;
  }

  /** Creates a new EntityID RecordBuilder */
  public static com.cohesionforce.dis.avro.EntityID.Builder newBuilder() {
    return new com.cohesionforce.dis.avro.EntityID.Builder();
  }
  
  /** Creates a new EntityID RecordBuilder by copying an existing Builder */
  public static com.cohesionforce.dis.avro.EntityID.Builder newBuilder(com.cohesionforce.dis.avro.EntityID.Builder other) {
    return new com.cohesionforce.dis.avro.EntityID.Builder(other);
  }
  
  /** Creates a new EntityID RecordBuilder by copying an existing EntityID instance */
  public static com.cohesionforce.dis.avro.EntityID.Builder newBuilder(com.cohesionforce.dis.avro.EntityID other) {
    return new com.cohesionforce.dis.avro.EntityID.Builder(other);
  }
  
  /**
   * RecordBuilder for EntityID instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EntityID>
    implements org.apache.avro.data.RecordBuilder<EntityID> {

    private int site;
    private int application;
    private int entity;

    /** Creates a new Builder */
    private Builder() {
      super(com.cohesionforce.dis.avro.EntityID.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cohesionforce.dis.avro.EntityID.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.site)) {
        this.site = data().deepCopy(fields()[0].schema(), other.site);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.application)) {
        this.application = data().deepCopy(fields()[1].schema(), other.application);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.entity)) {
        this.entity = data().deepCopy(fields()[2].schema(), other.entity);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EntityID instance */
    private Builder(com.cohesionforce.dis.avro.EntityID other) {
            super(com.cohesionforce.dis.avro.EntityID.SCHEMA$);
      if (isValidValue(fields()[0], other.site)) {
        this.site = data().deepCopy(fields()[0].schema(), other.site);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.application)) {
        this.application = data().deepCopy(fields()[1].schema(), other.application);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.entity)) {
        this.entity = data().deepCopy(fields()[2].schema(), other.entity);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'site' field */
    public java.lang.Integer getSite() {
      return site;
    }
    
    /** Sets the value of the 'site' field */
    public com.cohesionforce.dis.avro.EntityID.Builder setSite(int value) {
      validate(fields()[0], value);
      this.site = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'site' field has been set */
    public boolean hasSite() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'site' field */
    public com.cohesionforce.dis.avro.EntityID.Builder clearSite() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'application' field */
    public java.lang.Integer getApplication() {
      return application;
    }
    
    /** Sets the value of the 'application' field */
    public com.cohesionforce.dis.avro.EntityID.Builder setApplication(int value) {
      validate(fields()[1], value);
      this.application = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'application' field has been set */
    public boolean hasApplication() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'application' field */
    public com.cohesionforce.dis.avro.EntityID.Builder clearApplication() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'entity' field */
    public java.lang.Integer getEntity() {
      return entity;
    }
    
    /** Sets the value of the 'entity' field */
    public com.cohesionforce.dis.avro.EntityID.Builder setEntity(int value) {
      validate(fields()[2], value);
      this.entity = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'entity' field has been set */
    public boolean hasEntity() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'entity' field */
    public com.cohesionforce.dis.avro.EntityID.Builder clearEntity() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public EntityID build() {
      try {
        EntityID record = new EntityID();
        record.site = fieldSetFlags()[0] ? this.site : (java.lang.Integer) defaultValue(fields()[0]);
        record.application = fieldSetFlags()[1] ? this.application : (java.lang.Integer) defaultValue(fields()[1]);
        record.entity = fieldSetFlags()[2] ? this.entity : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
