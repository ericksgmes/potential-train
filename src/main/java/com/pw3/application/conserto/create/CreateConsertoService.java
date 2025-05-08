package com.pw3.application.conserto.create;

import com.pw3.domain.mecanico.Mecanico;
import com.pw3.domain.veiculo.Veiculo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

public interface CreateConsertoService {
    ResponseEntity create(ConsertoDto consertoDto, UriComponentsBuilder uriBuilder);

    record ConsertoDto(
            Date dataEntrada,

            @Valid
            Mecanico mecanico,

            @Valid
            Veiculo veiculo

    ) { }
}
