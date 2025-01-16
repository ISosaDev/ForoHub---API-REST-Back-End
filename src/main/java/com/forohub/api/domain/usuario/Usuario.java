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
    private String nombre;
    @Column(name = "correoElectronico", updatable = false) // Nombre exacto de la columna
    private String correoElectronico;
    private String contraseña;

    public Usuario(DatosUsuario autor) {
        this.nombre = autor.nombre();
        this.correoElectronico = autor.correoElectronico();
        this.contraseña = autor.contraseña();
    }
}
