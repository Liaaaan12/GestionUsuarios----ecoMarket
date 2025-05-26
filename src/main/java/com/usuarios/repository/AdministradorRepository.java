package com.usuarios.repository;

import com.usuarios.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByRun(String run);
    Optional<Administrador> findByEmail(String email);
}