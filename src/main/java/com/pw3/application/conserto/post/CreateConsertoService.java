package com.pw3.application.conserto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pw3.domain.mecanico.Mecanico;
import com.pw3.domain.veiculo.Veiculo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Date;

public interface CreateConsertoService {
    ResponseEntity create(RequestModel requestModel, UriComponentsBuilder uriBuilder);

    record RequestModel(
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
            LocalDate dataEntrada,

            @Valid
            Mecanico mecanico,

            @Valid
            Veiculo veiculo
    ) { }
}
