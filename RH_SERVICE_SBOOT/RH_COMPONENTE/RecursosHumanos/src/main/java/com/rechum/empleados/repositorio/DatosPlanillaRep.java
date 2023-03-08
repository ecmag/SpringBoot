package com.rechum.empleados.repositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 

import com.rechum.empleados.modelo.DatosPlanilla;


@Repository
public interface DatosPlanillaRep extends JpaRepository<DatosPlanilla,   Integer>{
	
	@Query(value = "{call Mostrar_Planilla()}", nativeQuery = true)
    List<DatosPlanilla> listaPlanilla();

	 
	 
	 @Query(value = "{call Mostrar_Planilla_Empleado(:pIdEmpleado)}", nativeQuery = true)
	 List<DatosPlanilla> Mostrar_Planilla_Empleado(@Param("pIdEmpleado") int pIdEmpleado);
	 
	 
	 
}

