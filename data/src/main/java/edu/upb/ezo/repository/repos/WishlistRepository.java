package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {
    UUID id(UUID id);
}
