package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.DatosFactura;
import edu.upb.ezo.service.DatosFacturaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/datos-factura")
public class DatosFacturaController {
    private final DatosFacturaService datosFacturaService;

    @GetMapping
    public ResponseEntity<List<DatosFactura>> datosFacturas(){
        try{
            return ResponseEntity.ok(datosFacturaService.getDatosFactura());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postDatosFactura(@RequestBody DatosFactura datosFactura){
        try{
            datosFacturaService.save(datosFactura);
            return ResponseEntity.ok("Dato Factura guardada correctamente" + "\n" + datosFactura);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDatosFactura(@RequestBody IdRequestDto id){
        try{
            datosFacturaService.delete(id.getId());
            return ResponseEntity.ok("Datos factura eliminado");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
