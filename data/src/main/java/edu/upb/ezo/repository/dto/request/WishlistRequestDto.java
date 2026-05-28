package edu.upb.ezo.repository.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequestDto {
    @JsonProperty("id")
    private UUID id;
    @NotNull
    @JsonProperty("id_usuario")
    private UUID idUsuario;
}
