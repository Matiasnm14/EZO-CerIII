package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "razon_social_emp", nullable = false)
    private String razonSocialEmp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private BigDecimal impuesto;

    private BigDecimal total;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    private BigDecimal subtotal;

    @Column(name = "nit_empresa", nullable = false)
    private String nitEmpresa;

    private String nit;

    @Column(name = "razon_social")
    private String razonSocial;
}
