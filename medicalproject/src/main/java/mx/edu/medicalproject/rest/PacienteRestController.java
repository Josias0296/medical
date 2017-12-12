/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import mx.edu.medicalproject.entity.Paciente;
import mx.edu.medicalproject.entity.Tiposangre;
import mx.edu.medicalproject.service.PacienteService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("pacientes")
public class PacienteRestController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("")
    public Paciente save(@RequestBody Paciente paciente) {
        pacienteService.save(paciente);
        return paciente;
    }
    
    @GetMapping("")
    public List<Paciente> getAll() {
        return pacienteService.findAllPaciente();
    }

    @GetMapping("{id}")
    public Paciente getPacienteById(@PathVariable("id") Integer id) {
        return pacienteService.findPacienteById(id);
    }

    @PutMapping("{id}")
    public Paciente update(@PathVariable("id") Integer id, @RequestBody Paciente paciente) {
        pacienteService.update(paciente);
        return paciente;
    }

    @DeleteMapping("{id}")
    public Paciente delete(@PathVariable("id") Integer id, @RequestBody Paciente paciente) {
        pacienteService.delete(id);
        return paciente;
    }
}
