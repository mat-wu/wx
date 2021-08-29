package com.mat.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mat.wx.api.WxUserTool;
import com.mat.wx.config.Appconfig;
import com.mat.wx.config.JdbcConfig;
import com.mat.wx.controller.JdbcController;
import com.mat.wx.test.Test;


@SpringBootApplication
public class WxApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WxApplication.class, args);
		System.out.println("*************************8");
		System.out.println("url:"+Test.get());
		
	}

}
