package edu.upb.ezo.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre_usuario", length = 50, unique = true, nullable = false)
    private String nombreUsuario;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    // Relación con tabla Paises (asumiendo que existe la entidad Pais)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @Column(name = "password_hash", unique = true, nullable = false)
    private String passwordHash;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 25, nullable = false)
    private String telefono;

    @Column(length = 20, nullable = false)
    private String rol;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "email_verificado")
    private Boolean emailVerificado = false;

    private Boolean activo = false;
}
