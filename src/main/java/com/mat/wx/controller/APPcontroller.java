package com.mat.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mat.wx.config.Appconfig;

@RestController
@RequestMapping("/appconfig")
@EnableConfigurationProperties(Appconfig.class)
public class APPcontroller {
	@Autowired
	Appconfig appconfig;

	@Value("${wx.openid}")
	private String openid;
	@Value("${wx.token}")
	private String token;
	@Value("${wx.name}")
	private String name;

	@RequestMapping("/hello")
	public String hello(){
		return "我的openid:"+openid+"!";
	}
	
	@RequestMapping("/all")
	public String all(){
		return "我的openid:"+openid+";\n token:"+token+";\n name:"+name+"!";
	}
}

