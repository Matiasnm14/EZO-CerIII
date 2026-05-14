package edu.upb.ezo.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "detalle_intercambio")
@Data
@NoArgsConstructor
public class DetalleIntercambio {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_intercambio",nullable = false,referencedColumnName = "id")
    private Intercambio intercambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_copia",nullable = false,referencedColumnName = "id")
    private Copia copia;

}
