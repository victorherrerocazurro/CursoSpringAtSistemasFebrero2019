package com.curso.spring.concesionario.core.servicios;

import com.curso.spring.concesionario.dto.CobroDto;

public interface ServicioCobros {

	void cobrarCorTarjeta(CobroDto cobroDto) throws Exception;

}