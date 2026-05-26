package edu.upb.ezo.repository;

import edu.upb.ezo.repository.dto.response.MateriaResponseDto;
import edu.upb.ezo.repository.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface MateriaRepository extends JpaRepository<Materia, UUID> {
    List<MateriaResponseDto> findBy();
}
