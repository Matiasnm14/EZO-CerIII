package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaRequestDto {
    @JsonProperty(namespace = "nombre")
    String nombre;
    @JsonProperty(namespace = "sigla")
    String sigla;
}
