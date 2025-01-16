package com.forohub.api.domain.topicos;

import com.forohub.api.domain.curso.DatosCursos;
import com.forohub.api.domain.respuesta.DatosRespuestas;
import com.forohub.api.domain.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosTopico(

        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Status status,
        @NotNull
        @Valid
        DatosUsuario autor,
        @NotNull
        @Valid
        DatosCursos curso,
        @NotNull
        @Valid
        List<DatosRespuestas> respuestas) {
}
