package com.curso.spring.webjpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaJpaRepository extends JpaRepository<PersonaDto, Long> {

	Collection<PersonaDto> findByNombre(String nombre);
	
	@Query("select u from PersonaDto u where u.nombre = ?1")
	Collection<PersonaDto> consultaPorNombre(String nombre);

}
