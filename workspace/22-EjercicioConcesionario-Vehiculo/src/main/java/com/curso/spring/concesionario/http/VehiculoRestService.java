package com.curso.spring.concesionario.http;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.spring.concesionario.core.VehiculoService;
import com.curso.spring.concesionario.dto.VehiculoDto;

@RestController
@RequestMapping("/vehiculo")
@PreAuthorize("#oauth2.hasScope('write')")
public class VehiculoRestService {

	@Autowired
	private VehiculoService vehiculoService;
	
	public ResponseEntity<Void> alta(VehiculoDto vehiculo) throws Exception{
		long idVehiculo = vehiculoService.alta(vehiculo);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
														.path("/{id}").buildAndExpand(idVehiculo).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Void> baja(long id) throws Exception{
		vehiculoService.baja(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> modificacion(VehiculoDto vehiculo) throws Exception{ 
		vehiculoService.modificacion(vehiculo);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<VehiculoDto> consultaPorId(long id) throws Exception {
		VehiculoDto vehiculoDto = vehiculoService.consultaPorId(id);
		
		return new ResponseEntity<VehiculoDto>(vehiculoDto,HttpStatus.OK);
	}
	
	public ResponseEntity<Collection<VehiculoDto>> consultarTodos() throws Exception{
		Collection<VehiculoDto> vehiculos = vehiculoService.consultarTodos();
		
		return new ResponseEntity<Collection<VehiculoDto>>(vehiculos, HttpStatus.OK);
	}
	
}
