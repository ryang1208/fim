package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodVarietyKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.response.ConcentrationOnStocksResponse;
import com.huaxin.fim.entity.response.RatioResponse;
import com.huaxin.fim.entity.response.TypeSourceListResponse;
import com.huaxin.fim.entity.response.VarietyBuySellProfitResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算产品品种指标处理接口
 * 
 * @author liumd
 *
 */
public interface ProductVarietyKPIStatisticsMapper {

	/**
	 * 计算累计盈利指标（品种）
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateVarietyProfitOrLoss(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 计算累计平仓手数（品种）
	 *
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateTotalOffsetLots(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 计算累计平仓盈利手数（品种）
	 *
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateTotalProfitOffsetLots(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 计算胜率（品种）
	 *
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateWinRatio(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 *
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public int deleteVarityKpi(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);


	/**
	 * 计算品种累计收益指标
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateVarietyTotalYield(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 计算品种成交额指标
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> calculateVarietyTurnOver(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 计算股票持仓比率
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<TypeSourceListResponse> findStockWeightRatioList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 *
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> getVarietyWinRatioList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 *
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> getVarietyTotalYieldProfitList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);
	/**
	 *
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> getVarietyTotalYieldLossList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 *
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ProductPeriodVarietyKPIStatistics> getVarietyTurnoverList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 多空盈亏
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<VarietyBuySellProfitResponse> getVarietyBuySellProfitList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 多空盈利
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<VarietyBuySellProfitResponse> getVarietyProfitList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 多空亏损
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<VarietyBuySellProfitResponse> getVarietyLossList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 前十大个股
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<RatioResponse> getSecurityVarietyTenAheadMarketValue(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 前十大行业
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<RatioResponse> getSecurityVarietyFirstTenthRatio(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 期末持股集中度
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ConcentrationOnStocksResponse> getConcentrationOnStocks(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);
	
	
	
}
