/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Paciente;

/**
 *
 * @author Eduardo
 */
public interface PacienteService {
    
    public List<Paciente> findAllPaciente();
    public void save(Paciente paciente);
    public Paciente update(Paciente paciente);
    public abstract void delete(int id);
    public Paciente findPacienteById(int id);
}
