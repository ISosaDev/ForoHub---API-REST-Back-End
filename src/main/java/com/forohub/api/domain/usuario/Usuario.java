package com.forohub.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(name = "correoElectronico", updatable = false, nullable = false, unique = true) // Nombre exacto de la columna
    private String correoElectronico;
    @Column(nullable = false)
    private String contraseña;

    public Usuario(DatosUsuario autor) {
        this.nombre = autor.nombre();
        this.correoElectronico = autor.correoElectronico();
        this.contraseña = autor.contraseña();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }
}
