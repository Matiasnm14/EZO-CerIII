package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Intercambio;
import edu.upb.ezo.service.IntercambioService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/intercambio")
public class IntercambioController {
    private final IntercambioService intercambioService;

    @GetMapping
    public ResponseEntity<List<Intercambio>> intercambios(){
        try{
            return ResponseEntity.ok(intercambioService.getIntercambios());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postIntercambio(@RequestBody Intercambio intercambio){
        try{
            intercambioService.save(intercambio);
            return ResponseEntity.ok("Intercambio guardado correctamente" + "\n" + intercambio);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteIntercambio(@RequestBody IdRequestDto id){
        try{
            intercambioService.delete(id.getId());
            return ResponseEntity.ok("Intercambio eliminado correctamente");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
