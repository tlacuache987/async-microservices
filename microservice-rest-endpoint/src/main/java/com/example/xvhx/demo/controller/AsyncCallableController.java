package com.example.xvhx.demo.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xvhx.demo.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncCallableController {

	private final TaskService taskService;

	public AsyncCallableController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/callable")
	public Callable<String> executeSlowTask() {

		log.info("Request received");

		Callable<String> callable = taskService::execute;

		log.info("Servlet thread released");

		return callable;
	}
}