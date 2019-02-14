package com.huaxin.fim.entity.sy.enums;

/**
 * 投顾状态
 * @author xieky
 *
 */
public enum InvestmentStatusEnum {
	
	NORMAL("0"), // 1身份资料 2风险签署书 3问卷书 4银行账号资料
	CANCEL("1");
	
	private String stringValue;
	
	private InvestmentStatusEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
