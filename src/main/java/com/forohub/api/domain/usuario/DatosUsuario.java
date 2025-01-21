package com.forohub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(

        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String correoElectronico,
        @NotBlank
        String contraseña,
        @NotBlank
        String username,
        @NotBlank
        Rol rol
) {

}
