/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.entity.Tiposangre;
import mx.edu.medicalproject.repository.TipoSangreRepository;
import mx.edu.medicalproject.service.TipoSangreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
@Transactional
public class TipoSangreServiceImpl implements TipoSangreService{

    @Autowired
    private TipoSangreRepository tiposangreRepository;
    
    @Override
    public List<Tiposangre> findAllTipoSangre() {
        return tiposangreRepository.findAll();
    }
    
}
