package com.forohub.api.domain.respuesta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    boolean existsByMensajeAndTopicoId(String mensaje, Long topicoId);
}
