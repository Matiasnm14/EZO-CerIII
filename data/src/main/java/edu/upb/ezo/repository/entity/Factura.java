package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "numero_factura",nullable = false)
    private String numeroFactura;

    @Column(name = "razon_social_emp", nullable = false)
    private String razonSocialEmp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;

    @Column(name = "impuesto",nullable = false)
    private BigDecimal impuesto;

    @Column(name = "total",nullable = false)
    private BigDecimal total;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "subtotal",nullable = false)
    private BigDecimal subtotal;

    @Column(name = "nit_empresa", nullable = false)
    private String nitEmpresa;

    @Column(name = "nit")
    private String nit;

    @Column(name = "razon_social",nullable = false)
    private String razonSocial;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaCopia> copias = new ArrayList<>();

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaMetodo> metodos = new ArrayList<>();

    public void addDetalle(DetalleFactura detalle) {
        detalles.add(detalle);
        detalle.setFactura(this);
    }

    public void addCopia(FacturaCopia copia) {
        copias.add(copia);
        copia.setFactura(this);
    }

    public void addMetodo(FacturaMetodo metodo) {
        metodos.add(metodo);
        metodo.setFactura(this);
    }
}
