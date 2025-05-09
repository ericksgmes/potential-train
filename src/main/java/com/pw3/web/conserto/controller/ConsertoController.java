package com.pw3.web.conserto.controller;

import com.pw3.application.conserto.delete.DeleteConsertoService;
import com.pw3.application.conserto.get.FindConsertoService;
import com.pw3.application.conserto.get.ResumoConsertoService;
import com.pw3.application.conserto.patch.RegistraSaidaService;
import com.pw3.application.conserto.post.CreateConsertoService;
import com.pw3.infrastructure.conserto.ConsertoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mecanica/conserto")
public class ConsertoController {

    private final CreateConsertoService createService;
    private final RegistraSaidaService patchService;
    private final DeleteConsertoService deleteService;
    private final FindConsertoService findService;
    private final ResumoConsertoService resumoService;

    public ConsertoController(
            CreateConsertoService createService,
            RegistraSaidaService patchService,
            DeleteConsertoService deleteService,
            FindConsertoService findService,
            ResumoConsertoService resumoService
    ) {
        this.createService = createService;
        this.patchService = patchService;
        this.deleteService = deleteService;
        this.findService = findService;
        this.resumoService = resumoService;
    }

    @PostMapping
    public ResponseEntity cadastrar(
            @RequestBody CreateConsertoService.RequestModel request,
            UriComponentsBuilder uriBuilder
    ) {
        return createService.create(request, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDto>> listarAtivos(Pageable pageable) {
        return findService.listarAtivos(pageable);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<ResumoConsertoService.ConsertoResumoDTO>> listarResumo() {
        return resumoService.listarResumo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDto> buscarPorId(@PathVariable Long id) {
        return findService.buscarPorId(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity registraSaida(
            @PathVariable Long id,
            @RequestBody RegistraSaidaService.RequestModel request,
            UriComponentsBuilder uriBuilder
    ) {
        var modelComId = new RegistraSaidaService.RequestModel(
                id,
                request.dataSaida()
        );
        return patchService.registraSaida(modelComId, uriBuilder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        deleteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
