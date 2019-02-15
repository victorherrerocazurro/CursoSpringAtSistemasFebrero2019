package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.spring.concesionario.ConfiguracionOauth;
import com.curso.spring.concesionario.dto.CobroDto;
import com.fasterxml.jackson.databind.JsonNode;

/*
 * @Autowired
    private OAuth2RestOperations restTemplate;

    @Value("${config.oauth2.resourceURI}")
    private String resourceURI;

    @RequestMapping("/")
    public JsonNode home() {
        return restTemplate.getForObject(resourceURI, JsonNode.class);

 */

@FeignClient(name="microservicio-cobro", configuration=ConfiguracionOauth.class)
@RequestMapping("/cobro")
public interface CobrosService {

	@PostMapping
	void cobrarCorTarjeta(@RequestBody CobroDto cobroDto);

}
