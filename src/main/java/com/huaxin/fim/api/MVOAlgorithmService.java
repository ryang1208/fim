package com.huaxin.fim.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;


/**
 * 资产组合配置MVO组合算法计算处理接口
 * @author liumd
 *
 */
@Gateway
public interface MVOAlgorithmService {
	
	/**
	 * MVO模型算法
	 * @param productIs
	 * @param expectedYieldRate
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Map<String,Object> getMVOModel(List<String> productIs, BigDecimal expectedYieldRate, String beginDate, String endDate);

}
