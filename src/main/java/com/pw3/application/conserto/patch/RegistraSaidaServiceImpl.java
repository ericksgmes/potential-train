package com.pw3.application.conserto.patch;

import com.pw3.util.ConsertoNotFoundException;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class RegistraSaidaServiceImpl implements RegistraSaidaService {
    public RegistraSaidaServiceImpl(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    private final ConsertoRepository consertoRepository;

    @Override
    public ResponseEntity registraSaida(RequestModel requestModel, UriComponentsBuilder uriBuilder) {
        var conserto = consertoRepository.findById(requestModel.id())
                .orElseThrow(() -> new ConsertoNotFoundException(requestModel.id()));

        conserto.registraSaida(requestModel.dataSaida());

        consertoRepository.save(conserto);

        return ResponseEntity.noContent().build();
    }
}
