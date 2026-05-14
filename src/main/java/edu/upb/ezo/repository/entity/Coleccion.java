package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "colecciones")
public class Coleccion {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publisher",nullable = false)
    private Publisher publisher;

    @Column(name = "fecha")
    private LocalDate fecha;

}
