package com.example.xvhx.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.xvhx.demo.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncDeferredController {

	private final TaskService taskService;

	public AsyncDeferredController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/deferred")
	public DeferredResult<String> executeSlowTask() {

		log.info("Request received");

		DeferredResult<String> deferredResult = new DeferredResult<>();

		CompletableFuture.supplyAsync(taskService::execute)
				.whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

		log.info("Servlet thread released");

		return deferredResult;
	}
}