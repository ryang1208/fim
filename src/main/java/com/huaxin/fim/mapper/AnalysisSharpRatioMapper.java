package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductDailyKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Sharp率指标计算
 * 
 * @author liumd
 *
 */
public interface AnalysisSharpRatioMapper {
	
	
	/**
	 * 交易天数指标计算
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatTradingDaysByPeriod(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * Sharp率指标计算(产品每日)
	 *
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculatSharpRatioByPeriod(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 收益率标准差指标计算
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatYieldRatioStandardDeviation(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	/**
	 * 每5日波动率
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatYieldRatioStandardDeviationFive(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 年化波动率指标计算
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatYearVolatilityRatio(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * Sortino比率指标计算(产品每日)
	 *
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculatSortinoRatioByPeriod(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * Calmar比率指标计算(产品每日)
	 *
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculatCalmarRatioByPeriod(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 平均收益率标准差指标计算
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatYieldRatioStandardDeviationAverage(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	/**
	 * 偏度值
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatSkewness(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	/**
	 *  计算峰度值
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatKurtosis(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 水下最大回撤恢复周期天数
	 *
	 * @return
	 */
	public List<ProductDailyKPIStatistics> underWaterRecoverWeek(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
}
