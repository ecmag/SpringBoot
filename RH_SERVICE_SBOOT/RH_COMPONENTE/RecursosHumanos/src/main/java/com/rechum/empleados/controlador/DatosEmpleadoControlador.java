package com.rechum.empleados.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rechum.empleados.service.DatosEmpleadoService;
//import com.rechum.empleados.excepciones.ResourceNotFoundException;
import com.rechum.empleados.modelo.DatosEmpleado;
//import com.rechum.empleados.modelo.Empleado;


/* Controlador para la inserción, borrado, actualizacion de la Tabla Empleados por medio de un Store Procedure*/
@RestController 
@RequestMapping("/SysRecursosHumanos/")
public class DatosEmpleadoControlador {

	@Autowired
	DatosEmpleadoService empService;
	
	@PostMapping("/NuevoEmpleado")
    public ResponseEntity<?> guarda(@RequestBody DatosEmpleado datosempleado){
		empService.InsertaEmpleado(datosempleado);
        return new ResponseEntity("Empleado guardado", HttpStatus.CREATED);
    }
	
	@PutMapping("/ActualizaEmpleado")
    public ResponseEntity<?> actualiza(@RequestBody DatosEmpleado datosempleado){
		empService.ModificaEmpleado(datosempleado) ;
        return new ResponseEntity("Empleado Actualizado", HttpStatus.CREATED );
    }
	
	@DeleteMapping("/BorrarEmpleado")
    public ResponseEntity<?> borra(@RequestBody DatosEmpleado datosempleado){
		empService.BorraEmpleado(datosempleado) ;
        return new ResponseEntity("Empleado Borrado", HttpStatus.CREATED );
    }
	
}
