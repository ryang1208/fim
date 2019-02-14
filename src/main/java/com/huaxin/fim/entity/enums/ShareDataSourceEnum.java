package com.huaxin.fim.entity.enums;

/**
 * 份额文件导入数据源枚举对象
 * @author liumd
 *
 */
public enum ShareDataSourceEnum {
	// 数据导入
	IMPORT("1"),
	// 手工录入
	MANUALINPUT("2"),
	// 净值计算获得
	CALCULATENETVALUE("3");
	private String  value;

	private ShareDataSourceEnum(String value) {

		this.value = value;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
