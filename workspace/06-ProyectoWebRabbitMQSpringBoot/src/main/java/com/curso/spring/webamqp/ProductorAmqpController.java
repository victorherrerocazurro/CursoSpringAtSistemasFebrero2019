package com.curso.spring.webamqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductorAmqpController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/enviar")
	public String enviar(@RequestParam("mensaje") String mensaje) {
		
		//Se envia un mensaje al Exchange
		rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.#", mensaje);
		
		return mensaje;
	}
	
}
