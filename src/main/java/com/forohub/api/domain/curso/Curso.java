package com.forohub.api.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    // Constructor sin argumentos (default constructor)
    public Curso() {
        // El constructor puede estar vacío, no es necesario hacer nada aquí.
    }

    public Curso(DatosCursos curso) {

        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }
}
