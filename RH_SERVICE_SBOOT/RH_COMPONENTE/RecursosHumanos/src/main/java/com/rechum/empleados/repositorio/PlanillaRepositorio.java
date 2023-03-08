package com.rechum.empleados.repositorio;
 

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.rechum.empleados.modelo.Empleado; 
 

@Repository
public interface PlanillaRepositorio extends JpaRepository<Empleado,   Long>{

	 
    
} 

 
