package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.CustomParameter;
import com.huaxin.fim.entity.entity.IndexInfo;
import com.huaxin.fim.entity.enums.PeriodTypeEnum;

@Gateway
public interface ProductIndexPeriodKPIStatisticsService {

	/**
	 * 计算产品M2测度
	 */
	public Map<String,Object> calculateM2Measure(String kpiCode, String beginDate, String endDate,
												 String productId, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes);

	/**
	 * 计算詹森alpha值
	 */
	public Map<String,Object> calculateAlphaValue(String KPI, String start_date, String end_date,
                                                  String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes);

	/**
	 * 计算择时能力
	 */
	public Map<String,Object> calculateTMModel(String KPI, String start_date, String end_date,
                                               String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes);

	/**
	 * 计算收益率相关系数及截距(正/负向)
	 */
	public Map<String,Object> calculateYieldCorrelationCoefficientByKPI(String KPI, String start_date,
                                                                        String end_date, String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes);

	/**
	 * 计算beta
	 */
	public Map<String,Object> calculateBetaValue(String KPI, String start_date, String end_date,
                                                 String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes);

	/**
	 * 计算年化跟踪误差
	 */
	public Map<String,Object> calculateTrackingError(String KPI, String start_date, String end_date,
                                                     String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes, CustomParameter cp);

	/**
	 * 计算年化特雷诺
	 */
	public Map<String,Object> calculateTreynorPerformanceMeasure(String KPI, String start_date, String end_date,
                                                                 String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes, CustomParameter cp);

	/**
	 * 计算年化信息比率
	 */
	public Map<String,Object> calculateInformationRatio(String KPI, String start_date, String end_date,
                                                        String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes, CustomParameter cp);

	/**
	 * 计算beta（历史及最新记录表）
	 */
	public Map<String,Object> calculateBetaValueHistory(String KPI, String start_date, String end_date,
                                                        String product_id, String isStatPeriod, List<IndexInfo> basicIndexs, List<PeriodTypeEnum> statPeriodTypes, CustomParameter cp);
	
}
