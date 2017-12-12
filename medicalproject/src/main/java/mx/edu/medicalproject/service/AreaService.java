/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Area;

/**
 *
 * @author Alumno
 */
public interface AreaService {
    
    public List<Area> findAllArea();
    public void save(Area area);
    public void update(Area area);
    public void delete(int id);
    public Area findAreaById(int id);
}
