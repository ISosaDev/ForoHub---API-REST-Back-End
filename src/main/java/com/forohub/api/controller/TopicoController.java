package com.forohub.api.controller;


import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.topicos.*;
import com.forohub.api.domain.usuario.DatosRespuestaUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService servicioTopico;

    @Autowired
    private TopicoRepository topicoRepository;

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
}


