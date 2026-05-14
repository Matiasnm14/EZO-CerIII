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
@Table(name = "Comentario")
public class Comentario {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_articulo",nullable = false,referencedColumnName = "id")
    private Articulo articulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false,referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "puntuacion")
    private int puntuacion;

    @Column(name = "comentario",columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "fecha")
    private LocalDate fecha;

}
