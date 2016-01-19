package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

/**
 * Class of values of the `additionalProperties` and `additionalItems` fields.
 */
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

    /**
     * Returns true if additional properties/items are allowed, false otherwise.
     *
     * Additional properties/items are only disallowed if the JSON value is `false`.
     */
    public boolean areAllowed() {
        return !Objects.equals(allowed, false);
    }
}
