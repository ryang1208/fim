package com.huaxin.fim.entity.enums.dictionary;

public enum XinRawDataSourceType {
	
	//1 沣泛国富
	FF_GF(1),
	//2 沣泛宽渡
	FF_QDIAM(2),
	//3 上海翼牛
	SH_YINIU(3),
	//4 深圳前海中宏金控
	SZ_QHZH(4),
	//5估值表导入
	EXPORT_VALUATION(5);
	
	private int intValue;

	private XinRawDataSourceType(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
