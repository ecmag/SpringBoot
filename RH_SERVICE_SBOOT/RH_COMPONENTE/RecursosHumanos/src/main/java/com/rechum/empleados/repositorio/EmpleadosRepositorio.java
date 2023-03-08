package com.rechum.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rechum.empleados.modelo.DatosEmpleado ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
@Repository
public interface EmpleadosRepositorio extends JpaRepository<DatosEmpleado,   Integer>{
	
	@Query(value = "{call Inserta_Empleado(:pNombre, :pApellido, :pEmail, :pSalario)}", nativeQuery = true)
    void Inserta_Empleado(
            @Param("pNombre")String pNombre,
            @Param("pApellido")String pApellido,
            @Param("pEmail")String pEmail,
            @Param("pSalario")double pSalario
    );
	
	
	@Query(value = "{call Modifica_Empleado(:pId, :pNombre, :pApellido, :pEmail, :pSalario)}", nativeQuery = true)
    void Modifica_Empleado(
    		@Param("pId")long pId,
            @Param("pNombre")String pNombre,
            @Param("pApellido")String pApellido,
            @Param("pEmail")String pEmail,
            @Param("pSalario")double pSalario
    );
	
	@Query(value = "{call Borra_Empleado(:pId)}", nativeQuery = true)
    void Borra_Empleado(
    		@Param("pId")long pId
    );


}
