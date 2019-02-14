package com.huaxin.fim.entity.enums.dictionary;
/*
 * 经纪公司类型
 */
public enum BrokerTypeEnum {
	// 1-期货;
	FUTURES("1"),
	//2-证券;
	SECURITIES("2"),
	//3- 资管
	QDAMD("3");
	
	private String stringValue;

	private BrokerTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
