package com.usuarios.service;

import com.usuarios.model.Cliente;
import com.usuarios.model.Pedido;
import com.usuarios.repository.ClienteRepository;
import com.usuarios.repository.PedidoRepository; // Podría ser PedidoService también
import com.usuarios.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository; // O inyectar PedidoService

    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + id));
    }
    
    @Transactional
    public Cliente actualizarCliente(Long id, Cliente detallesCliente) {
        Cliente cliente = obtenerClientePorId(id);
        cliente.setRun(detallesCliente.getRun());
        cliente.setNombre(detallesCliente.getNombre());
        cliente.setEmail(detallesCliente.getEmail());
        cliente.setTelefono(detallesCliente.getTelefono());
        cliente.setDireccion(detallesCliente.getDireccion());
        // No se actualiza el historial de pedidos directamente aquí
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void eliminarCliente(Long id) {
        Cliente cliente = obtenerClientePorId(id);
        clienteRepository.delete(cliente);
    }

    // Métodos de acción específicos para Cliente
    @Transactional(readOnly = true)
    public List<Pedido> clienteVerHistorialPedidos(Long clienteId) {
        Cliente cliente = obtenerClientePorId(clienteId);
        return cliente.getHistorial();
    }

    @Transactional
    public Pedido clienteRealizarPedido(Long clienteId, Pedido pedido) {
        Cliente cliente = obtenerClientePorId(clienteId);
        // Guardamos el pedido primero para que tenga un ID si es nuevo
        Pedido nuevoPedido = pedidoRepository.save(pedido);
        cliente.getHistorial().add(nuevoPedido);
        clienteRepository.save(cliente);
        return nuevoPedido;
    }
    
    @Transactional
    public void clienteAnadirMedioPago(Long clienteId) {
        Cliente cliente = obtenerClientePorId(clienteId);
        cliente.anadirMedioPago();
        // Lógica para persistir el medio de pago...
    }
     @Transactional
    public void clienteSolicitarSoporte(Long clienteId) {
        Cliente cliente = obtenerClientePorId(clienteId);
        cliente.solicitarSoporte();
        // Lógica para crear un ticket de soporte...
    }
}