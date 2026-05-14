package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,String> {
}
