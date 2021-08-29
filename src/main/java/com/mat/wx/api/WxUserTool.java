package com.mat.wx.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mat.wx.util.HttpUtil;
import com.mat.wx.util.WeChatUtil;

public class WxUserTool {
	private static String userInfoUrl= "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	private static String userOpenid="oXzQo61HCwKxu6XY9mjyYkokE7-A";
	/*
	 * 获取用户基本信息（包括UnionID机制）
	 * 开发者可通过OpenID来获取用户基本信息。请使用https协议。
	 * 接口调用请求说明 http请求方式: GET https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 * 
	 * */
	public static String getUserInfo() {
		String accessToken=WeChatUtil.getAccessToken();
		String url=userInfoUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", userOpenid);
		String userInfo=HttpUtil.getHttp(url);
		JSONObject jsonObject=JSONObject.parseObject(userInfo);
		System.out.println("***************userinfo*********************");
		Map< String, String> map=JSON.parseObject(userInfo,HashMap.class);
		/*for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		*/
		return userInfo;
	}
	
}
