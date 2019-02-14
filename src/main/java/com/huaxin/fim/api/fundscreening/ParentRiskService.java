package com.huaxin.fim.api.fundscreening;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.ParentAnalysisRequest;

/**
 * 母基金评价风险分析业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface ParentRiskService {

	/**
	 * 获取母子基金产品回撤率时序图
	 * @param request
	 * @return
	 */
	public Map<String,Object> getDrawDownList(ParentAnalysisRequest request);
	
	/**
	 * 获取夏普比率图表数据集
	 * @param request
	 * @return
	 */
	public Map<String,Object> getSharpList(ParentAnalysisRequest request);
	
	/**
	 * 获取索提诺比率图表数据集
	 * @param request
	 * @return
	 */
	public Map<String,Object> getSortinoList(ParentAnalysisRequest request);
	
	/**
	 * 获取卡玛比率图表数据集
	 * @param request
	 * @return
	 */
	public Map<String,Object> getCalmarList(ParentAnalysisRequest request);
	
	/**
	 * 获取风险价值图表数据集
	 * @param request
	 * @return
	 */
	public Map<String,Object> getRiskValueList(ParentAnalysisRequest request);
	
	/**
	 * 获取净值5日波动率
	 */
	public Map<String,Object> getFiveDayVolatility(ParentAnalysisRequest request);
	
	/**
	 * 获取产品协方差矩阵
	 * @param productIds
	 * @return
	 */
	public Map<String,Object> getCovariance(List<String> productIds);
	
}
