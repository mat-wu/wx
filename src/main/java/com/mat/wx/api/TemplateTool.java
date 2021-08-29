package com.mat.wx.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mat.wx.util.HttpUtil;
import com.mat.wx.util.WeChatUtil;

public class TemplateTool {
	//
	private static String setIndustryUrl="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	private static String getIndustryUrl="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
	private static String postTemplateUrl= "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	/*
	 * 设置公众号行业
	 * 
	 */
	public static void setAccountIndustry() throws ParseException, IOException {
		String accessToken=WeChatUtil.getAccessToken();
		String url=setIndustryUrl.replace("ACCESS_TOKEN", accessToken);
		Map<String, String> industry=new HashMap<>();
		industry.put("industry_id1", "2");
		industry.put("industry_id2", "8");
		JSONObject jsonIndustry=JSONObject.parseObject(JSON.toJSONString(industry));
		HttpUtil.postJson(url, jsonIndustry, "UTF-8");
	}
	
	/*
	 * 获取公众号行业信息
	 * 
	 */
	public static void getAccountIndustry() {
		String accessToken=WeChatUtil.getAccessToken();
		String url=getIndustryUrl.replace("ACCESS_TOKEN", accessToken);
		System.out.println(HttpUtil.getHttp(url));
		
	}
	
	/*
	 *  发送模板消息
		接口调用请求说明
		http请求方式: POST https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
	 */
	
	public static void postTemplate() {
		String accessToken=WeChatUtil.getAccessToken();
		String url=postTemplateUrl.replace("ACCESS_TOKEN", accessToken);
		String data="{\"touser\":\"oXzQo61HCwKxu6XY9mjyYkokE7-A\",\"template_id\":\"gguX2TPAz6vnU-ImJAl1Cb8uCZA_vIxzmg90VlbZhWo\",\"data\":{\"first\":{\"value\":\"恭喜你购买成功！\",\"color\":\"#173177\"},\"product\":{\"value\":\"一条街\",\"color\":\"#173177\"},\"price\":{\"value\":\"39878.87元\",\"color\":\"#173177\"},\"time\":{\"value\":\"2021-08-29 01:12:34\",\"color\":\"#173177\"},\"remark\":{\"value\":\"欢迎再次购买！\",\"color\":\"#173177\"}}}";
			

		JSONObject json=JSONObject.parseObject(data);	
		try{
		HttpUtil.postJson(url, json, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
