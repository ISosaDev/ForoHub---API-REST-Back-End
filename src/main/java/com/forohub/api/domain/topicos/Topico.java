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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private String titulo;
    @Getter
    private String mensaje;
    @Getter
    @CreationTimestamp
    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;
    @Getter
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    @Getter
    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotNull
    private Usuario autor;
    @Getter
    @ManyToOne
    @JoinColumn(name = "curso_id")
    @NotNull
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico(String titulo, String mensaje, Status status, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

}
