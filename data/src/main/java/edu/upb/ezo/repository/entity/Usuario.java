package edu.upb.ezo.repository.entity;

import edu.upb.ezo.repository.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "nombre_usuario", length = 50, unique = true, nullable = false)
    private String nombreUsuario;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

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
    @Enumerated(EnumType.STRING)
    private RoleType rol;

    @Column(name = "fecha_registro", updatable = false,nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "email_verificado",nullable = false)
    private Boolean emailVerificado = false;

    @Column(name = "activo",nullable = false)
    private Boolean activo = false;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wishlist wishlist;

    public void setWishlistRelacional(Wishlist wishlist) {
        this.wishlist = wishlist;
        wishlist.setUsuario(this);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol.name()));
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public Usuario(UUID id, String nombreUsuario, RoleType rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    }
}
