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
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_emisor",nullable = false,referencedColumnName = "id")
    private Usuario usuario_emisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_receptor",nullable = false,referencedColumnName = "id")
    private Usuario usuario_receptor;

    @Column(name = "mensaje",columnDefinition = "TEXT",nullable = false)
    private String mensaje;

    @Column(name = "fecha_emision",nullable = false)
    private LocalDate fecha_emision;

}
