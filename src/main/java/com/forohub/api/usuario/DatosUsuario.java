package com.forohub.api.usuario;

public record DatosUsuario(Long id,
                           String nombre,
                           String correoElectronico,
                           String contraseña) {
}
