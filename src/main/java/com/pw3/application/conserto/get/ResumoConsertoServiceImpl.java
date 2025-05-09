package com.pw3.application.conserto.get;

import com.pw3.infrastructure.conserto.ConsertoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ResumoConsertoServiceImpl implements ResumoConsertoService {

    private final ConsertoRepository consertoRepository;

    public ResumoConsertoServiceImpl(ConsertoRepository consertoRepository) {
        this.consertoRepository = consertoRepository;
    }

    @Override
    public ResponseEntity<List<ConsertoResumoDTO>> listarResumo() {
        var listaResumo = consertoRepository
                .findAllByAtivoTrue(Pageable.unpaged())
                .stream()
                .map(ConsertoResumoDTO::fromDomain)
                .toList();

        return ResponseEntity.ok(listaResumo);
    }
}
