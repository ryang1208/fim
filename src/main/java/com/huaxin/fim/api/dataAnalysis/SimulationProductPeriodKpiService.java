package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.SimulationProductNetValue;
import com.huaxin.fim.entity.entity.SimulationProductPeriodKpiStatistics;

/**
 * 模拟组合构建指标计算周期统计业务处理接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface SimulationProductPeriodKpiService {

	/**
	 * 计算收益率指标（020032）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public Map<String, Object> calculateYieldRateByPeriod(List<SimulationProductNetValue> list);
	
	/**
	 * 计算回撤率指标（020033）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateDrawdown(List<SimulationProductNetValue> list);
	
	
	/**
	 * 计算年化收益率指标（030002）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateYearYieldRatio(List<SimulationProductPeriodKpiStatistics> list);
	
	/**
	 * 计算收益率标准差（030023）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateSTD(List<SimulationProductPeriodKpiStatistics> list);
	
	/**
	 * 计算年化波动率（040008）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateYearVolatilityRatio(List<SimulationProductPeriodKpiStatistics> list);

	/**
	 * 计算夏普比率（030007）
	 * @param yearYieldList
	 * @param stdList
	 * @return
	 */
	@DisabledLog
	public Map<String,Object> calculateSharpRatio(List<SimulationProductPeriodKpiStatistics> yearYieldList, List<SimulationProductPeriodKpiStatistics> stdList);

}
