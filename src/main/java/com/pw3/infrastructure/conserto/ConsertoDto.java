package com.pw3.infrastructure.conserto;

import com.pw3.domain.conserto.Conserto;
import com.pw3.domain.mecanico.Mecanico;
import com.pw3.domain.veiculo.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record ConsertoDto(

        @NotNull
        LocalDate dataEntrada,

        @NotNull
        LocalDate dataSaida,

        @Valid @NotNull
        Mecanico mecanico,

        @Valid @NotNull
        Veiculo veiculo

) {
    public static ConsertoDto fromDomain(Conserto c) {
        return new ConsertoDto(
                c.getDataDeEntrada(),
                c.getDataDeSaida(),
                c.getMecanico(),
                c.getVeiculo()
        );
    }
}
