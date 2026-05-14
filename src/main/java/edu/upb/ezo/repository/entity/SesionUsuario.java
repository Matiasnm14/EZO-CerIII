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
@Table(name = "sesion_usuario")
public class SesionUsuario {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false,referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "token_refresh", columnDefinition = "TEXT")
    private String token_refresh;

    @Column(name = "fecha_expiracion")
    private LocalDate fecha_expiracion;

}
