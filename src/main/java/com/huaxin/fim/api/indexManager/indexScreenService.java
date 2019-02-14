package com.huaxin.fim.api.indexManager;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;

/**
 * 指数屏业务处理接口
 * @author sust
 *
 */
@Gateway
public interface indexScreenService {
	
	/**
	 * 指数查询
	 * @param 
	 * @return
	 */
	public Map<String,Object> queryIndexTable(AnalysisSearchRequest profitAndLossRequest);
	
}
