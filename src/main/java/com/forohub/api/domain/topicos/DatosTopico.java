package com.forohub.api.domain.topicos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.DatosCursos;
import com.forohub.api.domain.respuesta.DatosRespuestas;
import com.forohub.api.domain.usuario.DatosUsuario;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosTopico(

        Long id,
        @NotBlank ()
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Status status,
        @NotNull
        @JsonProperty("id de autor") Long autorId,
        @NotNull
        @JsonProperty("Curso") String cursoNombre,

        List<DatosRespuestas> respuestas) {
}
