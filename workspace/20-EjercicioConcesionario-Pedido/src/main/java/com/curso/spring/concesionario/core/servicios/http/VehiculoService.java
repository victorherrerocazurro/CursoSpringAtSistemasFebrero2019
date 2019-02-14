package com.curso.spring.concesionario.core.servicios.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.spring.concesionario.dto.VehiculoDto;

@FeignClient("microservicio-vehiculo")
@RequestMapping("/vehiculo")
public interface VehiculoService {

	@GetMapping("/{id}")
	VehiculoDto consultarPorId(@PathVariable long idVehiculo);

}
