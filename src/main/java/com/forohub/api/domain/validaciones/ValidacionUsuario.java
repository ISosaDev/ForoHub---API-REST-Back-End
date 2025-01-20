package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.usuario.DatosUsuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuario implements Validador<DatosUsuario> {

    private final UsuarioRepository usuarioRepository;

    // Constructor para inyectar el repositorio
    public ValidacionUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(DatosUsuario datosUsuario) {
        if (datosUsuario == null) {
            throw new ValidacionException("Los datos del usuario no pueden ser nulos.");
        }
        if (datosUsuario.nombre() == null || datosUsuario.nombre().isBlank()) {
            throw new ValidacionException("El nombre del usuario no puede estar vacío.");
        }
        if (datosUsuario.correoElectronico() == null || datosUsuario.correoElectronico().isBlank()) {
            throw new ValidacionException("El email del usuario no puede estar vacío.");
        }
        if (usuarioRepository.existsByCorreoElectronico(datosUsuario.correoElectronico())) {
            throw new ValidacionException("Ya existe un usuario con el mismo correo electrónico.");
        }
        //if (usuarioRepository.existsByNombre(datosUsuario.nombre())) {
        //    throw new ValidacionException("Ya existe un usuario con el mismo nombre.");
        //}

    }
}
