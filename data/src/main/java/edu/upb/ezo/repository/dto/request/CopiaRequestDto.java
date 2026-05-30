package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopiaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("id_articulo")
    @NotNull(message = "El id del artículo no puede ser nulo")
    private UUID idArticulo;

    @JsonProperty("codigo_unico")
    @NotNull(message = "El código único no puede ser nulo")
    @NotBlank(message = "El código único no puede estar en blanco")
    private String codigoUnico;

    @NotBlank
    @NotNull
    @JsonProperty("estado")
    private String estado;

    @JsonProperty("tipo")
    @NotNull(message = "El tipo de copia no puede ser nulo")
    @NotBlank(message = "El tipo de copia no puede estar en blanco")
    private String tipo;

    @JsonProperty("id_usuario")
    private UUID idUsuario;
}
