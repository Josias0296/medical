/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.repository;

import java.io.Serializable;
import mx.edu.utez.cli.cliweb4.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lenovo
 */
public interface PersonRepository extends JpaRepository<Person,Serializable> {
    
    
}
