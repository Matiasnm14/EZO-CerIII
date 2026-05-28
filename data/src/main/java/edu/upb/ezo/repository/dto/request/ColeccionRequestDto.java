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
public class ColeccionRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("nombre")
    @NotNull(message = "El nombre de la colección no puede ser nulo")
    @NotBlank(message = "El nombre de la colección no puede estar en blanco")
    private String nombre;

    @JsonProperty("id_publisher")
    private UUID idPublisher;
}
