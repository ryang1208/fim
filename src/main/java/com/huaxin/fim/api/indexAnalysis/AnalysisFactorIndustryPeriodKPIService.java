package com.huaxin.fim.api.indexAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.Index;

/**
 * 行业因子指标周期分析处理接口
 *
 */
@Gateway
public interface AnalysisFactorIndustryPeriodKPIService {
	
	/**
	 * 二级因子-超额收益率
	 * @param date		统计日期
	 * @param KPI		指标代码
	 * @param indexList	当日指数数据
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateExcessYieldRatio(String date, String KPI, List<Index> indexList);
	
	/**
	 * 二级因子-超额收益率
	 * @param date		统计日期
	 * @param KPI		指标代码
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateYieldRatioStandardDeviation(String date, String KPI);
	
}
