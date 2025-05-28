package com.GestionUsuarios.controller;

import com.GestionUsuarios.model.GerenteTienda;
import com.GestionUsuarios.service.GerenteTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gerentes-tienda")
public class GerenteTiendaController {

    @Autowired
    private GerenteTiendaService gerenteTiendaService;

    @PostMapping
    public ResponseEntity<GerenteTienda> crearGerente(@RequestBody GerenteTienda gerente) {
        return new ResponseEntity<>(gerenteTiendaService.crearGerente(gerente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GerenteTienda> obtenerGerentePorId(@PathVariable Long id) {
        return ResponseEntity.ok(gerenteTiendaService.obtenerGerentePorId(id));
    }
    
    @GetMapping
    public ResponseEntity<List<GerenteTienda>> obtenerTodosLosGerentes() {
        List<GerenteTienda> gerentes = gerenteTiendaService.obtenerTodosLosGerentes();
        if (gerentes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gerentes);
    }

    // ... otros endpoints CRUD ...

    @PostMapping("/{id}/gestionar-inventario")
    public ResponseEntity<String> gerenteGestionarInventario(@PathVariable Long id) {
        gerenteTiendaService.gerenteGestionarInventario(id);
        return ResponseEntity.ok("Acción 'gestionarInventario' ejecutada para Gerente ID: " + id);
    }
    
    @PostMapping("/{id}/generar-reportes")
    public ResponseEntity<String> gerenteGenerarReportes(@PathVariable Long id) {
        gerenteTiendaService.gerenteGenerarReportes(id);
        return ResponseEntity.ok("Acción 'generarReportes' ejecutada para Gerente ID: " + id);
    }
    // ... otros endpoints de acción ...
}