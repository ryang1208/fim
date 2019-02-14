package com.huaxin.fim.entity.enums;

public enum EntityType {
	//资产类型
	INVESTERFUND(1),
	//成交汇总
	TRANSACTION_SUMMARY(2),
	//持仓汇总
	POSITION_SUMMARY(3),
	//品总汇总
	VARIETY_SUMMARY(4), 
	//成交明细
	TRANSACTION_DETAILS(5),
	//平仓明细
	POSITION_CLOSED_ETAILS(6),
	//持仓明细
	POSITION_DETAILS(7),
	//资产类型
	PRODUCT_NETVALUE(8);

	private int entityType;

	private EntityType(int entityType) {

		this.entityType = entityType;
	}

	public int getEntityType() {
		return entityType;
	}

	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}

}
