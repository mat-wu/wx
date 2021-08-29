package com.mat.wx.util;

public class AccessToken {
	
	private String accessToken;
	private long expiredTime;
	
	
	public AccessToken(String accessToken, String expiredIn) {
		super();
		this.accessToken = accessToken;
		expiredTime = System.currentTimeMillis()/1000+Integer.parseInt(expiredIn)*1000;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		this.expiredTime = expiredTime;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis()>expiredTime;
	}
	
	

}
