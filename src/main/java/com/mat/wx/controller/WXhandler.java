package com.mat.wx.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mat.wx.util.AuthSignature;
import com.mat.wx.util.WeChatService;
import com.mat.wx.util.WeChatUtil;


@RestController
@RequestMapping("/wx")
public class WXhandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Value("${wx.token}")  
	private  static String token="mat_wx123";
	
	
	@GetMapping(value = "/wechat2")
	public String authGet(@PathVariable Integer agentId,
	                      @RequestParam(name = "msg_signature", required = false) String signature,
	                      @RequestParam(name = "timestamp", required = false) String timestamp,
	                      @RequestParam(name = "nonce", required = false) String nonce,
	                      @RequestParam(name = "echostr", required = false) String echostr) {
		System.out.println("****************wechat2*******************:"+new Date());
		
		this.logger.info("\n接收到来自微信服务器的认证消息：signature = [{}], timestamp = [{}], nonce = [{}], echostr = [{}]",
	        signature, timestamp, nonce, echostr);

	    if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
	      throw new IllegalArgumentException("请求参数非法，请核实!");
	    }
	    if(AuthSignature.authSign(token, timestamp, nonce).equals(signature)){
	    	return echostr;
	    }
	    
	    
	    
	   System.out.println("\n接收到来自微信服务器的认证消息：signature ="+signature+", timestamp ="+timestamp+", nonce = "+nonce+", echostr ="+ echostr);
  

	    return "非法请求";
	  }
	
	@GetMapping(value = "/wechat")
    public String validate(@RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp, 
            @RequestParam(value = "nonce") String nonce,
            @RequestParam(value = "echostr") String echostr) {
		System.out.println("***********************wechat*************8");
		System.out.println("***********************wechat*************:"+new Date());
        return WeChatUtil.checkSignature(signature, timestamp, nonce,token) ? echostr : null;

    }
	
	/**
     * 此处是处理微信服务器的消息转发的
     */
    @PostMapping(value = "/wechat")
    public String processMsg(HttpServletRequest request) {
        // 调用核心服务类接收处理请求
    	System.out.println("***********************processMsg*************:"+new Date());
        return WeChatService.processRequest(request);        
    }

}
