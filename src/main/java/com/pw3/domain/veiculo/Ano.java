package com.pw3.domain.veiculo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.regex.Pattern;

public record Ano(String value) {
    private static final Pattern ANO = Pattern.compile("^\\d{4}$");
    public Ano {
        if (!ANO.matcher(value).matches()) {
            throw new IllegalArgumentException("Ano deve ter 4 dígitos: " + value);
        }
    }

    public int getValue(String value) {
        return Integer.parseInt(value);
    }

    @Converter(autoApply = true)
    public static class AnoConverter implements AttributeConverter<Ano, String> {

        @Override
        public String convertToDatabaseColumn(Ano attribute) {
            return attribute == null ? null : attribute.value();
        }

        @Override
        public Ano convertToEntityAttribute(String dbData) {
            return dbData == null ? null : new Ano(dbData);
        }
    }
}
