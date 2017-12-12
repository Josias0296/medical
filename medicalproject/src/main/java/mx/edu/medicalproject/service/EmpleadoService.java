/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.service;

import java.util.List;
import mx.edu.medicalproject.entity.Empleado;

/**
 *
 * @author Eduardo
 */
public interface EmpleadoService {
    
    public List <Empleado> findAllEmpleado();
    public void save (Empleado empleado);
    public void update (Empleado empleado);
    public void delete (int id);
    public Empleado findEmpleadoByid(int id);
}
