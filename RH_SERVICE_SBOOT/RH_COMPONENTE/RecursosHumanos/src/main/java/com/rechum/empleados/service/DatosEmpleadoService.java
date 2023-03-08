package com.rechum.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechum.empleados.modelo.DatosEmpleado;
import com.rechum.empleados.repositorio.EmpleadosRepositorio;

@Service
public class DatosEmpleadoService {

	
	@Autowired
    private EmpleadosRepositorio repositorio;

	
    public void InsertaEmpleado(DatosEmpleado datosempleado) {
    repositorio.Inserta_Empleado(
    		datosempleado.getNombre(), 
    		datosempleado.getApellido(),
    		datosempleado.getEmail(),
    		datosempleado.getSalario());
    }
    
    public void ModificaEmpleado(DatosEmpleado datosempleado) {
        repositorio.Modifica_Empleado(
        		datosempleado.getId(),
        		datosempleado.getNombre(), 
        		datosempleado.getApellido(),
        		datosempleado.getEmail(),
        		datosempleado.getSalario());
        }
    
    public void BorraEmpleado(DatosEmpleado datosempleado) {
        repositorio.Borra_Empleado(
        		datosempleado.getId());
        }
}
