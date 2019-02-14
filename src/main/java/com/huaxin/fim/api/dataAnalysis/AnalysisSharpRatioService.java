package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductDailyKPIStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;

/**
 * Sharp率指标计算处理接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface AnalysisSharpRatioService {

	/**
	 * Sharp率指标计算(产品每日)
	 * @param type // 0 默认全部
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculatSharpRatioByPeriod(String type, String beginDate, String endDate, String productId, int kpiType);

	/**
	 * Sortino率指标计算(产品每日)
	 * @param type // 0 默认全部
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculatSortinoRatioByPeriod(String type, String beginDate, String endDate, String productId, int kpiType);

	/**
	 * 交易天数指标计算
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculatTradingDaysByPeriod(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 收益率标准差指标计算
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculatYieldRatioStandardDeviation(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 每5日年化波动率指标计算
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */

	public Map<String,Object> calculatYieldRatioStandardDeviationFive(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 五日的计算收益率标准差
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculatYearVolatilityRatio(String kpiCode, String beginDate, String endDate, String productId);

		/**
		 * 平均计算收益率标准差
		 * @param type
		 * @param beginDate
		 * @param endDate
		 * @param productId
		 * @return
		 */

		public List<ProductPeriodKPIStatistics> calculatYieldRatioStandardDeviationAverage(String KPI, String type, String beginDate, String endDate, String productId, int kpiType);



		/**
		 * 计算偏度值
		 * @param type
		 * @param beginDate
		 * @param endDate
		 * @param productId
		 * @return
		 */
		public List<ProductPeriodKPIStatistics> calculatSkewness(String KPI, String type, String beginDate, String endDate, String productId, int kpiType);
		/**
		 * 计算峰度值
		 * @return
		 */

		List<ProductPeriodKPIStatistics> calculatKurtosis(String KPI, String stat_type, String start_date, String end_date, String product_id, int kpiType);
		/**
		 * 计算水下最大回撤恢复周期天数
		 * @param kpiCode
		 * @param beginDate
		 * @param endDate
		 * @param productId
		 * @return
		 */

		public Map<String,Object> underWaterRecoverWeek(String kpiCode, String beginDate, String endDate, String productId);
}
