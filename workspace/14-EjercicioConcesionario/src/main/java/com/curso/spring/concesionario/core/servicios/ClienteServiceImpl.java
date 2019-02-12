package com.curso.spring.concesionario.core.servicios;

import java.util.Collection;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void modificacion(ClienteDto cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ClienteDto consultaPorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ClienteDto> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
