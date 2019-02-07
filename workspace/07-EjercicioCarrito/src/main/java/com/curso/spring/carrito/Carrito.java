package com.curso.spring.carrito;

import java.util.HashMap;
import java.util.Map;

//@Component
//@Scope("session")
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
