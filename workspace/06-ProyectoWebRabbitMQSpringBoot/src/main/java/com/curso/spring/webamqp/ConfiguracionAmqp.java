package com.curso.spring.webamqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionAmqp {

	// Es el equivalente a la anotacion @JmsListener de ActiveMQ
	@Bean
	public MessageListenerAdapter listenerAdapter(ConsumidorAmqp receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	//Tiene como mision, relacionar el listener con el Queue
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames("spring-boot");
		container.setMessageListener(listenerAdapter);
		return container;
	}

	/* NO ES RESPONSABILIDAD DE LA APLICACION EL DEFINIR ESTOS COMPONENTES, 
	 * LOS DEFINIMOS POR COMODIDAD, PARA NO TENER QUE LIDIAR CON LA HERRAMIENTA RABBITMQ*/
	
	
	@Bean
	public Queue queue() {
		return new Queue("spring-boot", false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}
}
