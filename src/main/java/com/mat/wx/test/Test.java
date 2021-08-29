package com.mat.wx.test;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mat.wx.api.TemplateTool;
import com.mat.wx.api.WxUserTool;
import com.mat.wx.config.JdbcConfig;
import com.mat.wx.util.WeChatUtil;

@Component
@EnableConfigurationProperties(JdbcConfig.class)
public class Test {
	
	private static String url;
	
	public static void main(String[] args) {
		WeChatUtil.getAccessToken();
		WeChatUtil.getAccessToken();
		System.out.println();
		WxUserTool wx=new WxUserTool();
		System.out.println(WxUserTool.getUserInfo());	
		
		try {
			TemplateTool.getAccountIndustry();
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static String  get() {
		return url;
	}

	
}
