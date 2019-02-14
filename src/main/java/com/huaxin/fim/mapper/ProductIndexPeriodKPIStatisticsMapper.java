package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductIndexPeriodStatisticsHistory;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductIndexPeriodKPIStatisticsMapper {
	
	public void deleteProductIndexPeriod(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 获取年化跟踪误差指标（计算信息比率指标）
	 * @param startDate
	 * @param endDate
	 * @param productID
	 * @param KPI
	 * @param indexIDs
	 * @param periodTypes
	 * @return
	 */
	public List<ProductIndexPeriodStatisticsHistory> getTrackingErrorList(@Param("startDate") String startDate,
																		  @Param("endDate") String endDate, @Param("productID") String productID,
																		  @Param("KPI") String KPI, @Param("indexIDs") List<String> indexIDs, @Param("periodTypes") List<String> periodTypes);

	/**
	 * 删除指数指标周期统计历史表数据
	 * @param request
	 */
	public void delProductIndexPeriodStatisticsHistory(@Param("request") KPICalculationRequest request);

	/**
	 * 删除指数指标周期统计历史表数据
	 * @param request
	 */
	public void delProductIndexPeriodStatistics(@Param("request") KPICalculationRequest request);

	/**
	 * 获取beta值（计算特雷诺比率）
	 * @param startDate
	 * @param endDate
	 * @param productID
	 * @param KPI
	 * @param indexIDs
	 * @param periodTypes
	 * @return
	 */
	public List<ProductIndexPeriodStatisticsHistory> getBetaList(@Param("startDate") String startDate,
                                                                 @Param("endDate") String endDate, @Param("productID") String productID,
                                                                 @Param("KPI") String KPI, @Param("indexIDs") List<String> indexIDs, @Param("periodTypes") List<String> periodTypes);
}
