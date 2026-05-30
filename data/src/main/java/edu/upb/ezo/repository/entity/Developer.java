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
@Table(name = "developers")
public class Developer {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    private Pais pais;

    @Column(name = "fecha_fundacion", nullable = true)
    private LocalDate fechaFundacion;
}
