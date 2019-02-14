package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductsRelationship;

/**
 * 计算产品每日合约统计数据处理接口
 * @author sust
 *
 */
@Gateway
public interface ProductContactTradeDailyStatisticsService {

	/**
	 * 计算平仓手数（产品每日统计）
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	@DisabledLog
	public Map<String, Object> countByContract(String KPI, String startDate, String endDate, String productId, Map<String, List<ProductsRelationship>> relationsMap);

	/**
	 * 计算持仓持续天数（产品每日统计-单日更新）
	 * @param KPI
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @param paramCount
	 * @return
	 */
	public Map<String, Object> countLastDaysByContract(String KPI, String startDate, String endDate, String productId, int paramCount);
	
}
