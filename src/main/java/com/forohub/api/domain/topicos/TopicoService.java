package com.forohub.api.domain.topicos;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.domain.validaciones.ValidacionTopico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private ValidacionTopico validacionTopico;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico crearTopico(DatosTopico datosTopico) {
        validacionTopico.validar(datosTopico);

        // Obtener el autor y el curso desde los repositorios
        Usuario autor = usuarioRepository.findById(datosTopico.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));
        Curso curso = cursoRepository.findByNombre(datosTopico.cursoNombre())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        // Crear la entidad Topico
        Topico topico = new Topico(datosTopico.titulo(), datosTopico.mensaje(), datosTopico.status(), autor, curso);

        return topicoRepository.save(topico);
    }
}

