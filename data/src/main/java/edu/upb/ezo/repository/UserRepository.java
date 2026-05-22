package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);
    Optional<Usuario> findBynombreUsuarioIgnoreCase(String name);
    @Query("SELECT new edu.upb.ezo.repository.entity.Usuario(u.id, u.nombreUsuario, u.rol) FROM Usuario u WHERE  u.id=:pId")
    Optional<Usuario> findByUserIdToValidateSession(@Param("pId") String pId);
}
