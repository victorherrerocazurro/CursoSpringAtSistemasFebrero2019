package com.curso.spring.seguridad;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SeguridadBasadaEnSessionInterceptor implements HandlerInterceptor {

	@Autowired
	private AlmacenUsuarios almacenUsuarios;
	@Autowired
	private ExtractorLoginPassword extractorLoginPassword;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("En el interceptor");
		
		HttpSession session = request.getSession(true);
		
		//Si se cumple la existencia del dato que indica que hay un usuario logado (Principal) en la session
		if(session.getAttribute("principal") != null) {
			//hay un usuario logado
			return true;
		} 

		//Recoger los datos de autenticacion de la request 
		//(de donde vengan, dependera de la estrategia o patron que se implemente)
		//Validar que corresponden a un usuario valido
		//Si es asi se genera el objeto Usuario que representa al usuario valido
		Usuario usuario = verificarDatosAutenticacion(request);
		
		//Si el usuario es valido
		if(usuario != null) {
			//Que los datos de acceso son validos
			session.setAttribute("principal", usuario);
			return true;
		}

		//Sino existen, si no nos pasan ni la cookie, ni los datos de autenticacion, interrumpimosel acceso.
		return false;
	}

	private Usuario verificarDatosAutenticacion(HttpServletRequest request) {
		
		System.out.println("Verificando usuario");
		
		String[] loginPassword = extractorLoginPassword.extraerDeRequest(request);
		
		return almacenUsuarios.consultaSiExisteConEsteLoginYPassword(loginPassword[0], loginPassword[1]);
	}	
}