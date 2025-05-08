package com.pw3.domain.veiculo;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    @UuidGenerator
    @GeneratedValue
    @Convert(converter = VeiculoId.VeiculoIdConverter.class)
    private VeiculoId id;

    @Convert(converter = Marca.MarcaConverter.class)
    private Marca marca;

    @Convert(converter = Modelo.ModeloConverter.class)
    private Modelo modelo;

    @Convert(converter = Ano.AnoConverter.class)
    private Ano ano;
}
