package com.curso.spring.concesionario.core.servicios;

import com.curso.spring.concesionario.dto.EntregaPedidoDto;
import com.curso.spring.concesionario.dto.PedidoDto;

public interface PedidoService {

	void lanzarPedido(PedidoDto pedido) throws Exception;
	
	PedidoDto seguimientoPedido(long id) throws Exception;
	
	void recepcionPedido(long idPedido) throws Exception;
	
	PedidoDto entregaPedido(EntregaPedidoDto entregaPedido) throws Exception;
	
}
