package com.curso.spring.concesionario;

import java.math.BigDecimal;

public class CobroDto {
	private String numeroTarjeta;
	private BigDecimal total;
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public CobroDto(String numeroTarjeta, BigDecimal total) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.total = total;
	}
	public CobroDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
