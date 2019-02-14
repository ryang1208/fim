package com.huaxin.fim.api.fundscreening;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import com.huaxin.fim.entity.request.ParentAnalysisRequest;

/**
 * 母基金评价持仓分析业务处理接口
 * @author sust
 *
 */
@Gateway
public interface ParentPositionService {
	
	/**
	 * 获取母基金持仓前十大个股
	 * @return
	 */
	public Map<String,Object> getParentMarketValueList(AnalysisSearchRequest request);

	/**
	 * 获取母基金持仓前十大合约
	 */
	public Map<String,Object> getParentFutureInsMarketValueList(AnalysisSearchRequest request);
	
	/**
	 * 获取母子基金资产净值
	 */
	public Map<String,Object> getTotalAssetRatioValue(ParentAnalysisRequest request);
	
	/**
	 * 获取子基金资产配置指标
	 */
	public Map<String,Object> getAssetMarketValue(ParentAnalysisRequest request);
	
	/**
	 * 获取母基金持仓前十大债券
	 */
	public Map<String,Object> getParentBondValueList(ParentAnalysisRequest request);

	}



