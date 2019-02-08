package com.curso.spring.seguridad;


public interface AlmacenUsuarios {

	Usuario consultaSiExisteConEsteLoginYPassword(String login, String password);

}
