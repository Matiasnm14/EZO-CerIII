package edu.upb.ezo.repository.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "intercambio")
public class Intercambio {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_origen",nullable = false,referencedColumnName = "id")
    private Usuario usuario_origen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_destino",nullable = false,referencedColumnName = "id")
    private Usuario usuario_destino;

    @Column(name = "estado",nullable = false,length = 20)
    private String estado;

    @Column(name = "fecha_completado")
    private LocalDate fecha_completado;

    @Column(name = "cantidad_origen")
    private int cantidad_origen;

    @Column(name = "cantidad_destino")
    private int cantidad_destino;

}
