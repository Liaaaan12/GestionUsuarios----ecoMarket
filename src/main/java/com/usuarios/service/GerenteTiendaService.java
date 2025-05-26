package com.usuarios.service;

import com.usuarios.model.GerenteTienda;
import com.usuarios.repository.GerenteTiendaRepository;
import com.usuarios.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GerenteTiendaService {

    @Autowired
    private GerenteTiendaRepository gerenteTiendaRepository;

    @Transactional
    public GerenteTienda crearGerente(GerenteTienda gerente) {
        return gerenteTiendaRepository.save(gerente);
    }

    @Transactional(readOnly = true)
    public List<GerenteTienda> obtenerTodosLosGerentes() {
        return gerenteTiendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GerenteTienda obtenerGerentePorId(Long id) {
        return gerenteTiendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gerente de Tienda no encontrado con ID: " + id));
    }

    @Transactional
    public GerenteTienda actualizarGerente(Long id, GerenteTienda detallesGerente) {
        GerenteTienda gerente = obtenerGerentePorId(id);
        gerente.setRun(detallesGerente.getRun());
        gerente.setNombre(detallesGerente.getNombre());
        gerente.setEmail(detallesGerente.getEmail());
        // ... otros campos ...
        return gerenteTiendaRepository.save(gerente);
    }

    @Transactional
    public void eliminarGerente(Long id) {
        GerenteTienda gerente = obtenerGerentePorId(id);
        gerenteTiendaRepository.delete(gerente);
    }

    // Métodos de acción
    @Transactional
    public void gerenteGestionarInventario(Long id) {
        GerenteTienda gerente = obtenerGerentePorId(id);
        gerente.gestionarInventario();
    }
     @Transactional
    public void gerenteGenerarReportes(Long id) {
        GerenteTienda gerente = obtenerGerentePorId(id);
        gerente.generarReportes();
    }
    // ... otros métodos específicos para GerenteTienda

    
}
