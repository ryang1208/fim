package com.huaxin.fim.api;


import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.InvestmentProductContrastAnalysisRequest;
import com.huaxin.fim.entity.response.InvestmentProductContrastAnalysisResponse;

/**
 * 同投顾产品对比分析业务处理接口
 * @author sust
 *
 */
@Gateway
public interface InvestmentProductContrastAnalysisService {
	
	/**
	 * 获取同投顾产品对比分析结果集
	 * @param fundRequest
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<InvestmentProductContrastAnalysisResponse> getInvestmentProductContrastAnalysisList(InvestmentProductContrastAnalysisRequest fundRequest,
																											 FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 导出同投顾产品对比分析结果集
	 * @param fundRequest
	 * @param columList
	 * @return
	 */
	public List<?> exportInvestmentProductContrastList(InvestmentProductContrastAnalysisRequest fundRequest, List<String> columList);
}
