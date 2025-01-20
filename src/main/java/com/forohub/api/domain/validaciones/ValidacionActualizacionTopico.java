package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.topicos.DatosActualizarTopico;
import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.TopicoRepository;
import com.forohub.api.domain.usuario.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacionActualizacionTopico {

    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    // Constructor para inyectar los repositorios
    public ValidacionActualizacionTopico(UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public void validar(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() == null || datosActualizarTopico.titulo().isEmpty()) {
            throw new ValidacionException("El campo 'titulo' no puede estar vacío.");
        }
        if (datosActualizarTopico.mensaje() == null || datosActualizarTopico.mensaje().trim().isEmpty()) {
            throw new ValidacionException("El campo 'mensaje' no puede estar vacío.");
        }
        if (datosActualizarTopico.status() == null) {
            throw new ValidacionException("El campo 'status' no puede estar vacío.");
        }
        if (datosActualizarTopico.autor() != null && !usuarioRepository.existsById(datosActualizarTopico.autor())) {
            throw new ValidacionException("Autor no encontrado");
        }
        if (datosActualizarTopico.cursoNombre() != null && !cursoRepository.existsByNombre(datosActualizarTopico.cursoNombre())) {
            throw new ValidacionException("Curso no encontrado");
        }
    }
}
