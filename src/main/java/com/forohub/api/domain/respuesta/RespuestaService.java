package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.domain.validaciones.ValidacionRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RespuestaService {

    @Autowired
    private ValidacionRespuesta validacionRespuesta;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Respuesta crearRespuesta(DatosRespuestas datosRespuesta) {
        validacionRespuesta.validar(datosRespuesta);

        // Buscar el Tópico y el Autor por sus IDs
        Topico topico = topicoRepository.findById(datosRespuesta.topico().id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        Usuario autor = usuarioRepository.findById(datosRespuesta.autor().id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));

        // Crear la entidad Respuesta
        Respuesta respuesta = new Respuesta(datosRespuesta, topico, autor);

        return respuestaRepository.save(respuesta);
    }
}
