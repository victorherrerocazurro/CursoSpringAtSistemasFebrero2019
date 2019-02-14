package com.curso.spring.concesionario.core;

import java.util.Collection;

import com.curso.spring.concesionario.dto.ClienteDto;

public interface ClienteService {

	long alta(ClienteDto cliente) throws Exception;
	void baja(long id) throws Exception;
	void modificacion(ClienteDto cliente) throws Exception;
	ClienteDto consultaPorId(long id) throws Exception;
	Collection<ClienteDto> consultarTodos() throws Exception;
	
}
