package com.encora.flightapp.services;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import org.threeten.bp.format.DateTimeFormatter;
//import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateDeserializer extends StdDeserializer<LocalDate> {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");

    public CustomDateDeserializer() {
        this(null);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String date = p.getText();

        return LocalDate.parse(date, formatter);

    }


    public CustomDateDeserializer(Class<LocalDate> t) {
        super(t);
    }




}
