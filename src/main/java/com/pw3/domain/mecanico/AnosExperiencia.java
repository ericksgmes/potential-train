package com.pw3.domain.mecanico;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public record AnosExperiencia(int value) {
    public AnosExperiencia{
        if (value < 0) {
            throw new IllegalArgumentException(
                    "Anos de experiência não pode ser negativo: " + value
            );
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Converter(autoApply = true)
    public static class AnosExperienciaConverter
            implements AttributeConverter<AnosExperiencia, Integer> {

        @Override
        public Integer convertToDatabaseColumn(AnosExperiencia attribute) {
            return (attribute == null ? null : attribute.value());
        }

        @Override
        public AnosExperiencia convertToEntityAttribute(Integer dbData) {
            return (dbData == null ? null : new AnosExperiencia(dbData));
        }
    }
}
