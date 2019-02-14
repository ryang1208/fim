package com.huaxin.fim.entity.enums.dictionary;

public enum ImportTypeEnum {
	
	// 0：鑫管家接口
	INTERFACE(0),
	// 1:源数据导入
	ORIGIN(1),
	//2:投顾页面导入;
	INVESTMENT(2);
	
	private int intValue;

	private ImportTypeEnum(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
