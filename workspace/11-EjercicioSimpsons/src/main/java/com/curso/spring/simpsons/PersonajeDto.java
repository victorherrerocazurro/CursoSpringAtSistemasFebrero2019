package com.curso.spring.simpsons;

import java.net.URL;

public class PersonajeDto {

	private String id;
	private String nombre;
	private URL padre;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public URL getPadre() {
		return padre;
	}
	public void setPadre(URL padre) {
		this.padre = padre;
	}
	public PersonajeDto(String id, String nombre, URL padre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.padre = padre;
	}
	public PersonajeDto() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
