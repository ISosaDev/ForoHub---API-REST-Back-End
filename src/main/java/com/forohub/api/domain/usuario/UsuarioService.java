package com.forohub.api.domain.usuario;


import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.validaciones.ValidacionUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private ValidacionUsuario validacionUsuario;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(DatosUsuario datosUsuario) {
        validacionUsuario.validar(datosUsuario);
        Usuario usuario = new Usuario(datosUsuario);
        return usuarioRepository.save(usuario);

    }
}
