package com.forohub.api.domain.usuario;

public record DatosRespuestaUsuario(
        long id,
        String nombre,
        String correoElectronico,
        String contraseña
) {
}
