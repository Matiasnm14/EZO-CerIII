package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, UUID> {
}
