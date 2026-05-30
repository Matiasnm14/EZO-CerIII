package edu.upb.ezo.repository.entity;


import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "copias")
public class Copia {
    @Id
    @UuidGenerator
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_articulo",nullable = false,referencedColumnName = "id")
    private Articulo articulo;

    @Column(name = "codigo_unico",nullable = false,columnDefinition = "TEXT")
    private String codigo_unico;

    @Column(name = "estado",length = 20,nullable = false)
    private String estado;

    @Column(name = "tipo",nullable = false,length = 20)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",nullable = true,referencedColumnName = "id")
    private Usuario usuario;

}
