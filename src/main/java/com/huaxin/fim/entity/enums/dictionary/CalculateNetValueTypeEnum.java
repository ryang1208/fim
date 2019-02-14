package com.huaxin.fim.entity.enums.dictionary;
/*
 * 资产类型
 */
public enum CalculateNetValueTypeEnum {
	// 大赛算法
	CompetitionMethod("1"),
	// 标准算法
	StandardMethod("2");
	
	private String stringValue;

	private CalculateNetValueTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
