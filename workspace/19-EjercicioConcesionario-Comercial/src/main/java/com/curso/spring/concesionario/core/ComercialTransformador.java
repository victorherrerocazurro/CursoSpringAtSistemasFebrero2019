package com.curso.spring.concesionario.core;

import org.springframework.stereotype.Component;

import com.curso.spring.concesionariodto.ComercialDto;

@Component
public class ComercialTransformador implements Transformador<ComercialDto, Comercial> {

	@Override
	public Comercial dtoToEntidad(ComercialDto dto) {
		return new Comercial(dto.getId(), dto.getNombre(), dto.getTelefono(), dto.getCorreo(), dto.getClientes(), dto.getPedidos());
	}

	@Override
	public ComercialDto entidadToDto(Comercial entidad) {
		return new ComercialDto(entidad.getId(), entidad.getNombre(), entidad.getTelefono(), entidad.getCorreo(), null, null);
	}

}
