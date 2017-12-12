/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.entity.Consultorio;
import mx.edu.medicalproject.repository.ConsultorioRepository;
import mx.edu.medicalproject.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author penlo
 */
@Service
@Transactional
public class ConsultorioServiceImpl implements ConsultorioService {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @Override
    public List<Consultorio> findAllConsultorio() {
        return consultorioRepository.findAll();
    }

    @Override
    public void save(Consultorio consultorio) {
        consultorioRepository.save(consultorio);
    }

    @Override
    public void update(Consultorio consultorio) {
        consultorioRepository.save(consultorio);
    }

    @Override
    public Consultorio findConsultorioById(int id) {
        return consultorioRepository.findConsultorioByIdConsultorio(id);
    }

    @Override
    public void delete(int id) {
        Consultorio consultorio = findConsultorioById(id);
        if (consultorio != null) {
            consultorioRepository.delete(findConsultorioById(id));
        }
    }
}
