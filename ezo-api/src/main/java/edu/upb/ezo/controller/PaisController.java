package edu.upb.ezo.controller;

import edu.upb.ezo.repository.entity.Pais;
import edu.upb.ezo.service.PaisService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class PaisController {
    private final PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> paises(){
        try{
            return ResponseEntity.ok(paisService.getPaises());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postPais(@RequestBody Pais pais){
        try{
            paisService.save(pais);
            return ResponseEntity.ok("Pais gurardado correctamente!");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePais(@RequestBody String IdPais){
        try{
            paisService.deletePais(IdPais);
            return ResponseEntity.ok("Pais eliminado correctamente");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
