package com.example.xvhx.demo._config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("xvhx.rpc");
	}
}
