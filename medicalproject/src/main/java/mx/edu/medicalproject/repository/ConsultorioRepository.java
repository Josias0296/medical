/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.repository;

import java.io.Serializable;
import mx.edu.medicalproject.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author penlo
 */
public interface ConsultorioRepository extends JpaRepository<Consultorio, Serializable>{
     
    public Consultorio findConsultorioByIdConsultorio(int id_consultorio);
    
}
