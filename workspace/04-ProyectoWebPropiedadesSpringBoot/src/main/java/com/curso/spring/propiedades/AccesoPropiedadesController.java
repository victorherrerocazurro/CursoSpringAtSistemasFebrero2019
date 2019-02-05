package com.curso.spring.propiedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccesoPropiedadesController {

	@Value("${message:Hello default}") 
	private String message;

	
	@Autowired
	private MisPropiedades props;
	
	@GetMapping("/acceso")
	public String acceso() {
		return props.getNombre() + props.getPuerto();
	}
	
}
