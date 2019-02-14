package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.AttributionAnalysisRequest;
import com.huaxin.fim.entity.response.RatioResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductFactorIndustryPeriodStatisticsMapper {
	
	public void deleteProrductFactorIndustryPeriod(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	public List<RatioResponse> getIndustrySensitivity(@Param("attributionAnalysisRequest") AttributionAnalysisRequest attributionAnalysisRequest);

	public List<RatioResponse> getIndustrySensitivityTrend(@Param("attributionAnalysisRequest") AttributionAnalysisRequest attributionAnalysisRequest);
	
}
