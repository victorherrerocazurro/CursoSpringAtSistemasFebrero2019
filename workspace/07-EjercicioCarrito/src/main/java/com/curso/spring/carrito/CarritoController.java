package com.curso.spring.carrito;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/carrito")
//Aunque esta declarado en el ControllerAdvice, hay que repetir la
//declaracion para que funcione (raro)
@SessionAttributes({"carrito"})
public class CarritoController {

	@PatchMapping
	public ResponseEntity<Void> addProductoToCarrito(
			@ModelAttribute("carrito") Carrito carrito, 
			HttpSession session,
			@RequestBody Producto producto) {

		carrito.addProducto(producto);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping
	public Carrito getCarrito(
			@ModelAttribute("carrito") Carrito carrito) {
		return carrito;
	}

}
