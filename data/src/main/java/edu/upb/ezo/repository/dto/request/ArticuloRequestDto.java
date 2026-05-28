package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("nombre")
    @NotNull(message = "El nombre del artículo no puede ser nulo")
    @NotBlank(message = "El nombre del artículo no puede estar en blanco")
    private String nombre;

    @JsonProperty("fecha_lanzamiento")
    @NotNull(message = "La fecha de lanzamiento no puede ser nula")
    @NotBlank(message = "La fecha de lanzamiento no puede estar en blanco")
    private String fechaLanzamiento;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("tamano")
    private String tamano;

    @JsonProperty("precio")
    @NotNull(message = "El precio no puede ser nulo")
    private BigDecimal precio;

    @JsonProperty("tipo")
    @NotNull(message = "El tipo no puede ser nulo")
    @NotBlank(message = "El tipo no puede estar en blanco")
    private String tipo;

    @JsonProperty("disponible")
    private Boolean disponible;

    @JsonProperty("id_publisher")
    private UUID idPublisher;

    @JsonProperty("id_developer")
    private UUID idDeveloper;

    @JsonProperty("id_coleccion")
    private UUID idColeccion;
}
