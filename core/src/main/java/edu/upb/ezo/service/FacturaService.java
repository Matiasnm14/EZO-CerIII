package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.FacturaRequestDto;
import edu.upb.ezo.repository.repos.FacturaRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.entity.Factura;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FacturaService {
    private final FacturaRepository facturaRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(FacturaRequestDto facturaRequestDto){
        Optional<Usuario> optionalUsuario = userRepository.findById(facturaRequestDto.getIdUsuario());
        if(optionalUsuario.isEmpty())
            throw new IllegalArgumentException("El usuario no existe");

        Factura factura = new Factura();

        factura.setNumeroFactura(facturaRequestDto.getNumeroFactura());
        factura.setNit(facturaRequestDto.getNit());
        factura.setImpuesto(facturaRequestDto.getImpuesto());
        factura.setTotal(facturaRequestDto.getTotal());
        factura.setFechaEmision(LocalDate.parse(facturaRequestDto.getFechaEmision()));
        factura.setNitEmpresa(facturaRequestDto.getNitEmpresa());
        factura.setRazonSocial(facturaRequestDto.getRazonSocial());
        factura.setRazonSocialEmp(facturaRequestDto.getRazonSocialEmp());
        factura.setSubtotal(facturaRequestDto.getSubtotal());
        factura.setUsuario(optionalUsuario.get());

        facturaRepository.save(factura);
    }

    @Transactional(readOnly = true)
    public List<Factura> getFacturas(){
        return facturaRepository.findAll();
    }

    @Transactional
    public void delete(UUID id){
        Optional<Factura> optionalFactura = facturaRepository.findById(id);
        Factura factura = new Factura();
        if(optionalFactura.isPresent()){
            factura = optionalFactura.get();
        }
        facturaRepository.delete(factura);
    }

}
