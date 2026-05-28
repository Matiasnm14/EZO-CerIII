package edu.upb.ezo.repository.dto.request;

import edu.upb.ezo.repository.entity.Articulo;
import edu.upb.ezo.repository.entity.Wishlist;

import java.time.LocalDate;
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
public class WishlistArticuloRequestDto {
    @JsonProperty("id")
    private UUID id;
    @NotNull
    @JsonProperty("id_wishlist")
    private UUID idWishlist;

    @NotNull
    @JsonProperty("id_articulo")
    private UUID idArticulo;

    @NotNull
    @JsonProperty("fecha_agregado")
    private LocalDate fecha_agregado;

    private int prioridad;
}
