package com.huaxin.fim.entity.sy.enums;

/**
 * 用户注册审核状态
 * @author konglingqi
 */
public enum RegisterClientInfoCheckEnum {
	
	CHECKED("0"), //审核通过 
	UNCHECKED("1");//未审核通过(默认不通过)
	
	private String stringValue;
	
	private RegisterClientInfoCheckEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
