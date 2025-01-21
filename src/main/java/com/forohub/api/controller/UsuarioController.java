package com.forohub.api.controller;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.usuario.*;
import com.forohub.api.domain.validaciones.ValidacionUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearer-key")
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
            DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuarioCreado.getId(), usuarioCreado.getNombre(),
                    usuarioCreado.getCorreoElectronico(), usuarioCreado.getContraseña());
            // Retornar la respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body(datosRespuestaUsuario);
        } catch (ValidacionException e) {
            // Manejar la excepción y retornar un mensaje de error amigable
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
