package com.huaxin.fim.entity.sy.enums;

public enum InvestmentTypeEnums {
    
    INVESTMENT_LOG("0"); // 投顾操作日志
	
	private String stringValue;
	
	private InvestmentTypeEnums(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
