package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false) // Relación con Tópico
    private Topico topico;

    @CreationTimestamp
    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false) // Relación con Autor
    private Usuario autor;

    @NotNull
    private String solucion;

    public Respuesta(DatosRespuestas datosRespuesta, Topico topico, Usuario autor) {
        this.mensaje = datosRespuesta.mensaje();
        this.topico = topico;
        this.autor = autor;
        this.solucion = datosRespuesta.solucion();
    }


}