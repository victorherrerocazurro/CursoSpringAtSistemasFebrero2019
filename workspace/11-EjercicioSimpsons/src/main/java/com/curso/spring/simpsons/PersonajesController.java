package com.curso.spring.simpsons;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.event.NamingEvent;
import javax.naming.event.NamingExceptionEvent;
import javax.naming.event.ObjectChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personajes")
public class PersonajesController {

	@Autowired
	private Negocio negocio;
	
	@GetMapping("{id}")
	public ResponseEntity<PersonajeDto> consultar(@PathVariable("id") String id) throws MalformedURLException {
		
		PersonajeEntidad personaje = negocio.buscarPersonajePorID(id);
		
		return new ResponseEntity<PersonajeDto>(
				new PersonajeDto(
						personaje.getId(), 
						personaje.getNombre(), 
						new URL("http://localhost:8080/personajes/" + personaje.getPadre().getId())),
				HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<PersonajeDto>> consultar() {
		
		List<PersonajeEntidad> personajes = negocio.buscarPersonajes();
		
		List<PersonajeDto> collect = personajes.stream().map(personajeEntidad -> 
			{
				try {
					return new PersonajeDto(
								personajeEntidad.getId(), 
								personajeEntidad.getNombre(), 
								new URL("http://localhost:8080/personajes/" + personajeEntidad.getPadre().getId()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				}
			}
		).collect(Collectors.toList());
		
		return new ResponseEntity<List<PersonajeDto>>(
				collect,
				HttpStatus.OK);
	}
	
	@GetMapping(params="genero")
	public ResponseEntity<List<PersonajeDto>> consultarPorGenero(@RequestParam String genero) {
		return null;
	}
	
	//Empleamos put para el alta porque el id forma parte 
	//de los datos que me envian
	//Este metodo tiene que contemplar la insercion o actualziacion en
	//la persistencia
	@PutMapping
	public ResponseEntity<Void> insertarModificar(@RequestBody PersonajeDto personaje){
		return null;
	}
		
	@GetMapping("{id}/padre")
	public ResponseEntity<PersonajeDto> consultarPadreDePersonaje(@PathVariable("id") String id) {
		return null;
	}
	
}
