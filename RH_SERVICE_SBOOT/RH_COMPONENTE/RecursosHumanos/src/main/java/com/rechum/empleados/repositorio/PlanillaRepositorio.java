package com.rechum.empleados.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rechum.empleados.modelo.Empleado;
import com.rechum.empleados.modelo.Planilla;
 

@Repository
public interface PlanillaRepositorio extends JpaRepository<Empleado, Long>{

	@Query(value = "{call Calculo_Planilla()}", nativeQuery = true)
    List<Planilla> listaProcedure();

    @Query(value = "{call Calculo_Planilla(:idIn)}", nativeQuery = true)
    Optional<Planilla> EmpleadoProcedure(@Param("idIn") int idIn);
    
} 

