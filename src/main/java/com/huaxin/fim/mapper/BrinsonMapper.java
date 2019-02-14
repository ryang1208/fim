package com.huaxin.fim.mapper;


import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.ProductIndustryPeriodStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * brinson相关指标计算
 * 
 * @author liumd
 *
 */
public interface BrinsonMapper {


	/**
	 * 删除产品行业周期统计表
	 */
	public void delIndustryPeriod(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 计算基准收益率
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateBaseYieldRate(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算基准权重
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateBaseWeight(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算组合权重
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculatePortfolioWeight(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算组合收益率
	 * @return
	 */
	public List<PositionSummary> calculatePortfolioYield(
            @Param("request") KPICalculationRequest request);

	/**
	 * 配置收益率
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateSettingYieldRatio(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);
	/**
	 * 选股收益率
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateChoiceYieldRatio(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);
	/**
	 * 交叉收益率
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateCrossYieldRatio(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);
	/**
	 * 超额收益率
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> calculateExcessearningsYieldRatio(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * brinosn（配置：030074，选股：030075，交叉：030076，超额：030073）
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateBrinsonKpi(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算各盘行价值成长指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateValueGrowth(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);


}

