package com.example.xvhx.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xvhx.demo.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BlockingController {

	private final TaskService taskService;

	public BlockingController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/block")
	public String executeSlowTask() {

		log.info("Request received");

		String result = taskService.execute();

		log.info("Servlet thread released");

		return result;
	}
}
