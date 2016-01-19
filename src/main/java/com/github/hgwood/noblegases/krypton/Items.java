package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

/**
 * Class of the values of the `items` field.
 */
public class Items {
    public Schema schema;
    public List<Schema> schemas;

    @JsonCreator
    public Items(Schema schema) {
        this.schema = schema;
    }

    @JsonCreator
    public Items(List<Schema> schemas) {
        this.schemas = schemas;
    }

    public Items schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Items schemas(List<Schema> schemas) {
        this.schemas = schemas;
        return this;
    }

    public boolean isArray() {
        return schemas != null;
    }
}
