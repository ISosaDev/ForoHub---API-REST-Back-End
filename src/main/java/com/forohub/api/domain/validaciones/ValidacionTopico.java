package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.topicos.DatosActualizarTopico;
import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;
import com.forohub.api.domain.usuario.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ValidacionTopico implements Validador<DatosTopico> {

    private final TopicoRepository topicoRepository;


    // Constructor para inyectar los repositorios
    public ValidacionTopico(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;

    }

    @Override
    public void validar(DatosTopico datosTopico) {


        // Validar que los campos no estén vacíos
        if (datosTopico.titulo() == null || datosTopico.titulo().isBlank()) {
            throw new ValidacionException("El campo 'titulo' no puede estar vacío.");
        }
        if (datosTopico.mensaje() == null || datosTopico.mensaje().trim().isBlank()) {
            throw new ValidacionException("El campo 'mensaje' no puede estar vacío.");
        }
        if (datosTopico.status() == null) {
            throw new ValidacionException("El campo 'status' no puede estar vacío.");
        }
        if (datosTopico.autorId() == null) {
            throw new ValidacionException("El campo 'id de autor' no puede estar vacío.");
        }
        if (datosTopico.cursoNombre() == null || datosTopico.cursoNombre().isBlank()) {
            throw new ValidacionException("El campo 'cursoNombre' no puede estar vacío.");
        }

        if (topicoRepository.existsByTituloAndMensaje(datosTopico.titulo(), datosTopico.mensaje())) {
            throw new ValidacionException("Ya existe un tópico con el mismo título y mensaje.");
        }
    }


}

