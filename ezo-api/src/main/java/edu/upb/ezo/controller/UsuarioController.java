package edu.upb.ezo.controller;

import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("api/v1/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> usuarios(){
        try{
            return ResponseEntity.ok(usuarioService.getUsuarios());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.save(usuario);
            return ResponseEntity.ok("Usuario guardado correctamente");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUsuario(@RequestBody IdRequestDto IdUsuario){
        try{
            usuarioService.deleteUsuarios(IdUsuario.getId());
            return ResponseEntity.ok("Usuario Eliminado correctamente");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PutMapping
    public ResponseEntity<String> putUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.update(usuario);
            return ResponseEntity.ok("Usuario actualizado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
