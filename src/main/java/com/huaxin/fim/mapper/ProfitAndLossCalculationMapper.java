package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算累计盈利及累计亏损指标
 * @author liumd
 *
 */
public interface ProfitAndLossCalculationMapper {

	/**
	 * 计算累计盈利及亏损指标
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateTotalProfitOrLossByPeriod(
            @Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	public void deleteStatDateAndProductIDAndKPI(@Param("profitAndLossCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

}
