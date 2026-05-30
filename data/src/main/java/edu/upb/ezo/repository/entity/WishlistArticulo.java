package edu.upb.ezo.repository.entity;


import edu.upb.ezo.repository.entityID.WishlistArticuloId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wishlist_articulo")
@IdClass(WishlistArticuloId.class)
public class WishlistArticulo {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wishlist",nullable = false,referencedColumnName = "id")
    private Wishlist wishlist;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_articulo",nullable = false,referencedColumnName = "id")
    private Articulo articulo;

    @Column(name = "fecha_agregado",nullable = false)
    private LocalDate fecha_agregado;

    @Column(name = "prioridad")
    private int prioridad;

}
