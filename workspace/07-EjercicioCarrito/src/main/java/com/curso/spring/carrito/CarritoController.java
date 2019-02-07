package com.curso.spring.carrito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/carrito")
@SessionAttributes({"carrito"})
public class CarritoController {

	@ModelAttribute("carrito")
	public void addCarritoToSession(Model model) {
		model.addAttribute("carrito", new Carrito());
	}
	
	/*@ModelAttribute("carrito")
	public Carrito addCarritoToSession() {
		return new Carrito();
	}*/
	
	@PatchMapping
	public ResponseEntity<Void> addProductoToCarrito(
			@ModelAttribute("carrito") Carrito carrito, 
			@RequestBody Producto producto){
		
		carrito.addProducto(producto);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping
	public Carrito getCarrito(@ModelAttribute("carrito") Carrito carrito){
		return carrito;
	}
	
	
}
