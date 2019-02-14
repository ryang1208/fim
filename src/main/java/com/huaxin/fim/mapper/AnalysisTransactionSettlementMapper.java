package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.Classify;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodVarietyKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisTransactionSettlementMapper {
	
	/**
	 * 对应AnalysisTransactionSettlementMapper.xml文件
	 * @return
	 */
	
	public List<ProductPeriodVarietyKPIStatistics> findDaysVarietyTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findDaysVarietyArbitrageTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysPeriodArbitrageTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysPeriodClassifyArbitrageTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysPeriodHedgingTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysPeriodTurnoverList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysPeriodNetWorthList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findDaysCloseLotsList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findCloseProfitList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findCloseProfitMarketList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findPeriodRiskReturnRateList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodVarietyKPIStatistics> findTransactionVarietyLotsList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

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
