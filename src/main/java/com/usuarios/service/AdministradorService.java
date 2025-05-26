package com.usuarios.service;

import com.usuarios.model.Administrador;
import com.usuarios.repository.AdministradorRepository;
import com.usuarios.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Transactional
    public Administrador crearAdministrador(Administrador administrador) {
        // Aquí podrías añadir validaciones, ej. verificar si el RUN o email ya existen
        return administradorRepository.save(administrador);
    }

    @Transactional(readOnly = true)
    public List<Administrador> obtenerTodosLosAdministradores() {
        return administradorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Administrador obtenerAdministradorPorId(Long id) {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador no encontrado con ID: " + id));
    }
    
    @Transactional(readOnly = true)
    public Administrador obtenerAdministradorPorRun(String run) {
        return administradorRepository.findByRun(run)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador no encontrado con RUN: " + run));
    }

    @Transactional
    public Administrador actualizarAdministrador(Long id, Administrador detallesAdministrador) {
        Administrador admin = obtenerAdministradorPorId(id);
        admin.setRun(detallesAdministrador.getRun());
        admin.setNombre(detallesAdministrador.getNombre());
        admin.setEmail(detallesAdministrador.getEmail());
        admin.setTelefono(detallesAdministrador.getTelefono());
        admin.setDireccion(detallesAdministrador.getDireccion());
        // Aquí no se actualizan las acciones específicas, se llaman desde el controller
        return administradorRepository.save(admin);
    }

    @Transactional
    public void eliminarAdministrador(Long id) {
        Administrador admin = obtenerAdministradorPorId(id);
        administradorRepository.delete(admin);
    }

    // Métodos de acción específicos
    @Transactional
    public void adminGestionarUsuarios(Long id) {
        Administrador admin = obtenerAdministradorPorId(id);
        admin.gestionarUsuarios(); // Llama al método de la entidad
        // Aquí podría haber lógica adicional del servicio
    }

    @Transactional
    public void adminConfigurarPermisos(Long id) {
        Administrador admin = obtenerAdministradorPorId(id);
        admin.configurarPermisos();
    }
    
    @Transactional
    public void adminMonitorearSistema(Long id) {
        Administrador admin = obtenerAdministradorPorId(id);
        admin.monitorearSistema();
    }

    @Transactional
    public void adminRespaldoDeDatos(Long id) {
        Administrador admin = obtenerAdministradorPorId(id);
        admin.respaldoDeDatos();
    }

    @Transactional
    public void adminActualizarPerfil(Long id, Administrador detallesPerfil) {
        Administrador admin = obtenerAdministradorPorId(id);
        // Actualiza los campos relevantes del perfil desde detallesPerfil
        admin.setNombre(detallesPerfil.getNombre());
        admin.setEmail(detallesPerfil.getEmail());
        admin.setTelefono(detallesPerfil.getTelefono());
        admin.setDireccion(detallesPerfil.getDireccion());
        admin.actualizarPerfil(); // Llama al método de la entidad
        administradorRepository.save(admin);
    }
}