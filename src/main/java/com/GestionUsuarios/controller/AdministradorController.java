package com.GestionUsuarios.controller;

import com.GestionUsuarios.model.Administrador;
import com.GestionUsuarios.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador administrador) {
        Administrador nuevoAdmin = administradorService.crearAdministrador(administrador);
        return new ResponseEntity<>(nuevoAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> obtenerAdministradorPorId(@PathVariable Long id) {
        Administrador admin = administradorService.obtenerAdministradorPorId(id);
        return ResponseEntity.ok(admin);
    }
    
    @GetMapping("/run/{run}")
    public ResponseEntity<Administrador> obtenerAdministradorPorRun(@PathVariable String run) {
        Administrador admin = administradorService.obtenerAdministradorPorRun(run);
        return ResponseEntity.ok(admin);
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> obtenerTodosLosAdministradores() {
        List<Administrador> administradores = administradorService.obtenerTodosLosAdministradores();
        if (administradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(administradores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable Long id, @RequestBody Administrador detallesAdministrador) {
        Administrador adminActualizado = administradorService.actualizarAdministrador(id, detallesAdministrador);
        return ResponseEntity.ok(adminActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdministrador(@PathVariable Long id) {
        administradorService.eliminarAdministrador(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para acciones específicas
    @PutMapping("/{id}/actualizar-perfil")
    public ResponseEntity<Void> actualizarPerfilAdministrador(@PathVariable Long id, @RequestBody Administrador detallesPerfil) {
        administradorService.adminActualizarPerfil(id, detallesPerfil);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/gestionar-usuarios")
    public ResponseEntity<String> adminGestionarUsuarios(@PathVariable Long id) {
        administradorService.adminGestionarUsuarios(id);
        return ResponseEntity.ok("Acción 'gestionarUsuarios' ejecutada para Administrador ID: " + id);
    }

    @PostMapping("/{id}/configurar-permisos")
    public ResponseEntity<String> adminConfigurarPermisos(@PathVariable Long id) {
        administradorService.adminConfigurarPermisos(id);
        return ResponseEntity.ok("Acción 'configurarPermisos' ejecutada para Administrador ID: " + id);
    }
    
    @PostMapping("/{id}/monitorear-sistema")
    public ResponseEntity<String> adminMonitorearSistema(@PathVariable Long id) {
        administradorService.adminMonitorearSistema(id);
        return ResponseEntity.ok("Acción 'monitorearSistema' ejecutada para Administrador ID: " + id);
    }

    @PostMapping("/{id}/respaldo-datos")
    public ResponseEntity<String> adminRespaldoDeDatos(@PathVariable Long id) {
        administradorService.adminRespaldoDeDatos(id);
        return ResponseEntity.ok("Acción 'respaldoDeDatos' ejecutada para Administrador ID: " + id);
    }
}
