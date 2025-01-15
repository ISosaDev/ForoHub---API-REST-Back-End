package com.forohub.api.topicos;

import com.forohub.api.curso.DatosCursos;
import com.forohub.api.respuesta.DatosRespuestas;
import com.forohub.api.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopico(

        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        LocalDateTime fechaCreacion,
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
