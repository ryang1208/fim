
package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.ProductIndustryPeriodStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.request.StyleAnalysisRequest;
import com.huaxin.fim.entity.response.RatioResponse;
import com.huaxin.fim.entity.response.TypeSourceListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行业分析业务处理接口
 * 
 * @author wucq
 *
 */

public interface ProductIndustryPeriodStatisticsMapper {
	
	
	public List<PositionSummary> getStockIndustryMarket(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 *
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> getStockIndustryUpDown(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 *
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> getStockExposure(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 期货多空方总成交额（周期）
	 *
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getBuyTurnover(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);


	/**
	 * 期货净暴露（周期）
	 *
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getNetExposure(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 期货暴露比（周期）
	 *
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getExposureRatio(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 风格分析(证券)-市值配置变化
	 *
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<ProductIndustryPeriodStatistics> getStockMarketValueRatio(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 品种分析(期现)-持仓基准偏离度
	 *
	 * @return
	 */
	public List<RatioResponse> getPositionDeviationRatio(
            @Param("analysisSearchRequest") AnalysisSearchRequest varietySpotMarketAnalysisRequest);


	/**
	 * 平均净资产
	 *
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getNetasset(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 行业配置比率
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<TypeSourceListResponse> findIndustryWeightRatioList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

}
