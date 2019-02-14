package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;

/**
 * 数据解析基础类
 * @author wucq
 *
 */
@Gateway
public interface IndexImportService {
	//指数文件解析
	public List<String> indexAnalysis(String str, String productIds, Integer dataSource, String indexId, String indexName);
		
}
