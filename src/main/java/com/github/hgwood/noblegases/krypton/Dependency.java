package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;

/**
 * Class of the values of the object found in the `dependencies` field.
 */
public class Dependency {
    public Schema schema;
    public Set<String> property;

    @JsonCreator
    public Dependency(Schema schema) {
        this.schema = schema;
    }

    @JsonCreator
    public Dependency(Set<String> property) {
        this.property = property;
    }

    @JsonValue
    public Object toJson() {
        return isSchema() ? schema : property;
    }

    public Dependency schemaDependency(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Dependency propertyDependency(Set<String> property) {
        this.property = property;
        return this;
    }

    @JsonIgnore
    public boolean isSchema() {
        return schema != null;
    }

    @JsonIgnore
    public boolean isProperty() {
        return property != null;
    }
}
