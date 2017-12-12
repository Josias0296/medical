/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import mx.edu.medicalproject.entity.Cita;
import mx.edu.medicalproject.service.CitaService;
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
@RequestMapping("citas")
public class CitaRestController {
 
    @Autowired
    private CitaService citaService;
    
    @GetMapping("")
    public List<Cita> getAll() {
        return citaService.findAllCita();
    }
    
    @GetMapping("{id}")
    public Cita getEmpleadoById(@PathVariable("id") Integer id) {
        return citaService.findCitaById(id);
    }

    @PostMapping("")
    public Cita save(@RequestBody Cita cita) {
        citaService.save(cita);
        return cita;
    }

    @PutMapping("{id}")
    public Cita update(@PathVariable("id") Integer id, @RequestBody Cita cita) {
        cita.setIdCita(id);
        citaService.update(cita);
        return cita;
    }
}
