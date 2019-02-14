package com.huaxin.fim.entity.sy.enums;

/**
 * 用户状态
 * @author xieky
 *
 */
public enum UserStatusEnums {
	
	NORMAL("1"), //正常
	CANCEL("0");//注销
	
	private String stringValue;
	
	private UserStatusEnums(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
