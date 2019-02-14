package com.huaxin.fim.api.dataAnalysis;

import com.dev.framework.core.annotation.Gateway;

/**
 * 产品 分析共用方法处理接口
 * 
 * @author sust
 *
 */
@Gateway
public interface AnalysisProductUtilService {

	/**
	 * 取得统计起日
	 * @param type // 0 默认全部
	 * @param productId
	 * @return
	 */
	public String getCreateDate(String productId, int type);

	
}
