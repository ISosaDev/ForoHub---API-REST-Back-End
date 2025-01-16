package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topicos.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
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
    private Long id;
    private String mensaje;
    @ManyToOne
    private Topico topico;
    @CreationTimestamp
    @Column(name = "fechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;
    @ManyToOne
    private Usuario autor;
    private String solucion;

    public Respuesta(DatosRespuestas datosRespuesta) {
        this.mensaje = datosRespuesta.mensaje();
        this.topico = new Topico(datosRespuesta.topico());
        this.autor = new Usuario(datosRespuesta.autor());
        this.solucion = datosRespuesta.solucion();
    }


}
