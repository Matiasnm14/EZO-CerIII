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
public class DeveloperRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @NotBlank
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("id_pais")
    private UUID idPais;

    @JsonProperty("fecha_fundacion")
    private String fechaFundacion;
}
