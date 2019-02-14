package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductsRelationship;

@Gateway
public interface ProductFactorPeriodKPIStatisticsService {

	/**
	 * 计算产品-收益贡献度
	 */
	@DisabledLog
	Map<String,Object> calculateProfitContribution(String KPI, String start_date, String end_date,
                                                   String product_id, Map<String, List<ProductsRelationship>> relationsMap);

	/**
	 * 计算产品-风险贡献度
	 */
	@DisabledLog
	Map<String,Object> calculateRiskContribution(String KPI, String start_date, String end_date,
                                                 String product_id, Map<String, List<ProductsRelationship>> relationsMap);
 	
}
