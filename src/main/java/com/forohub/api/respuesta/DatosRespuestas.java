package com.forohub.api.respuesta;

import com.forohub.api.topicos.Topico;
import com.forohub.api.usuario.DatosUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestas(

        Long id,
        @NotBlank
        String mensaje,
        @NotNull
        Topico topico,
        @NotBlank
        LocalDateTime fechaCreacion,
        @NotNull
        DatosUsuario autor,
        @NotBlank
        String solucion) {
}
