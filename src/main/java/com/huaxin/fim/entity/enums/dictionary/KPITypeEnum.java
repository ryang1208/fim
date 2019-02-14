package com.huaxin.fim.entity.enums.dictionary;

public enum KPITypeEnum {
	//指标类别
	//0:不分类
	All(0),
	// 1:净值;
	NetValue(1),
	//2:结算单;
	SettlementSheet(2);
	
	private int intValue;

	private KPITypeEnum(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
