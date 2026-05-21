package edu.upb.ezo.repository;

import edu.upb.ezo.repository.dto.response.DeveloperResponseDto;
import edu.upb.ezo.repository.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,String> {
    @Query("SELECT d FROM Developer d")
    List<DeveloperResponseDto> listarDevelopers();
}
