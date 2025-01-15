package com.forohub.api.topicos;

import com.forohub.api.curso.Curso;
import com.forohub.api.curso.DatosCursos;
import com.forohub.api.respuesta.Respuesta;
import com.forohub.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
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
        this.fechaCreacion = datosTopico.fechaCreacion();
        this.status = datosTopico.status();
        this.autor = new Usuario(datosTopico.autor());
        this.curso = new Curso(datosTopico.curso());

    }

}
