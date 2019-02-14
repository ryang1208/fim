package com.huaxin.fim.entity.enums.dictionary;
/*
 * 盘型
 */
public enum StockTypeEnum {
	// 1 大盘;
	LARGE_STOCK("1"),
	// 2 中盘;
	MEDIUM_STOCK("2"),
	// 3 小盘
	SMALL_STOCK("3");
	
	private String stringValue;

	private StockTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
