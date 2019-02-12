package com.curso.spring.concesionario.core.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String telefono;
	private String correo;
	//No queremos liarnos con configuraciones de Hibernate
	//private List<Pedido> pedidos;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//Estos dos constructores son para favorecer la construccion del objeto programaticamente
	public Cliente(Long id, String nombre, String telefono, String correo) {
		this(nombre, telefono,correo);
		this.id = id;
	}
	
	public Cliente(String nombre, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	//Hibernate obliga a que exista este constructor
	public Cliente() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
