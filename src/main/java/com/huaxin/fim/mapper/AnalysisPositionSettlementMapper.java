package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.Classify;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodVarietyKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisPositionSettlementMapper {
	
	/**
	 * 对应AnalysisPositionSettlementMapper.xml文件
	 * @return
	 */
	
	public List<ProductPeriodKPIStatistics> countMarginByPeriod(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> countMarginByVariety(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findOverNigthVarietyArbitrageMarginList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findOverNightPeriodArbitrageMarginList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findOverNightsPeriodClassifyArbitrageMarginList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findOvernightPeriodHedgingMarginList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findOverNightPeriodNetPositionList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> countOverNightOriMarginByPeriod(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> countOverNightOriMarginByVariety(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findPositonVarietyLotsList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

    //重仓股的排序
	public List<ProductPeriodVarietyKPIStatistics> AwkwardnessList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	//获取个股持仓品种市值
	public List<ProductPeriodVarietyKPIStatistics> getkwardProductPeriodVarietyKPIStatistics(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 品系
	 * @param
	 * @return
	 */
	public List<Classify> getClassify(@Param("productId") String productId, @Param("startDate") String startDate,
									  @Param("endDate") String endDate);

	public List<ProductPeriodKPIStatistics> findVaietyKPIList(@Param("productId") String productId, @Param("startDate") String startDate,
                                                              @Param("endDate") String endDate);

	public List<ProductPeriodKPIStatistics> findVaietyKPIByClassifyList(@Param("productId") String productId, @Param("startDate") String startDate,
                                                                        @Param("endDate") String endDate);

}
