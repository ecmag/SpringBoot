package com.rechum.empleados.controlador;
  
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rechum.empleados.service.*;
import java.util.List;
import java.util.Optional;
import com.rechum.empleados.modelo.DatosPlanilla;

 
@RestController
@RequestMapping("/SysRecursosHumanos/")
//CORS (Cross-Origin Resource Sharing) es un mecanismo que, a través de las cabeceras de los encabezados HTTP, va a permitir a un determinado cliente (User-Agent) a acceder a los recursos de un servidor diferente al del servidor actual
//intercambiar recursos entre BAKCEND y FRONTEND
//@CrossOrigin(origins = "http://localhost:1111")

public class PlanillaControlador {

		 
		@Autowired
		 PlanillaService empservice;
 
		@GetMapping("/planilla")
		public ResponseEntity<List<DatosPlanilla>> listaPlanilla() {
			List<DatosPlanilla> listaPlanilla = empservice.listaPlanilla();
			return new ResponseEntity(listaPlanilla, HttpStatus.OK);
		}
		
		@GetMapping("/planilla/{pIdEmpleado}")
		public ResponseEntity<List<DatosPlanilla>> ListaxEmpleado(@PathVariable("pIdEmpleado")  int pIdEmpleado ) {
			List<DatosPlanilla> lista2 = empservice.getByEmpleado( pIdEmpleado );
			return new ResponseEntity(lista2, HttpStatus.OK);
		}
		
 	   
 	
		 
}