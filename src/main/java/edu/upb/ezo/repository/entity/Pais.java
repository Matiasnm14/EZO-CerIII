package edu.upb.ezo.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

}
