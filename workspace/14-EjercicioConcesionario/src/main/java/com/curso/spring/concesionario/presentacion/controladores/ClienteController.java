package com.curso.spring.concesionario.presentacion.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.concesionario.core.servicios.ClienteService;
import com.curso.spring.concesionario.dto.ClienteDto;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/nuevo")
	public String altaFormulario(Model model) {
		
		model.addAttribute("cliente", new ClienteDto());
		
		return "cliente/formulario";
	}
	
	@PostMapping("/nuevo")
	public String alta(@ModelAttribute ClienteDto cliente, Model model) throws Exception {
		
		long idCliente = clienteService.alta(cliente);
		
		model.addAttribute("mensaje", "Se ha dado de alta correctamente un cliente con ID = " + idCliente);
		model.addAttribute("cliente", cliente);
		
		return "cliente/formulario";
	}
	
	@GetMapping("/borrar")
	public String baja(@RequestParam long id, Model model) {
		
		try {
			clienteService.baja(id);
			
			model.addAttribute("mensaje", "Se ha borrado correctamente un cliente con ID = " + id);
						
			return "cliente/listado";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/actualizar")
	public String modificacion(@ModelAttribute ClienteDto cliente, Model model) throws Exception {
		
		clienteService.modificacion(cliente);
		
		model.addAttribute("mensaje", "Se ha modificado correctamente un cliente con ID = " + cliente.getId());
		
		return "cliente/formulario";
	}
	
	@GetMapping("/detalle")
	public String consultaPorId(@RequestParam long id, Model model) throws Exception {
		
		ClienteDto clienteDto = clienteService.consultaPorId(id);
		
		model.addAttribute("cliente", clienteDto);
		
		return "cliente/formulario";
	}
	
	@GetMapping("/listado")
	public String consultarTodos(Model model) throws Exception {
		
		Collection<ClienteDto> clientes = clienteService.consultarTodos();
		
		model.addAttribute("clientes", clientes);
		
		return "cliente/listado";
	}
	
	@ExceptionHandler(Exception.class)
	public String procesarExcepcionesFormularioCliente() {
		return "cliente/formulario";
	}
	
	
}
