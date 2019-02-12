package com.curso.spring.concesionario.core.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.curso.spring.concesionario.core.Estado;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private long idCliente;
	private long idComercial;
	private long idVehiculo;
	private long idFactura;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private Estado estado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getIdComercial() {
		return idComercial;
	}
	public void setIdComercial(long idComercial) {
		this.idComercial = idComercial;
	}
	public long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Pedido(Long id, long idCliente, long idComercial, long idVehiculo, long idFactura, Date fecha,
			Estado estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idComercial = idComercial;
		this.idVehiculo = idVehiculo;
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.estado = estado;
	}
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
