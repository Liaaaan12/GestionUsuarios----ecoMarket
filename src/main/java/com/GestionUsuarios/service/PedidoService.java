package com.GestionUsuarios.service;

import com.GestionUsuarios.model.Pedido;
import com.GestionUsuarios.repository.PedidoRepository;
import com.GestionUsuarios.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional(readOnly = true)
    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }
    
    // Podrías tener un método para obtener pedidos de un cliente específico si es necesario
    // public List<Pedido> obtenerPedidosPorClienteId(Long clienteId) { ... }
}