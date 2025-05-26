package com.usuarios.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor 
public class Cliente extends TipoUsuario {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Asumiendo que Pedido es otra entidad
    @JoinColumn(name = "cliente_id") // Para evitar tabla intermedia si es unidireccional
    private List<Pedido> historial = new ArrayList<>();

    public Cliente(String run, String nombre, String email, String telefono, String direccion) {
        super(null, run, nombre, email, telefono, direccion);
    }

    public void verHistorialPedidos() {
        System.out.println("Cliente " + getNombre() + " está viendo su historial de pedidos.");
        // Lógica para mostrar historial
    }

    public void realizarPedido(Pedido pedido) {
        this.historial.add(pedido);
        System.out.println("Cliente " + getNombre() + " ha realizado un pedido.");
        // Lógica adicional para procesar el pedido
    }

    public void seguirPedido() {
        System.out.println("Cliente " + getNombre() + " está siguiendo un pedido.");
    }

    public void anadirMedioPago() { // El diagrama dice "añadirMedioPagol )" pero asumo que es "Pago"
        System.out.println("Cliente " + getNombre() + " está añadiendo un medio de pago.");
    }

    public void solicitarSoporte() {
        System.out.println("Cliente " + getNombre() + " está solicitando soporte.");
    }
}

