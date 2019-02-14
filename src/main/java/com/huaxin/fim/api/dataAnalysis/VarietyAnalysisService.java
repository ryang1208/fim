package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductPeriodVarietyKPIStatistics;

/**
 * 基金筛选--品种分析业务处理接口
 * 
 * @author liumd
 *
 */

@Gateway
public interface VarietyAnalysisService {

	/**
	 * 计算品种累计盈利及亏损
	 * 
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Map<String,Object> calculateVarietyProfitOrLoss(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算品种累计盈利及亏损
	 *
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Map<String,Object> calculateTotalOffsetLots(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算品种累计盈利及亏损
	 *
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Map<String,Object> calculateTotalProfitOffsetLots(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算品种胜率
	 *
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public  Map<String,Object> calculateWinRatio(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算品种成交额
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateVarietyTurnOver(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算债券类型市值
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateProductBondTypeMarketValue(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算债券利率类型市值
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateBondInterestRatePeriod(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 产品品种统计表中计算1月、3月等字段数据
	 * @param list
	 * @param period
	 * @return
	 */
	@DisabledLog
	public ProductPeriodVarietyKPIStatistics calculateProductVarietyBySum(List<ProductPeriodVarietyKPIStatistics> list, ProductPeriodVarietyKPIStatistics period);

}
