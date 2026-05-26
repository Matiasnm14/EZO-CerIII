package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.EstudianteRequestDto;
import edu.upb.ezo.repository.dto.response.EstudianteIntDto;
import edu.upb.ezo.repository.dto.response.EstudianteResponseDto;
import edu.upb.ezo.repository.entity.Materia;
import edu.upb.ezo.service.EstudianteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;


    @GetMapping
    public ResponseEntity<List<EstudianteIntDto>> get(){
        try{
            return ResponseEntity.ok(estudianteService.getEstudiantes());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody EstudianteRequestDto materiaRequestDto){
        try{
            estudianteService.save(materiaRequestDto);
            return ResponseEntity.ok("Estudiante guardada");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestBody EstudianteRequestDto materia){
        try{
            estudianteService.update(materia);
            return ResponseEntity.ok("Materia Act");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
