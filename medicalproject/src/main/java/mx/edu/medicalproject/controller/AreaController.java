/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import java.util.ArrayList;
import java.util.List;
import mx.edu.medicalproject.entity.Area;
import mx.edu.medicalproject.service.AreaService;
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
 * @author Alumno
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("altaArea")
    public String goAltaArea(Model model) {
        Area a = new Area();
        model.addAttribute("area", a);
        return "saveArea";
    }

    @GetMapping("areasConsulta")
    public ModelAndView areasConsulta() {
        ModelAndView mav = new ModelAndView("areas");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("areas", areaService.findAllArea());
        return mav;
        
    }
    
    @GetMapping("eliminarArea")
    public ModelAndView eliminarArea(@RequestParam(name = "id", required = true) int id) {
        areaService.delete(id);
        return areasConsulta();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping("consultarArea")
//    public String goConsultaArea (){
//        return "consultarArea";
//    }
}
