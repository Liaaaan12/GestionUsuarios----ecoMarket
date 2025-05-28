package com.GestionUsuarios.repository;

import com.GestionUsuarios.model.GerenteTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GerenteTiendaRepository extends JpaRepository<GerenteTienda, Long> {
    Optional<GerenteTienda> findByRun(String run);
    Optional<GerenteTienda> findByEmail(String email);
}

