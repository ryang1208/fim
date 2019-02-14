package com.huaxin.fim.entity.sy.enums;

/**
 * 微信用户状态
 * @author konglingqi
 */
public enum WechatUserStatusEnum {
	
	UNREGISTERED("2"), // 未注册
	REGISTERED("1"),// 已注册
	BOUNDED("0");// 已绑定
	
	private String stringValue;
	
	private WechatUserStatusEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
