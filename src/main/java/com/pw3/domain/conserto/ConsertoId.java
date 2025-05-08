package com.pw3.domain.conserto;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;

public record ConsertoId(Long id) {
    public ConsertoId {
        Objects.requireNonNull(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public static class ConsertoIdConverter
    implements AttributeConverter<ConsertoId, Long> {

        @Override
        public Long convertToDatabaseColumn(ConsertoId attribute) {
            return attribute == null ? null : attribute.id();
        }

        @Override
        public ConsertoId convertToEntityAttribute(Long dbData) {
            return dbData == null ? null : new ConsertoId(dbData);
        }
    }
}
