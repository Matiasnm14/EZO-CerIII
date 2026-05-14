package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Intercambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntercambioRepository extends JpaRepository<Intercambio,String> {
}
