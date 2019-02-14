package com.curso.spring.concesionario.core.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	private Long idVehiculo;
	private int cantidad;
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Stock(Long idVehiculo, int cantidad) {
		super();
		this.idVehiculo = idVehiculo;
		this.cantidad = cantidad;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
}
