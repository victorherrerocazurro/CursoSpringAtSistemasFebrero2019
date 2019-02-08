package com.curso.spring.carrito;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Component
//@JsonIgnoreProperties("proxiedInterfaces")
//Se alamcena en el mapa de atributos de la session como *scopedTarget.carrito*
@SessionScope
public class Carrito {

	//Habria que considerar, el tamaño del objeto producto, 
	//por motivo de aprovechamiento de la memoria
	private Map<Long, Producto> productos = new HashMap<Long, Producto>();
	
	public void addProducto(Producto producto) {
		productos.put(producto.getId(), producto);		
	}

	public Map<Long, Producto> getProductos() {
		return productos;
	}
}
