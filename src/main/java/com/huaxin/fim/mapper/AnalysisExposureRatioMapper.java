package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算敞口指标
 * 
 * @author liumd
 *
 */
public interface AnalysisExposureRatioMapper {

	/**
	 * 计算累计净值及单位净值（产品每日统计表）
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculatExposureRatioByPeriod(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);


}
