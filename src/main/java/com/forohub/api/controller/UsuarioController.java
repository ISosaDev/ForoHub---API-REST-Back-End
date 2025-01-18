package com.forohub.api.controller;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.usuario.DatosUsuario;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.domain.usuario.UsuarioService;
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
    private UsuarioService servicioUsuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid DatosUsuario datosUsuario) {
        try {
            // Crear el usuario utilizando el servicio
            Usuario usuarioCreado = servicioUsuario.crearUsuario(datosUsuario);
            // Retornar la respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body(datosUsuario);
        } catch (ValidacionException e) {
            // Manejar la excepción y retornar un mensaje de error amigable
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
