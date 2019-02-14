package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品年化指标统计数据计算
 * 
 * @author liumd
 *
 */
public interface ProductPeriodStatisticsMapper {

	/**
	 * 删除
	 * @param request
	 */
	public void delProductPeriodStatistics(@Param("request") KPICalculationRequest request);


	/**
	 * 获取计算年化收益率数据样本
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getYieldForYearYieldRatio(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	
	/**
	 * 获取计算收益率标准差、上行标准差、下行标准差数据样本
	 * @param request
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getYieldListForSTD(@Param("request") KPICalculationRequest request);

}

