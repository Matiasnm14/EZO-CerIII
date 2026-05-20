package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,String> {
}
