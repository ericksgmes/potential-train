package com.pw3.domain.veiculo;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;
import java.util.UUID;

public record VeiculoId(UUID uuid) {
    public VeiculoId {
        Objects.requireNonNull(uuid, "UUID cannot be null");
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    public static class VeiculoIdConverter
            implements AttributeConverter<VeiculoId, UUID> {

        @Override
        public UUID convertToDatabaseColumn(VeiculoId attribute) {
            return attribute == null ? null : attribute.uuid();
        }

        @Override
        public VeiculoId convertToEntityAttribute(UUID dbData) {
            return dbData == null ? null : new VeiculoId(dbData);
        }
    }
}
