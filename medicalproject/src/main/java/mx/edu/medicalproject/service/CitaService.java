/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Cita;

/**
 *
 * @author Eduardo
 */
public interface CitaService {
    
    public List<Cita> findAllCita();
    public void save(Cita cita);
    public void update(Cita cita);
    public void delete(int id);
    public Cita findCitaById(int id);
}
