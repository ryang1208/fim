package com.huaxin.fim.entity.enums;

public enum ProportionTypeEnum {
	//母基金占子基金比例
	ParentProportion("1"),
	//子基金占母基金比例
	ChildProportion("2");
	

	private String value;

	private ProportionTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
