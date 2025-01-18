package com.forohub.api.domain.topicos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopicos(
        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        Status status,

        Usuario autor,

        Curso curso
) {
}
