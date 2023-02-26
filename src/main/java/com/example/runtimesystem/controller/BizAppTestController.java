package com.example.runtimesystem.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.runtimesystem.dto.response.TransformableJson;
import com.example.runtimesystem.dto.response.impl.Test0001ResponseDto;
import com.example.runtimesystem.dto.response.impl.TestChildDto;

@RestController
@RequestMapping("/test")
public class BizAppTestController {

	@GetMapping("/{screenId}/{elementId}/{eventId}")
	public ResponseEntity<TransformableJson> GetJsonResource(
			@PathVariable("screenId") String screenId,
			@PathVariable("elementId") String elementId,
			@PathVariable("eventId") String eventId) {
		
		var aaa = new Test0001ResponseDto();
		aaa.setKey(777);
		aaa.setValue("bbb");
		
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
		aaa.getMaps().put("xxx_key", "xxx_value");
		aaa.getMaps().put("yyy_key", "yyy_vaule");
		aaa.getMaps().put("zzz_key", "zzz_value");
		
		return new ResponseEntity<>(aaa, HttpStatus.CREATED);
	}
	
}
