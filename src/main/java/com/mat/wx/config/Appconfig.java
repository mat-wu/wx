package com.mat.wx.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix="wx")
public class Appconfig {
  /**
   * 设置企业微信的corpId
   */
  private String openid;
  private String token;
  private String name;

public String getOpenid() {
	return openid;
}

public void setOpenid(String openid) {
	this.openid = openid;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
