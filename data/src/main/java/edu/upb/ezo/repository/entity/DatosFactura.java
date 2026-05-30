package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@Table(name = "datos_factura")
public class DatosFactura {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false,referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "nit",nullable = false)
    private String nit;

    @Column(name = "razon_social",nullable = false)
    private String razon_social;

    @Column(name = "direccion",columnDefinition = "TEXT",nullable = false)
    private String direccion;

}
