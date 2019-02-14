package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;

/**
 * 数据分析回撤指业务处理类
 * @author sust
 *
 */
@Gateway
public interface AnalysisProductDrawDownService {

	/**
	 * 处理指标集合，线程池添加任务等
	 * @return
	 */
	public Map<String,Object> countDrawDownByPeriod(String KPI, String start_date, String end_date, String product_id);


	/**
	 *  计算水下回撤指标（依产品周期）
	 * @param KPI
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @return
	 */
	public Map<String,Object> calculateUnderWaterDrawDownByPeriod(String KPI, String start_date, String end_date, String product_id);

	/**
	 *  计算水上回撤指标（依产品周期）
	 * @param KPI
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @return
	 */
	public Map<String,Object> calculateWaterDrawDownByPeriod(String KPI, String start_date, String end_date, String product_id);


	/**
	 * 水下最大回撤（老版本）
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMaxUnderWaterDrawDownByPeriod(String KPI, String stat_type,
																				   String start_date, String end_date, String product_id, int kpiType);

	/**
	 * 水上最大回撤（老版本）
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateMaxWaterDrawDownByPeriod(String KPI, String stat_type,
                                                                              String start_date, String end_date, String product_id, int kpiType);


	/**
	 * 最大回撤（老版本）
	 * @param KPI
	 * @param stat_type
	 * @param start_date
	 * @param end_date
	 * @param product_id
	 * @param kpiType
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> calculateProductDrawdownPeroid(String KPI, String stat_type, String start_date,
                                                                           String end_date, String product_id, int kpiType);
	
}
