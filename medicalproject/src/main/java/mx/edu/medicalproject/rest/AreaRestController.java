/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.rest;

import java.util.List;
import javax.enterprise.inject.Produces;
import mx.edu.medicalproject.entity.Area;
import mx.edu.medicalproject.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("areas")
public class AreaRestController {

    @Autowired
    private AreaService areaService;

    @GetMapping("")
    public List<Area> getAll() {
        return areaService.findAllArea();
    }

    @GetMapping("{id}")
    public Area getAreaById(@PathVariable("id") Integer id) {
        return areaService.findAreaById(id);
    }

    @PostMapping("")
    public Area save(@RequestBody Area area) {
        areaService.save(area);
        return area;
    }

    @PutMapping("{id}")
    public Area update(@PathVariable("id") Integer id, @RequestBody Area area) {
        area.setIdArea(id);
        areaService.update(area);
        return area;
    }

//    @DeleteMapping("{id}")
//    public Area delete(@PathVariable("id") Integer id, @RequestBody Area area) {
//        areaService.delete(area);
//        return area;
//    }  
}
