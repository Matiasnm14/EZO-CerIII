package edu.upb.ezo.repository.entity;

import edu.upb.ezo.repository.entityID.FacturaMetodoId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "factura_metodo")
@IdClass(FacturaMetodoId.class)
public class FacturaMetodo {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura",nullable = false,referencedColumnName = "id")
    private Factura factura;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo_pago",nullable = false,referencedColumnName = "id")
    private MetodoPago metodoPago;
}
