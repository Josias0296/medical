/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import mx.edu.medicalproject.entity.Tiposangre;
import mx.edu.medicalproject.service.TipoSangreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("tiposangre")
public class TipoSangreRestController {
    
    @Autowired
    private TipoSangreService tipoSangreService;
    
    @GetMapping("")
    public List<Tiposangre> getAll() {
        return tipoSangreService.findAllTipoSangre();
    }
}
