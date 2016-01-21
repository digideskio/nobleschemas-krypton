package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

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

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
