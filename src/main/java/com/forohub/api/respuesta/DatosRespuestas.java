package com.forohub.api.respuesta;

import com.forohub.api.topicos.Topico;
import com.forohub.api.usuario.DatosUsuario;

import java.time.LocalDateTime;

public record DatosRespuestas(Long id,
                              String mensaje,
                              Topico topico,
                              LocalDateTime fechaCreacion,
                              DatosUsuario autor,
                              String solucion) {
}
