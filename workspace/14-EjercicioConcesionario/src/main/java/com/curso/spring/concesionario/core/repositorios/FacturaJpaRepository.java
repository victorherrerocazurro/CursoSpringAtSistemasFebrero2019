package com.curso.spring.concesionario.core.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.concesionario.core.entidades.Factura;

public interface FacturaJpaRepository extends JpaRepository<Factura, Long> {

}
