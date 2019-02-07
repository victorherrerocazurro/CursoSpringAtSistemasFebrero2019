package com.curso.spring.carrito;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

//@ControllerAdvice(basePackages="com.curso.spring.carrito")
@SessionAttributes({"carrito"})
public class ConfiguracionGlobalControllers {

	@ModelAttribute
	public void addCarritoToSession(Model model) {
		model.addAttribute("carrito", new Carrito());
	}
	
}
