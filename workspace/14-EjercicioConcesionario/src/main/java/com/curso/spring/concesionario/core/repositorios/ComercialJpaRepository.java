package com.curso.spring.concesionario.core.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.concesionario.core.entidades.Comercial;

public interface ComercialJpaRepository extends JpaRepository<Comercial, Long> {

}
