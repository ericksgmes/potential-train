package com.pw3.domain.veiculo;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public record Marca(String value) {
    public Marca {
        Objects.requireNonNull(value);
    }

    @Override
    public String toString() {
        return value;
    }

    public static class MarcaConverter
    implements AttributeConverter<Marca, String> {
        @Override
        public String convertToDatabaseColumn(Marca attribute) {
            return attribute == null ? null : attribute.value();
        }

        @Override
        public Marca convertToEntityAttribute(String dbData) {
            return new Marca(dbData);
        }
    }
}
