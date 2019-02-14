package com.huaxin.fim.entity.enums;
/**
 * 买卖方向定义
 * @Description:TODO
 * @author lihuijun
 *
 * @date:  2017年3月10日 下午4:15:32
 *
 */
public enum CFMMCBSFlagEnum {

	// 买
	BUY("B"),
	// 卖
	SELL("S");

	private String intValue;

	private CFMMCBSFlagEnum(String intValue) {

		this.intValue = intValue;
	}

	public String getIntValue() {
		return intValue;
	}

}
