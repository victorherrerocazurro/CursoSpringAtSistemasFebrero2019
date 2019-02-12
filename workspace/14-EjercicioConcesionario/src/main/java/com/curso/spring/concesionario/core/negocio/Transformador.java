package com.curso.spring.concesionario.core.negocio;

public interface Transformador<DTO,ENTIDAD> {

	public ENTIDAD dtoToEntidad(DTO vehiculoDto);
	
	public DTO entidadToDto(ENTIDAD vehiculo);

}
