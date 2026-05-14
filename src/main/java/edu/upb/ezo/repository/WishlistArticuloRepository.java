package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.WishlistArticulo;
import edu.upb.ezo.repository.entityID.WishlistArticuloId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistArticuloRepository extends JpaRepository<WishlistArticulo, WishlistArticuloId> {
}
