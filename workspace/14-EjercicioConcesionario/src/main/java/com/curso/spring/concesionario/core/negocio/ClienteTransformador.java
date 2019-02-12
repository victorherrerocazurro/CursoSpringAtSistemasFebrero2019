package com.curso.spring.concesionario.core.negocio;

import org.springframework.stereotype.Component;

import com.curso.spring.concesionario.core.entidades.Cliente;
import com.curso.spring.concesionario.dto.ClienteDto;

@Component
public class ClienteTransformador implements Transformador<ClienteDto, Cliente> {

	@Override
	public Cliente dtoToEntidad(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto.getId(), clienteDto.getNombre(), clienteDto.getTelefono(), clienteDto.getCorreo());
		return cliente;
	}

	@Override
	public ClienteDto entidadToDto(Cliente vehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

}
