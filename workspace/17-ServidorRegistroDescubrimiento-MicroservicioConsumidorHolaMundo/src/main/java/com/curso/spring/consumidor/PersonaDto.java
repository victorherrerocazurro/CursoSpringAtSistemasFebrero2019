package com.curso.spring.consumidor;

public class PersonaDto {

	private long id;

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PersonaDto(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public PersonaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
