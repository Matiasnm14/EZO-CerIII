package edu.upb.ezo.service;

import edu.upb.ezo.repository.dto.request.WishlistRequestDto;
import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.repos.WishlistRepository;
import edu.upb.ezo.repository.dto.request.IdRequestDto;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.entity.Wishlist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    public List<Wishlist> getWishlist(){
        return wishlistRepository.findAll();
    }

    @Transactional
    public void save(WishlistRequestDto wishlistRequestDto){
        Optional<Usuario> optional = userRepository.findById(wishlistRequestDto.getIdUsuario());

        if(optional.isEmpty())
            throw new IllegalArgumentException("No existe el Usuario para el Wishlist");

        Wishlist wishlist = new Wishlist();

        wishlist.setUsuario(optional.get());
        wishlistRepository.save(wishlist);
    }

    @Transactional
    public void delete(UUID id){
        Optional<Wishlist> optional = wishlistRepository.findById(id);

        if(optional.isEmpty())
            throw new IllegalArgumentException("El wishlist no existe");

        Wishlist wishlist = optional.get();
        wishlistRepository.delete(wishlist);
    }

    @Transactional
    public void update(WishlistRequestDto wishlistRequestDto){
        Optional<Wishlist> optional = wishlistRepository.findById(wishlistRequestDto.getId());

        if(optional.isEmpty())
            throw new IllegalArgumentException("El wishlist no existe");

        Wishlist wishlistToUpdate = optional.get();

        Optional<Usuario> optionalUsuario = userRepository.findById(wishlistRequestDto.getIdUsuario());
        if(optionalUsuario.isEmpty())
            throw new IllegalArgumentException("Usuario no existe");

        wishlistToUpdate.setUsuario(optionalUsuario.get());
        wishlistRepository.save(wishlistToUpdate);
    }
}
