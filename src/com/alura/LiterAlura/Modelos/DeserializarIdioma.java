package com.alura.LiterAlura.Modelos;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.IOException;
import java.util.Arrays;

public class DeserializarIdioma extends JsonDeserializer<Idioma> {

    @Override
    public Idioma deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        String key = jsonParser.getText().toUpperCase().trim();

        return Arrays.stream(Idioma.values())
                .filter(idioma -> idioma.getIdioma().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una constante en com.alura.LiterAlura.Modelos.Idioma." + key));
    }
}
