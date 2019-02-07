package com.curso.spring.webamqp;

import org.springframework.stereotype.Service;

@Service
public class ConsumidorAmqp {
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}
}
