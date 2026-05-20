package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionUsuarioRepository  extends JpaRepository<SesionUsuario,String> {
}
