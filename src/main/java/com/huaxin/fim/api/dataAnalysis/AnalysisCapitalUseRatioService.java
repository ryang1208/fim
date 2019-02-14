package com.huaxin.fim.api.dataAnalysis;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

/**
 * 资金使用率指标计算处理接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface AnalysisCapitalUseRatioService {

	/**
	 * 计算敞口比指标
	 * @param kpiCode
	 * @param type // 0 默认全部
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public  Map<String,Object>  calculatCapitalUseRatioByPeriod(String kpiCode, String startDate, String endDate, String productId);
	

}
