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
@Table(name = "articulos")
public class Articulo {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_lanzamiento", nullable = false)
    private LocalDate fechaLanzamiento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 10)
    private String tamano;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false, length = 20)
    private String tipo;

    @Column(nullable = false,name = "disponible")
    private Boolean disponible = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_developer")
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion")
    private Coleccion coleccion;
}
