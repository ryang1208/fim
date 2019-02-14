package com.huaxin.fim.entity.enums;

public enum YesOrNoEnum {
	YES("Y"), NO("N");
	private String stringValue;

	private YesOrNoEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public int getValue() {
		return Integer.parseInt(stringValue);
	}
}
