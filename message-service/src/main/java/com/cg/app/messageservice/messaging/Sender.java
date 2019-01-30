package com.cg.app.messageservice.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	RabbitMessagingTemplate template;
	
	@Bean
	public Queue queue() {
		return new Queue("message",false);
		
	}
	public void send(String message) {
		template.convertAndSend("message", message);
	}
	
}
