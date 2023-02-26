package com.example.runtimesystem.dtos.response.impl;

import java.util.Map;

import com.example.runtimesystem.dtos.response.TransformableJson;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Test0002ResponseDto implements TransformableJson {

	private Map<String, String> map;

}
