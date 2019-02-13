package com.curso.spring.consumidor;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteController {

	@Autowired
    private RestTemplate restTemplate;

	@RequestMapping("/")
    String getMessage() throws RestClientException, URISyntaxException {
        
    	ResponseEntity<PersonaDto> resultado = restTemplate.getForEntity(new URI("http://holamundo/"), PersonaDto.class);
    	
    	return resultado.getBody().getNombre() + "-" + resultado.getBody().getId();
    }
}
