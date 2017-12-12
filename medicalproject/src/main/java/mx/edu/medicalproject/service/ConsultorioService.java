/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Consultorio;

/**
 *
 * @author penlo
 */
public interface ConsultorioService {
    public List<Consultorio> findAllConsultorio();
    public void save(Consultorio consultorio);
    public void update(Consultorio consultorio);
    public void delete(int id);
    public Consultorio findConsultorioById(int id);
    
}
