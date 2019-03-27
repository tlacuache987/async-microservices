package com.example.xvhx.demo.callable;

import java.util.concurrent.Callable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.xvhx.demo.service.AsyncTaskService;

import lombok.Setter;

@Component
@Scope("prototype")
public class CallableOperation implements Callable<Integer> {

	private @Setter Integer number;
	private final AsyncTaskService asyncTaskService;

	public CallableOperation(AsyncTaskService asyncTaskService) {
		this.asyncTaskService = asyncTaskService;
	}

	@Override
	public Integer call() throws Exception {
		return asyncTaskService.execute(number);
	}

}
