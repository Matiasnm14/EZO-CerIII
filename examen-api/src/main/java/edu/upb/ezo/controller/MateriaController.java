package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.MateriaRequestDto;
import edu.upb.ezo.repository.entity.Materia;
import edu.upb.ezo.service.MateriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/materias")
public class MateriaController {
    private final MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<Materia>> get(){
        try{
            return ResponseEntity.ok(materiaService.getMaterias());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Materia materiaRequestDto){
        try{
            materiaService.save(materiaRequestDto);
            return ResponseEntity.ok("Materia guardada");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestBody Materia materia){
        try{
            materiaService.updateMateria(materia);
            return ResponseEntity.ok("Materia Act");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
