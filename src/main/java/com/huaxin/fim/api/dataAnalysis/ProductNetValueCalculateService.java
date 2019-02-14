package com.huaxin.fim.api.dataAnalysis;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;

/**
 * 计算产品净值数据处理接口
 * @author liumd
 *
 */
@Gateway
public interface ProductNetValueCalculateService {

	/**
	 * 计算产品净值数据（大赛算法）
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateProductNetValueForCompetition(String startDate, String endDate, String productId);

	/**
	 * 获取产品最大指标计算日期
	 * @param productId
	 * @param type(净值，结算单)
	 * @return
	 */
	public Map<String,Object> getLastCalculateDate(String productId, String type, String maxMonth);

	/**
	 * 标准算法
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateProductNetValueForStandard(String startDate, String endDate, String productId);

	/**
	 * 计算母基金净值数据
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @return
	 */
	public Map<String,Object> calculateParentProductNetValue(String startDate, String endDate, String productId);

}
