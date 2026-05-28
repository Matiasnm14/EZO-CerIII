package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.FacturaCopia;
import edu.upb.ezo.repository.entityID.FacturaCopiaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCopiaRepository extends JpaRepository<FacturaCopia, FacturaCopiaId> {
}
