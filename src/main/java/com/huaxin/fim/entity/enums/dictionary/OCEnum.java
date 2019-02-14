package com.huaxin.fim.entity.enums.dictionary;

public enum OCEnum {
	//开平方向
	// 0:开;
	Open(0),
	//1:平;
	Close(1);
	
	private int intValue;

	private OCEnum(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
