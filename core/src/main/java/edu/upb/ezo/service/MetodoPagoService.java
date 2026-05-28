package edu.upb.ezo.service;

import edu.upb.ezo.repository.repos.MetodoPagoRepository;
import edu.upb.ezo.repository.entity.MetodoPago;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class MetodoPagoService {
    private final MetodoPagoRepository metodoPagoRepository;

    public void  save(MetodoPago metodoPago){
        metodoPagoRepository.save(metodoPago);
    }

    public List<MetodoPago> findAll(){
        return metodoPagoRepository.findAll();
    }

    public MetodoPago findById(UUID id){
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public void deleteById(UUID id){
        metodoPagoRepository.deleteById(id);
    }

    public void delete(MetodoPago metodoPago){
        metodoPagoRepository.delete(metodoPago);
    }

}
