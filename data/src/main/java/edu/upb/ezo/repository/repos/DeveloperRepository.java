package edu.upb.ezo.repository.repos;

import edu.upb.ezo.repository.dto.response.DeveloperResponseDto;
import edu.upb.ezo.repository.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
    @Query("SELECT d FROM Developer d")
    List<DeveloperResponseDto> listarDevelopers();
}
