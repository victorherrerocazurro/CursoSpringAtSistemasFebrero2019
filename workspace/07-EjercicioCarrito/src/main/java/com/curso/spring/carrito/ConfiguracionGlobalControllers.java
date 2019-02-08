package com.curso.spring.carrito;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice(basePackages="com.curso.spring.carrito")
@SessionAttributes({"carrito"})
public class ConfiguracionGlobalControllers {

	//El metodo se invoca cada vez que se pide algo a este controller
	/*@ModelAttribute
	public void addCarritoToSession(Model model) {
		model.addAttribute("carrito", new Carrito());
	}*/
	
	//Se invoca siempre que se pida algo a este controlador, salvo que se indique
	//que "carrito" esta en la session
	/*@ModelAttribute("carrito")
	public void addCarritoToSession(Model model) {
		model.addAttribute("carrito", new Carrito());
	}*/
	
	@ModelAttribute("carrito")
	public Carrito addCarritoToSession() {
		return new Carrito();
	}
}
