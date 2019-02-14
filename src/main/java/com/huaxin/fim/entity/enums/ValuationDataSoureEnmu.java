package com.huaxin.fim.entity.enums;

public enum ValuationDataSoureEnmu {
	
	EXPORT(0),//净值
	INTERFACE(2);// 估值
	
	private int value;

	private ValuationDataSoureEnmu(int uploadFileType) {
		this.value = uploadFileType;
	}

	public int getValue() {
		return value;
	}

	public void setUploadFileType(int uploadFileType) {
		this.value = uploadFileType;
	}

}
