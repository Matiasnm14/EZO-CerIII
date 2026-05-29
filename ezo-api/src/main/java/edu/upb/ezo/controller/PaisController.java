package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Pais;
import edu.upb.ezo.service.PaisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Secured({"ROLE_ADMIN","ROLE_USER"})
@Controller
@RequestMapping("api/v1/pais")
@AllArgsConstructor
public class PaisController {
    private final PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> paises(){
        try{
            return ResponseEntity.ok(paisService.getPaises());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postPais(@RequestBody Pais pais){
        try{
            paisService.save(pais);
            return ResponseEntity.ok("Pais gurardado correctamente!");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deletePais(@RequestBody IdRequestDto id){
        try{
            paisService.deletePais(id.getId());
            return ResponseEntity.ok("Pais eliminado correctamente");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
