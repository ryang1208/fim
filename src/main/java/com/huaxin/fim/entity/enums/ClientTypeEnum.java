package com.huaxin.fim.entity.enums;

/**
 * 份额文件导入客户类型枚举
 * @author liumd
 *
 */
public enum ClientTypeEnum {

	// 个人
	Personal("1"),
	// 机构
	Organization("2");
	private String  value;

	private ClientTypeEnum(String value) {

		this.value = value;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
