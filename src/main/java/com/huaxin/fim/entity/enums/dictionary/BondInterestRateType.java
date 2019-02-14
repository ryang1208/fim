package com.huaxin.fim.entity.enums.dictionary;

public enum BondInterestRateType {
	
	// 1:浮动利率
	FLOATING_INTESTERST_RATE(1),
	// 2:固定利率
	FIXED_INTESTERST_RATE(2),
	// 3:累进利率
	PROGRESSIVE_INCREASE_INTESTERST_RATE(3);
	
	private int intValue;

	private BondInterestRateType(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
