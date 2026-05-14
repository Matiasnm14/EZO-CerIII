package edu.upb.ezo.repository.entityID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCopiaId {
    private UUID copia;
    private UUID factura;
}
