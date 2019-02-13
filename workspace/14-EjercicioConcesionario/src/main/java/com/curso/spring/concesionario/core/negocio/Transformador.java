package com.curso.spring.concesionario.core.negocio;

public interface Transformador<DTO,ENTIDAD> {

	public ENTIDAD dtoToEntidad(DTO dto);
	
	public DTO entidadToDto(ENTIDAD entidad);

}
