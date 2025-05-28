package com.GestionUsuarios.controller;

import com.GestionUsuarios.model.EmpleadoVentas;
import com.GestionUsuarios.service.EmpleadoVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados-ventas")
public class EmpleadoVentasController {

    @Autowired
    private EmpleadoVentasService empleadoVentasService;

    @PostMapping
    public ResponseEntity<EmpleadoVentas> crearEmpleado(@RequestBody EmpleadoVentas empleado) {
        return new ResponseEntity<>(empleadoVentasService.crearEmpleado(empleado), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoVentas> obtenerEmpleadoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoVentasService.obtenerEmpleadoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoVentas>> obtenerTodosLosEmpleados() {
        List<EmpleadoVentas> empleados = empleadoVentasService.obtenerTodosLosEmpleados();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }
    // ... otros endpoints CRUD ...
    @PostMapping("/{id}/registrar-venta")
    public ResponseEntity<String> empleadoRegistrarVenta(@PathVariable Long id) {
        empleadoVentasService.empleadoRegistrarVenta(id);
        return ResponseEntity.ok("Acción 'registrarVenta' ejecutada para Empleado ID: " + id);
    }
}