package com.curso.spring.webjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductorJms {
	@Autowired
	private JmsTemplate jmsTemplate;

	///enviar?mensaje=Hello
	@GetMapping("/enviar")
	public Email enviar(@RequestParam("mensaje") String mensaje) {
		Email email = new Email(mensaje);
		jmsTemplate.convertAndSend("mailbox", email);
		return email;
	}
}
