package com.example.runtimesystem.dto.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface TransformableJson {

	default String toJson() throws JsonProcessingException
	{
		return new ObjectMapper().writeValueAsString(getClass());
	}
	
}