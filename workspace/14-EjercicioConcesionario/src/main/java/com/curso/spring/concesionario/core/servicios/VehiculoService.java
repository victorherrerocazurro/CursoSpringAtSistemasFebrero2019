package com.curso.spring.concesionario.core.servicios;

import java.util.Collection;

import com.curso.spring.concesionario.dto.VehiculoDto;

public interface VehiculoService {

	long alta(VehiculoDto vehiculo) throws Exception;
	void baja(long id) throws Exception;
	void modificacion(VehiculoDto vehiculo) throws Exception;
	VehiculoDto consultaPorId(long id) throws Exception;
	Collection<VehiculoDto> consultarTodos() throws Exception;
	
}
