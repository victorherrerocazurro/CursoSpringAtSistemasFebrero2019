package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("microservicio-stock")
@RequestMapping("/stock")
public interface StockService {

	@GetMapping
	boolean hayStock(@RequestParam Long idVehiculo,@RequestParam int i);

}
