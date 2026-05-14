package edu.upb.ezo.repository;

import edu.upb.ezo.repository.entity.TokenRecuperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRecuperacionRepository extends JpaRepository<TokenRecuperacion,String> {
}
