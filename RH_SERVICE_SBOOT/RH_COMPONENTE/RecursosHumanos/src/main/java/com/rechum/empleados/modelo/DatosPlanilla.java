package com.rechum.empleados.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table; 

@Entity 
public class DatosPlanilla {

	  
  //Los paràmetros de Entradad de el Metodo, son los nombres de los campos en la Base de Datos cuando retorna.
	public DatosPlanilla(Long id_planilla, Long id_empleado, String nombres
			, double salario, double pago, double horas_trabajadas
			) {
		super();
		this.idPlanilla = id_planilla;
		this.idEmpleado = id_empleado; 
		Nombres = nombres;
		Salario = salario;
		Pago = pago;
		horas_trabajadas = Horas_trabajadas;
	}

	 //Constructor para Entidad DatosPlanilla
	public DatosPlanilla()
	{	 
	}


	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;
	

	
	@Column(name = "idPlanilla",   nullable = false)
	private Long idPlanilla;
 
	
	@Column(name = "idEmpleado",   nullable = false)
	private Long idEmpleado;
	
	@Column(name = "Nombres",   nullable = false)
	private String Nombres;
 
	


	@Column(name = "Salario",   nullable = false )
	private Double Salario;
	

	@Column(name = "Pago",  nullable = false )
	private Double Pago;
	

	@Column(name = "Horas_trabajadas",  nullable = false )
	private Double Horas_trabajadas;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	
	public Long getidPlanilla() {
		return idPlanilla;
	}

	public void setidPlanilla(Long idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public Long getidEmpleado() {
		return idEmpleado;
	}

	public void setidEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Double getHoras_trabajadas() {
		return Horas_trabajadas;
	}

	public void setHoras_trabajadas(double Horas_trabajadas) {
		this.Horas_trabajadas = Horas_trabajadas;
	}
 
	public Double getSalario() {
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
	}

	
}
