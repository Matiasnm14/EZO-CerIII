package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.DeveloperRequestDto;
import edu.upb.ezo.repository.repos.DeveloperRepository;
import edu.upb.ezo.repository.dto.response.DeveloperResponseDto;
import edu.upb.ezo.repository.entity.Developer;
import edu.upb.ezo.repository.entity.Pais;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
@Slf4j
public class DeveloperService {
    private final DeveloperRepository repository;
    private final PaisService paisService;

    @Transactional(readOnly = true)
    public List<DeveloperResponseDto> findAll(){
        return this.repository.listarDevelopers();
    }

    @Transactional
    public void save(DeveloperRequestDto developerDto) throws Exception{
        Optional<Pais> optionalPais = this.paisService.findById(developerDto.getIdPais());
        if(optionalPais.isEmpty())
            throw new IllegalArgumentException("El pais no existe");

        Pais pais = optionalPais.get();

        Developer developer1 = new Developer();
        developer1.setNombre(developerDto.getNombre());
        developer1.setFechaFundacion(LocalDate.parse(developerDto.getFechaFundacion()));
        developer1.setPais(pais);

        this.repository.save(developer1);
    }

    @Transactional(readOnly = true)
    public void deleteDeveloper(UUID id){
        Optional<Developer> optionalDeveloper = repository.findById(id);
        Developer developer = new Developer();
        if (optionalDeveloper.isPresent()){
            developer = optionalDeveloper.get();
        }
        repository.delete(developer);
    }

}
