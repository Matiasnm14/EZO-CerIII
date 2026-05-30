package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.MensajeRequestDto;
import edu.upb.ezo.repository.entity.Mensaje;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.repos.MensajeRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MensajeService {
    private final MensajeRepository mensajeRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Mensaje> getMensajes(){
        return mensajeRepository.findAll();
    }

    @Transactional
    public void save(MensajeRequestDto mensajeRequestDto){
        Optional<Usuario> optionalUsuario1 = userRepository.findById(mensajeRequestDto.getIdUsuarioEmisor());
        Optional<Usuario> optionalUsuario2 = userRepository.findById(mensajeRequestDto.getIdUsuarioReceptor());

        if(optionalUsuario1.isEmpty() || optionalUsuario2.isEmpty())
            throw new IllegalArgumentException("El usuario emisor o receptor no existen");

        Mensaje mensaje = new Mensaje();
        BeanUtils.copyProperties(mensajeRequestDto,mensaje);

        mensaje.setUsuario_emisor(optionalUsuario1.get());
        mensaje.setUsuario_receptor(optionalUsuario2.get());

        mensajeRepository.save(mensaje);

    }
    @Transactional
    public void deleteMensajes(UUID IdMensaje){
        Optional<Mensaje> optional = mensajeRepository.findById(IdMensaje);
        if(optional.isEmpty())
            throw new IllegalArgumentException("Mensaje no existe");

        Mensaje mensaje = optional.get();

        mensajeRepository.delete(mensaje);
    }

    @Transactional
    public void update(MensajeRequestDto mensajeRequestDto) {
        Optional<Mensaje> optional = mensajeRepository.findById(mensajeRequestDto.getId());
        if(optional.isEmpty())
            throw new IllegalArgumentException("Mensaje no existe");

        Mensaje mensaje = optional.get();

        Optional<Usuario> optionalUsuario1 = userRepository.findById(mensajeRequestDto.getIdUsuarioEmisor());
        Optional<Usuario> optionalUsuario2 = userRepository.findById(mensajeRequestDto.getIdUsuarioReceptor());
        optionalUsuario1.ifPresent(mensaje::setUsuario_emisor);
        optionalUsuario2.ifPresent(mensaje::setUsuario_receptor);
        if(mensajeRequestDto.getMensaje()!=null)mensaje.setMensaje(mensajeRequestDto.getMensaje());

        mensajeRepository.save(mensaje);
    }
}
