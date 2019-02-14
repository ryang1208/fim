package com.huaxin.fim.entity.enums.dictionary;

public enum DataAccessFileSourceEnum {

	// 鑫管家接入_沣泛国富
	ACCESS_FROM_XIN_FF_GF("1"),
	// qdiamApi CTP文件接入
	ACCESS_FROM_QDIAM_CTP("2"),
	// 鑫管家接入_沣泛宽渡
	ACCESS_FROM_XIN_FF_QDIAM("3"),
	// 鑫管家接入_上海翼牛
	ACCESS_FROM_XIN_SH_YINIU("4"),
	// 鑫管家接入_深圳前海中宏金控
	ACCESS_FROM_XIN_SZ_QHZH("5");
	
	private String fileSource;
	
	private DataAccessFileSourceEnum(String fileSource){
		this.fileSource = fileSource;
	}

	public String getStringValue() {
		return fileSource;
	}
	
}
