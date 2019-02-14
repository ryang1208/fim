package com.huaxin.fim.entity.enums.dictionary;
/*
 * 经纪公司类型
 */
public enum TrusteeTypeEnum {
	// 1-恒生;
	HUNDSUN("1"),
	//2-赢时胜;
	YSSCTECH("2");
	
	private String stringValue;

	private TrusteeTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
