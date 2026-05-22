package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.DetalleIntercambio;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetalleIntercambioRepository extends JpaRepository<DetalleIntercambio, UUID> {
}
