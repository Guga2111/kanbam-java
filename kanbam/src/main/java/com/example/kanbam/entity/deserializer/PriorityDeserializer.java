package com.example.kanbam.entity.deserializer;

import com.example.kanbam.entity.Priority;
import com.example.kanbam.entity.Status;
import com.example.kanbam.exception.EnumIncorretFormatException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class PriorityDeserializer extends JsonDeserializer<Priority> {

    @Override
    public Priority deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText().trim();

        if (value.isEmpty()) {
            throw new EnumIncorretFormatException("Campo status não pode ser vazio!");
        }

        try {
            return Priority.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new EnumIncorretFormatException(value);
        }
    }
}
