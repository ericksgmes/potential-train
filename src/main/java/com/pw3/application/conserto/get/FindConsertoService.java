package com.pw3.application.conserto.get;

import com.pw3.infrastructure.conserto.ConsertoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FindConsertoService {
    /**
     * Lista todos os consertos ativos, paginados, retornando um ResponseEntity com a página de DTOs.
     */
    ResponseEntity<Page<ConsertoDto>> listarAtivos(Pageable pageable);

    /**
     * Busca um conserto ativo pelo ID, retornando um ResponseEntity com o DTO ou 404 se não encontrado.
     */
    ResponseEntity<ConsertoDto> buscarPorId(Long id);
}
