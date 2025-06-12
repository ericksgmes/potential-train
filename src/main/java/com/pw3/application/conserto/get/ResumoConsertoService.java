package com.pw3.application.conserto.get;

import com.pw3.domain.conserto.Conserto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ResumoConsertoService {

    /**
     * Retorna um resumo de todos os consertos ativos (sem paginação).
     *
     * @return ResponseEntity contendo a lista de ConsertoResumoDTO
     */
    ResponseEntity<List<ConsertoResumoDTO>> listarResumo();

    public record ConsertoResumoDTO(
            Long id,
            LocalDate dataEntrada,
            LocalDate dataSaida,
            String nomeMecanico,
            String marcaVeiculo,
            String modeloVeiculo
    ) {
        /** Converte um Conserto de domínio para o DTO de resumo */
        public static ConsertoResumoDTO fromDomain(Conserto c) {
            return new ConsertoResumoDTO(
                    c.getId(),
                    c.getDataDeEntrada(),
                    c.getDataDeSaida(),
                    c.getMecanico().getNome(),
                    c.getVeiculo().getMarca(),
                    c.getVeiculo().getModelo()
            );
        }
    }

}
