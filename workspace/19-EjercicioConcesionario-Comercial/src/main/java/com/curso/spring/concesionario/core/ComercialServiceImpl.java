package com.curso.spring.concesionario.core;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.concesionariodto.ComercialDto;

@Service
@Transactional
public class ComercialServiceImpl implements ComercialService {

	@Autowired
	private ComercialJpaRepository comercialRepository;
	@Autowired
	private Transformador<ComercialDto, Comercial> transformador;
	
	@Override
	public long alta(ComercialDto comercialDto) throws Exception {
		Comercial comercial = transformador.dtoToEntidad(comercialDto);
		
		Comercial comercialGuardado = comercialRepository.save(comercial);
		
		return comercialGuardado.getId();
	}

	@Override
	public void baja(long id) throws Exception {
		comercialRepository.deleteById(id);

	}

	@Override
	public void modificacion(ComercialDto comercial) throws Exception {
		alta(comercial);

	}

	@Override
	public ComercialDto consultaPorId(long id) throws Exception {
		Comercial comercial = comercialRepository.getOne(id);
		
		return transformador.entidadToDto(comercial);
	}

	@Override
	public Collection<ComercialDto> consultarTodos() throws Exception {
		return comercialRepository.findAll().parallelStream()
				.map(c -> transformador.entidadToDto(c)).collect(Collectors.toList());
	}

}
