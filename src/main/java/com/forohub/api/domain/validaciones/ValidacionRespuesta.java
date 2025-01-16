package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.respuesta.DatosRespuestas;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ValidacionRespuesta {

    public static void validar(Topico topico, Usuario autor, String mensaje) {
        if (topico == null) {
            throw new IllegalArgumentException("El tópico relacionado no puede ser nulo.");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor de la respuesta no puede ser nulo.");
        }
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje de la respuesta no puede estar vacío.");
        }
    }
}
