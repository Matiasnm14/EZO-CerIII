package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalle_facturas")
public class DetalleFactura {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura",nullable = false,referencedColumnName = "id")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_articulo",nullable = false,referencedColumnName = "id")
    private Articulo articulo;

    @Column(name = "descripcion",columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario",precision = 5, scale = 2)
    private BigDecimal precio_unitario;
      
}
