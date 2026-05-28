package edu.upb.ezo.service;

import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService{
    private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario authUser = this.userRepository.findByNombreUsuarioIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe el usuario"));
        String password = authUser.getPassword();
        return new org.springframework.security.core.userdetails.User(
                authUser.getUsername(),
                password,
                authUser.isEnabled(),
                true,
                authUser.isAccountNonExpired(),
                true,
                authUser.getAuthorities()
        );
    }
}
