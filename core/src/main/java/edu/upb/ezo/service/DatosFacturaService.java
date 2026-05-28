package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.DatosFacturaRequestDto;
import edu.upb.ezo.repository.entity.DetalleFactura;
import edu.upb.ezo.repository.repos.DatosFacturaRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.entity.DatosFactura;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
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
    public void save(DatosFacturaRequestDto datosFacturaRequestDto){

        DatosFactura datosFactura = new DatosFactura();

        datosFactura.setDireccion(datosFacturaRequestDto.getDireccion());
        datosFactura.setNit(datosFacturaRequestDto.getNit());
        datosFactura.setRazon_social(datosFacturaRequestDto.getRazonSocial());

        Optional<Usuario> optional = userRepository.findById(datosFacturaRequestDto.getIdUsuario());

        if(optional.isEmpty()){
            throw new IllegalArgumentException("No existe el usuario para el Dato Factura");
        }

        Usuario usuario = optional.get();

        datosFactura.setUsuario(usuario);

        datosFacturaRepository.save(datosFactura);

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
