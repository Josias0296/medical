/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import mx.edu.medicalproject.entity.Empleado;
import mx.edu.medicalproject.service.EmpleadoService;
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
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("altaEmpleado")
    public String goAltaEmpleado(Model model) {
        Empleado e = new Empleado();
        model.addAttribute("empleado", e);
        return "saveEmpleado";
    }
    
    @GetMapping("empleadosConsulta")
    public ModelAndView empleadosConsulta() {
        ModelAndView mav = new ModelAndView("empleados");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("empleados", empleadoService.findAllEmpleado());
        System.out.println("EMPLEADOS:"+empleadoService.findAllEmpleado());
        return mav;
    }
    
    @GetMapping("eliminarEmpleado")
    public ModelAndView eliminarEmpleado(@RequestParam(name = "id", required = true) int id) {
        empleadoService.delete(id);
        return empleadosConsulta();
    }
}
