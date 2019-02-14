package com.huaxin.fim.entity.enums.dictionary;
/*
 * 投顾来源
 */
public enum InvestmentSourceEnum {
	// 0 业务经理录入;
	INPUT_BY_SERVICE_MANAGER("0"),
	// 1 渠道录入;
	INPUT_BY_CHANNEL_USER("1"),
	// 2 投顾录入
	INPUT_BY_INVESTER_USER("2");
	
	private String stringValue;

	private InvestmentSourceEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
