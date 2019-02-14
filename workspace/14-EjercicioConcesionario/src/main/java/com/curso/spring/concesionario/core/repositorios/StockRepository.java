package com.curso.spring.concesionario.core.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.concesionario.core.entidades.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query("select s.cantidad from Stock s where s.idVehiculo = ?1")
	boolean hayStock(Long idVehiculo, int i);

}
