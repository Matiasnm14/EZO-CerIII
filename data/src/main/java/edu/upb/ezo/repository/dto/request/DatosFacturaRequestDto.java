package edu.upb.ezo.repository.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatosFacturaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("id_usuario")
    private UUID idUsuario;

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("razon_social")
    private String razonSocial;

    @JsonProperty("direccion")
    private String direccion;
}
