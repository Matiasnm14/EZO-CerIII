package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.UsuarioRequestDto;
import edu.upb.ezo.repository.entity.Wishlist;
import edu.upb.ezo.repository.enums.RoleType;
import edu.upb.ezo.repository.repos.PaisRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.entity.Pais;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UserRepository userRepository;
    private final PaisRepository paisRepository;
    @Transactional
    public void save(UsuarioRequestDto usuario){

        Optional<Pais> optionalPais = paisRepository.findById(usuario.getIdPais());

        if (optionalPais.isEmpty()) {
            throw new IllegalArgumentException("El país asignado no existe en el sistema.");
        }
        if (userRepository.findByEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("El email ya está registrado por otro usuario.");
        }

        Usuario usuarioS = new Usuario();

        if(usuario.getNombre() != null) usuarioS.setNombre(usuario.getNombre());
        if(usuario.getApellido() != null) usuarioS.setApellido(usuario.getApellido());
        if(usuario.getFechaNacimiento() != null) usuarioS.setFechaNacimiento(LocalDate.parse(usuario.getFechaNacimiento()));
        if(usuario.getTelefono() != null) usuarioS.setTelefono(usuario.getTelefono());
        if(usuario.getEmail() != null) usuarioS.setEmail(usuario.getEmail());
        if(usuario.getNombreUsuario() != null) usuarioS.setNombreUsuario(usuario.getNombreUsuario());
        if(usuario.getPasswordHash() != null) usuarioS.setPasswordHash(usuario.getPasswordHash());
        if(usuario.getRol() != null) usuarioS.setRol(RoleType.valueOf(usuario.getRol()));
        if(usuario.getFechaRegistro() != null) usuarioS.setFechaRegistro(LocalDateTime.parse(usuario.getFechaRegistro()));
        if(usuario.isEmailVerificado()) usuarioS.setEmailVerificado(true);
        usuarioS.setActivo(usuario.isActivo());


        usuarioS.setPais(optionalPais.get());

        Wishlist wishlist = new Wishlist();

        usuarioS.setWishlistRelacional(wishlist);

        userRepository.save(usuarioS);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUsuarios(UUID IdUsuario){
        UUID uuid = UUID.fromString(IdUsuario.toString());
        Optional<Usuario> optionalUsuario = userRepository.findById(IdUsuario);
        Usuario usuario = new Usuario();
        if (optionalUsuario.isPresent()){
            usuario = optionalUsuario.get();
        }
        userRepository.delete(usuario);
    }

    @Transactional
    public void update(UsuarioRequestDto usuario) {
        if (usuario.getId() == null) {
            throw new IllegalArgumentException("El ID del usuario es obligatorio para actualizar.");
        }

        Optional<Usuario> optionalUsuario = userRepository.findById(usuario.getId());
        if (optionalUsuario.isEmpty()) {
            throw new IllegalArgumentException("El usuario que intenta actualizar no existe.");
        }

        Usuario usuarioExistente = optionalUsuario.get();

        if (usuario.getEmail() != null && !usuario.getEmail().equalsIgnoreCase(usuarioExistente.getEmail())) {
            if (userRepository.findByEmail(usuario.getEmail()) != null) {
                throw new IllegalArgumentException("El nuevo email ya está registrado por otro usuario.");
            }
            usuarioExistente.setEmail(usuario.getEmail());
        }


            Optional<Pais> optionalPais = paisRepository.findById(usuario.getIdPais());
            if (optionalPais.isEmpty()) {
                throw new IllegalArgumentException("El país asignado no existe en el sistema.");
            }
            usuarioExistente.setPais(optionalPais.get());


        if (usuario.getNombreUsuario() != null) usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        if (usuario.getPasswordHash() != null) usuarioExistente.setPasswordHash(usuario.getPasswordHash());
        if (usuario.getFechaNacimiento() != null) usuarioExistente.setFechaNacimiento(LocalDate.parse(usuario.getFechaNacimiento()));
        if (usuario.getTelefono() != null) usuarioExistente.setTelefono(usuario.getTelefono());
        if (usuario.getRol() != null) usuarioExistente.setRol(RoleType.valueOf(usuario.getRol()));

        userRepository.save(usuarioExistente);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findByUserIdToValidateSession(UUID id) {
        return userRepository.findByUserIdToValidateSession(id);
    }

    @Transactional
    public Optional<Usuario> findByUsername(String username){
        return  userRepository.findBynombreUsuarioIgnoreCase(username);
    }
}
