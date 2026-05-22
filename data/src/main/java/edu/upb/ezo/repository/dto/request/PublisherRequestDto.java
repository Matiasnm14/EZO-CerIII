package edu.upb.ezo.repository.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequestDto {
    @JsonProperty("nombre_editorial")
    private String nombre; //nombre_editorial;

    @NotNull(message = "El pais no puede ser nulo")
    @NotBlank(message = "El pais no puede estar en blanco")
    private String id_pais;

    private String fechaFundacion;
}
