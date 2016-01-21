package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SimpleType {
    ARRAY,
    BOOLEAN,
    INTEGER,
    NULL,
    NUMBER,
    OBJECT,
    STRING;

    @JsonCreator
    public static SimpleType fromJson(String jsonStringValue) {
        for (SimpleType simpleType : values()) {
            if (simpleType.toString().equals(jsonStringValue)) return simpleType;
        }
        throw new IllegalArgumentException("Invalid primitive type: " + jsonStringValue);
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }

    /**
     * @deprecated use {@link #toJson()} instead to get the name in lower case. Will return the name in upper case
     * starting from 2.0.
     */
    @Deprecated
    @Override
    public String toString() {
        return toJson();
    }
}
