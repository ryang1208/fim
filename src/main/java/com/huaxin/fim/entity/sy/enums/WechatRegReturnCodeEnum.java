package com.huaxin.fim.entity.sy.enums;

/**
 * 微信注册时返回码
 * @author konglingqi
 */
public enum WechatRegReturnCodeEnum {
	
	SUCCESS("0"), // 保存成功
	FAILURE("1");// 保存失败
	
	private String stringValue;
	
	private WechatRegReturnCodeEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
