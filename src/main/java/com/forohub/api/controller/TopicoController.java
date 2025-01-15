package com.forohub.api.controller;


import com.forohub.api.topicos.DatosTopico;
import com.forohub.api.topicos.Topico;
import com.forohub.api.topicos.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosTopico datosTopico){
        topicoRepository.save(new Topico(datosTopico));
    }
}
