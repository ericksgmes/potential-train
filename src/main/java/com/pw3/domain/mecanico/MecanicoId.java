package com.pw3.domain.mecanico;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.UUID;

public record MecanicoId(UUID uuid) {
    public MecanicoId {
        Objects.requireNonNull(uuid, "UUID cannot be null");
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    @Converter(autoApply = true)
    public static class MecanicoIdConverter
            implements AttributeConverter<MecanicoId, UUID> {

        @Override
        public UUID convertToDatabaseColumn(MecanicoId attribute) {
            return attribute == null ? null : attribute.uuid();
        }

        @Override
        public MecanicoId convertToEntityAttribute(UUID dbData) {
            return dbData == null ? null : new MecanicoId(dbData);
        }
    }
}
