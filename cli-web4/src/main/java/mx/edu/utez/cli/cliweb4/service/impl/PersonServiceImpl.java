/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.service.impl;

import java.util.List;
import mx.edu.utez.cli.cliweb4.entity.Person;
import mx.edu.utez.cli.cliweb4.repository.PersonRepository;
import mx.edu.utez.cli.cliweb4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service //We have to put this one // MUST TO
public class PersonServiceImpl implements PersonService {

     @Autowired //with this it will inyect the data
    private PersonRepository personRepository;
     
    @Override
    public List<Person> findAll() {
        return  personRepository.findAll();
    }
    
}
