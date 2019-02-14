package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.FundValuation;
import com.huaxin.fim.entity.entity.ProductIndexPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.StandardDeviationYieldRate;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.request.AttributionAnalysisRequest;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.request.RiskAssessRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductPeriodKPIStatisticsMapper {

	/**
	 * 计算指标第一个日期
	 * 
	 * @param 
	 * @return
	 */
	public String getFistDate(
            @Param("productID") String ProductId, @Param("kpicode") String kpicode);


	/**
	 * 计算股票仓位
	 *
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getStockPosition(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);



	/**
	 * 累计仓位收益率
	 * @param analysisSearchRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getStockPositionYieldRateList(
            @Param("analysisSearchRequest") AnalysisSearchRequest analysisSearchRequest);

	/**
	 * 获取收益率和标准差
	 *
	 * @return
	 */
	public List<StandardDeviationYieldRate> getStandardDeviationYieldRate(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 查询M2测度
	 * @param riskAssessRequest
	 * @return
	 */
	public List<ProductIndexPeriodKPIStatistics> getM2MeasureByIndexID(
            @Param("analysisSearchRequest") RiskAssessRequest riskAssessRequest);

	/**
	 * 获取择时选股能力指标
	 * @param
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getTMModelByProductIdAndDate(
            @Param("attributionAnalysisRequest") AttributionAnalysisRequest attributionAnalysisRequest);

	/**
	 * 获取指定区间估值信息当日的托管机构
	 * @param request
	 * @return
	 */
	public List<FundValuation> getTrusteeAndDate(@Param("request") KPICalculationRequest request);

	/**
	 * 计算估值市值计算
	 * @param request
	 * @param assetType
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMarketCapitalizationFromValuation(@Param("request") KPICalculationRequest request, @Param("assetType") String assetType);
	
	/**
	 * 计算估值市值计算
	 * @param request
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateOtherMarketCapitalizationFromValuation(@Param("request") KPICalculationRequest request);
	
	/**
	 * 获取净值差额和累计净值
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> findNetValueAndDifferenceByProductId(@Param("productId") String productId);
	
}
