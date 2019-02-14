package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterFund;
import com.huaxin.fim.entity.entity.PositionCloseDetails;
import com.huaxin.fim.entity.entity.PositionDetails;
import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.ProductNetValue;
import com.huaxin.fim.entity.entity.TransactionDetails;
import com.huaxin.fim.entity.entity.TransactionSummary;
import com.huaxin.fim.entity.entity.VarietySummary;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.https.ResponseDetail;

/**
 * 数据解析基础类
 * @author xieky
 *
 */
@Gateway
public interface BaseDataAnalysisService {

	//投资者资金表保存
	public boolean saveInvesterFund(List<InvesterFund> list, String fileName, String parseDir);

	//投资者出入金
//	public void saveMoneyIo();
	public boolean saveMoneyIo(List<InvesterDepositWithdrawal> list, String fileName, String parseDir);

	//持仓汇总
	public boolean savePositionSummary(List<PositionSummary> list, String fileName, String parseDir);

	//成交汇总
	public boolean saveTransactionSummary(List<TransactionSummary> list, String fileName, String parseDir);

	//品种汇总
	public boolean saveVarietySummary(List<VarietySummary> list, String fileName, String parseDir);

	//成交明细
	public boolean saveTransactionDetails(List<TransactionDetails> list, String fileName, String parseDir);

	//平仓明细
	public boolean savePositionCloseDetails(List<PositionCloseDetails> list, String fileName, String parseDir);

	//持仓明细
	public boolean savePositionDetails(List<PositionDetails> list, String fileName, String parseDir);

	//产品净值表
	public boolean saveProductNetValue(List<ProductNetValue> list, String fileName, String parseDir, String productIds);

	public List<String> dataAnalysis(String str, String productIds, Integer dataSource);


	/**
	 * 根据估值表解析持仓及资金信息
	 * @param date
	 * @param p
	 * @param parseDir
	 * @param fileName
	 * @param valuationList
	 * @param importFlags
	 * @param trusteeId
	 * @return
	 */
	public boolean dealValuationTableAndMessage(String date, iWinProduct p, String parseDir, String fileName,
												List<ResponseDetail> valuationList, int importFlags, String trusteeId);
	
}
