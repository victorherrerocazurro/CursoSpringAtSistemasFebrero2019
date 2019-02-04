package com.curso.spring.webjpa;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Persona")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona insertar(@RequestBody Persona persona) {
		personaRepository.save(persona);
		return persona;
	}
	
	@GetMapping
	public Collection<Persona> consultar(){
		return personaRepository.findAll();
	}
	
	//?n=Victor
	
	@GetMapping("/nombre")
	public Collection<Persona> consultar(@RequestParam("n") String nombre){
		return personaRepository.findByNombre(nombre);
	}
	
	@GetMapping("/{identificador}")
	public Persona consultar(@PathVariable("identificador") long id){
		return personaRepository.getOne(id);
	}
	
}
