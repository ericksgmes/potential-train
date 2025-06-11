package com.pw3.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record authData(
        @NotBlank
        String login,

        @NotBlank
        String senha) {
}
