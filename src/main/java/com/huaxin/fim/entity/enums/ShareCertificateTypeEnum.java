package com.huaxin.fim.entity.enums;

/**
 * 份额文件导入客户证件类型枚举
 * @author liumd
 *
 */
public enum ShareCertificateTypeEnum {

	// 身份证
	IDCard("1"),
	// 营业执照
	BusinessLicense("2");
	private String  value;

	private ShareCertificateTypeEnum(String value) {

		this.value = value;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
