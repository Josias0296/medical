/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import mx.edu.medicalproject.entity.Consultorio;
import mx.edu.medicalproject.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author penlo
 */
@Controller
public class ConsultorioController {
    
    @Autowired
    private ConsultorioService consultorioService;
    
    @GetMapping("altaConsultorio")
    public String goAltaConsultorio(Model model) {
        Consultorio c = new Consultorio();
        model.addAttribute("consultorio", c);
        return "saveConsultorio";
    }

    @GetMapping("consultoriosConsulta")
    public ModelAndView consultoriosConsulta() {
        ModelAndView mav = new ModelAndView("consultorios");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("consultorios", consultorioService.findAllConsultorio());
        return mav;      
    }
    
    @GetMapping("eliminarConsultorio")
    public ModelAndView eliminarConsultorio(@RequestParam(name = "id", required = true) int id) {
        consultorioService.delete(id);
        return consultoriosConsulta();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping("consultarArea")
//    public String goConsultaArea (){
//        return "consultarArea";
//    }
    
}
