package edu.upb.ezo.controller;

import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("api/v1/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> usuarios(){
        try{
            return ResponseEntity.ok(usuarioService.getUsuarios());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> postUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.save(usuario);
            return ResponseEntity.ok("Usuario guardado correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUsuario(@RequestBody String IdUsuario){
        try{
            usuarioService.deleteUsuarios(IdUsuario);
            return ResponseEntity.ok("Usuario Eliminado correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

}
