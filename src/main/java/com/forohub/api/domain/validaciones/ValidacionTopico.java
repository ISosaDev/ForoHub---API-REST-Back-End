package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ValidacionTopico implements Validador<DatosTopico> {

    private final TopicoRepository topicoRepository;

    // Constructor para inyectar el repositorio
    public ValidacionTopico(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    public void validar(DatosTopico datosTopico) {
        if (topicoRepository.existsByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje())) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }
    }
}
