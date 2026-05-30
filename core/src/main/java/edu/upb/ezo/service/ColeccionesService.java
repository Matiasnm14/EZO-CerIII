package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.ColeccionRequestDto;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Coleccion;
import edu.upb.ezo.repository.entity.Publisher;
import edu.upb.ezo.repository.repos.ColeccionRepository;
import edu.upb.ezo.repository.repos.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColeccionesService {
    private final ColeccionRepository coleccionRepository;
    private final PublisherRepository publisherRepository;

    @Transactional(readOnly = true)
    public List<Coleccion> getColecciones(){
        return coleccionRepository.findAll();
    }

    @Transactional
    public void save(ColeccionRequestDto coleccionRequestDto){
        Optional<Publisher> optional = publisherRepository.findById(coleccionRequestDto.getIdPublisher());

        if(optional.isEmpty())
            throw new IllegalArgumentException("El publisher no existe");

        Coleccion coleccion = new Coleccion();
        if(coleccionRequestDto.getNombre() != null) coleccion.setNombre(coleccionRequestDto.getNombre());
        coleccion.setPublisher(optional.get());

        coleccionRepository.save(coleccion);

    }

    @Transactional
    public void deleteColeccion(IdRequestDto idRequestDto){
        Optional<Coleccion> optional = coleccionRepository.findById(idRequestDto.getId());

        if(optional.isEmpty())
            throw new IllegalArgumentException("La coleccion no existe");

        Coleccion coleccion = optional.get();

        coleccionRepository.delete(coleccion);
    }

    @Transactional
    public void update(ColeccionRequestDto coleccionRequestDto){
        Optional<Coleccion> optional = coleccionRepository.findById(coleccionRequestDto.getId());

        if(optional.isEmpty())
            throw new IllegalArgumentException("La coleccion no existe");

        Coleccion coleccion = optional.get();

        if(coleccionRequestDto.getNombre() != null) coleccion.setNombre(coleccionRequestDto.getNombre());

        coleccionRepository.save(coleccion);

    }
}
