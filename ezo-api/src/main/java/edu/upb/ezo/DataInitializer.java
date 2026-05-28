package edu.upb.ezo;

import edu.upb.ezo.repository.UserRepository;
import edu.upb.ezo.repository.entity.Pais;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.enums.RolType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    private void init() {
        if (userRepository.count() == 0) {
            Usuario root = userRepository.save(Usuario.builder()
                    .nombreUsuario("root")
                    .email("root@ezo.com")
                    .pais(null)
                    .passwordHash(passwordEncoder.encode("azoadmin"))
                    .nombre("Balatro")
                    .apellido("Balatrez")
                    .fechaNacimiento(LocalDate.now())
                    .telefono("00000000")
                    .rol(RolType.ROL_ADMIN_EZO)
                    .fechaRegistro(LocalDateTime.now())
                    .emailVerificado(true)
                    .activo(true)
                    .build());
        }
    }
}
