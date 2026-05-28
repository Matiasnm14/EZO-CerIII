package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.IntercambioRequestDto;
import edu.upb.ezo.repository.repos.IntercambioRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.entity.Intercambio;
import edu.upb.ezo.repository.entity.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IntercambioService {
    private final IntercambioRepository intercambioRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(IntercambioRequestDto intercambio){
        Optional<Usuario> optionalUsuarioOrigen = userRepository.findById(intercambio.getIdUsuarioOrigen());
        Optional<Usuario> optionalUsuarioDestino = userRepository.findById(intercambio.getIdUsuarioDestino());

        if(optionalUsuarioOrigen.isEmpty() || optionalUsuarioDestino.isEmpty())
            throw new IllegalArgumentException("El Usuario Destino o el Usuario Origen no existen");


        LocalDate date = LocalDate.parse(intercambio.getFecha());
        if(date.isEqual(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de intercambio no es valida (no puede ser nula, futura ni pasada)");

        if(intercambio.getEstado() == null)
            throw new IllegalArgumentException("El estado no puede ser nulo");

        Intercambio intercambioS = new Intercambio();

        intercambioS.setEstado(intercambio.getEstado());
        intercambioS.setFecha(date);
        intercambioS.setCantidad_destino(intercambio.getCantidadDestino());
        intercambioS.setCantidad_origen(intercambio.getCantidadOrigen());
        intercambioS.setUsuario_destino(optionalUsuarioDestino.get());
        intercambioS.setUsuario_origen(optionalUsuarioOrigen.get());

        intercambioRepository.save(intercambioS);
    }

    @Transactional(readOnly = true)
    public List<Intercambio> getIntercambios(){
        return intercambioRepository.findAll();
    }

    @Transactional
    public void delete(UUID id){
        Optional<Intercambio> optional = intercambioRepository.findById(id);
        Intercambio intercambio = new Intercambio();

        if(optional.isPresent())
            intercambio = optional.get();

        intercambioRepository.save(intercambio);
    }
}
