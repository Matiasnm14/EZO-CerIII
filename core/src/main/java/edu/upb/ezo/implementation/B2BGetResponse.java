package edu.upb.ezo.implementation;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class B2BGetResponse {
    private UUID id;
    private String nombre;
    private String descripcion;
    private UUID idProducto;

}
