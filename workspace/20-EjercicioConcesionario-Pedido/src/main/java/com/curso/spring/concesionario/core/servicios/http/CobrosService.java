package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.spring.concesionario.dto.CobroDto;

@FeignClient("microservicio-cobro")
@RequestMapping("/cobro")
public interface CobrosService {

	@PostMapping
	void cobrarCorTarjeta(@RequestBody CobroDto cobroDto);

}
