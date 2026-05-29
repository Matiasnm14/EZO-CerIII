package edu.upb.ezo.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class EzoMetodoPagoResponse {
    private UUID id;
    private String nombreMetodo;
}
