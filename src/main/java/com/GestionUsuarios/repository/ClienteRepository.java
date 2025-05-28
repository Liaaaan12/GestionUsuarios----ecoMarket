package com.GestionUsuarios.repository;

import com.GestionUsuarios.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByRun(String run);
    Optional<Cliente> findByEmail(String email);
}