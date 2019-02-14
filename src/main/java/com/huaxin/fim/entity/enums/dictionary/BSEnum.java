package com.huaxin.fim.entity.enums.dictionary;

public enum BSEnum {
	//买卖方向
	// 0:买;
	Buy(0),
	//1:卖;
	Sell(1);
	
	private int intValue;

	private BSEnum(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
