package com.huaxin.fim.service.common;


import com.dev.framework.core.annotation.Gateway;

import java.text.ParseException;
import java.util.Map;

@Gateway
public interface ProductPeriodKpiRiskValueService {
	
	/**
	 * 基金产品估值信息的市值
	 */
	Map<String,Object> rikeValueMarketValue(String KPI, String start_date, String end_date, String product_id);
	/**
	 * 99%的风险价值5日交易日
	 * 99%的风险价值10日交易日
	 * 99%的风险价值10日交易日
	 * 95%的风险价值5日交易日
	 * 95%的风险价值10日交易日
	 * 95%的风险价值20日交易日
	 * @throws ParseException
	 */
	Map<String,Object> rikeValueNinetyNineFiveMarketDay(String KPI, String start_date, String end_date, String product_id) ;

	/**
	 *股票投资
	 */
	Map<String,Object> netAssetValue(String KPI, String start_date, String end_date, String product_id);
}
