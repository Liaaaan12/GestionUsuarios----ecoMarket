package com.GestionUsuarios.service;

import com.GestionUsuarios.model.EmpleadoVentas;
import com.GestionUsuarios.repository.EmpleadoVentasRepository;
import com.GestionUsuarios.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmpleadoVentasService {

    @Autowired
    private EmpleadoVentasRepository empleadoVentasRepository;

    @Transactional
    public EmpleadoVentas crearEmpleado(EmpleadoVentas empleado) {
        return empleadoVentasRepository.save(empleado);
    }

    @Transactional(readOnly = true)
    public EmpleadoVentas obtenerEmpleadoPorId(Long id) {
        return empleadoVentasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado de Ventas no encontrado con ID: " + id));
    }
    
    @Transactional(readOnly = true)
    public List<EmpleadoVentas> obtenerTodosLosEmpleados() {
        return empleadoVentasRepository.findAll();
    }
    
    // ... otros métodos CRUD y específicos ...
    @Transactional
    public void empleadoRegistrarVenta(Long id) {
        EmpleadoVentas empleado = obtenerEmpleadoPorId(id);
        empleado.registrarVenta();
    }
}