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
public class DetalleFacturaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @JsonProperty("id_factura")
    private UUID idFactura;

    @JsonProperty("id_articulo")
    @NotNull(message = "El id del artículo no puede ser nulo")
    private UUID idArticulo;

    @JsonProperty("descripcion")
    private String descripcion;

    @NotNull
    @JsonProperty("cantidad")
    private Integer cantidad;

    @NotNull
    @JsonProperty("precio_unitario")
    private BigDecimal precioUnitario;
}
