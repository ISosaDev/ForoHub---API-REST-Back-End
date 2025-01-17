package com.forohub.api.domain.respuesta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    // Verifica si existe una respuesta con el mismo mensaje y tópico (y puede incluir autor, si es necesario).
    boolean existsByMensajeAndTopicoId(String mensaje, Long topicoId);
}
