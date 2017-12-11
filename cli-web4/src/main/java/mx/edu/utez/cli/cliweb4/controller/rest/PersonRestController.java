/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.controller.rest;

import java.util.List;
import mx.edu.utez.cli.cliweb4.entity.Person;
import mx.edu.utez.cli.cliweb4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("personrest")
public class PersonRestController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping
    public  List<Person> getAll(){
        
        return  personService.findAll();
    }
}
