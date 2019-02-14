package com.huaxin.fim.mapper;


import com.huaxin.fim.entity.entity.ProductPeriodHisStatistics;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品年化指标统计历史数据计算
 * 
 * @author liumd
 *
 */
public interface ProductPeriodHisStatisticsMapper {

	/**
	 * 删除
	 * @param request
	 */
	public void delProductPeriodHisStatistics(@Param("request") KPICalculationRequest request);
	
	/**
	 * 获取计算夏普率所需数据样本（年化收益率，年化标准差）
	 * @param request
	 * @return
	 */
	public List<ProductPeriodHisStatistics> getHisStatisticsForSharp(@Param("request") KPICalculationRequest request);
	
	
}

