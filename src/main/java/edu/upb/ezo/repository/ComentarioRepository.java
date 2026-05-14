package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Comentario;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,String> {
}
