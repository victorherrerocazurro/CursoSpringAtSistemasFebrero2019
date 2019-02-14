package com.curso.spring.concesionario.dto;

public class PedidoDto {

	private Long id;
	private Long idCliente;
	private Long idComercial;
	private Long idVehiculo;
	private String estado; 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdComercial() {
		return idComercial;
	}
	public void setIdComercial(Long idComercial) {
		this.idComercial = idComercial;
	}
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public PedidoDto(Long idCliente, Long idComercial, Long idVehiculo, String estado) {
		super();
		this.idCliente = idCliente;
		this.idComercial = idComercial;
		this.idVehiculo = idVehiculo;
		this.estado = estado;
	}
	
	public PedidoDto(Long id, Long idCliente, Long idComercial, Long idVehiculo, String estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idComercial = idComercial;
		this.idVehiculo = idVehiculo;
		this.estado = estado;
	}
	public PedidoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
