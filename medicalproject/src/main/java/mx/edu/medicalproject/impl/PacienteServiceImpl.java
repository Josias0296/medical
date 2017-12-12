/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.entity.Paciente;
import mx.edu.medicalproject.repository.PacienteRepository;
import mx.edu.medicalproject.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAllPaciente() {
        return pacienteRepository.findAll();
    }

    @Override
    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente findPacienteById(int id) {
        return pacienteRepository.findPacienteByIdPaciente(id);
    }

    @Override
    public void delete(int id) {
        Paciente paciente = findPacienteById(id);
        if (paciente != null) {
            System.out.println("ENCONTRÓ AL PACIENTE");
            pacienteRepository.delete(findPacienteById(id));
        }
    }

    @Override
    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

}
