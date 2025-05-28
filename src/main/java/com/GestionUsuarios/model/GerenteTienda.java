package com.GestionUsuarios.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class GerenteTienda extends TipoUsuario {

    public GerenteTienda(String run, String nombre, String email, String telefono, String direccion) {
        super(null, run, nombre, email, telefono, direccion);
    }

    public void gestionarInventario() {
        System.out.println("Gerente " + getNombre() + " está gestionando el inventario.");
    }

    public void generarReportes() {
        System.out.println("Gerente " + getNombre() + " está generando reportes.");
    }

    public void gestionarPedidos() {
        System.out.println("Gerente " + getNombre() + " está gestionando pedidos.");
    }

    public void gestionarTienda() {
        System.out.println("Gerente " + getNombre() + " está gestionando la tienda.");
    }
}
