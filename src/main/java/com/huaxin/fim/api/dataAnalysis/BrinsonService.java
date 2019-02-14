package com.huaxin.fim.api.dataAnalysis;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

/**
 * brinson相关指标计算接口
 * 
 * @author liumd
 *
 */

@Gateway
public interface BrinsonService {

	/**
	 * 获取基准收益率
	 * 
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculateBaseYieldRate(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 获取基准权重
	 *
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculateBaseWeight(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算组合权重
	 *
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculatePortfolioWeight(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 计算组合收益率
	 *
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculatePortfolioYield(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 配置收益率
	 *
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculateSettingYieldRatio(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 选股收益率(030075/030116)
	 * @param KPI
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateChoiceYieldRatio(String KPI, String beginDate, String endDate, String productId);


	/**
	 * 交叉收益率(
	 * @param KPI
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateCrossYieldRatio(String KPI, String beginDate, String endDate, String productId);


	/**
	 * 超额收益率指标计算(030073/030118)
	 * @param KPI
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @return
	 */
	public Map<String,Object> calculateExcessearningsYieldRatio(String KPI, String beginDate, String endDate, String productId);


	/**
	 *  brinson相关指标(030059/030119/030060/030120/030061/030121/030062/030122)
	 * @param KPI
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateBrinsonKpi(String KPI, String beginDate, String endDate, String productId);

	/**
	 * 计算盘行成长价值指标
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public Map<String,Object> calculateValueGrowth(String kpiCode, String beginDate, String endDate, String productId);
	
	
}
