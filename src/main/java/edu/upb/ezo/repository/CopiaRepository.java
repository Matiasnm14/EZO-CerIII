package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Copia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiaRepository extends JpaRepository<Copia,String> {
}
