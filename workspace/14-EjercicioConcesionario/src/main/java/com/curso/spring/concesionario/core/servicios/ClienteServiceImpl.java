package com.curso.spring.concesionario.core.servicios;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.concesionario.core.entidades.Cliente;
import com.curso.spring.concesionario.core.negocio.Transformador;
import com.curso.spring.concesionario.core.repositorios.ClienteJpaRepository;
import com.curso.spring.concesionario.dto.ClienteDto;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteJpaRepository clienteRepository;
	@Autowired
	private Transformador<ClienteDto, Cliente> transformador;
	
	@Override
	public long alta(ClienteDto clienteDto) throws Exception {
		Cliente cliente = transformador.dtoToEntidad(clienteDto);
		
		Cliente clienteGuardado = clienteRepository.save(cliente);
		
		return clienteGuardado.getId();
	}

	@Override
	public void baja(long id) throws Exception {
		clienteRepository.deleteById(id);
	}

	@Override
	public void modificacion(ClienteDto cliente) throws Exception {
		alta(cliente);
	}

	@Override
	public ClienteDto consultaPorId(long id) throws Exception {	
		Cliente cliente = clienteRepository.getOne(id);
	
		return transformador.entidadToDto(cliente);
	}

	@Override
	public Collection<ClienteDto> consultarTodos() throws Exception {
		return clienteRepository.findAll().parallelStream()
				.map(c -> transformador.entidadToDto(c)).collect(Collectors.toList());
	}

}
