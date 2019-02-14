package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;

@Gateway
public interface ProductRatingKpiStaticsService {

	/**
	 * 计算产品债券评级市值
	 */
	public Map<String,Object> calculateProductBondRatingMarketValue(String KPI, String start_date, String end_date, String product_id);
	
  
}
