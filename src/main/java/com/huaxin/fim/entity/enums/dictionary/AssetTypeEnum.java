package com.huaxin.fim.entity.enums.dictionary;
/*
 * 资产类型
 */
public enum AssetTypeEnum {
	// 1 期货;
	FUTURE("1"),
	// 2 期权;
	OPTION("2"),
	// 3 基金
	FUND("3"),
	// 4 债券
	BOND("4"),
	// 5 股票
	STOCK("5"),
	// 6 产品投资
	PRODUCT_INVESTMENT("6"),
	// 7 股票账户可用资金
	STOCK_AVAILABLE("7"),
	// 8 股权投资
	EQUITY_INVESTMENT("8"),
	// 9 期货账户可用资金
	FUTURE_AVAILABLE("9"),
	// 10 现金管理类
	CASH("10"),
	// 0 其他
	OTHER("0");
	
	private String stringValue;

	private AssetTypeEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
