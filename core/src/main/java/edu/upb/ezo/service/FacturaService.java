package edu.upb.ezo.service;

import edu.upb.ezo.repository.FacturaRepository;
import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Factura;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacturaService {
    private final FacturaRepository facturaRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(Factura factura){
        Optional<Usuario> optionalUsuario = userRepository.findById(factura.getUsuario().getId().toString());
        if(optionalUsuario.isPresent()){
            facturaRepository.save(factura);
        }
    }

    @Transactional(readOnly = true)
    public List<Factura> getFacturas(){
        return facturaRepository.findAll();
    }

    @Transactional
    public void delete(String id){
        Optional<Factura> optionalFactura = facturaRepository.findById(id);
        Factura factura = new Factura();
        if(optionalFactura.isPresent()){
            factura = optionalFactura.get();
        }
        facturaRepository.delete(factura);
    }

}
