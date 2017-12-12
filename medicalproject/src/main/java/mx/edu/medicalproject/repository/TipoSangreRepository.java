/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.repository;

import java.io.Serializable;
import mx.edu.medicalproject.entity.Tiposangre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface TipoSangreRepository extends JpaRepository<Tiposangre, Serializable>{
    
    public Tiposangre findTiposangreByIdTipoSangre (Integer id_tipo_sangre);
}
