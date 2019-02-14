package com.huaxin.fim.api.dataAnalysis;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

/**
 * 累计盈利及累计亏损指标计算接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface TotalProfitAndLossService {

	/**
	 * 计算指标累计盈利及亏损
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateTotalProfitOrLossByPeriod(String kpiCode, String beginDate, String endDate, String productId);
}
