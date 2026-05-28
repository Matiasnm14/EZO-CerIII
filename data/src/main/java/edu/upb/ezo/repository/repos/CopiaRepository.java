package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.entity.Copia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, UUID> {
}
