/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Tiposangre;

/**
 *
 * @author Eduardo
 */
public interface TipoSangreService {
    
    public List <Tiposangre> findAllTipoSangre();
}
