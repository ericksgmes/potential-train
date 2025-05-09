package com.pw3.application.conserto.patch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

public interface RegistraSaidaService {
    ResponseEntity registraSaida(
            RequestModel requestModel,
            UriComponentsBuilder uriBuilder);

    record RequestModel(
            Long id,
            Date dataSaida
    ) { }
}
