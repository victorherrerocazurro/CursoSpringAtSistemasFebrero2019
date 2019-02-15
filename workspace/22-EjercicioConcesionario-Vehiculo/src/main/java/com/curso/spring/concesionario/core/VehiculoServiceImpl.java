package com.curso.spring.concesionario.core;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.concesionario.dto.VehiculoDto;

@Service
@Transactional
public class VehiculoServiceImpl  implements VehiculoService{
	@Autowired
	private VehiculoJpaRepository vehiculoRepository;
	@Autowired
	private Transformador<VehiculoDto, Vehiculo> transformador;
	
	@Override
	public long alta(VehiculoDto vehiculoDto) throws Exception {
		Vehiculo vehiculo = transformador.dtoToEntidad(vehiculoDto);
		
		Vehiculo vehiculoGuardado = vehiculoRepository.save(vehiculo);
		
		return vehiculoGuardado.getId();
	}

	@Override
	public void baja(long id) throws Exception {
		vehiculoRepository.deleteById(id);
	}

	@Override
	public void modificacion(VehiculoDto vehiculo) throws Exception {
		alta(vehiculo);
	}

	@Override
	public VehiculoDto consultaPorId(long id) throws Exception {	
		Vehiculo vehiculo = vehiculoRepository.getOne(id);
	
		return transformador.entidadToDto(vehiculo);
	}

	@Override
	public Collection<VehiculoDto> consultarTodos() throws Exception {
		return vehiculoRepository.findAll().parallelStream()
				.map(c -> transformador.entidadToDto(c)).collect(Collectors.toList());
	}
}
