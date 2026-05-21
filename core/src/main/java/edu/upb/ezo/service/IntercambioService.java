package edu.upb.ezo.service;

import edu.upb.ezo.repository.IntercambioRepository;
import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Intercambio;
import edu.upb.ezo.repository.entity.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IntercambioService {
    private final IntercambioRepository intercambioRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(Intercambio intercambio){
        Optional<Usuario> optionalUsuarioOrigen = userRepository.findById(intercambio.getUsuario_origen().getId().toString());
        Optional<Usuario> optionalUsuarioDestino = userRepository.findById(intercambio.getUsuario_destino().getId().toString());

        if(optionalUsuarioOrigen.isEmpty() && optionalUsuarioDestino.isPresent())
            throw new IllegalArgumentException("El Usuario Destino o el Usuario Origen no existen");

        if(intercambio.getFecha() == null && intercambio.getFecha().isEqual(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de intercambio no es valida (no puede ser nula, futura ni pasada)");

        if(intercambio.getEstado() == null)
            throw new IllegalArgumentException("El estado no puede ser nulo");

        intercambioRepository.save(intercambio);
    }

    @Transactional(readOnly = true)
    public List<Intercambio> getIntercambios(){
        return intercambioRepository.findAll();
    }

    @Transactional
    public void delete(String id){
        Optional<Intercambio> optional = intercambioRepository.findById(id);
        Intercambio intercambio = new Intercambio();

        if(optional.isPresent())
            intercambio = optional.get();

        intercambioRepository.save(intercambio);
    }
}
