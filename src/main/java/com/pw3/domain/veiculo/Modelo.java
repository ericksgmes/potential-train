package com.pw3.domain.veiculo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;

public record Modelo(String value) {

    public Modelo {
        Objects.requireNonNull(value, "Modelo não pode ser nulo");
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio");
        }
        if (trimmed.length() > 100) {
            throw new IllegalArgumentException("Modelo não pode exceder 100 caracteres");
        }
        value = trimmed;
    }

    @Converter(autoApply = true)
    public static class ModeloConverter implements AttributeConverter<Modelo, String> {

        @Override
        public String convertToDatabaseColumn(Modelo attribute) {
            return attribute == null ? null : attribute.value();
        }

        @Override
        public Modelo convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new Modelo(dbData);
        }
    }
}
