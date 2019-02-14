package com.curso.spring.concesionario.core.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.concesionario.core.entidades.Pedido;

public interface PedidoJpaRepository extends JpaRepository<Pedido, Long> {

}
