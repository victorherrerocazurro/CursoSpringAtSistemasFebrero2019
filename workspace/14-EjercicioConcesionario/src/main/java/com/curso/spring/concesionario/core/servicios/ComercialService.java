package com.curso.spring.concesionario.core.servicios;

import java.util.Collection;

import com.curso.spring.concesionario.dto.ComercialDto;

public interface ComercialService {

	long alta(ComercialDto comercial) throws Exception;
	void baja(long id) throws Exception;
	void modificacion(ComercialDto comercial) throws Exception;
	ComercialDto consultaPorId(long id) throws Exception;
	Collection<ComercialDto> consultarTodos() throws Exception;
	
}
