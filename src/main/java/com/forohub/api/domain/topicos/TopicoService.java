package com.forohub.api.domain.topicos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Transactional
    public Topico registrarTopico(DatosTopico datosTopico) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        if (topicoRepository.existsByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Crear el tópico y guardarlo en la base de datos
        Topico topico = new Topico(datosTopico);
        return topicoRepository.save(topico); // La fecha de creación se maneja automáticamente
    }
}
