package com.curso.spring.carrito;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrito")
//Aunque esta declarado en el ControllerAdvice, hay que repetir la
//declaracion para que funcione (raro)
//@SessionAttributes({"carrito"})
public class CarritoController {

	//CONFUSO!!!!! Este carrito que nos inyecta Sring, es realmente un Proxy (singleton) de todos los carritos
	//de todas las sessiones, que internamente resuelve el carrito (target), a partir de la informacion de la
	//request que lo emplea, buscando en el mapa de sesiones la sesion correspondiente empleando el JSESSIONID
	//y una vez obtenida la session, buscando el carrito dentro de esa session.
	@Autowired
	private Carrito carrito;
	
	@PatchMapping
	public ResponseEntity<Void> addProductoToCarrito(
			//@ModelAttribute("carrito") Carrito carrito,
			//@ModelAttribute("scopedTarget.carrito") Carrito carrito,
			HttpSession session,
			@RequestBody Producto producto) {

		//Carrito carrito2 = (Carrito) session.getAttribute("scopedTarget.carrito");
		
		carrito.addProducto(producto);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public Map<Long, Producto> getCarrito(
			//@ModelAttribute("scopedTarget.carrito") Carrito carrito
			) {
		return carrito.getProductos();
	}

}
