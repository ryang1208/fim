package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.InvestmentProductContrastAnalysisRequest;
import com.huaxin.fim.entity.response.InvestmentProductContrastAnalysisResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestmentProductContrastAnalysisMapper {

	/**
	 * 查询同投顾产品比对分析
	 * @param request
	 * @return
	 */
	public List<InvestmentProductContrastAnalysisResponse> getInvestmentProductContrastAnalysisList(
			@Param("request") InvestmentProductContrastAnalysisRequest request, @Param("ids") String[] ids, @Param("investIds") String[] investIds);
}
