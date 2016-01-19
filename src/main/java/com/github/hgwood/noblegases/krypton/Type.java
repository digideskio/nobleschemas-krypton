package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

/**
 * Class of the values of the `type` field.
 */
public class Type {
    public SimpleType type;
    public Set<SimpleType> types;

    @JsonCreator
    public Type(SimpleType type) {
        this.type = type;
    }

    @JsonCreator
    public Type(Set<SimpleType> types) {
        this.types = types;
    }

    public Type type(SimpleType type) {
        this.type = type;
        return this;
    }

    public Type types(Set<SimpleType> types) {
        this.types = types;
        return this;
    }

    public boolean isArray() {
        return types != null;
    }
}
