/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.controller;

import mx.edu.utez.cli.cliweb4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("Person")
public class PersonController  {
    @Autowired
    private PersonService personService;
    
    @GetMapping
    public String goPerson(Model model){
        model.addAttribute("persons",personService.findAll());
        return "person"; //name of view into templates
    }
    
}
