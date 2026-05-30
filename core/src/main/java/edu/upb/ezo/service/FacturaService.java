package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.DetalleCompraRequestDto;
import edu.upb.ezo.repository.dto.request.FacturaRequestDto;
import edu.upb.ezo.repository.entity.*;
import edu.upb.ezo.repository.repos.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FacturaService {
    private final FacturaRepository facturaRepository;
    private final UserRepository userRepository;
    private final ArticuloRepository articuloRepository;
    private final CopiaRepository copiaRepository;
    private final MetodoPagoRepository metodoPagoRepository;

    @Transactional
    public void save(FacturaRequestDto facturaRequestDto){
        Usuario usuario = userRepository.findById(facturaRequestDto.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

        MetodoPago metodoPago = metodoPagoRepository.findById(facturaRequestDto.getIdMetodoPago())
                .orElseThrow(() -> new IllegalArgumentException("Método de pago no existe"));

        Factura factura = new Factura();
        factura.setNumeroFactura(facturaRequestDto.getNumeroFactura());
        factura.setUsuario(usuario);
        factura.setFechaEmision(LocalDate.parse(facturaRequestDto.getFechaEmision()));
        factura.setNitEmpresa(facturaRequestDto.getNitEmpresa());
        factura.setRazonSocialEmp(facturaRequestDto.getRazonSocialEmp());
        factura.setNit(facturaRequestDto.getNit());
        factura.setRazonSocial(facturaRequestDto.getRazonSocial());

        BigDecimal subtotalAcumulado = BigDecimal.ZERO;

        for (DetalleCompraRequestDto detalleDto : facturaRequestDto.getDetalles()) {

            Articulo articulo = articuloRepository.findById(detalleDto.getIdArticulo())
                    .orElseThrow(() -> new IllegalArgumentException("Artículo no existe: " + detalleDto.getIdArticulo()));

            Copia copia = copiaRepository.findById(detalleDto.getIdCopia())
                    .orElseThrow(() -> new IllegalArgumentException("Copia no existe: " + detalleDto.getIdCopia()));

            BigDecimal precioItem = articulo.getPrecio();
            BigDecimal costoTotalItem = precioItem.multiply(BigDecimal.valueOf(detalleDto.getCantidad()));
            subtotalAcumulado = subtotalAcumulado.add(costoTotalItem);

            DetalleFactura detalle = new DetalleFactura();
            detalle.setArticulo(articulo);
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecio_unitario(precioItem);
            detalle.setDescripcion(detalleDto.getDescripcion() != null ? detalleDto.getDescripcion() : "Compra de: " + articulo.getNombre());
            factura.addDetalle(detalle);

            FacturaCopia facturaCopia = new FacturaCopia();
            facturaCopia.setCopia(copia);
            facturaCopia.setPrecio_unitario(precioItem);
            factura.addCopia(facturaCopia);
        }

        BigDecimal porcentajeImpuesto = BigDecimal.valueOf(0.13); // Ejemplo: 13% de IVA
        BigDecimal impuestoCalculado = subtotalAcumulado.multiply(porcentajeImpuesto);
        BigDecimal totalCalculado = subtotalAcumulado.add(impuestoCalculado);

        factura.setSubtotal(subtotalAcumulado);
        factura.setImpuesto(impuestoCalculado);
        factura.setTotal(totalCalculado);

        FacturaMetodo facturaMetodo = new FacturaMetodo();
        facturaMetodo.setMetodoPago(metodoPago);
        factura.addMetodo(facturaMetodo);

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
