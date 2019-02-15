package com.curso.spring.concesionario.core.servicios;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.concesionario.Estado;
import com.curso.spring.concesionario.core.entidades.Factura;
import com.curso.spring.concesionario.core.entidades.Pedido;
import com.curso.spring.concesionario.core.negocio.FacturaTransformador;
import com.curso.spring.concesionario.core.negocio.PedidoTransformador;
import com.curso.spring.concesionario.core.persistencia.FacturaJpaRepository;
import com.curso.spring.concesionario.core.persistencia.PedidoJpaRepository;
import com.curso.spring.concesionario.core.servicios.http.CobrosService;
import com.curso.spring.concesionario.core.servicios.http.StockService;
import com.curso.spring.concesionario.core.servicios.http.VehiculoService;
import com.curso.spring.concesionario.dto.CobroDto;
import com.curso.spring.concesionario.dto.EntregaPedidoDto;
import com.curso.spring.concesionario.dto.FacturaDto;
import com.curso.spring.concesionario.dto.PedidoDto;
import com.curso.spring.concesionario.dto.VehiculoDto;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
	
	//Negocio interno
	@Autowired
	private PedidoTransformador pedidoTransformador;
	@Autowired
	private FacturaTransformador facturaTransformador;
	@Autowired
	private PedidoJpaRepository pedidoRepository;
	@Autowired
	private FacturaJpaRepository facturaRepository;
	
	//Negocio Externo
	@Autowired
	private CobrosService cobrosService;
	@Autowired
	private StockService stockService;
	@Autowired
	private VehiculoService vehiculoService;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * Lanzar un nuevo pedido. conocidos el cliente, el comercial y el vehiculo a
	 * pedir, se cosulta el stock, si hay stock se registra en la BBDD un nuevo
	 * Pedido con estado en proceso si no hay stock, se registra en la BBDD un nuevo
	 * Pedido con estado en sin stock y se envia un evento al bus que escuchará la
	 * fabrica para producir el vehiculo.
	 */
	@Override
	public void lanzarPedido(PedidoDto pedidoDto) throws Exception {
		// El Pedido obtenido tiene como valores iniciales del estado EN_PROCESO y de
		// fecha la fecha actual
		Pedido pedido = pedidoTransformador.dtoToEntidad(pedidoDto);

		// Consultar Stock
		//if (!stockService.hayStock(pedidoDto.getIdVehiculo(), 1)) {
			// si no hay stock, se cambia el estado del nuevo Pedido a sin stock
			pedido.setEstado(Estado.SIN_STOCK);
			// se envia un evento al bus que escuchará la fabrica para producir el vehiculo.
			rabbitTemplate.convertAndSend("amqp.fabrica.vehiculos", "amqp.fabrica.vehiculos.pedido", pedido);
		//}
		// Tanto si hay stock, como sino, se registra en la BBDD un nuevo Pedido
		pedidoRepository.save(pedido);
	}

	/**
	 * Seguimiento del pedido de un cliente (comprobacion de estado). Consulta por
	 * Identificador del Pedido, que como proyeccion nos de el estado.
	 */
	@Override
	public PedidoDto seguimientoPedido(long idPedido) throws Exception {
		return pedidoTransformador.entidadToDto(pedidoRepository.getOne(idPedido));
	}

	/**
	 * Recepcion de pedido cambiando su estado a "listo para entregar" y creacion de
	 * entidad factura con estado no cobrada. (Envio de correo al cliente o al
	 * comercial)
	 */
	@Override
	public void recepcionPedido(long idPedido) throws Exception {
		// recuperar el pedido
		Pedido pedido = pedidoRepository.getOne(idPedido);

		// Creamos la factura, para lo cual necesitamos recuperar el precio del vehiculo
		VehiculoDto vehiculo = vehiculoService.consultarPorId(pedido.getIdVehiculo());

		Factura factura = new Factura(null, new Date(), vehiculo.getPrecio(), idPedido, "PENDIENTE_DE_COBRO");

		// Guardamos la factura
		facturaRepository.save(factura);

		// Establecemos el nuevo estado
		pedido.setEstado(Estado.LISTO_PARA_ENTREGAR);
		// Establecemos la relacion entre la factrua y el pedido
		pedido.setIdFactura(factura.getId());

		// Actualizamos el pedido
		// Esto depende, no tiene porque ser necesario
		pedidoRepository.save(pedido);
	}

	/**
	 * Cobro del pedido, generacion impresa de la factura y entrega de pedido.
	 * Cambio de estados de las entidades.
	 */
	@Override
	public FacturaDto entregaPedido(EntregaPedidoDto entregaPedido) throws Exception {
		// recuperar el pedido
		Pedido pedido = pedidoRepository.getOne(entregaPedido.getIdPedido());

		// recuperamos la Factura
		Factura factura = facturaRepository.getOne(pedido.getIdFactura());

		// Cobrar el pedido
		cobrosService.cobrarCorTarjeta(new CobroDto(entregaPedido.getNumeroTarjeta(), factura.getTotal()));

		// Cambio de estado a la factura
		factura.setEstado("COBRADA");

		// Cambio de estado a la factura
		pedido.setEstado(Estado.ENTREGADO);

		// Actualziacion de la factura en BBDD
		facturaRepository.save(factura);

		// Actualziacion de la pedido en BBDD
		pedidoRepository.save(pedido);

		FacturaDto facturaDto = facturaTransformador.entidadToDto(factura);
		
		facturaDto.setPedido(pedidoTransformador.entidadToDto(pedido));
		
		return facturaDto;
	}

}
