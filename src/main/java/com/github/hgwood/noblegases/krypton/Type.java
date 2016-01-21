package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;

import static java.util.Collections.singleton;

/**
 * Class of the values of the `type` field.
 */
public class Type {
    public SimpleType simple;
    public Set<SimpleType> union;

    @JsonCreator
    public Type(SimpleType simple) {
        this.simple = simple;
    }

    @JsonCreator
    public Type(Set<SimpleType> union) {
        this.union = union;
    }

    @JsonValue
    public Object toJson() {
        return isSimple() ? simple : union;
    }

    public Type type(SimpleType type) {
        this.simple = type;
        return this;
    }

    public Type types(Set<SimpleType> types) {
        this.union = types;
        return this;
    }

    @JsonIgnore
    public boolean isSimple() {
        return simple != null;
    }

    @JsonIgnore
    public boolean isUnion() {
        return union != null;
    }

    public Set<SimpleType> toUnion() {
        return isUnion() ? union : singleton(simple);
    }
}
