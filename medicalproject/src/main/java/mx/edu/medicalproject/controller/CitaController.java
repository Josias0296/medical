/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import mx.edu.medicalproject.entity.Cita;
import mx.edu.medicalproject.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Eduardo
 */
@Controller
public class CitaController {
 
    @Autowired
    private CitaService citaService;
    
    @GetMapping("altaCita")
    public String goAltaCita(Model model) {
        Cita a = new Cita();
        model.addAttribute("cita", a);
        return "saveCita";
    }

    @GetMapping("citasConsulta")
    public ModelAndView citasConsulta() {
        ModelAndView mav = new ModelAndView("citas");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("citas", citaService.findAllCita());
        return mav;
        
    }
    
    @GetMapping("eliminarCita")
    public ModelAndView eliminarArea(@RequestParam(name = "id", required = true) int id) {
        citaService.delete(id);
        return citasConsulta();
    }
}
