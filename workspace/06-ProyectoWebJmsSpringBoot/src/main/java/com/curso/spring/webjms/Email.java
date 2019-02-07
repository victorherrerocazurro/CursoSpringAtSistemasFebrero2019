package com.curso.spring.webjms;

import java.io.Serializable;

public class Email implements Serializable{

	private String mensaje;
	
	public Email(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Email() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
