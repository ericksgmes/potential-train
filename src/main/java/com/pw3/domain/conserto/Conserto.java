package com.pw3.domain.conserto;

import com.pw3.application.conserto.post.CreateConsertoService;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataDeEntrada;
    private Date dataDeSaida;
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

    public void registraSaida(Date dataSaida) { this.dataDeSaida = dataSaida; }

    public void excluir() {
        this.ativo = false;
    }
}
