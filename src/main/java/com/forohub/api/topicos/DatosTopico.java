package com.forohub.api.topicos;

import com.forohub.api.curso.DatosCursos;
import com.forohub.api.respuesta.DatosRespuestas;
import com.forohub.api.usuario.DatosUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopico(String titulo,
                          String mensaje,
                          LocalDateTime fechaCreacion,
                          Status status,
                          DatosUsuario autor,
                          DatosCursos curso,
                          List<DatosRespuestas> respuestas) {
}
