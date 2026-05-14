package edu.upb.ezo.repository.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre_metodo",length = 25,nullable = false)
    private String nombre_metodo;

}
