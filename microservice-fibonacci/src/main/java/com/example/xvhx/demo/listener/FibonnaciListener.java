package com.example.xvhx.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FibonnaciListener {

	@RabbitListener(queues = "xvhx.rpc.requests")
	// @SendTo("tut.rpc.replies") used when the
	// client doesn't set replyTo.
	public int fibonacci(int n) {
		log.info(" [x] Received request for " + n);

		int result = fib(n);

		log.info(" [.] Returned " + result);
		return result;
	}

	public int fib(int n) {
		return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
	}

}
