package com.huaxin.fim.entity.enums.dictionary;

public enum RiskValuePeriodEnum {
	//风险价值周期类型
	FiveDay("1"),
	TenDay("2"),
	TwentyDay("3");
	
	private String intValue;

	private RiskValuePeriodEnum(String intValue) {

		this.intValue = intValue;
	}

	public String getStringValue() {
		return intValue;
	}

}
