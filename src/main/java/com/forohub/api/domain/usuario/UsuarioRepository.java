package com.forohub.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre);

    boolean existsByCorreoElectronico(@NotBlank String correoElectronico);

    boolean existsByNombre(@NotBlank String nombre);


    UserDetails findByUsername(String username);
}
