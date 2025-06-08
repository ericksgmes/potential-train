package com.pw3.util;

import com.pw3.application.util.ConsertoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ConsertoNotFoundException.class)
    public ResponseEntity<Void> handleConsertoNotFound(ConsertoNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
