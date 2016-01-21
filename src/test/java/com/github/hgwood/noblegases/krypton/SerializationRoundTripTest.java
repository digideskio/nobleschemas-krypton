package com.github.hgwood.noblegases.krypton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static java.nio.file.Files.createTempFile;

public class SerializationRoundTripTest {

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer()
        .with(SerializationFeature.INDENT_OUTPUT);

    @Test
    public void a_serialized_schema_is_deserializable() throws Exception {
        serializationRoundtrip(deserialize());
    }

    private Schema deserialize() throws IOException {
        try (InputStream stream = getClass().getResourceAsStream("json-schema-draft-4-schema.json")) {
            return objectMapper.readValue(stream, Schema.class);
        }
    }

    private Schema serializationRoundtrip(Schema schema) throws IOException {
        Path path = createTempFile(getClass().getCanonicalName(), ".schema.json");
        objectWriter.writeValue(path.toFile(), schema);
        return objectMapper.readValue(path.toFile(), Schema.class);
    }

}
