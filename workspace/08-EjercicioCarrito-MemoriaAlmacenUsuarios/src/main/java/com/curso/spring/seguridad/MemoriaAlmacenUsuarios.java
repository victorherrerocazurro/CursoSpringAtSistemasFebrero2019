package com.curso.spring.seguridad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MemoriaAlmacenUsuarios implements AlmacenUsuarios {

	private Map<String, Usuario> almacenUsuarios = new HashMap<String, Usuario>();
	
	@PostConstruct
	public void init() {
		almacenUsuarios.put("victor:victor", new Usuario("victor", "victor", Arrays.asList("USER")));
	}
	
	@Override
	public Usuario consultaSiExisteConEsteLoginYPassword(String login, String password) {		
		return almacenUsuarios.get(login + ":" + password);
	}

}
