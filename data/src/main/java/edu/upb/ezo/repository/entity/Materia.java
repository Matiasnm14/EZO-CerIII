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
@Table(name = "materia")
public class Materia {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sigla")
    private String sigla;
}
