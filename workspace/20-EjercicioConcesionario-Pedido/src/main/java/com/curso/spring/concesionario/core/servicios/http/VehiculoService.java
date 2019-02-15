package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.spring.concesionario.ConfiguracionOauth;
import com.curso.spring.concesionario.dto.VehiculoDto;

@FeignClient(name="microservicio-vehiculo", configuration=ConfiguracionOauth.class)
@RequestMapping("/vehiculo")
public interface VehiculoService {

	@GetMapping("/{id}")
	VehiculoDto consultarPorId(@PathVariable long idVehiculo);

}
