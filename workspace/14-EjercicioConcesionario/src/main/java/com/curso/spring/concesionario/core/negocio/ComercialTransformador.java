package com.curso.spring.concesionario.core.negocio;

import org.springframework.stereotype.Component;

import com.curso.spring.concesionario.core.entidades.Comercial;
import com.curso.spring.concesionario.dto.ComercialDto;

@Component
public class ComercialTransformador implements Transformador<ComercialDto, Comercial> {

	@Override
	public Comercial dtoToEntidad(ComercialDto dto) {
		return new Comercial(dto.getId(), dto.getNombre(), dto.getTelefono(), dto.getCorreo(), dto.getClientes(), dto.getPedidos());
	}

	@Override
	public ComercialDto entidadToDto(Comercial entidad) {
		return new ComercialDto(entidad.getId(), entidad.getNombre(), entidad.getTelefono(), entidad.getCorreo(), entidad.getClientes(), entidad.getPedidos());
	}

}
