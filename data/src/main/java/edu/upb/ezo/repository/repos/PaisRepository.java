package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<Pais , UUID> {
}
