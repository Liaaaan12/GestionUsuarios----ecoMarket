package com.usuarios.repository;

import com.usuarios.model.EmpleadoVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmpleadoVentasRepository extends JpaRepository<EmpleadoVentas, Long> {
    Optional<EmpleadoVentas> findByRun(String run);
    Optional<EmpleadoVentas> findByEmail(String email);
}