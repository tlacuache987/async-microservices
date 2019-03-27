package com.example.xvhx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.mkopylec.charon.configuration.CharonConfiguration;


@SpringBootApplication
@Import(CharonConfiguration.class)
public class MicroserviceReverseProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReverseProxyApplication.class, args);
	}

}
