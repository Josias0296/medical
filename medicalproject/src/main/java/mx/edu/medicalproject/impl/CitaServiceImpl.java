/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.entity.Cita;
import mx.edu.medicalproject.repository.CitaRepository;
import mx.edu.medicalproject.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
@Transactional
public class CitaServiceImpl implements CitaService{
    
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> findAllCita() {
        return citaRepository.findAll();
    }

    @Override
    public void save(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public void update(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public void delete(int id) {
        Cita cita = findCitaById(id);
        if (cita != null) {
            citaRepository.delete(findCitaById(id));
        }
    }

    @Override
    public Cita findCitaById(int id) {
        return citaRepository.findCitaByIdCita(id);
    }
}
