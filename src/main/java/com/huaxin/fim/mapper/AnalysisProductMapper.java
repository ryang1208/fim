package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface AnalysisProductMapper {
	
	/**
	 * 对应AnalysisProductMapper.xml文件
	 * @return
	 */	
	public List<Map<String,String>> getLossDate(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public String getCreateDate(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public void deleteProrductPeriodDateAndProductIDAndKPI(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public void deleteProrductRatingPeriodDateAndProductIDAndKPI(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public String getMinNetvalueDate(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public String getMinSettlementDate(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 获取计算指标产品最小日期及最大日期等信息
	 * @param productId
	 * @return
	 */
	public Map<String, String> getJobProductDate(@Param("productId") String productId);

	/**
	 * 获取需要计算指标的产品ID列表
	 * @return
	 */
	public List<String> getJobProductIds(@Param("productId") String productId);

	/**
	 * 获取补录综合排名的起始日期
	 * @return
	 */
	public String getMinDateFromPendingJob(@Param("productId") String productId);
}
