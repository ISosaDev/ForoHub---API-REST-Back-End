package com.forohub.api.domain.usuario;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String contraseña
) {
}
