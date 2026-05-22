package edu.upb.ezo.service;

import edu.upb.ezo.repository.PaisRepository;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Pais;
import jakarta.transaction.TransactionScoped;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaisService {
    private final PaisRepository paisRepository;


    @Transactional
    public void save(Pais pais){
        try{
            paisRepository.save(pais);
        }catch (Exception e){
            System.out.println(e.getMessage());;
        }
    }

    
    @Transactional(readOnly = true)
    public List<Pais> getPaises(){
        return paisRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Pais> findById(UUID id){
        return this.paisRepository.findById(id);
    }

    @Transactional
    public void deletePais(UUID IdPais){
        Optional<Pais> optionalPais = paisRepository.findById(IdPais);
        Pais pais = new Pais();
        if(optionalPais.isPresent()){
            pais = optionalPais.get();
        }
        paisRepository.delete(pais);
    }

}
