/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.medicalproject.repository.AreaRepository;
import mx.edu.medicalproject.service.AreaService;
import mx.edu.medicalproject.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> findAllArea() {
        return areaRepository.findAll();
    }

    @Override
    public void save(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void update(Area area) {
        areaRepository.save(area);
    }

    @Override
    public Area findAreaById(int id) {
        return areaRepository.findAreaByIdArea(id);
    }

    @Override
    public void delete(int id) {
        Area area = findAreaById(id);
        if (area != null) {
            areaRepository.delete(findAreaById(id));
        }
    }

}
