package com.rechum.empleados.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Planilla {

	 

	public Planilla(//Long id_planilla, Long id_empleado, 
			String nombre, String apellido
			//, Long salario, Long pago
			) {
		super();
//		this.idPlanilla = id_planilla;
	//	this.idEmpleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
//		Salario = salario;
	//	Pago = pago;
	}

	/*@Column(name = "idPlanilla",   nullable = false)
	private Long idPlanilla;

	
	
	@Column(name = "idEmpleado",   nullable = false)
	private Long idEmpleado;

*/
	@Column(name = "nombre",   length = 60, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;

	/*
	@Column(name = "Salario",   nullable = false )
	private Double Salario;
	

	@Column(name = "Pago",  nullable = false )
	private Double Pago;
*/
	public Planilla() {

	}
/*
	public Long getId_planilla() {
		return idPlanilla;
	}

	public void setId_planilla(Long id_planilla) {
		this.idPlanilla = id_planilla;
	}

	public Long getId_empleado() {
		return idEmpleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.idEmpleado = id_empleado;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

/*	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}

	public Double getPago() {
		return Pago;
	}

	public void setPago(Double pago) {
		Pago = pago;
	}*/

	
}
