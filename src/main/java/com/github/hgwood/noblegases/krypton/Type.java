package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class Type {
    public String type;
    public Set<String> types;

    @JsonCreator
    public Type(String type) {
        this.type = type;
    }

    @JsonCreator
    public Type(Set<String> types) {
        this.types = types;
    }

    public Type type(String type) {
        this.type = type;
        return this;
    }

    public Type types(Set<String> types) {
        this.types = types;
        return this;
    }

    public boolean isArray() {
        return types != null;
    }
}
