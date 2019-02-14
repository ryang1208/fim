package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.response.ProductNetValueResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisProductNetValueMapper {
	
	/**
	 * 对应AnalysisProductNetValueMapper.xml文件
	 * @return
	 */
	public List<ProductNetValueResponse> findYieldRateList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findCurrentMaxNetValueList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findYearYieldRateList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);


	/**
	 * 计算当前连续上涨天数（正为上涨，负为下跌）指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateCurrentContinuousRiseDays(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算历史连续上涨（下跌）最大天数
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMaxRiseOrFailDays(
            @Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);
}
