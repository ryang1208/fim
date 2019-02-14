package com.huaxin.fim.entity.sy.enums;

public enum ClientInfoPhotoEnum {
	
	ID_PIC_URL("1"), // 1身份资料 2风险签署书 3问卷书 4银行账号资料
	RISK_SIGN_PIC_URL("2"),
	QUESTION_PIC_URL("3"),
	BANK_ACCOUNT_PIC_URL("4"),
	PDF_URL("5");
	
	private String stringValue;
	
	private ClientInfoPhotoEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
