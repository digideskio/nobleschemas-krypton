package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

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

    public Dependency schemaDependency(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Dependency propertyDependency(Set<String> property) {
        this.property = property;
        return this;
    }

    public boolean isSchema() {
        return schema != null;
    }

    public boolean isProperty() {
        return property != null;
    }
}
