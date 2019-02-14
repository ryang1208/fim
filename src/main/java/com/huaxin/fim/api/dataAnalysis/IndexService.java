package com.huaxin.fim.api.dataAnalysis;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

/**
 * 计算沣泛综合指数及FOF指数业务处理接口
 * 
 * @author liumd
 *
 */

@Gateway
public interface IndexService {

	/**
	 * 计算沣泛自定基准指数
	 * @param indexId
	 * @return
	 */
	public Map<String,Object> calculateFFIndex(String indexId);
	
}