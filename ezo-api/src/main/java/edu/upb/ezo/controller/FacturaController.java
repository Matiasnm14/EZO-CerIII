package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.FacturaRequestDto;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Factura;
import edu.upb.ezo.service.FacturaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/factura")
public class FacturaController {
    private final FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> facturas(){
        try{
            return ResponseEntity.ok(facturaService.getFacturas());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postFactura(@RequestBody FacturaRequestDto factura){
        try{
            facturaService.save(factura);
            return ResponseEntity.ok("Factura guardada correctamente" + "\n" + factura);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFactura(@RequestBody IdRequestDto id){
        try{
            facturaService.delete(id.getId());
            return ResponseEntity.ok("Factura eliminada correctamente");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
