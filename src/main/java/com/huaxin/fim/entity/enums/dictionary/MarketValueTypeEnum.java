package com.huaxin.fim.entity.enums.dictionary;
/*
 * 市值分类
 */
public enum MarketValueTypeEnum {
	// 1 超大市值
	HUGE_MARKET_VALUE("1"),
	// 2 大市值
	LARGE_MARKET_VALUE("2"),
	// 3 中市值
	MEDIUM_MARKET_VALUE("3"),
	// 4 小市值
	SMALL_MARKET_VALUE("4");
	
	private String stringValue;

	private MarketValueTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
