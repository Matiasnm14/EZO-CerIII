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
public class MensajeRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @JsonProperty("id_usuario_emisor")
    private UUID idUsuarioEmisor;

    @NotNull
    @JsonProperty("id_usuario_receptor")
    private UUID idUsuarioReceptor;

    @NotNull
    @JsonProperty("mensaje")
    private String mensaje;

    @NotNull
    @NotBlank
    @JsonProperty("fecha_emision")
    private String fechaEmision;
}
