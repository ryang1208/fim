package com.huaxin.fim.entity.enums;

public enum UploadFileType {
	
	XLS(0),//xls文件类型
	ZIP(1),//压缩文件类型
	TXT(2);
	
	private int uploadFileType;

	private UploadFileType(int uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

	public int getUploadFileType() {
		return uploadFileType;
	}

	public void setUploadFileType(int uploadFileType) {
		this.uploadFileType = uploadFileType;
	}

}
