package com.pw3.web.conserto.controller;

import com.pw3.application.conserto.create.CreateConsertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mecanica/conserto")
public class ConsertoController {
    @Autowired
    private CreateConsertoService createConsertoService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(
            @RequestBody CreateConsertoService.ConsertoDto conserto,
            UriComponentsBuilder uriBuilder
    ) {
        return createConsertoService.create(conserto, uriBuilder);
    }
}
