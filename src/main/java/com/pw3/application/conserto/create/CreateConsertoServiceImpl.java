package com.pw3.application.conserto.create;

import com.pw3.domain.conserto.Conserto;
import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CreateConsertoServiceImpl implements CreateConsertoService {
    public CreateConsertoServiceImpl(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    private final ConsertoRepository consertoRepository;

    @Override
    public ResponseEntity create(ConsertoDto consertoDto, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(consertoDto);

        consertoRepository.save(conserto);

        var responseEntity = new ResponseEntity<>(conserto, HttpStatus.CREATED);
        var uri = uriBuilder.path("/{id}").buildAndExpand(conserto.getId()).toUri();
        ResponseEntity.created(uri).body( conserto );

        return responseEntity;
    }
}
