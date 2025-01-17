package com.forohub.api.controller;


import com.forohub.api.domain.topicos.DatosTopico;
import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.topicos.TopicoRepository;
import com.forohub.api.domain.topicos.TopicoService;
import com.forohub.api.domain.validaciones.ValidacionTopico;
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

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid DatosTopico datos) {
        // Crear el tópico utilizando el servicio
        Topico topicoCreado = servicioTopico.crearTopico(datos);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoCreado);
    }
}


