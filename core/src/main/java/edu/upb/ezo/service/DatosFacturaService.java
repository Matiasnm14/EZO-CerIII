package edu.upb.ezo.service;

import edu.upb.ezo.repository.DatosFacturaRepository;
import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Articulo;
import edu.upb.ezo.repository.entity.DatosFactura;
import edu.upb.ezo.repository.entity.DetalleFactura;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DatosFacturaService {
    private final DatosFacturaRepository datosFacturaRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(DatosFactura detalleFactura){
        Optional<Usuario> optional = userRepository.findById(detalleFactura.getUsuario().getId());

        if(optional.isPresent()){
            datosFacturaRepository.save(detalleFactura);
        }
    }

    @Transactional(readOnly = true)
    public List<DatosFactura> getDatosFactura(){
        return datosFacturaRepository.findAll();
    }

    @Transactional
    public void delete(UUID id){
        Optional<DatosFactura> optional = datosFacturaRepository.findById(id);
        DatosFactura datosFactura = new DatosFactura();

        if(optional.isPresent()){
            datosFactura = optional.get();
        }
        datosFacturaRepository.delete(datosFactura);
    }
}
