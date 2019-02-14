package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import org.apache.ibatis.annotations.Param;


public interface ProductFactorPeriodKPIStatisticsMapper {
	
	public void deleteProrductFactorPeriod(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);
	
}
