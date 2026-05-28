package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("id_pais")
    private UUID idPais;

    @JsonProperty("fecha_fundacion")
    private String fechaFundacion;
}
