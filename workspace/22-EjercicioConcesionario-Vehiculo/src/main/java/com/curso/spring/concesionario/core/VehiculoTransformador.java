package com.curso.spring.concesionario.core;

import org.springframework.stereotype.Component;

import com.curso.spring.concesionario.dto.VehiculoDto;

@Component
public class VehiculoTransformador implements Transformador<VehiculoDto, Vehiculo>{

	@Override
	public Vehiculo dtoToEntidad(VehiculoDto dto) {
		return new Vehiculo(dto.getDescripcion(), dto.getModelo(), dto.getColor(), dto.getMotor(), dto.getPrecio());
	}

	@Override
	public VehiculoDto entidadToDto(Vehiculo entidad) {
		return new VehiculoDto(entidad.getDescripcion(), entidad.getModelo(), entidad.getColor(), entidad.getMotor(), entidad.getPrecio());
	}

}
