package com.huaxin.fim.entity.enums.dictionary;

/**
 * 因子分类
 * @author shenwei
 *
 */
public enum FactorTypeEnum {
	// 0:不分类
	ALL(0),
	// 1:期货类;
	FUTURE(1),
	// 2:证券类;
	STOCK(2);
	
	private int intValue;

	private FactorTypeEnum(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}
	
	public String getStringValue(){
		return "" + intValue;
	}

}
