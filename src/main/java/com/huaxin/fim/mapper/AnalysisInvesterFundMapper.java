package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.response.SourceListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnalysisInvesterFundMapper {
	
	/**
	 * 对应AnalysisInvesterFundMapper.xml文件
	 * @return
	 */
	
	public List<ProductPeriodKPIStatistics> findPositionList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findFiveDaysAveragePositionList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<ProductPeriodKPIStatistics> findAverageRiskList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<SourceListResponse> findInvesterFundList(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

}
