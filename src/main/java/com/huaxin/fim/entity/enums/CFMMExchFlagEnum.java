package com.huaxin.fim.entity.enums;

public enum CFMMExchFlagEnum {

	//上期所
	S("S"),
	// 郑商所
	Z("Z"),
	//大商所
	D("D"),
	//中金所
	J("J"),
	//上海能源交易中心
	N("N");

	private String intValue;

	private CFMMExchFlagEnum(String intValue) {

		this.intValue = intValue;
	}

	public String getIntValue() {
		return intValue;
	}

}
