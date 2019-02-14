package com.huaxin.fim.entity.enums;

/**
 * 综合排名基础配置表数据计算类型
 * @author liumd
 *
 */
public enum CalculateTypeEnum {
	
	//源数据
	ORIGIN_DATA("0"),
	//加权
	WEIGHT_DATA("1"),
	//平均值
	AVERAGE_DATA("2");

	private String stateType;

	private CalculateTypeEnum(String stateType) {

		this.stateType = stateType;
	}

	public String getStateType() {
		return stateType;
	}
}
