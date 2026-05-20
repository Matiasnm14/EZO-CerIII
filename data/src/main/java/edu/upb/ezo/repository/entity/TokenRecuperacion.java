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
@Table(name = "token_recuperacion")
public class TokenRecuperacion {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = false,referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "token",columnDefinition = "TEXT")
    private String token;

    @Column(name = "fecha_expiracion")
    private LocalDate fecha_expiracion;

    private boolean usado;

}
