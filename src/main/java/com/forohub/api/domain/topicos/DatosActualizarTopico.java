package com.forohub.api.domain.topicos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,
                                    String titulo,
                                    String mensaje,
                                    Status status,
                                    @JsonProperty("id de autor")Long autor,
                                    @JsonProperty("Curso")String cursoNombre
) {
}
