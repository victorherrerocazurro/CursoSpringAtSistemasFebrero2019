package com.curso.spring.concesionario.core.servicios;

import org.springframework.stereotype.Service;

import com.curso.spring.concesionario.dto.CobroDto;

/**
 * Este servicio tranquilamente podria ser un servicio remoto, accesible via HTTP
 * @author Atprestamos
 *
 */
@Service
public class ServicioCobrosImpl implements ServicioCobros {

	/* (non-Javadoc)
	 * @see com.curso.spring.concesionario.core.servicios.ServicioCobros#cobrarCorTarjeta(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public void cobrarCorTarjeta(CobroDto cobroDto) throws Exception{
		// TODO Auto-generated method stub
		
	}

}
