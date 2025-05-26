package com.usuarios.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Importante para la herencia con Lombok
@NoArgsConstructor
public class Administrador extends TipoUsuario {

    // Constructores si son necesarios, por ejemplo:
    public Administrador(String run, String nombre, String email, String telefono, String direccion) {
        super(null, run, nombre, email, telefono, direccion); // El ID se genera automáticamente
    }

    public void gestionarUsuarios() {
        System.out.println("Administrador " + getNombre() + " está gestionando usuarios.");
    }

    public void configurarPermisos() {
        System.out.println("Administrador " + getNombre() + " está configurando permisos.");
    }

    public void monitorearSistema() {
        System.out.println("Administrador " + getNombre() + " está monitoreando el sistema.");
    }

    public void respaldoDeDatos() {
        System.out.println("Administrador " + getNombre() + " está realizando respaldo de datos.");
    }
}
