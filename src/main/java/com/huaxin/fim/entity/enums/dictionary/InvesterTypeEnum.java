package com.huaxin.fim.entity.enums.dictionary;
/*
 * 市场类型
 */
public enum InvesterTypeEnum {
	// 1 期货;
	FUTURE("1"),
	// 2 证券;
	SECURITY("2"),
	// 3 外盘
	FOREIGNE_QUITY_MARKET("3"),
	// 4 信用
	CREDIT("4"),
	// 5 黄金
	GOLD_FURTURE("5"),
	// 6 证券期权
	SECURITY_OPTIONS("6"),
	// 7 现货
	SPOT_FUTURE("7"),
	// 债券
	BOND("8");
	
	private String stringValue;

	private InvesterTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
