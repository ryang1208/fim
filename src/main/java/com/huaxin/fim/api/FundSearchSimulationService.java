package com.huaxin.fim.api;


import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.FundSearchSimulationRequest;
import com.huaxin.fim.entity.response.FundSearchSimulationResponse;

/**
 * 模拟组合构建查询处理接口
 * @author liumd
 *
 */
@Gateway
public interface FundSearchSimulationService {
	
	/**
	 * 获取组合构建条件查询结果集
	 * @param fundRequest
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<FundSearchSimulationResponse> getFundSimulationList(FundSearchSimulationRequest fundRequest,
																			 FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 获取产品最新制定指标数据
	 * @param productId
	 * @return
	 */
	public Map<String,Object> getLastKpiInfo(String productId);

	/**
	 * 获取收益率图表
	 * @param productId
	 * @param periodType
	 * @return
	 */
	public Map<String,Object> getYieldList(String productId, String periodType);

	/**
	 * 获取净值回撤率图表(最大回撤)
	 * @param productId
	 * @param periodType
	 * @return
	 */
	public Map<String,Object> getDrawndownList(String productId, String periodType);
}
