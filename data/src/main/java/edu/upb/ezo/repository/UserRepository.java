package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);

    Optional<Usuario> findByNombreUsuarioIgnoreCase(String lowerCase);

    @Query("SELECT u FROM Usuario u WHERE  u.id=:pId")
    Optional<Usuario> findByUserIdToValidateSession(@Param("pId") UUID pId);
}
