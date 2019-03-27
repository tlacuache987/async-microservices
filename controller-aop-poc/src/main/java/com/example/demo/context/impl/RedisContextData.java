package com.example.demo.context.impl;

import org.springframework.stereotype.Component;

import com.example.demo.context.ContextData;
import com.example.demo.context.model.RedisData;

@Component
public class RedisContextData implements ContextData<RedisData> {

	@Override
	public RedisData getContext() {
		return RedisData.builder().data("some data").otherData("other data").build();
	}

}
