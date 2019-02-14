package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisProductRiskValueMapper {
	
	/**
	 * 资产基金的估值表的市值
	 * @return
	 */	
	public List<ProductPeriodKPIStatistics> rikeValueMarketValue(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 基金资产净值
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> netAssetValue(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	
}
