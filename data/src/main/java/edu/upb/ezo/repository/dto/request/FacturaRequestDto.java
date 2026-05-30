package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
public class FacturaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @NotBlank
    @JsonProperty("numero_factura")
    private String numeroFactura;

    @JsonProperty("razon_social_emp")
    @NotNull(message = "La razón social de la empresa no puede ser nula")
    @NotBlank(message = "La razón social de la empresa no puede estar en blanco")
    private String razonSocialEmp;

    @NotNull
    @JsonProperty("id_usuario")
    private UUID idUsuario;

    @NotNull
    @JsonProperty("impuesto")
    private BigDecimal impuesto;

    @NotNull
    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("fecha_emision")
    @NotNull(message = "La fecha de emisión no puede ser nula")
    @NotBlank(message = "La fecha de emisión no puede estar en blanco")
    private String fechaEmision;

    @NotNull
    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    @JsonProperty("nit_empresa")
    @NotNull(message = "El NIT de la empresa no puede ser nulo")
    @NotBlank(message = "El NIT de la empresa no puede estar en blanco")
    private String nitEmpresa;

    @JsonProperty("nit")
    private String nit;

    @NotNull
    @NotBlank
    @JsonProperty("razon_social")
    private String razonSocial;

    @NotNull(message = "El método de pago es obligatorio")
    @JsonProperty("id_metodo_pago")
    private UUID idMetodoPago;

    @NotEmpty(message = "La factura debe contener al menos un artículo")
    @Valid
    @JsonProperty("detalles")
    private List<DetalleCompraRequestDto> detalles;
}