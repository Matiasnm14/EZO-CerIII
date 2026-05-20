package edu.upb.ezo.repository.entity;


import edu.upb.ezo.repository.entityID.FacturaCopiaId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.basic.BasicIconFactory;
import java.math.BigDecimal;

@Entity
@Table(name = "factura_copia")
@Data
@NoArgsConstructor
@IdClass(FacturaCopiaId.class)
public class FacturaCopia {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_copia",nullable = false,referencedColumnName = "id")
    private Copia copia;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura",nullable = false,referencedColumnName = "id")
    private Factura factura;

    @Column(name = "precio_unitario",precision = 5,scale = 2)
    private BigDecimal precio_unitario;

}
