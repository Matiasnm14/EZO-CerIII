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
public class FacturaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("numero_factura")
    private String numeroFactura;

    @JsonProperty("razon_social_emp")
    @NotNull(message = "La razón social de la empresa no puede ser nula")
    @NotBlank(message = "La razón social de la empresa no puede estar en blanco")
    private String razonSocialEmp;

    @JsonProperty("id_usuario")
    private UUID idUsuario;

    @JsonProperty("impuesto")
    private BigDecimal impuesto;

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("fecha_emision")
    @NotNull(message = "La fecha de emisión no puede ser nula")
    @NotBlank(message = "La fecha de emisión no puede estar en blanco")
    private String fechaEmision;

    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    @JsonProperty("nit_empresa")
    @NotNull(message = "El NIT de la empresa no puede ser nulo")
    @NotBlank(message = "El NIT de la empresa no puede estar en blanco")
    private String nitEmpresa;

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("razon_social")
    private String razonSocial;
}