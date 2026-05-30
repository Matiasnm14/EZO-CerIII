package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.CopiaRequestDto;
import edu.upb.ezo.repository.entity.Articulo;
import edu.upb.ezo.repository.entity.Copia;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.repos.ArticuloRepository;
import edu.upb.ezo.repository.repos.CopiaRepository;
import edu.upb.ezo.repository.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CopiaService {
    private final CopiaRepository copiaRepository;
    private final ArticuloRepository articuloRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Copia> getCopias(){
        return copiaRepository.findAll();
    }

    @Transactional
    public void save(CopiaRequestDto copiaRequestDto){
        Copia copia = new Copia();

        Optional<Articulo> optional = articuloRepository.findById(copiaRequestDto.getIdArticulo());

        if(optional.isEmpty())
            throw new IllegalArgumentException("El articulo no existe");

        copia.setArticulo(optional.get());

        Optional<Usuario> optionalUsuario = userRepository.findById(copiaRequestDto.getIdUsuario());
        optionalUsuario.ifPresent(copia::setUsuario);

        copia.setTipo(copiaRequestDto.getTipo());
        copia.setEstado(copiaRequestDto.getEstado());
        copia.setCodigo_unico(copiaRequestDto.getCodigoUnico());

        copiaRepository.save(copia);

    }

    @Transactional
    public void delete(CopiaRequestDto copiaRequestDto) {
        Optional<Copia> optional = copiaRepository.findById(copiaRequestDto.getId());
        if(optional.isEmpty())
            throw new IllegalArgumentException("Copia no existe");

        Copia copia = optional.get();
        copiaRepository.delete(copia);
    }

    @Transactional
    public void update(CopiaRequestDto copiaRequestDto){
        Optional<Copia> optional = copiaRepository.findById(copiaRequestDto.getId());
        if(optional.isEmpty())
            throw new IllegalArgumentException("Copia no existe");

        Copia copia = optional.get();

        Optional<Articulo> optionalArticulo = articuloRepository.findById(copiaRequestDto.getIdArticulo());
        optionalArticulo.ifPresent(copia::setArticulo);

        Optional<Usuario> optionalUsuario = userRepository.findById(copiaRequestDto.getIdUsuario());
        optionalUsuario.ifPresent(copia::setUsuario);

        if(copiaRequestDto.getTipo() != null) copia.setTipo(copiaRequestDto.getTipo());
        if(copiaRequestDto.getEstado() != null) copia.setEstado(copiaRequestDto.getEstado());
        if(copiaRequestDto.getCodigoUnico() != null) copia.setCodigo_unico(copiaRequestDto.getCodigoUnico());

        copiaRepository.save(copia);
    }

}
