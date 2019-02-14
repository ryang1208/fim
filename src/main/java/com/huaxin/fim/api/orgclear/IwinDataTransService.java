package com.huaxin.fim.api.orgclear;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductInvesterRelationship;
import com.huaxin.fim.entity.entity.RawQDIAMInvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.RawQDIAMInvesterFund;
import com.huaxin.fim.entity.entity.RawQDIAMPositionCloseDetails;
import com.huaxin.fim.entity.entity.RawQDIAMPositionSummary;
import com.huaxin.fim.entity.entity.RawQDIAMProductNetValue;
import com.huaxin.fim.entity.entity.RawQDIAMTransactionDetails;
import com.huaxin.fim.entity.entity.iWinProduct;

import java.util.List;

@Gateway
public interface IwinDataTransService {
	
	/**
	 * 产品数据传输接口
	 */
	public List<iWinProduct> transIWinProduct();
	
	/**
	 * 产品对应投资者数据传输接口
	 */
	public List<ProductInvesterRelationship> transInvester(List<String> markets);
	
	/**
	 * 投资者资金数据传输接口
	 */
	public List<RawQDIAMInvesterFund> transInvesterFundDataByDate(String date, List<String> markets);
	
	/**
	 * 投资者出入金数据传输接口
	 */
	public List<RawQDIAMInvesterDepositWithdrawal> transInvesterDepositWithdrawalDataByDate(String date, List<String> markets);
	
	/**
	 * 持仓汇总数据传输接口
	 */
	public List<RawQDIAMPositionSummary> transPositionSummaryDataByDate(String date, List<String> markets);
	
	/**
	 * 成交明细数据传输接口
	 */
	public List<RawQDIAMTransactionDetails> transTransactionDetailsDataByDate(String date, List<String> markets);
	
	/**
	 * 平仓明细数据传输接口
	 */
	public List<RawQDIAMPositionCloseDetails> transPositionCloseDetailsDataByDate(String date, List<String> markets);
	
	/**
	 * 产品净值数据传输接口
	 */
	public List<RawQDIAMProductNetValue> transNetValueDataByDate(String date);
	
}
