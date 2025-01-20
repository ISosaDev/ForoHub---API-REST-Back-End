package com.forohub.api.controller;


import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.topicos.*;
import com.forohub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService servicioTopico;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosTopico datos) {
        try {
            // Crear el tópico utilizando el servicio
            Topico topicoCreado = servicioTopico.crearTopico(datos);
            DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topicoCreado.getId(),
                    topicoCreado.getTitulo(), topicoCreado.getMensaje(),topicoCreado.getFechaCreacion(), topicoCreado.getStatus(),
                    topicoCreado.getAutor(), topicoCreado.getCurso());
            // Retornar la respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body(topicoCreado);
        } catch (ValidacionException e) {
            // Manejar la excepción y retornar un mensaje de error amigable
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping
    public Page<DatoslistadoTopicos> ListadoTopicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatoslistadoTopicos::new);

    }


    @PutMapping
    @Transactional
    public ResponseEntity<?> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico, usuarioRepository, cursoRepository);
        return ResponseEntity.status(HttpStatus.OK).body("Tópico Actualizado");

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Tópico eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado");
        }
    }
}


