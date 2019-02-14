package com.huaxin.fim.api.fundscreening;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.ParentAnalysisRequest;

/**
 * 母基金评价风格分析业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface ParentStyleService {
	

	/**
	 * 获取子基金胜率
	 * @return
	 */
	public Map<String,Object> getWinRatioValue(ParentAnalysisRequest request);
	
	/**
	 * 获取子基金T-M模型
	 * @return
	 */
	public Map<String,Object> getTMModelValue(ParentAnalysisRequest request);
	
	/**
	 * 获取母子基金分散比率
	 * @return
	 */
	public Map<String,Object> getDispersionRatioValue(ParentAnalysisRequest request);
	
	
}
