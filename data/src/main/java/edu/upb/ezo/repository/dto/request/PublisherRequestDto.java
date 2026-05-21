package edu.upb.ezo.repository.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequestDto {
    @JsonProperty("nombre_editorial")
    private String nombre; //nombre_editorial;
    private String pais;
    private String fechaFundacion;
}
