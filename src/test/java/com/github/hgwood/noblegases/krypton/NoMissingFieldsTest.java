package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Iterator;

public class NoMissingFieldsTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void schema_contains_all_fields_and_setters_defined_by_the_spec() throws Exception {
        JsonNode expected = deserializeToJsonTree();
        for (String propertyName : iterable(expected.get("properties").fieldNames())) {
            if (propertyName.equals("default") || propertyName.equals("enum")) propertyName = "_" + propertyName;
            Field field = Schema.class.getField(propertyName); // will throw if field is absent
            Schema.class.getMethod(propertyName, field.getType()); // will throw if setter is absent
        }
    }

    private JsonNode deserializeToJsonTree() throws IOException {
        try (InputStream stream = getClass().getResourceAsStream("json-schema-draft-4-schema.json")) {
            return objectMapper.readValue(stream, JsonNode.class);
        }
    }

    private <T> Iterable<T> iterable(final Iterator<T> iterator) {
        return new Iterable<T>() {
            @Override public Iterator<T> iterator() {
                return iterator;
            }
        };
    }

}
