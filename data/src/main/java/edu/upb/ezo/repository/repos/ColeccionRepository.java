package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColeccionRepository extends JpaRepository<Coleccion, UUID> {
    UUID id(UUID id);
}
