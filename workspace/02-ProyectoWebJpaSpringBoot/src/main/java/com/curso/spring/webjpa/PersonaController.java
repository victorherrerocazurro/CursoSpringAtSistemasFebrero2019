package com.curso.spring.webjpa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
	private PersonaJpaRepository personaRepository;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertar(@RequestBody PersonaDto persona) throws URISyntaxException {
		personaRepository.save(persona);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8080/Persona/" + persona.getId()));
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//En este caso no seria necesario emplear responseEntity por que complica el codigo para obtener lo mismo,
	//solo es encesario emplearlo cuando se cambien el HttpStatus o se añadan cabeceras
	@GetMapping
	public ResponseEntity<Collection<PersonaDto>> consultar(){
		return  new ResponseEntity<Collection<PersonaDto>>(personaRepository.findAll(), HttpStatus.OK);
	}
	
	//?n=Victor
	
	@GetMapping("/nombre")
	public Collection<PersonaDto> consultar(@RequestParam("n") String nombre){
		return personaRepository.findByNombre(nombre);
	}
	
	@GetMapping("/{identificador}")
	public PersonaDto consultar(@PathVariable("identificador") long id){
		//return personaRepository.getOne(id);
		 return personaRepository.findById(id).get();
	}
	
}
