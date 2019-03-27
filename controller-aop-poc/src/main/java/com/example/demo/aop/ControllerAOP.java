package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.context.ContextData;
import com.example.demo.context.model.RedisData;

import lombok.SneakyThrows;

@Aspect
@Component
public class ControllerAOP {

	private ContextData<?> contextData;

	public ControllerAOP(ContextData<?> contextData) {
		this.contextData = contextData;
	}

	@SneakyThrows
	@Around("execution( * *.*(..)) and (within(@org.springframework.stereotype.Controller *) or within(@org.springframework.web.bind.annotation.RestController *))")
	public Object controllerMethod(ProceedingJoinPoint pjp) {

		pjp.getArgs()[0] = (RedisData) contextData.getContext();

		return pjp.proceed(pjp.getArgs());
	}

}
