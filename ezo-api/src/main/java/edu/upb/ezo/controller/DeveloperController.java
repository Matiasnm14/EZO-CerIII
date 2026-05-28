package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.DeveloperRequestDto;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.dto.response.DeveloperResponseDto;
import edu.upb.ezo.repository.entity.Developer;
import edu.upb.ezo.service.DeveloperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Secured("ROL_ADMIN_EZO")
@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/api/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<DeveloperResponseDto>> developers() {
        try {
            return ResponseEntity.ok(developerService.findAll());
        } catch (Exception e){
            log.error("Error al listar developers: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postDeveloper(DeveloperRequestDto developer){
        try {
            developerService.save(developer);
            return ResponseEntity.ok("Developer guardado correctamente");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteDeveloper(
            @RequestBody IdRequestDto IdDeveloper){
        try {
            developerService.deleteDeveloper(IdDeveloper.getId());
            return ResponseEntity.ok("Developer eliminado correctamente");
        } catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();}
    }
}
