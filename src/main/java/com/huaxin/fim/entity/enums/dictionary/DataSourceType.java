package com.huaxin.fim.entity.enums.dictionary;

public enum DataSourceType {
	
	// 0:QDIAM系统接口
	QDIAM_API(0),
	// 1:保证金中心结算单;
	CFMMC_SETTLEMENT(1),
	//2:QDIAM结算单;
	QDIAM_SETTLEMENT(2),
	//3:CTP柜台结算单;
	CTP_SETTLEMENT(3),
	//4:手工录入
	MANUAL_RECORD(4),
	//5:CTP接口
	CTP_INTERFACE(5),
	//6:国信鑫管家基金托管系统
	GX_XIN(6),
	//7:期货公司保证金中心(期货公司txt)
	CFMMCTxt(7),
	//8:CTP结算单接口导入;
	CTP_FROM_QDIAM(8),
	//9:估值表导入;
	VALUATION_TABLE(9),
	//10:系统计算;
	SYSTEM_CALCULATE(10),
	//11:邮件导入(或指定目录）
	MAIL_IMPORT(11),
	//12:鑫托管平台结算数据
	XIN_SETTLEMENT(12),
	//13:鑫托管平台估值数据
	XIN_VALUATOIN_TABLE(13),
	//14:N世界平台结算数据
	N_SETTLEMENT(14),
	//15:N世界平台估值数据
	N_VALUATION_TABLE(15);

	private int intValue;

	private DataSourceType(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

    /**
     * 判断是否是估值数据来源
     * @param dataSource
     * @return
     */
	public static Boolean isValuation(int dataSource){
		return  dataSource == VALUATION_TABLE.getIntValue() || dataSource == XIN_VALUATOIN_TABLE.getIntValue() || dataSource == N_VALUATION_TABLE.getIntValue();
	}

    /**
     * 判断是否是结算单数据来源
     * @param dataSource
     * @return
     */
	public static Boolean isSettlement(int dataSource){
		return  dataSource == CFMMC_SETTLEMENT.getIntValue() || dataSource == QDIAM_SETTLEMENT.getIntValue() ||
				dataSource == CTP_SETTLEMENT.getIntValue() || dataSource == MANUAL_RECORD.getIntValue() ||
				dataSource == CTP_INTERFACE.getIntValue() || dataSource == GX_XIN.getIntValue() ||
				dataSource == CFMMCTxt.getIntValue() || dataSource == CTP_FROM_QDIAM.getIntValue() ||
				dataSource == MAIL_IMPORT.getIntValue() || dataSource == QDIAM_API.getIntValue() ||
				dataSource == XIN_SETTLEMENT.getIntValue() || dataSource == N_SETTLEMENT.getIntValue();
	}
}
