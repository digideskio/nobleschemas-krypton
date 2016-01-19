package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class Additionals {
    public Boolean allowed;
    public Schema schema;

    @JsonCreator
    public Additionals(Boolean allowed) {
        this.allowed = allowed;
    }

    @JsonCreator
    public Additionals(Schema schema) {
        this.schema = schema;
    }

    public Additionals allowed(Boolean allowed) {
        this.allowed = allowed;
        return this;
    }

    public Additionals schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public boolean isBoolean() {
        return allowed != null;
    }

    public boolean haveSchema() {
        return schema != null;
    }

    public boolean areAllowed() {
        return !Objects.equals(allowed, false);
    }
}
