package com.curso.spring.webjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Receptor {
	@JmsListener(destination = "mailbox")
	public void receiveMessage(Email email) {
		System.out.println("Received <" + email + ">");
	}
}
