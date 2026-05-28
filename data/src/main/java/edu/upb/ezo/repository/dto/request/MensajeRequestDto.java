package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id_usuario_emisor")
    private UUID idUsuarioEmisor;

    @JsonProperty("id_usuario_receptor")
    private UUID idUsuarioReceptor;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("fecha_emision")
    private String fechaEmision;
}
