package com.usuarios.repository;

import com.usuarios.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
    Optional<TipoUsuario> findByRun(String run);
    Optional<TipoUsuario> findByEmail(String email);
}

