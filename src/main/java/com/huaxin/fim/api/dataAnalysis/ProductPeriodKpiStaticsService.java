package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.CustomParameter;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductsRelationship;
import com.huaxin.fim.entity.enums.PeriodTypeEnum;

@Gateway
public interface ProductPeriodKpiStaticsService {

	/**
	 * 计算产品每日股票总市值(个股市值汇总,估值表仅取1102)
	 */
	@DisabledLog
	public Map<String,Object> calculateProductStockMarketValue(String KPI, String start_date, String end_date, String product_id);
	/**
	 * 计算产品每日按市值分类的总市值
	 */
	public Map<String,Object> calculateProductMarketValueByMarketValueType(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 计算产品每日收益率相关系数
	 */
	public Map<String,Object> calculateYieldCorrelationCoefficientByKPICode(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 计算产品股票仓位
	 */
	public Map<String,Object> calculateProductStockPositionValue(String KPI, String start_date, String end_date, String product_id);


	/**
	 * 计算产品每日各资产类别总市值
	 */
	@DisabledLog
	public Map<String,Object> calculateProductAssetMarketValue(String KPI, String start_date, String end_date, String product_id,
                                                               Map<String, List<ProductsRelationship>> productRelationList);

	/**
	 * 计算产品M2测度
	 */
	public List<ProductPeriodKPIStatistics> calculateM2Measure(String kpiCode, String type, String beginDate,
															   String endDate, String productId, int kpiType);

	/**
	 * 计算各股息率分类市值
	 */
	public Map<String,Object> calculateStockDividendRatioMarketValue(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 计算贝塔值
	 */
	public Map<String,Object> calculateBetaValue(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 计算詹森alpha值
	 */
	public Map<String,Object> calculateAlphaValue(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 特雷诺比率
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateTreynorPerformanceMeasure(String kpiCode, String beginDate, String endDate, String productId);

	 /**
		 * 年化跟踪误差
		 * @param kpiCode
		 * @param beginDate
		 * @param endDate
		 * @param productId
		 * @return
		 */
	public Map<String,Object> calculateTrackingError(String kpiCode, String beginDate, String endDate, String productId);

	/**
	 * 年化信息比率
	 * @param kpiCode
	 * @param beginDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
   public Map<String,Object> calculateInformationRatio(String kpiCode, String beginDate, String endDate, String productId);


	/**
	 * 计算最大回撤形成恢复周期,水下最大回撤形成恢复周期（天）
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object>  calculateMAXDrawdownFormactionRecoveryCycle(String kpiCode, String startDate, String endDate, String productId);

 	/**
 	 * 计算T-M 模型
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
 	 */
 	public Map<String,Object>  calculateTMModel(String kpiCode, String startDate, String endDate, String productId);

 	/**
 	 * 计算股指期货净头寸市值占净值
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
 	 */
 	public Map<String,Object>  calculateNETPOSITINOFSTOCKINDEXFUTURES(String kpiCode, String startDate, String endDate, String productId);

 	/**
 	 * 计算股指期货净头寸市值占净值
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
 	 */
 	public Map<String,Object>  calculateNETPOSITINOFPRESENTINVESTMENT(String kpiCode, String startDate, String endDate, String productId);


 	/**
 	 * 计算基差
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
 	 */
 	public Map<String,Object>  calculateBasisValue(String kpiCode, String startDate, String endDate, String productId);

 	/**
	 * 超额收益率
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateExcessearningsYieldRatio(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 计算产品每日总资产
	 */
	public Map<String,Object> calculateProductTotalAssetByPeriod(String KPI, String start_date, String end_date, String product_id);

	/**
	 * 产品胜率
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateWinRatio(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 产品shap比率
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateYearShapRatio(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 净值差额
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateNetValueDifference(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 最大回撤(包括水上水下)
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateMAXRetracement(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 最大回撤(包括水上水下)
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return productPeriodKPIStatisticsList
	 */
	public Map<String,Object>  calculateMaxDrawdown(String kpiCode, String startDate, String endDate, String productId, List<PeriodTypeEnum> periodMap, CustomParameter cp);

	/**
	 * 产品Calmar比率
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculateYearCalmaRatio(String kpiCode, String startDate, String endDate, String productId);

	/**
	 * 产品Calmar比率
 	 * @param startDate
 	 * @param endDate
 	 * @param productId
 	 * @return
	 */
	public Map<String,Object>  calculatePeriodYearCalmarRatio(String kpiCode, String startDate, String endDate, String productId, CustomParameter cp1);

	/**
	 * 统计产品周期表中（区间求比例）
	 * @param list
	 * @return
	 */
	@DisabledLog
	public ProductPeriodKPIStatistics calculateProductPeriodByAverage(List<ProductPeriodKPIStatistics> list, ProductPeriodKPIStatistics varietyPeriod);


	/**
	 * 计算索提诺(产品周期)
	 */
   public Map<String,Object> calculateSortino(String kpiCode, String beginDate, String endDate, String productId);

   /**
	 * 计算风报比(产品周期)
	 */
  public Map<String,Object> calculateRiskReturnRatio(String kpiCode, String beginDate, String endDate, String productId);

  /**
	 * 计算产品债券偿还期市值
	 */
  public Map<String,Object> calculateBondRepaymentPeriod(String KPI, String start_date, String end_date, String product_id);

  /**
	 * 计算产品久期
	 */
  public Map<String,Object> calculateBondDuration(String KPI, String start_date, String end_date, String product_id);

  /**
	 * 计算产品凸性
	 */
  public Map<String,Object> calculateBondConvexity(String KPI, String start_date, String end_date, String product_id);
  
}
