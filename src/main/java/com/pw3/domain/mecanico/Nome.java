package com.pw3.domain.mecanico;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

public record Nome(String value) {
    public Nome {
        Objects.requireNonNull(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Converter(autoApply = true)
    public static class NomeConverter implements AttributeConverter<Nome, String> {

        @Override
        public String convertToDatabaseColumn(Nome attribute) {
            return attribute.value();
        }

        @Override
        public Nome convertToEntityAttribute(String dbData) {
            return new Nome(dbData);
        }
    }
}
