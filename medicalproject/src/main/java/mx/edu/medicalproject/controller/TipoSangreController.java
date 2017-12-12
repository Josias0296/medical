/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import mx.edu.medicalproject.service.TipoSangreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Eduardo
 */
@Controller
public class TipoSangreController {

    @Autowired
    private TipoSangreService tipoSangreService;
    
    
}
