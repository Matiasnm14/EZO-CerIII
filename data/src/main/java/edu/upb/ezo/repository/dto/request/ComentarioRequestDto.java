package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonProperty("id_articulo")
    private UUID idArticulo;

    @NotNull
    @JsonProperty("id_usuario")
    private UUID idUsuario;

    @NotNull
    @JsonProperty("puntuacion")
    private Integer puntuacion;

    @NotNull
    @NotBlank
    @JsonProperty("comentario")
    private String comentario;

    @NotNull
    @NotBlank
    @JsonProperty("fecha")
    private String fecha;
}
