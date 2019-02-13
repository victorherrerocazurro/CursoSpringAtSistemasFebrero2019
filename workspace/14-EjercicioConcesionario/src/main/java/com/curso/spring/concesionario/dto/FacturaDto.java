package com.curso.spring.concesionario.dto;

import java.math.BigDecimal;
import java.util.Date;

public class FacturaDto {
	private long idFactura;
	private Date fecha;
	//Precio del vehiculo con IVA
	private BigDecimal total;
	private PedidoDto pedido;
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public PedidoDto getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}
	public FacturaDto(long idFactura, Date fecha, BigDecimal total, PedidoDto pedido) {
		super();
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.total = total;
		this.pedido = pedido;
	}
	public FacturaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
