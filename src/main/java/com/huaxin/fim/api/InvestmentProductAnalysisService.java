package com.huaxin.fim.api;


import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.InvestmentProductAnalysisRequest;
import com.huaxin.fim.entity.response.InvestmentProductAnalysisResponse;

/**
 * 投顾产品数据分析业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface InvestmentProductAnalysisService {
	
	/**
	 * 获取投顾产品数据分析结果集
	 * @param fundRequest
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<InvestmentProductAnalysisResponse> getInvestmentProductFundList(InvestmentProductAnalysisRequest fundRequest,
																						 FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);
	
	/**
	 * 导出投顾产品数据分析结果集
	 * @param fundRequest
	 * @return
	 */
	public List<InvestmentProductAnalysisResponse> exportInvestmentProductFundList(InvestmentProductAnalysisRequest fundRequest);
	
}
