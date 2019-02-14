package com.huaxin.fim.entity.enums.dictionary;
/*
 * 盘型
 */
public enum GrowthValueTypeEnum {
	// 1 价值股;
	VALUE_STOCK("1"),
	// 2 平衡股;
	BALANCE_STOCK("2"),
	// 3 成长股
	GROWTH_STOCK("3");
	
	private String stringValue;

	private GrowthValueTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
