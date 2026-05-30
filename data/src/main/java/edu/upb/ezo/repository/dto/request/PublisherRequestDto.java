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
public class PublisherRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @NotBlank
    @JsonProperty("nombre_editorial")
    private String nombre;

    private UUID id_pais;

    private String fechaFundacion;
}
