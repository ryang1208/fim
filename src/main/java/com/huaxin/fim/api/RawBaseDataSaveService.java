package com.huaxin.fim.api;

import com.dev.framework.core.annotation.Gateway;

/**
 * 原始基础数据存储
 * @author xieky
 *
 */
@Gateway
public interface RawBaseDataSaveService {

	//投资者资金表保存
	public int saveAccountCapital();
	
	//投资者出入金
	public int saveMoneyIo();
	
	//持仓汇总
	public int savePositionSummary();
	
	//成交汇总
	public int saveTransactionSummary();
	
	//品种汇总
	public int saveVarietySummary();
	
	//成交明细
	public int saveTransactionDetails();
	
	//平仓明细
	public int savePositionCloseDetails();
	
	//持仓明细
	public int savePositionDetails();
	
	//产品净值表
	public int saveProductNetValue();
	
}
