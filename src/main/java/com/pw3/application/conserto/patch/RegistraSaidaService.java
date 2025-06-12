package com.pw3.application.conserto.patch;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Date;

public interface RegistraSaidaService {
    ResponseEntity registraSaida(
            RequestModel requestModel,
            UriComponentsBuilder uriBuilder);

    record RequestModel(
            Long id,

            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
            LocalDate dataSaida
    ) { }
}
