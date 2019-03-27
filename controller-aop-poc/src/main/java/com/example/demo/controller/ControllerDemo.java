package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.context.model.RedisData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ControllerDemo {

	@GetMapping("/{name}")
	@ResponseBody
	public String hello(RedisData redisData, Model model, @PathVariable String name) {
		
		log.info("redisData: {}", redisData);
		log.info("name: {}", name);

		return "hello " + name;
	}
}
