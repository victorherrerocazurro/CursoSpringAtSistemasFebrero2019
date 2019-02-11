package com.curso.spring.simpsons;

import java.util.List;

public class Negocio {

	public PersonajeEntidad buscarPersonajePorID(String id) {
		return new PersonajeEntidad(id, "Hommer Simpson", new PersonajeEntidad("Herb", "Herb Simpson", null));
	}

	public List<PersonajeEntidad> buscarPersonajes() {
		// TODO Auto-generated method stub
		return null;
	}

}
