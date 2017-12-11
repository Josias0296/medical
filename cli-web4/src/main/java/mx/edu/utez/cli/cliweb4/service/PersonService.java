/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.service;

import java.util.List;
import mx.edu.utez.cli.cliweb4.entity.Person;

/**
 *
 * @author Lenovo
 */
public interface PersonService {
    public List <Person> findAll();
}
