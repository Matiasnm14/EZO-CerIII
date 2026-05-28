package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("id_articulo")
    private UUID idArticulo;

    @JsonProperty("id_usuario")
    private UUID idUsuario;

    @JsonProperty("puntuacion")
    private Integer puntuacion;

    @JsonProperty("comentario")
    private String comentario;

    @JsonProperty("fecha")
    private String fecha;
}
