package com.mat.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mat.wx.config.JdbcConfig;

@RestController
@RequestMapping("/appconfig")
@EnableConfigurationProperties(JdbcConfig.class)
public class JdbcController {
	@Autowired
	JdbcConfig jdbcConfig;

	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.url}")
	private String url;

	@RequestMapping("/jdbc")
	public String all(){
		return "我的user:"+user+";\n password:"+password+";\n url:"+url+"!";
	}
}

