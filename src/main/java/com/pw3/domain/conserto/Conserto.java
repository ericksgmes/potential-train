package com.pw3.domain.conserto;

import com.pw3.application.conserto.post.CreateConsertoService;
import com.pw3.domain.mecanico.Mecanico;
import com.pw3.domain.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "consertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    private LocalDate dataDeEntrada;
    private LocalDate dataDeSaida;
    private boolean ativo;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(CreateConsertoService.RequestModel conserto) {
        this.dataDeEntrada = conserto.dataEntrada();
        this.mecanico = conserto.mecanico();
        this.veiculo = conserto.veiculo();
        this.ativo = true;
    }

    public void registraSaida(LocalDate dataSaida) { this.dataDeSaida = dataSaida; }

    public void excluir() {
        this.ativo = false;
    }
}
