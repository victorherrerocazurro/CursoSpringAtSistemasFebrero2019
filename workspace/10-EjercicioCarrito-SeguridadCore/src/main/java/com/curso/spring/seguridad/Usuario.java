package com.curso.spring.seguridad;


import java.util.List;

public class Usuario {

	private String login;
	private String nombre;
	private List<String> roles;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public Usuario(String login, String nombre, List<String> roles) {
		super();
		this.login = login;
		this.nombre = nombre;
		this.roles = roles;
	}	
}
