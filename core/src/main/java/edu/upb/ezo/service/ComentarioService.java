package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.ComentarioRequestDto;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Articulo;
import edu.upb.ezo.repository.entity.Comentario;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.repos.ArticuloRepository;
import edu.upb.ezo.repository.repos.ComentarioRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final ArticuloRepository articuloRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Comentario> getComentarios(){
        return comentarioRepository.findAll();
    }

    @Transactional
    public void save(ComentarioRequestDto comentarioRequestDto){
        Optional<Articulo> optionalArticulo = articuloRepository.findById(comentarioRequestDto.getIdArticulo());
        Optional<Usuario> optionalUsuario = userRepository.findById(comentarioRequestDto.getIdUsuario());
        if(optionalArticulo.isEmpty()){
            throw new IllegalArgumentException("El artículo no existe");
        }
        if(optionalUsuario.isEmpty())
            throw new IllegalArgumentException("El usuario no existe");


        Comentario comentario = new Comentario();
        comentario.setArticulo(optionalArticulo.get());
        comentario.setUsuario(optionalUsuario.get());

        if(comentarioRequestDto.getComentario() != null) comentario.setComentario(comentarioRequestDto.getComentario());
        if(comentarioRequestDto.getPuntuacion() != null) comentario.setPuntuacion(comentarioRequestDto.getPuntuacion());
        if(comentarioRequestDto.getFecha() != null) comentario.setFecha(LocalDate.parse(comentarioRequestDto.getFecha()));

        comentarioRepository.save(comentario);
    }

    @Transactional
    public void delete(IdRequestDto idRequestDto){
        Optional<Comentario> optionalComentario = comentarioRepository.findById(idRequestDto.getId());
        Comentario comentario = new Comentario();
        if(optionalComentario.isPresent()){
            comentario = optionalComentario.get();
        }
        comentarioRepository.delete(comentario);
    }

    @Transactional
    public void update(ComentarioRequestDto comentarioRequestDto){
        Optional<Comentario> optionalComentario = comentarioRepository.findById(comentarioRequestDto.getId());
        if(optionalComentario.isEmpty()){
            throw new IllegalArgumentException("El comentario no existe");
        }

        Comentario comentario = optionalComentario.get();

        if(comentarioRequestDto.getComentario() != null) comentario.setComentario(comentarioRequestDto.getComentario());
        if(comentarioRequestDto.getPuntuacion() != null) comentario.setPuntuacion(comentarioRequestDto.getPuntuacion());
        if(comentarioRequestDto.getFecha() != null) comentario.setFecha(LocalDate.parse(comentarioRequestDto.getFecha()));

        comentarioRepository.save(comentario);
    }
}
