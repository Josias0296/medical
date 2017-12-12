/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import mx.edu.medicalproject.entity.Empleado;
import mx.edu.medicalproject.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("empleados")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("")
    public List<Empleado> getAll() {
        return empleadoService.findAllEmpleado();
    }
    
    @GetMapping("{id}")
    public Empleado getEmpleadoById(@PathVariable("id") Integer id) {
        return empleadoService.findEmpleadoByid(id);
    }

    @PostMapping("")
    public Empleado save(@RequestBody Empleado empleado) {
        empleadoService.save(empleado);
        return empleado;
    }

    @PutMapping("{id}")
    public Empleado update(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        empleado.setIdEmpleado(id);
        empleadoService.update(empleado);
        return empleado;
    }
}
