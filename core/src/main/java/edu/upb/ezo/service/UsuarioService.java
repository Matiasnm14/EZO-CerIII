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

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UserRepository userRepository;
    private final PaisRepository paisRepository;
    @Transactional
    public void save(Usuario usuario){
        Optional<Pais> optionalPais = paisRepository.findById(usuario.getPais().getId().toString());
        Usuario auxUser = new Usuario();
        if (optionalPais.isPresent()){
            userRepository.save(usuario);
        }
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

}
