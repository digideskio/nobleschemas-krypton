package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class Dependency {
    public Schema schemaDependency;
    public Set<String> propertyDependency;

    @JsonCreator
    public Dependency(Schema schemaDependency) {
        this.schemaDependency = schemaDependency;
    }

    @JsonCreator
    public Dependency(Set<String> propertyDependency) {
        this.propertyDependency = propertyDependency;
    }

    public Dependency schemaDependency(Schema schemaDependency) {
        this.schemaDependency = schemaDependency;
        return this;
    }

    public Dependency propertyDependency(Set<String> propertyDependency) {
        this.propertyDependency = propertyDependency;
        return this;
    }
}
