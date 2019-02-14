package com.huaxin.fim.entity.enums.dictionary;

public enum RiskValueRatioEnum {
	//风险价值百分比
	NinetyNine("1"),
	ninetyFive("2");
	
	private String intValue;

	private RiskValueRatioEnum(String intValue) {

		this.intValue = intValue;
	}
	public String getStringValue() {
		return intValue;
	}
}
