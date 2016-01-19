package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Schema {
    public String $ref;
    public String id;
    public String $schema;
    public String title;
    public String description;
    @JsonProperty("default") public Object _default;
    public BigDecimal multipleOf;
    public BigDecimal maximum;
    public Boolean exclusiveMaximum;
    public BigDecimal minimum;
    public Boolean exclusiveMinimum;
    public BigInteger maxLength;
    public BigInteger minLength;
    public String pattern;
    public Additionals additionalItems;
    public Items items;
    public BigInteger maxItems;
    public BigInteger minItems;
    public Boolean uniqueItems;
    public BigInteger maxProperties;
    public BigInteger minProperties;
    public List<String> required;
    public Additionals additionalProperties;
    public Map<String, Schema> definitions;
    public Map<String, Schema> properties;
    public Map<String, Dependency> dependencies;
    @JsonProperty("enum") public Set<Object> _enum;
    public Type type;
    public String format;
    public List<Schema> allOf;
    public List<Schema> anyOf;
    public List<Schema> oneOf;
    public Schema not;

    public Schema $ref(String $ref) {
        this.$ref = $ref;
        return this;
    }

    public Schema id(String id) {
        this.id = id;
        return this;
    }

    public Schema $schema(String $schema) {
        this.$schema = $schema;
        return this;
    }

    public Schema title(String title) {
        this.title = title;
        return this;
    }

    public Schema description(String description) {
        this.description = description;
        return this;
    }

    public Schema _default(Object _default) {
        this._default = _default;
        return this;
    }

    public Schema multipleOf(BigDecimal multipleOf) {
        this.multipleOf = multipleOf;
        return this;
    }

    public Schema maximum(BigDecimal maximum) {
        this.maximum = maximum;
        return this;
    }

    public Schema exclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
        return this;
    }

    public Schema minimum(BigDecimal minimum) {
        this.minimum = minimum;
        return this;
    }

    public Schema exclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
        return this;
    }

    public Schema maxLength(BigInteger maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public Schema minLength(BigInteger minLength) {
        this.minLength = minLength;
        return this;
    }

    public Schema pattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public Schema additionalItems(Additionals additionalItems) {
        this.additionalItems = additionalItems;
        return this;
    }

    public Schema items(Items items) {
        this.items = items;
        return this;
    }

    public Schema maxItems(BigInteger maxItems) {
        this.maxItems = maxItems;
        return this;
    }

    public Schema minItems(BigInteger minItems) {
        this.minItems = minItems;
        return this;
    }

    public Schema uniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
        return this;
    }

    public Schema maxProperties(BigInteger maxProperties) {
        this.maxProperties = maxProperties;
        return this;
    }

    public Schema minProperties(BigInteger minProperties) {
        this.minProperties = minProperties;
        return this;
    }

    public Schema required(List<String> required) {
        this.required = required;
        return this;
    }

    public Schema additionalProperties(Additionals additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    public Schema definitions(Map<String, Schema> definitions) {
        this.definitions = definitions;
        return this;
    }

    public Schema properties(Map<String, Schema> properties) {
        this.properties = properties;
        return this;
    }

    public Schema dependencies(Map<String, Dependency> dependencies) {
        this.dependencies = dependencies;
        return this;
    }

    public Schema _enum(Set<Object> _enum) {
        this._enum = _enum;
        return this;
    }

    public Schema type(Type type) {
        this.type = type;
        return this;
    }

    public Schema format(String format) {
        this.format = format;
        return this;
    }

    public Schema allOf(List<Schema> allOf) {
        this.allOf = allOf;
        return this;
    }

    public Schema anyOf(List<Schema> anyOf) {
        this.anyOf = anyOf;
        return this;
    }

    public Schema oneOf(List<Schema> oneOf) {
        this.oneOf = oneOf;
        return this;
    }

    public Schema not(Schema not) {
        this.not = not;
        return this;
    }

    public boolean isRef() {
        return $ref != null;
    }
}
