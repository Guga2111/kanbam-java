package com.example.kanbam.entity.deserializer;

import com.example.kanbam.entity.Status;
import com.example.kanbam.exception.EnumIncorretFormatException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class StatusDeserializer extends JsonDeserializer<Status> {

    @Override
    public Status deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText().trim();

        if (value.isEmpty()) {
            throw new EnumIncorretFormatException("Campo status não pode ser vazio!");
        }

        try {
            return Status.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new EnumIncorretFormatException(value);
        }
    }
}
