package edu.upb.ezo.repository.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "paises")
public class Pais {
    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "El pais no debe de estar vacio")
    @NotNull(message = "El pais no debe de ser nulo")
    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

}
