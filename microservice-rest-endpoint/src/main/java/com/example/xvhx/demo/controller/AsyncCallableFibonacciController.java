package com.example.xvhx.demo.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.xvhx.demo.callable.CallableOperation;
import com.example.xvhx.demo.service.AsyncTaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncCallableFibonacciController {

	private final AsyncTaskService asyncTaskService;

	@Autowired
	private ObjectFactory<CallableOperation> callableOperationProvider;

	public AsyncCallableFibonacciController(AsyncTaskService asyncTaskService) {
		this.asyncTaskService = asyncTaskService;
	}

	@GetMapping("/fibonacci/{number}")
	public Callable<Integer> executeSlowTask(@PathVariable Integer number) {

		log.info("Request received");

		number = number > 10 ? 10 : number;

		CallableOperation co = callableOperationProvider.getObject();
		co.setNumber(number);
		Callable<Integer> callable = co;

		log.info("Servlet thread released");

		return callable;
	}

	private static int globalNumber = 0;

	@GetMapping("/fibonacci")
	public Callable<Integer> executeSlowTask2() {

		log.info("Request received");
		
		globalNumber = ++globalNumber > 10 ? 10 : globalNumber;

		CallableOperation co = callableOperationProvider.getObject();
		co.setNumber(globalNumber);
		Callable<Integer> callable = co;

		log.info("Servlet thread released");

		return callable;
	}
}