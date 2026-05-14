package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.DatosFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosFacturaRepository extends JpaRepository<DatosFactura,String> {
}
