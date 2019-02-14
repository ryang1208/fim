package com.huaxin.fim.entity.enums;

/*
 * 资管同步数据类型
 */
public enum QDAMDataTypeEnum {
	// 成交
	TRADE(1),
	// 持仓
	POSITION(2),
	// 资金
	CAPITAL(3),
	//zip文件包
	ZIP(4);

	private int type;

	private QDAMDataTypeEnum(int type) {

		this.type = type;
	}

	public int getValue() {
		return type;
	}
}
