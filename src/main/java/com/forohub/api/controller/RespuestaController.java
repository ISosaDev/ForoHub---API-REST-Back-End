package com.forohub.api.controller;

import com.forohub.api.domain.respuesta.DatosRespuestas;
import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.respuesta.RespuestaRepository;
import com.forohub.api.domain.respuesta.RespuestaService;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.domain.validaciones.ValidacionRespuesta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService servicioRespuesta;

    @PostMapping
    public ResponseEntity<Respuesta> registrarRespuesta(@RequestBody @Valid DatosRespuestas datosRespuesta) {
        // Crear la respuesta utilizando el servicio
        Respuesta respuestaGuardada = servicioRespuesta.crearRespuesta(datosRespuesta);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaGuardada);
    }
}
