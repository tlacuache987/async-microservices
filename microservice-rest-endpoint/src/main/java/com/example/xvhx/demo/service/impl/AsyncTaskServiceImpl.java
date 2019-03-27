package com.example.xvhx.demo.service.impl;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xvhx.demo.service.AsyncTaskService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange exchange;

	@Override
	@SneakyThrows
	public int execute(int number) {

		log.info("Requesting fib({})", number);

		Integer response = (Integer) template.convertSendAndReceive(exchange.getName(), "rpc", number);

		log.info("Got {}", response);

		return response;
	}

}
