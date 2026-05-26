package edu.upb.ezo.repository;

import edu.upb.ezo.repository.dto.response.EstudianteIntDto;
import edu.upb.ezo.repository.dto.response.EstudianteResponseDto;
import edu.upb.ezo.repository.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, UUID> {
    List<EstudianteIntDto> findBy();
}
