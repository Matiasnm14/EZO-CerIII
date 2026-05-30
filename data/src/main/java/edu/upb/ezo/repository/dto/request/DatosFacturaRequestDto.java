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
public class DatosFacturaRequestDto {
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @JsonProperty("id_usuario")
    private UUID idUsuario;


    @JsonProperty("nit")
    private String nit;

    @NotBlank
    @NotNull
    @JsonProperty("razon_social")
    private String razonSocial;

    @NotBlank
    @NotNull
    @JsonProperty("direccion")
    private String direccion;
}
