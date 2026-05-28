package edu.upb.ezo;

import edu.upb.ezo.repository.repos.UserRepository;
import edu.upb.ezo.repository.entity.Usuario;
import edu.upb.ezo.repository.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
                    .email("root@upb.com")
                    .rol(RoleType.ROLE_ADMIN)
                    .nombre("Ricardo")
                    .apellido("Laredo")
                    .emailVerificado(true)
                    .fechaNacimiento(LocalDate.now())
                    .telefono("00000000")
                    .passwordHash(passwordEncoder.encode("password"))

                    .build());

            Usuario root2 = userRepository.save(Usuario.builder()
                    .nombreUsuario("usurio")
                    .email("usuario@upb.com")
                    .rol(RoleType.ROLE_USER)
                    .nombre("Matias")
                    .apellido("Nunez")
                    .emailVerificado(true)
                    .fechaNacimiento(LocalDate.now())
                    .telefono("00000000")
                    .passwordHash(passwordEncoder.encode("password"))

                    .build());
        }
    }
}
