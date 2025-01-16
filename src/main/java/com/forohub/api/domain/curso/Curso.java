package com.forohub.api.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Curso(DatosCursos curso) {

        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }
}
