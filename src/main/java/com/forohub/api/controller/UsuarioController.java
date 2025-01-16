package com.forohub.api.controller;

import com.forohub.api.domain.usuario.DatosUsuario;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.domain.validaciones.ValidacionUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody @Valid DatosUsuario datosUsuario) {
        // Validar datos del usuario
        ValidacionUsuario.validar(datosUsuario);

        // Crear la entidad Usuario
        Usuario usuario = new Usuario(datosUsuario);

        // Guardar la entidad en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }
}
