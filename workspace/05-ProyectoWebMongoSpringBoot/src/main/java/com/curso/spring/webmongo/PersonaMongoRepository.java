package com.curso.spring.webmongo;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaMongoRepository extends MongoRepository<PersonaDto, Long>{

	Collection<PersonaDto> findByNombre(String nombre);
	
}
