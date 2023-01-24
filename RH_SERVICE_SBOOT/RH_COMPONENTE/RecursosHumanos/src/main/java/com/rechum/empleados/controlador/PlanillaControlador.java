package com.rechum.empleados.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rechum.empleados.excepciones.ResourceNotFoundException;
import com.rechum.empleados.modelo.Planilla;
import com.rechum.empleados.repositorio.PlanillaRepositorio;
import com.rechum.empleados.service.PlanillaService;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SysRecursosHumanos/")
//CORS (Cross-Origin Resource Sharing) es un mecanismo que, a través de las cabeceras de los encabezados HTTP, va a permitir a un determinado cliente (User-Agent) a acceder a los recursos de un servidor diferente al del servidor actual
//intercambiar recursos entre BAKCEND y FRONTEND
//@CrossOrigin(origins = "http://localhost:1111")

public class PlanillaControlador {

		 
		@Autowired
		private PlanillaService empservice;
 
		@GetMapping("/planilla")
		public ResponseEntity<List<Planilla>> lista() {
			List<Planilla> lista = empservice.lista()  ;
			return new ResponseEntity(lista, HttpStatus.OK);
		}

		@GetMapping("/planilla/{id}")
		public ResponseEntity<Planilla> verId(@PathVariable("id") int id) {
			Optional<Planilla> coche = empservice.getById(id) ;
			return new ResponseEntity(coche, HttpStatus.OK);
		}
 	
}
