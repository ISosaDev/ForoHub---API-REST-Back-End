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

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico) {
        // Validar los datos del tópico antes de guardarlos
        topicoService.registrarTopico(datosTopico);

        // Retornar el tópico guardado con código 201
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.registrarTopico(datosTopico));
    }

}
