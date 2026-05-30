package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.ArticuloRequestDto;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Articulo;
import edu.upb.ezo.repository.entity.Coleccion;
import edu.upb.ezo.repository.entity.Developer;
import edu.upb.ezo.repository.entity.Publisher;
import edu.upb.ezo.repository.repos.ArticuloRepository;
import edu.upb.ezo.repository.repos.ColeccionRepository;
import edu.upb.ezo.repository.repos.DeveloperRepository;
import edu.upb.ezo.repository.repos.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticuloService {
    private final ArticuloRepository articuloRepository;
    private final PublisherRepository publisherRepository;
    private final DeveloperRepository developerRepository;
    private final ColeccionRepository coleccionRepository;

    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(){
        return articuloRepository.findAll();
    }

    @Transactional
    public void save(ArticuloRequestDto articuloRequestDto){
        Optional<Publisher>optionalPublisher = publisherRepository.findById(articuloRequestDto.getIdPublisher());
        Optional<Developer> optionalDeveloper = developerRepository.findById(articuloRequestDto.getIdDeveloper());
        Optional<Coleccion> optionalColeccion = coleccionRepository.findById(articuloRequestDto.getIdColeccion());

        Articulo articulo = new Articulo();
        optionalColeccion.ifPresent(articulo::setColeccion);
        optionalPublisher.ifPresent(articulo::setPublisher);
        optionalDeveloper.ifPresent(articulo::setDeveloper);

        articulo.setDescripcion(articuloRequestDto.getDescripcion());
        articulo.setDisponible(articuloRequestDto.getDisponible());
        articulo.setFechaLanzamiento(LocalDate.parse(articuloRequestDto.getFechaLanzamiento()));
        articulo.setNombre(articuloRequestDto.getNombre());
        articulo.setPrecio(articuloRequestDto.getPrecio());
        articulo.setTamano(articuloRequestDto.getTamano());
        articulo.setTipo(articuloRequestDto.getTipo());

        articuloRepository.save(articulo);

        articuloRepository.save(articulo);

    }
    @Transactional
    public void delete(IdRequestDto idRequestDto){
        Optional<Articulo> optional = articuloRepository.findById(idRequestDto.getId());

        if(optional.isEmpty())
            throw new IllegalArgumentException("El articulo no existe");

        Articulo articulo = optional.get();

        articuloRepository.delete(articulo);
    }

    @Transactional
    public void update(ArticuloRequestDto articuloRequestDto){
        Optional<Articulo> optional = articuloRepository.findById(articuloRequestDto.getId());

        if(optional.isEmpty())
            throw new IllegalArgumentException("El articulo no existe");

        Articulo articulo = optional.get();

        Optional<Publisher>optionalPublisher = publisherRepository.findById(articuloRequestDto.getIdPublisher());
        Optional<Developer> optionalDeveloper = developerRepository.findById(articuloRequestDto.getIdDeveloper());
        Optional<Coleccion> optionalColeccion = coleccionRepository.findById(articuloRequestDto.getIdColeccion());

        optionalColeccion.ifPresent(articulo::setColeccion);
        optionalPublisher.ifPresent(articulo::setPublisher);
        optionalDeveloper.ifPresent(articulo::setDeveloper);

        if(articuloRequestDto.getDescripcion() != null) articulo.setDescripcion(articuloRequestDto.getDescripcion());
        if(articuloRequestDto.getDisponible() != null) articulo.setDisponible(articuloRequestDto.getDisponible());
        if(articuloRequestDto.getFechaLanzamiento() != null)articulo.setFechaLanzamiento(LocalDate.parse(articuloRequestDto.getFechaLanzamiento()));
        if(articuloRequestDto.getNombre() != null) articulo.setNombre(articuloRequestDto.getNombre());
        if(articuloRequestDto.getPrecio() != null) articulo.setPrecio(articuloRequestDto.getPrecio());
        if(articuloRequestDto.getTamano() != null) articulo.setTamano(articuloRequestDto.getTamano());
        if(articuloRequestDto.getTipo() != null) articulo.setTipo(articuloRequestDto.getTipo());

        articuloRepository.save(articulo);

    }
}
