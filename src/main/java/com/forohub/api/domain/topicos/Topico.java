package com.forohub.api.domain.topicos;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Topico")
@Entity(name = "Topico")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @CreationTimestamp
    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotNull
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    @NotNull
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico() {
        // El constructor puede estar vacío, no es necesario hacer nada aquí.
    }



    public Topico(String titulo, String mensaje, Status status, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }


}
