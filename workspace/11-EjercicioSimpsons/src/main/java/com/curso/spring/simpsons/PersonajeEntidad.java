package com.curso.spring.simpsons;

public class PersonajeEntidad {
	private String id;
	private String nombre;
	private PersonajeEntidad padre;
	
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
	public PersonajeEntidad getPadre() {
		return padre;
	}
	public void setPadre(PersonajeEntidad padre) {
		this.padre = padre;
	}
	public PersonajeEntidad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonajeEntidad(String id, String nombre, PersonajeEntidad padre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.padre = padre;
	}
}
