/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import mx.edu.medicalproject.entity.Consultorio;
import mx.edu.medicalproject.service.ConsultorioService;
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
 * @author penlo
 */

@RestController
@RequestMapping("consultorios")
public class ConsultorioRestController {
    
    @Autowired
    private ConsultorioService consultorioService;

    @GetMapping("")
    public List<Consultorio> getAll() {
        return consultorioService.findAllConsultorio();
    }

    @GetMapping("{id}")
    public Consultorio getConsultorioById(@PathVariable("id") Integer id) {
        return consultorioService.findConsultorioById(id);
    }

    @PostMapping("")
    public Consultorio save(@RequestBody Consultorio consultorio) {
        consultorioService.save(consultorio);
        return consultorio;
    }

    @PutMapping("{id}")
    public Consultorio update(@PathVariable("id") Integer id, @RequestBody Consultorio consultorio) {
        consultorio.setIdConsultorio(id);
        consultorioService.update(consultorio);
        return consultorio;
    }

//    @DeleteMapping("{id}")
//    public Area delete(@PathVariable("id") Integer id, @RequestBody Area area) {
//        areaService.delete(area);
//        return area;
//    }      
}
