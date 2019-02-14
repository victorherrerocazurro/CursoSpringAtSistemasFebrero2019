package com.curso.spring.concesionario.dto;

public class EntregaPedidoDto {
	private long idPedido;
	//Esto podria ser una tipo de dato DatosDeCobro, que abtraiga el concepto de sobre que soporte se 
	//realiza el cobro
	private String numeroTarjeta;
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public EntregaPedidoDto(long idPedido, String numeroTarjeta) {
		super();
		this.idPedido = idPedido;
		this.numeroTarjeta = numeroTarjeta;
	}
	public EntregaPedidoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
