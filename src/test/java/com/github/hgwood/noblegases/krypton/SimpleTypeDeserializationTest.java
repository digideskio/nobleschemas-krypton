package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class SimpleTypeDeserializationTest {

    @Test
    public void test() throws Exception {
        for (SimpleType simpleType : SimpleType.values()) {
            assertEquals(format("expected '%s' to deserialize into '%s'", simpleType.toString(), simpleType.name()),
                simpleType, new ObjectMapper().readValue(format("\"%s\"", simpleType.toString()), SimpleType.class));
        }
    }

}
