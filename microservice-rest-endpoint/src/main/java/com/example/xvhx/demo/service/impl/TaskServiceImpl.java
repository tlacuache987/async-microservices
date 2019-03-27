package com.example.xvhx.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.xvhx.demo.service.TaskService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

	@Override
	@SneakyThrows
	public String execute() {
		log.info("Starting slow task");
		Thread.sleep(5000);
		log.info("Slow task executed!");
		return "Task finished";
	}

}
