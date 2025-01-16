package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;

import java.util.Optional;

public class ValidacionTopico {

    private final TopicoRepository topicoRepository;

    // Constructor para inyectar el repositorio
    public ValidacionTopico(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // Método estático para validar los datos
    public static void validar(DatosTopico datosTopico, TopicoRepository topicoRepository) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        if (topicoRepository.existsByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }


    }


}
