package com.huaxin.fim.entity.enums;
/*
 * 鑫管家接口确认标记
 */
public enum ConfirmTypeEnum {
	//全部
	ALL(""),
	//已确认
	CONFIRMED("1"),
	//未确认
	UNCONFIRMED("0");

	private String confirmType;

	private ConfirmTypeEnum(String confirmType) {

		this.confirmType = confirmType;
	}

	public String getValue() {
		return confirmType;
	}
}
