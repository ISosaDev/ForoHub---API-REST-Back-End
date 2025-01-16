package com.forohub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCursos(

        Long id,
        @NotBlank
        String nombre ,
        @NotBlank
        String categoria) {
}
