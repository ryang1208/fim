package com.huaxin.fim.entity.enums;
/**
 * 投机套保标识
 * @Description:TODO
 * @author lihuijun
 *
 * @date:  2017年3月10日 下午4:15:20
 *
 */
public enum CFMMCSHFlagEnum {

	//投机
	S("S"),
	// 套保
	H("H"),
	//套利
	A("A");

	private String intValue;

	private CFMMCSHFlagEnum(String intValue) {

		this.intValue = intValue;
	}

	public String getIntValue() {
		return intValue;
	}

}
