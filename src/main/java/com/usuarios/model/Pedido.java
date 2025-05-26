package com.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Pedido { // Clase placeholder muy básica

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDateTime fechaPedido;
    private String estado;

    public Pedido(String descripcion) {
        this.descripcion = descripcion;
        this.fechaPedido = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }
}
