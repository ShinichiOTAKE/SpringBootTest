package com.example.runtimesystem.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.runtimesystem.dtos.request.InvokeEventDto;
import com.example.runtimesystem.dtos.response.TransformableJson;
import com.example.runtimesystem.dtos.response.impl.Test0001ResponseDto;
import com.example.runtimesystem.dtos.response.impl.Test0002ResponseDto;
import com.example.runtimesystem.dtos.response.impl.TestChildDto;

@RestController
@RequestMapping("/test/{screenId}/{elementId}/{eventName}")
public class BizAppTestController {

	@GetMapping
	public ResponseEntity<TransformableJson> GetJsonResource(InvokeEventDto invokeEvent) {
		
		var aaa = new Test0001ResponseDto();
		aaa.setKey(777);
		aaa.setValue("xyz");
		
		aaa.setChildren(new ArrayList<TestChildDto>());
		for (int i = 1; i <= 10; i++) {
			var bbb = new TestChildDto();
			bbb.setNo(i);
			if ((i % 2) == 0) {
  			    bbb.setOverWork(true);
			}
			else {
				bbb.setOverWork(false);
			}
			aaa.getChildren().add(bbb);
		}
		
		aaa.setEmptyList(new ArrayList<String>());
		
		aaa.setMaps(new HashMap<String, String>());
		aaa.getMaps().put("screenId : ", invokeEvent.getScreenId());
		aaa.getMaps().put("elementId", invokeEvent.getElementId());
		aaa.getMaps().put("eventName", invokeEvent.getEventName());
		
		return new ResponseEntity<>(aaa, HttpStatus.OK);
	}
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<TransformableJson> createOrReaplaceResource(
			InvokeEventDto invokeEvent,
			@RequestParam Map<String, String> keys,
			@RequestBody String json) {
		
		var aaa = new Test0002ResponseDto(new HashMap<String, String>());
		
		aaa.getMap().put("screenId", invokeEvent.getScreenId());
		aaa.getMap().put("elementId", invokeEvent.getElementId());
		aaa.getMap().put("eventName", invokeEvent.getEventName());
		
		keys.forEach((key, value) -> aaa.getMap().put(key, value));
		
		aaa.getMap().put("json", json);
		
		return new ResponseEntity<>(aaa, HttpStatus.OK);
	}
}
