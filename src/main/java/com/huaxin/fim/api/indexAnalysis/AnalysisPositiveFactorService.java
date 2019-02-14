package com.huaxin.fim.api.indexAnalysis;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.Contract;
import com.huaxin.fim.entity.entity.FactorCustomParameter;
import com.huaxin.fim.entity.entity.Index;

/**
 * 正向因子分析处理接口
 * @author sust
 *
 */

@Gateway
public interface AnalysisPositiveFactorService {
	
	/**
	 * 大盘
	 * @param factor_id
	 * @param sortType
	 * @param date
	 * @param contractList
	 * @param indexList
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateBeta(String factor_id, String sortType,
											String date, List<Contract> contractList, List<Index> indexList);

	/**
	 * 动量
	 * @param factor_id
	 * @param date
	 * @param contractList
	 * @param indexList
	 * @param factors
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateMomentum(String factor_id, String date, List<Contract> contractList,
                                                List<Index> indexList, List<FactorCustomParameter> factors);

	/**
	 * 盈利能力
	 * @param factor_id
	 * @param sortType
	 * @param date
	 * @param contractList
	 * @param indexList
	 * @param factors
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateEarningYield(String factor_id, String sortType,
                                                    String date, List<Contract> contractList, List<FactorCustomParameter> factors);

	/**
	 * 一级因子-波动率
	 * @param factorID	因子代码
	 * @param date		统计日期
	 * @param contractList	合约源数据
	 * @param indexList		指数源数据
	 * @param factorParams	因子参数源数据
	 * @param indexID	指定对比的指数代码
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateResidualVolatility(String factorID, String date, List<Contract> contractList,
                                                          List<Index> indexList, List<FactorCustomParameter> factorParams);

	/**
	 * 一级因子-成长性
	 * @param factorID	因子代码
	 * @param sortType	排序方式
	 * @param date		统计日期
	 * @param contractList	合约源数据
	 * @param factorParams	因子参数源数据
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateGrowth(String factorID, String sortType, String date,
                                              List<Contract> contractList, List<FactorCustomParameter> factorParams);

	/**
	 * 一级因子-杠杆率
	 * @param factorID	因子代码
	 * @param sortType	排序方式
	 * @param date		统计日期
	 * @param contractList	合约源数据
	 * @param factorParams	因子参数源数据
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateLeverage(String factorID, String sortType, String date,
                                                List<Contract> contractList, List<FactorCustomParameter> factorParams);

	/**
	 * 一级因子-流动性
	 * @param factorID	因子代码
	 * @param sortType	排序方式
	 * @param date		统计日期
	 * @param contractList	合约源数据
	 * @param factorParams	因子参数源数据
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateLiquidity(String factorID, String sortType, String date,
                                                 List<Contract> contractList, List<FactorCustomParameter> factorParams);
	
}
