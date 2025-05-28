package com.GestionUsuarios.controller;

import com.GestionUsuarios.model.Cliente;
import com.GestionUsuarios.model.Pedido;
import com.GestionUsuarios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }
    
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente detallesCliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(id, detallesCliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para Pedidos del Cliente
    @GetMapping("/{clienteId}/pedidos")
    public ResponseEntity<List<Pedido>> obtenerHistorialPedidos(@PathVariable Long clienteId) {
        List<Pedido> historial = clienteService.clienteVerHistorialPedidos(clienteId);
        if (historial.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historial);
    }

    @PostMapping("/{clienteId}/pedidos")
    public ResponseEntity<Pedido> realizarPedido(@PathVariable Long clienteId, @RequestBody Pedido pedido) {
        // En una app real, Pedido vendría como un DTO y se mapearía.
        Pedido nuevoPedido = clienteService.clienteRealizarPedido(clienteId, pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
    
    @PostMapping("/{clienteId}/anadir-medio-pago")
    public ResponseEntity<String> anadirMedioPago(@PathVariable Long clienteId) {
        clienteService.clienteAnadirMedioPago(clienteId);
        return ResponseEntity.ok("Acción 'añadirMedioPago' ejecutada para Cliente ID: " + clienteId);
    }

    @PostMapping("/{clienteId}/solicitar-soporte")
    public ResponseEntity<String> solicitarSoporte(@PathVariable Long clienteId) {
        clienteService.clienteSolicitarSoporte(clienteId);
        return ResponseEntity.ok("Acción 'solicitarSoporte' ejecutada para Cliente ID: " + clienteId);
    }
}
