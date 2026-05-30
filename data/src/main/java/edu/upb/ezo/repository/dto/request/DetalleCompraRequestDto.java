package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCompraRequestDto {
    @NotNull(message = "El ID del artículo es obligatorio")
    @JsonProperty("id_articulo")
    private UUID idArticulo;

    @NotNull(message = "El ID de la copia física/digital es obligatorio")
    @JsonProperty("id_copia")
    private UUID idCopia;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima de compra es 1")
    @JsonProperty("cantidad")
    private Integer cantidad;

    @JsonProperty("descripcion")
    private String descripcion;
}
