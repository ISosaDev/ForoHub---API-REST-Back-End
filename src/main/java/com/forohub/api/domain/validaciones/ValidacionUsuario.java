package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.usuario.DatosUsuario;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuario {

    public static void validar(DatosUsuario datosUsuario) {
        if (datosUsuario == null) {
            throw new IllegalArgumentException("Los datos del usuario no pueden ser nulos.");
        }
        if (datosUsuario.nombre() == null || datosUsuario.nombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacío.");
        }
        if (datosUsuario.correoElectronico() == null || datosUsuario.correoElectronico().isBlank()) {
            throw new IllegalArgumentException("El email del usuario no puede estar vacío.");
        }

    }
}
