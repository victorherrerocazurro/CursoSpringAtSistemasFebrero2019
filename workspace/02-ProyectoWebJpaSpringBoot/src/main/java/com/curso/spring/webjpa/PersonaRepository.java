package com.curso.spring.webjpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	Collection<Persona> findByNombre(String nombre);
	
	@Query("select u from Persona u where u.nombre = ?1")
	Collection<Persona> consultaPorNombre(String nombre);

}
