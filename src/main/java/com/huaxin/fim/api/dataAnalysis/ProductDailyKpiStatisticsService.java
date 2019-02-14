package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.ProductDailyKPIStatistics;
import com.huaxin.fim.entity.response.FundSearchResponse;

/**
 * 计算产品每日统计数据处理接口
 * @author liumd
 *
 */
@Gateway
public interface ProductDailyKpiStatisticsService {

	/**
	 * 计算产品净值数据（产品每日统计）
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateProductNetValueDaily(String startDate, String endDate, String productId);

	/**
	 * 计算平均回撤和最大回撤（产品每日统计）
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public List<ProductDailyKPIStatistics> calculateProductDrawdownDaily(String type, String startDate, String endDate, String productId, int kpiType);


	/**
	 * 获取产品每日统计数据
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public List<ProductDailyKPIStatistics> getProductDailyList(String type, String startDate, String endDate, String productId);


    public ProductDailyKPIStatistics findMaxDateNetNewValue(String productName);

    /**
     * 获取基金筛选表头数据
     * @param productName
     * @return
     */
	public List<FundSearchResponse> findProductInfoList(String productName);

}
