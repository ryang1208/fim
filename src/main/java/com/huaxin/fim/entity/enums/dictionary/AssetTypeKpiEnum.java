package com.huaxin.fim.entity.enums.dictionary;
/*
 * 资产类型（资产配置指标计算）
 */
public enum AssetTypeKpiEnum {
	// 1 产品投资
	ProductInvestment("01"),
	// 2 股票
	Stock("02"),
	// 3 商品期货&期权
	ProductFuture("03"),
	// 4 股指期货
	StockIndex("04"),
	// 5 期权
	Option("05"),
	// 6 债券
	Bonds("06"),
	// 7 基金
	Fund("07"),
	// 8 股权投资
	EquityInvestment("08"),
	// 9 期货账户可用资金
	FutureAvailableMoney("09"),
	// 10 股票账户可用资金
	StockAvailableMoney("10"),
	// 11期权账户可用资金
	OptionAvailableMoney("11"),
	// 12现金管理类
	CashManagement("12"),
	// 0 其他
	Other("13");
	
	private String stringValue;

	private AssetTypeKpiEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
