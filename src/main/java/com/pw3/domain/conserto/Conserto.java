package com.pw3.domain.conserto;

import com.pw3.application.conserto.create.CreateConsertoService;
import com.pw3.domain.mecanico.Mecanico;
import com.pw3.domain.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "consertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Convert(converter = ConsertoId.ConsertoIdConverter.class)
    private ConsertoId id;

    private Date dataDeEntrada;
    private Date dataDeSaida;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(CreateConsertoService.ConsertoDto conserto) {
        this.dataDeEntrada = conserto.dataEntrada();
        this.mecanico = conserto.mecanico();
        this.veiculo = conserto.veiculo();
    }
}
