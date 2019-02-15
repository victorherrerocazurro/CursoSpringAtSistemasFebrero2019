package com.curso.spring.concesionario.http;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.spring.concesionario.core.ClienteService;
import com.curso.spring.concesionario.dto.ClienteDto;

@RestController
@RequestMapping("/cliente")
public class ClienteRestService {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Void> alta(@RequestBody ClienteDto cliente) throws Exception{
		
		long idCliente = clienteService.alta(cliente);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
														.path("/{id}").buildAndExpand(idCliente).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> baja(@PathVariable long id) throws Exception{
		clienteService.baja(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Void> modificacion(@RequestBody ClienteDto cliente) throws Exception{
		clienteService.modificacion(cliente);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDto> consultaPorId(@PathVariable long id) throws Exception{
		ClienteDto clienteDto = clienteService.consultaPorId(id);
		
		return new ResponseEntity<ClienteDto>(clienteDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Collection<ClienteDto>> consultarTodos() throws Exception{
		Collection<ClienteDto> clientes = clienteService.consultarTodos();
		
		return new ResponseEntity<Collection<ClienteDto>>(clientes, HttpStatus.OK);
	}
	
}
