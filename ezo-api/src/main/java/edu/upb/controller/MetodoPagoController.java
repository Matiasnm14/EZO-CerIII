package edu.upb.controller;

import edu.upb.ezo.repository.entity.MetodoPago;
import edu.upb.ezo.service.MetodoPagoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("pruebas/metodospago")
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> findAll(){
        try {
            return ResponseEntity.ok(metodoPagoService.findAll());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<MetodoPago> save(@RequestBody MetodoPago metodoPago){
        try {
            metodoPagoService.save(metodoPago);
            return ResponseEntity.ok().body(metodoPago);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody String id){
        try {
            MetodoPago metodoPago = metodoPagoService.findById(id);
            metodoPagoService.delete(metodoPago);
            return ResponseEntity.ok().body("Método de pago '" + metodoPago.getNombreMetodo() + "' eliminado");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
