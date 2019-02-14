package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.InvestmentProductAnalysisRequest;
import com.huaxin.fim.entity.response.InvestmentProductAnalysisResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestmentProductAnalysisMapper {

	/**
	 * 查询投顾产品数据分析
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public List<InvestmentProductAnalysisResponse> getInvestmentProductFundList(
            @Param("request") InvestmentProductAnalysisRequest request,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay, @Param("ids") String[] ids);
}
