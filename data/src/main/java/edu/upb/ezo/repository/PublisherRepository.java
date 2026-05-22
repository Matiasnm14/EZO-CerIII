package edu.upb.ezo.repository;

import edu.upb.ezo.repository.dto.response.PublisherDto;
import edu.upb.ezo.repository.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    @Query("SELECT new edu.upb.ezo.repository.dto.response.PublisherDto(p.id, p.nombre, p.pais.nombre, p.fecha_fundacion) FROM Publisher p")
    List<PublisherDto> findAllDto();

}

