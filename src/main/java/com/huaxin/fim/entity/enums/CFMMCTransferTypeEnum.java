package com.huaxin.fim.entity.enums;

/**
 * 出入金类型定义
 * @Description:TODO
 * @author lihuijun
 *
 * @date:  2017年3月10日 下午4:15:08
 *
 */
public enum CFMMCTransferTypeEnum {

	//正常出入金
	ZERO("0"),
	// 换汇产生的出入金
	ONE("1"),
	//手工调整出入金
	TWO("2");

	private String intValue;

	private CFMMCTransferTypeEnum(String intValue) {

		this.intValue = intValue;
	}

	public String getIntValue() {
		return intValue;
	}

}
