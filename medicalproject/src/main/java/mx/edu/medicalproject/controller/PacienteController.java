/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.controller;

import java.util.List;
import javax.validation.Valid;
import mx.edu.medicalproject.entity.Paciente;
import mx.edu.medicalproject.entity.Tiposangre;
import mx.edu.medicalproject.service.PacienteService;
import mx.edu.medicalproject.service.TipoSangreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Eduardo
 */
@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private TipoSangreService tipoSangreService;

    @GetMapping("altaPaciente")
    public String goAltaPaciente(Model model) {
        Paciente p = new Paciente();
        model.addAttribute("paciente", p);
        return "savePaciente";
    }

    @GetMapping("pacientesConsulta")
    private ModelAndView pacientesConsulta() {
        ModelAndView mav = new ModelAndView("pacientes");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("pacientes", pacienteService.findAllPaciente());
        return mav;
    }

    @GetMapping("eliminarPaciente")
    public ModelAndView eliminarPaciente(@RequestParam(name = "id", required = true) int id) {
        pacienteService.delete(id);
        return pacientesConsulta();
    }

    /*
     Método para mostrar los datos del paciente en el formulario
     */
    @GetMapping("/pacienteModificar")
    public ModelAndView pacienteModificar(@RequestParam(name = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView("modificarpaciente");
        if (id != null) {
            Paciente paciente = pacienteService.findPacienteById(id);
            mav.addObject("pacienteM", paciente);
            mav.addObject("listaSangre", tipoSangreService.findAllTipoSangre());
        }
        return mav;
    }

    /*
     Método para modificar los datos del paciente en la Base de Datos
     */
    @PostMapping("/modificarPaciente")
    public String modificarPaciente(@ModelAttribute("pacienteM") Paciente paciente, BindingResult bindingResult, RedirectAttributes model) {
        System.out.println(paciente);
        if (null != pacienteService.update(paciente)) {
            model.addFlashAttribute("result", 1);
        } else {
            model.addFlashAttribute("result", 0);
        }
        return "redirect:/pacientesConsulta";
    }

    @GetMapping("/paciente/cancelar")
    public String cancel() {
        return "redirect:/pacientesConsulta";
    }

//    @RequestMapping("consultarPaciente")
//    public String goConsultaPaciente() {
//        return "consultarPaciente";
//    }
}
