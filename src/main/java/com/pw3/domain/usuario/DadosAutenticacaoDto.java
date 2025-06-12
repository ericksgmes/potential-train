package com.pw3.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoDto(
        @NotBlank
        String login,

        @NotBlank
        String senha) {
}
