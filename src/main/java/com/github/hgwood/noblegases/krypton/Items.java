package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public Object toJson() {
        return isArray() ? schemas : schema;
    }

    public Items schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public Items schemas(List<Schema> schemas) {
        this.schemas = schemas;
        return this;
    }

    @JsonIgnore
    public boolean isSingle() {
        return schema != null;
    }

    @JsonIgnore
    public boolean isArray() {
        return schemas != null;
    }
}
