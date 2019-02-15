package com.curso.spring.concesionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cobros")
@PreAuthorize("#oauth2.hasScope('write')")
public class CobrosRestService {
	
	@Autowired
	private ServicioCobros servicioCobros;

	@PostMapping
	public ResponseEntity<Void> cobrarCorTarjeta(@RequestBody CobroDto cobroDto) throws Exception{
		servicioCobros.cobrarCorTarjeta(cobroDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
