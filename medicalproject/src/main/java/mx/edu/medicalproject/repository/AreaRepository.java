/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.repository;

import java.io.Serializable;
import mx.edu.medicalproject.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alumno
 */
public interface AreaRepository extends JpaRepository<Area, Serializable> {
    
    public Area findAreaByIdArea(int id_area);
}
