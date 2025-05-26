package com.usuarios.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String run;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;

    private String direccion;

    // Métodos del diagrama (implementaciones vacías o lógicas según necesidad)
    public void actualizarPerfil() {
        // Lógica para actualizar perfil
        System.out.println("Perfil actualizado para: " + nombre);
    }

    public void eliminarCuenta() {
        // Lógica para eliminar cuenta
        System.out.println("Cuenta eliminada para: " + nombre);
    }

    public void gestionarDireccion() {
        // Lógica para gestionar dirección
        System.out.println("Dirección gestionada para: " + nombre);
    }

    public void crearCuenta() {
        // Lógica para crear cuenta (esto podría estar más en un servicio)
        System.out.println("Cuenta creada para: " + nombre);
    }
}