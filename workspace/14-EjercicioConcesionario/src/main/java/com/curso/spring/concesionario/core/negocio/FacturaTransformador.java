package com.curso.spring.concesionario.core.negocio;

import org.springframework.stereotype.Component;

import com.curso.spring.concesionario.core.entidades.Factura;
import com.curso.spring.concesionario.dto.FacturaDto;

@Component
public class FacturaTransformador implements Transformador<FacturaDto, Factura> {

	@Override
	public Factura dtoToEntidad(FacturaDto dto) {
		return new Factura(dto.getIdFactura(), dto.getFecha(), dto.getTotal(), dto.getPedido().getId(), null);
	}

	@Override
	public FacturaDto entidadToDto(Factura entidad) {
		return new FacturaDto(entidad.getId(), entidad.getFecha(), entidad.getTotal(), null);
	}



}
