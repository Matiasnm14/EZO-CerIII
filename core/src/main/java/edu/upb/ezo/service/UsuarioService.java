package edu.upb.ezo.service;

import edu.upb.ezo.repository.PaisRepository;
import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Pais;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UserRepository userRepository;
    private final PaisRepository paisRepository;
    @Transactional
    public void save(Usuario usuario){
        if (usuario.getPais() == null || usuario.getPais().getId() == null) {
            throw new IllegalArgumentException("El usuario debe tener un país asignado.");
        }

        Optional<Pais> optionalPais = paisRepository.findById(usuario.getPais().getId().toString());

        if (optionalPais.isEmpty()) {
            throw new IllegalArgumentException("El país asignado no existe en el sistema.");
        }
        if (userRepository.findByEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("El email ya está registrado por otro usuario.");
        }

        userRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUsuarios(String IdUsuario){
        Optional<Usuario> optionalUsuario = userRepository.findById(IdUsuario);
        Usuario usuario = new Usuario();
        if (optionalUsuario.isPresent()){
            usuario = optionalUsuario.get();
        }
        userRepository.delete(usuario);
    }

    @Transactional
    public void update(Usuario usuario) {
        if (usuario.getId() == null) {
            throw new IllegalArgumentException("El ID del usuario es obligatorio para actualizar.");
        }

        Optional<Usuario> optionalUsuario = userRepository.findById(usuario.getId().toString());
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

        if (usuario.getPais() != null && usuario.getPais().getId() != null) {
            Optional<Pais> optionalPais = paisRepository.findById(usuario.getPais().getId().toString());
            if (optionalPais.isEmpty()) {
                throw new IllegalArgumentException("El país asignado no existe en el sistema.");
            }
            usuarioExistente.setPais(optionalPais.get());
        }

        if (usuario.getNombreUsuario() != null) usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
        if (usuario.getPasswordHash() != null) usuarioExistente.setPasswordHash(usuario.getPasswordHash());
        if (usuario.getFechaNacimiento() != null) usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento());
        if (usuario.getTelefono() != null) usuarioExistente.setTelefono(usuario.getTelefono());
        if (usuario.getRol() != null) usuarioExistente.setRol(usuario.getRol());

        userRepository.save(usuarioExistente);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findByUserIdToValidateSession(String id) {
        return userRepository.findByUserIdToValidateSession(UUID.fromString(id));
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findByUsername(String username) {
        return userRepository.findByNombreUsuarioIgnoreCase(username);
    }
}
