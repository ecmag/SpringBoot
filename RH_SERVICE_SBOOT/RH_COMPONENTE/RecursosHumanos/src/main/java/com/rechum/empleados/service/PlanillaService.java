package com.rechum.empleados.service;


import org.springframework.beans.factory.config.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List;
import java.util.Optional;

import com.rechum.empleados.modelo.Planilla;
import com.rechum.empleados.repositorio.PlanillaRepositorio; 


@Service	
public class PlanillaService {

    @Autowired
    private PlanillaRepositorio repositorio;

    public List<Planilla> lista(){
        return repositorio.listaProcedure();
    }

    public Optional<Planilla> getById(int id){
        return repositorio.EmpleadoProcedure(id);
    }
 
}