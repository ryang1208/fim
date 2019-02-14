package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.FundCompareRequest;
import org.apache.ibatis.annotations.Param;

/**
 * 基础信息查询
 * @author sust
 *
 */
public interface BasicInfoStatisticsMapper {

	/**
	 * 取得最后统计日期
	 * @return
	 */
	public String getMaxStatisticDate(
            @Param("productID") String productID);

	/**
	 * 取得最后统计日期
	 * @return
	 */
	public String getProductPeriodMaxDate(@Param("fundCompareRequest") FundCompareRequest fundCompareRequest);

	/**
	 * 取得指标最后统计日期
	 * @return
	 */
	public String getMaxStatisticDateByKPI(@Param("productIds") String[] productIds, @Param("kpiCode") String kpiCode);
}
