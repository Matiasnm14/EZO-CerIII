package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.FacturaMetodo;
import edu.upb.ezo.repository.entityID.FacturaMetodoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaMetodoRepository extends JpaRepository<FacturaMetodo, FacturaMetodoId> {
}
