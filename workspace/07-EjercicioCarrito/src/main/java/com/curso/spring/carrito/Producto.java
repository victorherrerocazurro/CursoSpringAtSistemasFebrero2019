package com.curso.spring.carrito;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1917925643666834095L;

	private long id;
	private String descripcion;
	private int cantidad;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto(long id, String descripcion, int cantidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
}
