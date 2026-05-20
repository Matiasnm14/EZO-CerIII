package edu.upb.ezo.service;

import edu.upb.ezo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UserRepository userRepository;


}
