package com.curso.spring.concesionario.dto;

import java.math.BigDecimal;

public class VehiculoDto {
	private Long id;
	private String descripcion;
	private String modelo;
	private String color;
	private String motor;
	private BigDecimal precio;
	public VehiculoDto(Long id, String descripcion, String modelo, String color, String motor, BigDecimal precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.precio = precio;
	}
	public VehiculoDto(String descripcion, String modelo, String color, String motor, BigDecimal precio) {
		super();
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.color = color;
		this.motor = motor;
		this.precio = precio;
	}
	public VehiculoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiculoDto other = (VehiculoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
