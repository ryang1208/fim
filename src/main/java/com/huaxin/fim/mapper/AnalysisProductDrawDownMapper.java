package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisProductDrawDownMapper {
	
	/**
	 * 对应AnalysisProductDrawDownMapper.xml文件
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> findDrawDownList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);


	/**
	 * 计算水下回撤指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateUnderWaterDrawDownByPeriod(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算水下最大回撤指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMaxUnderWaterDrawDownByPeriod(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算水上回撤指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateWaterDrawDownByPeriod(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);
	/**
	 * 计算水上最大回撤指标
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMaxWaterDrawDownByPeriod(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 计算产品最大回撤（按产品周期）
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateProductDrawdownPeroid(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

}
