package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;

public class JsonSchemaDraft4SchemaTest {

    @Test
    public void deserializeJsonSchemaDraft4Schema() throws Exception {
        try (InputStream stream = getClass().getResourceAsStream("json-schema-draft-4-schema.json")) {
            new ObjectMapper().readValue(stream, Schema.class);
        }
    }

}
