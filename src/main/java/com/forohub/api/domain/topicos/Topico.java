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
    private Long id;
    private String titulo;
    private String mensaje;
    @CreationTimestamp
    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;



    public Topico(DatosTopico datosTopico){

        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.status = datosTopico.status();
        this.autor = new Usuario(datosTopico.autor());
        this.curso = new Curso(datosTopico.curso());


    }


}
