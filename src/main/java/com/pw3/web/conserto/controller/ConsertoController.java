package com.pw3.web.conserto.controller;

import com.pw3.application.conserto.delete.DeleteConsertoService;
import com.pw3.application.conserto.get.FindConsertoService;
import com.pw3.application.conserto.get.ResumoConsertoService;
import com.pw3.application.conserto.patch.RegistraSaidaService;
import com.pw3.application.conserto.post.CreateConsertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/mecanica/conserto")
public class ConsertoController {
    @Autowired
    private CreateConsertoService createConsertoService;
    @Autowired
    private RegistraSaidaService registraSaidaService;
    @Autowired
    private DeleteConsertoService deleteConsertoService;
    @Autowired
    private FindConsertoService findConsertoService;
    @Autowired
    private ResumoConsertoService resumoConsertoService;

    @PostMapping()
    public ResponseEntity cadastrar(
            @RequestBody CreateConsertoService.RequestModel request,
            UriComponentsBuilder uriBuilder
    ) {
        return createConsertoService.create(request, uriBuilder);
    }

    @PatchMapping()
    public ResponseEntity registraSaida(
            @RequestBody RegistraSaidaService.RequestModel request,
            UriComponentsBuilder uriBuilder
    ) {
        return registraSaidaService.registraSaida(request, uriBuilder);
    }


}
