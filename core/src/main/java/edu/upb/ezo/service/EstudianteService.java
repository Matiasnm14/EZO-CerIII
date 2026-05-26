package edu.upb.ezo.service;

import edu.upb.ezo.repository.EstudianteRepository;
import edu.upb.ezo.repository.MateriaRepository;
import edu.upb.ezo.repository.dto.request.EstudianteRequestDto;
import edu.upb.ezo.repository.dto.response.EstudianteIntDto;
import edu.upb.ezo.repository.dto.response.EstudianteResponseDto;
import edu.upb.ezo.repository.entity.Estudiante;
import edu.upb.ezo.repository.entity.Materia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final MateriaRepository materiaRepository;

    @Transactional
    public List<EstudianteIntDto> getEstudiantes(){
        return estudianteRepository.findBy();
    }

    @Transactional
    public void save(EstudianteRequestDto estudianteRequestDto){
        Estudiante estudiante = new Estudiante();
        Optional<Materia> materia = materiaRepository.findById(estudianteRequestDto.getId_materia());

        estudiante.setNombre(estudianteRequestDto.getNombre());
        estudiante.setApellido(estudianteRequestDto.getApellido());
        estudiante.setNota(estudianteRequestDto.getNota());
        estudiante.setTelefono(estudianteRequestDto.getTelefono());
        estudiante.setCi(estudianteRequestDto.getCi());

        System.out.println(estudiante.getCi());
        System.out.println(estudiante.getTelefono());

        if(materia.isPresent()){
            estudiante.setMateria(materia.get());
        }

        estudianteRepository.save(estudiante);
    }

    @Transactional
    public void update(EstudianteRequestDto estudianteRequestDto){
        Estudiante estudiante = new Estudiante();

        Optional<Estudiante> optional = estudianteRepository.findById(estudianteRequestDto.getId());

        if(optional.isPresent()){
            estudiante = optional.get();
        }

        if(estudianteRequestDto.getNombre() != null)
            estudiante.setNombre(estudianteRequestDto.getNombre());

        if(estudianteRequestDto.getApellido() != null)
            estudiante.setApellido(estudianteRequestDto.getApellido());
        Optional<Materia> optionalMateria = materiaRepository.findById(estudianteRequestDto.getId_materia());
        if(optional.isPresent())
            estudiante.setMateria(optionalMateria.get());

        if(estudianteRequestDto.getNombre() !=null)
            estudiante.setNota(estudianteRequestDto.getNota());

        if(estudianteRequestDto.getTelefono() != null)
            estudiante.setTelefono(estudianteRequestDto.getTelefono());

        if(estudianteRequestDto.getCi() != null)
            estudiante.setCi(estudianteRequestDto.getCi());

        estudianteRepository.save(estudiante);
    }
}
