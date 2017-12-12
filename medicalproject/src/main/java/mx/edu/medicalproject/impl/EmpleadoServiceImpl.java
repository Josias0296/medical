/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.entity.Empleado;
import mx.edu.medicalproject.repository.EmpleadoRepository;
import mx.edu.medicalproject.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAllEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public void save(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void delete(int id) {
        Empleado empleado = findEmpleadoByid(id);
        if (empleado != null) {
            empleadoRepository.delete(empleado);
        }
    }

    @Override
    public Empleado findEmpleadoByid(int id) {
        return empleadoRepository.findEmpleadoByIdEmpleado(id);
    }
}
