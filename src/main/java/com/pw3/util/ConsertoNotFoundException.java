package com.pw3.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um Conserto não é encontrado.
 * O @ResponseStatus faz o Spring devolver 404.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConsertoNotFoundException extends RuntimeException {
    public ConsertoNotFoundException(Long id) {
        super("Conserto não encontrado com id " + id);
    }
}
