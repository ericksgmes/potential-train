package com.pw3.domain.mecanico;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public Email {
        Objects.requireNonNull(value, "Email cannot be null");
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Email inválido: " + value);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email other)) return false;
        return value.equals(other.value);
    }

    @Converter(autoApply = true)
    public static class EmailConverter
            implements AttributeConverter<Email, String> {

        @Override
        public String convertToDatabaseColumn(Email attribute) {
            return attribute == null ? null : attribute.value();
        }

        @Override
        public Email convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new Email(dbData);
        }
    }
}
