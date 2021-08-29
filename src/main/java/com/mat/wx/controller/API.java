package com.mat.wx.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mat.wx.api.TemplateTool;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class API {
	
	 private static final Logger logger  = LoggerFactory.getLogger(API.class);
	
	 @RequestMapping("/getInfo")
	 public String getInfo() {
		return "spring boot api test";
	}
	 
	 @RequestMapping("/getMap")
	 public Map<String, String> getMap() {
		 
		 logger.info("spring boot map data structure");
		 TemplateTool.postTemplate();
		 Map<String, String> map=new HashMap<>();
		 map.put("1", "matlab");
		 map.put("2", "java");
		 map.put("3", "C++");
		 map.put("4", "C#");
		 map.put("5", "javascript");
		 map.put("6", "html");		 
		 return map;
	}

}
