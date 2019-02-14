package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductDailyKPIStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算指标产品每日统计处理数据层接口
 * 
 * @author liumd
 *
 */
public interface ProductDailyKpiStatisticsMapper {

	/**
	 * 计算最大回撤和平均回撤（产品每日统计）
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculateProductDrawdownDaily(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);


	/**
	 * 获取产品每日统计数据
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductDailyKPIStatistics> getProductDailyList(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 删除历史记录(产品每日统计表)
	 *
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public int deleteProductNetValueDaily(
            @Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

}
