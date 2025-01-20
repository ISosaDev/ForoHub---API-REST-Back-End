package com.forohub.api.domain.topicos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forohub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatoslistadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String Estado,
        String autor,
        String curso) {

    public DatoslistadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}
