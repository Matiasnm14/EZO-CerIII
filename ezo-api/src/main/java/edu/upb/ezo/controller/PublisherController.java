package edu.upb.ezo.controller;


import edu.upb.ezo.repository.dto.response.PublisherDto;
import edu.upb.ezo.repository.dto.request.PublisherRequestDto;
import edu.upb.ezo.service.PublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/api/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping()
    public ResponseEntity<List<PublisherDto>> publishers(){
        try {
            return ResponseEntity.ok(publisherService.listar());
        }catch (Exception e) {
            log.error("Error al listar publishers", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody PublisherRequestDto publisher) {
        try {
            this.publisherService.save(publisher);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            log.error("Error al guardar publisher", e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
