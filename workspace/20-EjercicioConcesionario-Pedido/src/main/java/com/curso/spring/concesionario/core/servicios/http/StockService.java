package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.concesionario.ConfiguracionOauth;

@FeignClient(name="microservicio-stock", configuration=ConfiguracionOauth.class)
@RequestMapping("/stock")
public interface StockService {

	@GetMapping
	boolean hayStock(@RequestParam Long idVehiculo,@RequestParam int i);

}
