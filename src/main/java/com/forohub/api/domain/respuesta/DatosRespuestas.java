package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.usuario.DatosUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestas(

        Long id,
        @NotBlank
        String mensaje,
        @NotNull
        DatosTopico topico,
        @NotNull
        DatosUsuario autor,
        @NotBlank
        String solucion
) {
}
