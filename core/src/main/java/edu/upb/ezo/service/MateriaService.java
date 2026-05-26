package edu.upb.ezo.service;

import edu.upb.ezo.repository.MateriaRepository;
import edu.upb.ezo.repository.dto.request.MateriaRequestDto;
import edu.upb.ezo.repository.dto.response.MateriaResponseDto;
import edu.upb.ezo.repository.entity.Materia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MateriaService {
    private final MateriaRepository materiaRepository;

    @Transactional
    public void save(Materia materiaRequestDto){
        materiaRepository.save(materiaRequestDto);
    }

    @Transactional
    public List<Materia> getMaterias(){
        return materiaRepository.findAll();
    }

    @Transactional
    public void updateMateria(Materia materia){
        Optional<Materia> optional = materiaRepository.findById(materia.getId());

        if(!optional.isPresent()){
            throw new IllegalArgumentException("Materia no existe");
        }
        Materia materiaUpdate = optional.get();

            materiaUpdate.setNombre(materia.getNombre());
            materiaUpdate.setSigla(materia.getSigla());


        materiaRepository.save(materiaUpdate);
    }

}
