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
public class IntercambioRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("fecha")
    @NotNull(message = "La fecha no puede ser nula")
    @NotBlank(message = "La fecha no puede estar en blanco")
    private String fecha;


    @JsonProperty("id_usuario_origen")
    private UUID idUsuarioOrigen;

    @JsonProperty("id_usuario_destino")
    private UUID idUsuarioDestino;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("fecha_completado")
    private String fechaCompletado;

    @JsonProperty("cantidad_origen")
    private Integer cantidadOrigen;

    @JsonProperty("cantidad_destino")
    private Integer cantidadDestino;
}
