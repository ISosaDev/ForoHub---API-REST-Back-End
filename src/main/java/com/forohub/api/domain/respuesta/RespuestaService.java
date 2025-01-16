package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topicos.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;

    public RespuestaService(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
    }

    @Transactional
    public Respuesta registrarRespuesta(DatosRespuestas datosRespuesta) {
        // Verificar si ya existe una respuesta con el mismo mensaje en el mismo tópico
        if (respuestaRepository.existsByMensajeAndTopicoId(datosRespuesta.mensaje(), datosRespuesta.topico().id())) {
            throw new IllegalArgumentException("Ya existe una respuesta con el mismo mensaje en este tópico.");
        }

        // Crear la respuesta y guardarla en la base de datos
        Respuesta respuesta = new Respuesta(datosRespuesta);
        return respuestaRepository.save(respuesta); // La fecha de creación se maneja automáticamente
    }
}
