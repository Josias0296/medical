/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.repository;

import java.io.Serializable;
import mx.edu.medicalproject.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface PacienteRepository extends JpaRepository<Paciente, Serializable>{
    
    public Paciente findPacienteByIdPaciente (int id_paciente);
    
}
