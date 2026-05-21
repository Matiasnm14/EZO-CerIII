package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
