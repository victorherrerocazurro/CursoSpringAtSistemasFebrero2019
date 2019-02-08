package com.curso.spring.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcAlmacenUsuarios implements AlmacenUsuarios{

	//@Autowired
	//private UsuariosRepository usuariosRepository;
	
	@Override
	public Usuario consultaSiExisteConEsteLoginYPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
