package com.huaxin.fim.entity.enums;

public enum ExcelFileTypeEnum {
	
	SETTLE(0),//结算单
	NETVALUE(1),//净值
	VALUATION(2);// 估值
	
	private int uploadFileType;

	private ExcelFileTypeEnum(int uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

	public int getUploadFileType() {
		return uploadFileType;
	}

	public void setUploadFileType(int uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

}
