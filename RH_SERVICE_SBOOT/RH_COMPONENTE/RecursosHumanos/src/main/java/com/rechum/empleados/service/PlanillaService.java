package com.rechum.empleados.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import com.rechum.empleados.modelo.DatosPlanilla;
import com.rechum.empleados.repositorio.DatosPlanillaRep; 

@Service	
public class PlanillaService {

    @Autowired
    private DatosPlanillaRep repositorio;

    public List<DatosPlanilla> listaPlanilla(){
        return repositorio.listaPlanilla();
    } 
    
 
    
    public List<DatosPlanilla> getByEmpleado(int pIdEmpleado){
        return repositorio.Mostrar_Planilla_Empleado(pIdEmpleado)  ;
    }
}
