package com.usuarios.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EmpleadoVentas extends TipoUsuario {

    public EmpleadoVentas(String run, String nombre, String email, String telefono, String direccion) {
        super(null, run, nombre, email, telefono, direccion);
    }

    public void registrarVenta() {
        System.out.println("Empleado " + getNombre() + " está registrando una venta.");
    }

    public void atenderDevolucion() {
        System.out.println("Empleado " + getNombre() + " está atendiendo una devolución.");
    }

    public void consultarInventario() {
        System.out.println("Empleado " + getNombre() + " está consultando el inventario.");
    }

    public void generarFactura() {
        System.out.println("Empleado " + getNombre() + " está generando una factura.");
    }
}